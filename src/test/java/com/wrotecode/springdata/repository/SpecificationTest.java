package com.wrotecode.springdata.repository;

import com.wrotecode.springdata.config.DbConfig;
import com.wrotecode.springdata.entity.User;
import com.wrotecode.springdata.entity.User_;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@ContextConfiguration(classes = DbConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class SpecificationTest {
    @Autowired
    private UserRepository repository;
    @Autowired
    private EntityManager entityManager;

    @Test
    public void demo() {
        Specification<User> specification = (root, query, builder) -> {
            Predicate predicate = builder.ge(root.get(User_.age), 20);
            return predicate;
        };
        List<User> all = repository.findAll(specification);
        System.out.println(all);
    }

    @Test
    public void testCriteriaQuery() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> query = criteriaBuilder.createQuery(User.class);
        Root<User> root = query.from(User.class);
        Predicate predicate = criteriaBuilder.ge(root.get(User_.age), 20);
        query.where(predicate);
        List<User> resultList = entityManager.createQuery(query).getResultList();
        System.out.println(resultList);
    }
}
