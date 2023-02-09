package com.wrotecode.springdata.repository;

import com.wrotecode.springdata.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository
        extends JpaRepository<User, String>, JpaSpecificationExecutor<User> {
}
