
package com.example.rbac.web.rest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.common.constant.ErrorCode;
import com.example.common.exception.BusinessException;
import com.example.common.pojo.vo.PageVO;
import com.example.common.util.DateUtil;
import com.example.rbac.constant.Sex;
import com.example.rbac.excel.handler.ConstConstraintHandler;
import com.example.rbac.excel.handler.TemplateCellStyleStrategy;
import com.example.rbac.excel.handler.TitleDescriptionWriteHandler;
import com.example.rbac.pojo.dto.UserAddDTO;
import com.example.rbac.pojo.dto.UserExcelDTO;
import com.example.rbac.pojo.dto.UserUpdateDTO;
import com.example.rbac.pojo.mapper.UserMapper;
import com.example.rbac.pojo.po.UserPO;
import com.example.rbac.pojo.qo.UserQO;
import com.example.rbac.pojo.vo.UserExcelVO;
import com.example.rbac.pojo.vo.UserListVO;
import com.example.rbac.pojo.vo.UserShowVO;
import com.example.rbac.service.UserService;
import com.example.rbac.web.AbstractController;
import com.example.rbac.web.api.UserAPI;
import com.example.rbac.web.constant.WebConst;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Valid;
import javax.validation.Validator;
import java.net.URI;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 【用户】控制器
 *
 * @author Jack
 * @date 2020/04/25
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/user")
public class UserController extends AbstractController implements UserAPI {

    @Autowired
    private UserService userService;
    @Autowired
    private Validator validator;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<UserShowVO> save(@Valid @RequestBody UserAddDTO userAddDTO) throws Exception {
        UserPO user = userService.save(userAddDTO);
        return ResponseEntity.created(new URI(WebConst.API_PATH + "/user/" + user.getId()))
            .body(UserMapper.INSTANCE.toShowVO(user));
    }

    @Override
    @PutMapping
    public ResponseEntity<UserShowVO> update(@Valid @RequestBody UserUpdateDTO userUpdateDTO) {
        UserPO user = userService.update(userUpdateDTO);
        return ResponseEntity.ok(UserMapper.INSTANCE.toShowVO(user));
    }

    @Override
    @GetMapping
    public ResponseEntity<PageVO<UserListVO>> list(@Valid UserQO userQO) {
        PageVO<UserListVO> page = userService.list(userQO);
        return ResponseEntity.ok(page);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserShowVO> show(@PathVariable Long id) {
        UserShowVO userShowVO = userService.show(id);
        return ResponseEntity.ok(userShowVO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Long id) {
        int count = userService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Integer> deleteBatch(@RequestBody Long[] id) {
        if(ArrayUtils.isEmpty(id)){
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = userService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @GetMapping("/export")
    public void exportExcel(@Valid UserQO userQO, HttpServletResponse response) throws Exception {
        userQO.setPageSize(Integer.MAX_VALUE);
        userQO.setPageNo(1);
        List<UserListVO> list = userService.list(userQO).getList();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("用户导出", "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), UserExcelVO.class)
                .sheet()
                .doWrite(UserMapper.INSTANCE.toExcelVOList(list));
    }

    @Override
    @PostMapping("/import")
    public ResponseEntity<Integer> importExcel(@RequestParam(value = "file") MultipartFile file) throws Exception {
        List<UserAddDTO> list = EasyExcel.read(file.getInputStream())
                .head(UserExcelDTO.class)
                .sheet()
                .headRowNumber(3)
                .<UserExcelDTO>doReadSync()
                .stream()
                .map(UserMapper.INSTANCE::fromExcelDTO)
                .peek(userAddDTO -> {
                    // 校验数据
                    Set<ConstraintViolation<UserAddDTO>> set = validator.validate(userAddDTO);
                    if (!set.isEmpty()) {
                        throw new ConstraintViolationException(set);
                    }
                })
                .collect(Collectors.toList());
        int count = userService.batchSave(list);
        return ResponseEntity.ok(count);
    }

    @Override
    @GetMapping("/template")
    public void downloadExcelTemplate(HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String title = "用户导入模板(" + DateUtil.getDateStr(new Date()) + ")";
        String fileName = URLEncoder.encode(title, "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        String[] description = new String[]{
                "模版前三行标题请勿修改",
                "带“*”号为必填项",
                "“部门id”请填入id值",
                "“角色”支持一次性填入多个id（请用英文逗号分隔）",
        };
        String[] sexConstraint = Arrays.stream(Sex.values()).map(Sex::getDesc).toArray(String[]::new);
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream())
                .registerWriteHandler(new ConstConstraintHandler(sexConstraint, 3, 3, 0, 0))
                .registerWriteHandler(new ConstConstraintHandler(sexConstraint, 3, 3, 3, 3))
                // 第一行是标题，第二行是说明
                .registerWriteHandler(new TitleDescriptionWriteHandler(title, description, UserExcelDTO.class))
                // 自定义模板单元格样式
                .registerWriteHandler(new TemplateCellStyleStrategy())
                .build();
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "Sheet1")
                .head(UserExcelDTO.class)
                // 从第三行开始写表头
                .relativeHeadRowIndex(2)
                .build();
        excelWriter.write(Arrays.asList(UserExcelDTO.example()), writeSheet);

        excelWriter.finish();
    }

}


