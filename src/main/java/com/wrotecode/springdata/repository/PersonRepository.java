package com.wrotecode.springdata.repository;

import com.wrotecode.springdata.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonRepository extends JpaRepository<Person, String>, JpaSpecificationExecutor<Person> {
    Person findByAddressZipCode(String zipCode);
}