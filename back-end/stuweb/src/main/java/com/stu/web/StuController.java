package com.stu.web;

import com.stu.entity.stu.Stu;
import com.stu.service.IStuService;
import com.stu.util.MySessionContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LARK on 2018/1/16.
 */

@Controller
@RequestMapping("/stuController")
public class StuController {

    @Resource(name = "stuService")
    private IStuService stuService;

    @RequestMapping("/updateStu")
    @ResponseBody
    public Object updateStu(Stu stu, String sessionid, HttpSession session){

        stuService.updateStu(stu);

        session = MySessionContext.getSession(sessionid);
        Map data = new HashMap();
        stu = (Stu) stuService.getStuByUserId(stu.getUser().getUno());
        session.setAttribute("loginUser", stu);
        data.put("stu",stu);
        data.put("session", session.getId());

        return data;
    }

    public void setStuService(IStuService stuService) {
        this.stuService = stuService;
    }
}
