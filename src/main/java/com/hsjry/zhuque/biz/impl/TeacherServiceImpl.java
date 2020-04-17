package com.hsjry.zhuque.biz.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hsjry.zhuque.biz.TeacherService;
import com.hsjry.zhuque.dal.mapper.TeacherMapper;
import com.hsjry.zhuque.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuwk@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2019/12/3 9:57
 */
@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    @Override
    public Teacher findById(Integer id) {
        Teacher teacher = teacherMapper.selectById(id);
        return teacher;
    }

    @Override
    public Page<Teacher> findAll(int start, int size) {
        Page<Teacher> page = new Page<Teacher>(start, size);
        Page<Teacher> teacherList = teacherMapper.selectPage(page, null);
        return teacherList;
    }

    @Override
    public Teacher findByUsername(String username) {
        QueryWrapper<Teacher> queryWrapper = new QueryWrapper<Teacher>();
        queryWrapper.eq("username", username);
        return teacherMapper.selectOne(queryWrapper);
    }
}
