package com.hsjry.zhuque.biz;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hsjry.zhuque.model.Teacher;

/**
 * @author liuwk@yunrong.cn
 * @version V2.1
 * @since 2.1.0 2019/12/3 9:52
 */
public interface TeacherService {
    Teacher findById(Integer id);

    Page<Teacher> findAll(int start, int size);

    Teacher findByUsername(String username);
}
