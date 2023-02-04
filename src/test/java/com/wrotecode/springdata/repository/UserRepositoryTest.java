package com.wrotecode.springdata.repository;

import com.wrotecode.springdata.config.DbConfig;
import com.wrotecode.springdata.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = DbConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void testQuery() {
        User user = repository.findById("1");
        System.out.println(user);
    }
}