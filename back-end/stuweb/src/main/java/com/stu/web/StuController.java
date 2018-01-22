package com.stu.web;

import com.stu.entity.stu.Stu;
import com.stu.service.IStuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

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
    public Stu updateStu(Stu stu, MultipartFile file){
        System.out.println(file);
        System.out.println(stu.getSname() + "," + stu.getSaddress() + "," + stu.getSbirthday());

        return stu;
    }

    public void setStuService(IStuService stuService) {
        this.stuService = stuService;
    }
}
