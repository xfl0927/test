
package com.example.rbac.web.rest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.example.common.constant.ErrorCode;
import com.example.common.exception.BusinessException;
import com.example.common.pojo.qo.OptionQO;
import com.example.common.pojo.vo.OptionVO;
import com.example.common.pojo.vo.PageVO;
import com.example.common.util.DateUtil;
import com.example.rbac.excel.handler.TemplateCellStyleStrategy;
import com.example.rbac.excel.handler.TitleDescriptionWriteHandler;
import com.example.rbac.pojo.dto.DepartmentAddDTO;
import com.example.rbac.pojo.dto.DepartmentExcelDTO;
import com.example.rbac.pojo.dto.DepartmentUpdateDTO;
import com.example.rbac.pojo.mapper.DepartmentMapper;
import com.example.rbac.pojo.po.DepartmentPO;
import com.example.rbac.pojo.qo.DepartmentQO;
import com.example.rbac.pojo.vo.DepartmentExcelVO;
import com.example.rbac.pojo.vo.DepartmentListVO;
import com.example.rbac.pojo.vo.DepartmentShowVO;
import com.example.rbac.service.DepartmentService;
import com.example.rbac.web.AbstractController;
import com.example.rbac.web.api.DepartmentAPI;
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
 * 【部门】控制器
 *
 * @author Jack
 * @date 2020/04/25
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/department")
public class DepartmentController extends AbstractController implements DepartmentAPI {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private Validator validator;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<DepartmentShowVO> save(@Valid @RequestBody DepartmentAddDTO departmentAddDTO) throws Exception {
        DepartmentPO department = departmentService.save(departmentAddDTO);
        return ResponseEntity.created(new URI(WebConst.API_PATH + "/department/" + department.getId()))
            .body(DepartmentMapper.INSTANCE.toShowVO(department));
    }

    @Override
    @PutMapping
    public ResponseEntity<DepartmentShowVO> update(@Valid @RequestBody DepartmentUpdateDTO departmentUpdateDTO) {
        DepartmentPO department = departmentService.update(departmentUpdateDTO);
        return ResponseEntity.ok(DepartmentMapper.INSTANCE.toShowVO(department));
    }

    @Override
    @GetMapping
    public ResponseEntity<PageVO<DepartmentListVO>> list(@Valid DepartmentQO departmentQO) {
        PageVO<DepartmentListVO> page = departmentService.list(departmentQO);
        return ResponseEntity.ok(page);
    }

    @Override
    @GetMapping(value = "/options")
    public ResponseEntity<List<OptionVO<Integer, String>>> findOptions(OptionQO<Integer, String> qo) {
        List<OptionVO<Integer, String>> options = departmentService.findOptions(qo);
        return ResponseEntity.ok(options);
    }

    @Override
    @GetMapping(value = "/{id}")
    public ResponseEntity<DepartmentShowVO> show(@PathVariable Integer id) {
        DepartmentShowVO departmentShowVO = departmentService.show(id);
        return ResponseEntity.ok(departmentShowVO);
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Integer> delete(@PathVariable Integer id) {
        int count = departmentService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @DeleteMapping
    public ResponseEntity<Integer> deleteBatch(@RequestBody Integer[] id) {
        if(ArrayUtils.isEmpty(id)){
            throw new BusinessException(ErrorCode.PARAM_IS_NULL);
        }
        int count = departmentService.delete(id);
        return ResponseEntity.ok(count);
    }

    @Override
    @GetMapping("/export")
    public void exportExcel(@Valid DepartmentQO departmentQO, HttpServletResponse response) throws Exception {
        departmentQO.setPageSize(Integer.MAX_VALUE);
        departmentQO.setPageNo(1);
        List<DepartmentListVO> list = departmentService.list(departmentQO).getList();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("部门导出", "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), DepartmentExcelVO.class)
                .sheet()
                .doWrite(DepartmentMapper.INSTANCE.toExcelVOList(list));
    }

    @Override
    @PostMapping("/import")
    public ResponseEntity<Integer> importExcel(@RequestParam(value = "file") MultipartFile file) throws Exception {
        List<DepartmentAddDTO> list = EasyExcel.read(file.getInputStream())
                .head(DepartmentExcelDTO.class)
                .sheet()
                .headRowNumber(3)
                .<DepartmentExcelDTO>doReadSync()
                .stream()
                .map(DepartmentMapper.INSTANCE::fromExcelDTO)
                .peek(departmentAddDTO -> {
                    // 校验数据
                    Set<ConstraintViolation<DepartmentAddDTO>> set = validator.validate(departmentAddDTO);
                    if (!set.isEmpty()) {
                        throw new ConstraintViolationException(set);
                    }
                })
                .collect(Collectors.toList());
        int count = departmentService.batchSave(list);
        return ResponseEntity.ok(count);
    }

    @Override
    @GetMapping("/template")
    public void downloadExcelTemplate(HttpServletResponse response) throws Exception {
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String title = "部门导入模板(" + DateUtil.getDateStr(new Date()) + ")";
        String fileName = URLEncoder.encode(title, "utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        String[] description = new String[]{
                "模版前三行标题请勿修改",
                "带“*”号为必填项",
        };
        ExcelWriter excelWriter = EasyExcel.write(response.getOutputStream())
                // 第一行是标题，第二行是说明
                .registerWriteHandler(new TitleDescriptionWriteHandler(title, description, DepartmentExcelDTO.class))
                // 自定义模板单元格样式
                .registerWriteHandler(new TemplateCellStyleStrategy())
                .build();
        WriteSheet writeSheet = EasyExcel.writerSheet(0, "Sheet1")
                .head(DepartmentExcelDTO.class)
                // 从第三行开始写表头
                .relativeHeadRowIndex(2)
                .build();
        excelWriter.write(Arrays.asList(DepartmentExcelDTO.example()), writeSheet);

        excelWriter.finish();
    }

}


