package com.cydeo.labormecommerce.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
public class Customer extends BaseEntity {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;

    @OneToMany(mappedBy = "customer")
    private List<Address> addressList;
}
