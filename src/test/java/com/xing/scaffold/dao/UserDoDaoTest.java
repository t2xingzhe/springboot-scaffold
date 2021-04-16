package com.xing.scaffold.dao;

import com.xing.scaffold.SpringbootScaffoldApplication;
import com.xing.scaffold.domain.entity.UserDo;
import com.xing.scaffold.repository.UserDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 测试类
 *
 * @author xingzhe
 * @date 2021/4/2 10:35
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = SpringbootScaffoldApplication.class)
public class UserDoDaoTest {

    @Autowired
    UserDao userDao;

    @Test
    public void userTest() {
        UserDo user = userDao.getById(1);
        System.out.println(user);
    }
}
