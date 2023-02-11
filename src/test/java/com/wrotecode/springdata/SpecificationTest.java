package com.wrotecode.springdata;

import com.wrotecode.springdata.config.DbConfig;
import com.wrotecode.springdata.entity.User;
import com.wrotecode.springdata.entity.User_;
import com.wrotecode.springdata.repository.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.criteria.Predicate;
import java.util.List;

@ContextConfiguration(classes = DbConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpecificationTest {
    @Autowired
    private UserRepository repository;

    @Test
    public void demo() {
        Specification<User> specification = (root, query, builder) -> {
            Predicate predicate = builder.ge(root.get(User_.age), 20);
            return predicate;
        };
        List<User> all = repository.findAll(specification);
        System.out.println(all);
    }
}
