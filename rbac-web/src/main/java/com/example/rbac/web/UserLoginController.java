package com.example.rbac.web;

import com.example.common.pojo.vo.ReplyVO;
import com.example.rbac.pojo.dto.UserLoginDTO;
import com.example.rbac.pojo.vo.UserLoginVO;
import com.example.rbac.web.AbstractController;
import com.example.rbac.web.constant.WebConst;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * 用户登录控制器
 * <p>当前并没有真正实现用户登录功能，只是Mock登录接口而已
 *
 * @author Jack
 * @date 2020/04/25
 */
@RestController
@RequestMapping(WebConst.API_PATH + "/_user")
public class UserLoginController extends AbstractController {

    @PostMapping(value = "/login")
    public ResponseEntity<ReplyVO<String>> login(UserLoginDTO userLoginDTO) {
        return ResponseEntity.ok(ReplyVO.success("this_is_token"));
    }

    @GetMapping(value = "/info")
    public ResponseEntity<ReplyVO<UserLoginVO>> info(String token) {
        UserLoginVO userLoginVO = new UserLoginVO();
        userLoginVO.setRoles(Arrays.asList("admin"));
        userLoginVO.setIntroduction("I am a super administrator");
        userLoginVO.setAvatar("https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        userLoginVO.setName("admin");
        return ResponseEntity.ok(ReplyVO.success(userLoginVO));
    }

    @PostMapping(value = "/logout")
    public ResponseEntity<ReplyVO<Void>> logout() {
        return ResponseEntity.ok(ReplyVO.success());
    }

}


