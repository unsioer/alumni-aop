package cn.edu.xmu.alumni.controller;

import cn.edu.xmu.alumni.service.UserService;
import cn.edu.xmu.alumni.vo.StatusResponse;
import cn.edu.xmu.alumni.vo.UserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@Controller
@Validated
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping(value="/login")
    public StatusResponse login(@RequestBody UserRequest loginRequest, HttpSession session){
        int state=userService.login(loginRequest);
        if (state==200){
            session.setAttribute("userName",loginRequest.getUserName());
        }
        return new StatusResponse(state,"");
    }

    @DeleteMapping(value = "/logout")
    public StatusResponse logout(HttpSession session){
        if (session.getAttribute("userName")==null){
            return new StatusResponse(403,"");
        }
        session.invalidate();
        return new StatusResponse(200,"");
    }

    /*@PostMapping(value = "/register")
    public String register(@RequestBody UserRequest userRequest){

        return null;
    }*/
}
