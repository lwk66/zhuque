package com.hsjry.zhuque.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hsjry.zhuque.biz.TeacherService;
import com.hsjry.zhuque.common.entiy.Result;
import com.hsjry.zhuque.common.entiy.ResultCode;
import com.hsjry.zhuque.model.Teacher;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author liuwk@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2019/12/3 9:46
 */
@Slf4j
@Controller
@RequestMapping("teacher")
public class TeacherController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private TeacherService teacherService;

    @ResponseBody
    @GetMapping("{id}")
    public Result FindById(@PathVariable("id") Integer id) {
        Teacher teacher = teacherService.findById(id);
        Result result = new Result(ResultCode.SUCCESS, teacher);
        return result;
    }

    @ResponseBody
    @PostMapping("/login")
    public Result Login(Teacher teacher) {
        Result result;
        Teacher teacher2 = teacherService.findByUsername(teacher.getUsername());
        if (teacher.getPassword().equals(teacher2.getPassword())) {
            result = new Result(ResultCode.SUCCESS);
        } else {
            result = new Result(ResultCode.FAIL);
        }
        return result;
    }

    @ResponseBody
    @GetMapping("allTeacher")
    public Result findAllTeacher(ModelMap modelMap, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        Page<Teacher> teachers = teacherService.findAll(start, size);
        Result result = new Result(ResultCode.SUCCESS, teachers);
        return result;
    }

    @GetMapping("all")
    public String findAll(ModelMap modelMap, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        try {
            Page<Teacher> teachers = teacherService.findAll(start, size);
            modelMap.addAttribute("teachers", teachers);
            int i = 10 / 0;
        } catch (Exception e) {
            log.error("数学异常");
            throw new RuntimeException("服务器维护,请联系管理员");
        }
        return "teachers";
    }

    @GetMapping("index")
    public String index(ModelMap modelMap, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) {
        return "index";
    }

    @GetMapping("string")
    @ResponseBody
    public String string() {
        return "string";
    }

    @GetMapping("/listTeacher")
    public String listCategory(Model m, @RequestParam(value = "start", defaultValue = "0") int start, @RequestParam(value = "size", defaultValue = "5") int size) throws Exception {
        Logger logger = LoggerFactory.getLogger(this.getClass());
        Page<Teacher> page = teacherService.findAll(start, size);
        logger.info("数据查询成功");
        m.addAttribute("page", page);
        return "teachers";
    }


//    @Scheduled(cron = "0/5 * * * * *")
//    public void test(){
//        logger.info("======================================={}====================================","测试");
//    }
}
