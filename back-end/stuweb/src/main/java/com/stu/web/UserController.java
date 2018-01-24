package com.stu.web;

import com.stu.entity.stu.Stu;
import com.stu.entity.user.User;
import com.stu.service.IStuService;
import com.stu.service.IUserService;
import com.stu.util.MySessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LARK on 2018/1/11.
 * 处理用户请求的Controller类
 */

@Controller
@RequestMapping("/userController")
@CrossOrigin(origins = "*", maxAge = 3600)
public class UserController {

    @Resource(name = "userService")
    private IUserService userService;
    @Resource(name = "stuService")
    private IStuService stuService;

    @RequestMapping("/getUserById")
    @ResponseBody
    public User getUserById(){
        return userService.getUserById(1);
    }

    @RequestMapping("/userLogin")
    @ResponseBody
    public Object userLogin(User user, HttpSession session, Stu stu){
        user = userService.userLogin(user);
        if(user != null){
            Map data = new HashMap();
            stu = (Stu) stuService.getStuByUserId(user.getUno());
            session.setAttribute("loginUser", stu);
            data.put("stu",stu);
            data.put("session", session.getId());
            return data;
        }
        return null;
    }



    @RequestMapping("/isLogin")
    @ResponseBody
    public String isLogin(String sessionid, HttpSession session){
        session = MySessionContext.getSession(sessionid);
        if(session.getAttribute("loginUser") != null){
            return "{\"isLogin\":true}";
        }
        return "{\"isLogin\":false}";
    }

    public void setUserService(IUserService userService) {
        this.userService = userService;
    }

    public void setStuService(IStuService stuService) {
        this.stuService = stuService;
    }
}
