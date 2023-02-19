package com.wrotecode.springdata.repository;

import com.wrotecode.springdata.config.DbConfig;
import com.wrotecode.springdata.entity.Address;
import com.wrotecode.springdata.entity.Person;
import com.wrotecode.springdata.util.IdUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = DbConfig.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Test
    public void testOneToOne() {
        String personId = IdUtil.nextId();
        String addressId = IdUtil.nextId();
        String zipCode = String.valueOf(System.currentTimeMillis());
        Person person = new Person();
        person.setId(personId);
        Address address = new Address();
        address.setId(addressId);
        address.setZipCode(zipCode);
        person.setAddressZip(address);
        addressRepository.save(address);
        Person person2 = personRepository.save(person);
        System.out.println(person2);
        Person person3 = personRepository.findByAddressZipCode(zipCode);
        System.out.println(person3);
    }
}