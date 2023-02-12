package com.wrotecode.springdata.repository;

import com.wrotecode.springdata.config.DbConfig;
import com.wrotecode.springdata.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

@ContextConfiguration(classes = DbConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ExampleTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void exampleDemo() {
        User user = new User();
        user.setGender("1");
        Example<User> example = Example.of(user);
        Optional<User> one = repository.findOne(example);
        System.out.println(one);
    }

    @Test
    public void exampleMatcher() {
        User user = new User();
        user.setGender("1");
        ExampleMatcher matcher = ExampleMatcher.matching()
                .withIgnorePaths("id", "name", "age", "location", "country")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<User> example = Example.of(user, matcher);
        List<User> all = repository.findAll(example);
        System.out.println(all);
    }

    @Test
    public void exampleMatcherAny() {
        User user = new User();
        user.setGender("1");
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);
        Example<User> example = Example.of(user, matcher);
        List<User> all = repository.findAll(example);
        System.out.println(all);
    }

    @Test
    public void customerMatcherDemo() {
        User user = new User();
        user.setGender("1");
        user.setName("username");
        ExampleMatcher matcher = ExampleMatcher.matchingAny()
                .withMatcher("username", GenericPropertyMatchers.startsWith())
                .withMatcher("gender", ele -> ele.exact());
        Example<User> example = Example.of(user, matcher);
        List<User> all = repository.findAll(example);
        System.out.println(all);
    }
}
