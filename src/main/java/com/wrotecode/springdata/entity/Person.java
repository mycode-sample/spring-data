package com.wrotecode.springdata.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Table(name = "person")
@Entity
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    private String id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "address_id")
    private Address addressZip;


    @Override
    public String toString() {
        return "Person{" + "id=" + id + ", addressId=" + addressZip + ", address=" + '}';
    }


    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public Address getAddressZip() {
        return addressZip;
    }

    public void setAddressZip(Address addressId) {
        this.addressZip = addressId;
    }
}
