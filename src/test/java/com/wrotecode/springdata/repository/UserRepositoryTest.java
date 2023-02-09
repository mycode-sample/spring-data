package com.wrotecode.springdata.repository;

import com.wrotecode.springdata.config.DbConfig;
import com.wrotecode.springdata.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Optional;

@ContextConfiguration(classes = DbConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserRepositoryTest {

    @Autowired
    private UserRepository repository;


    @Test
    public void testQuery() {
        Optional<User> opt = repository.findById("12345");
        System.out.println(opt.orElse(null));
    }

    @Test
    public void testSave() {
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setId(String.valueOf(System.currentTimeMillis()));
            user.setAge(20 + i);
            user.setGender(String.valueOf(i % 2));
            user.setName("username" + i);
            user.setCountry("country" + i * 2);
            user.setLocation("location" + i * 4);
            User savedUser = repository.save(user);
            System.out.println(savedUser);
        }
    }
}