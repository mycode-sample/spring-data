package com.wrotecode.springdata.repository;

import com.wrotecode.springdata.entity.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, String> {
    User findById(String id);
}
