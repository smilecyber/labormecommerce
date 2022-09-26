package com.cydeo.labormecommerce.model;

import com.cydeo.labormecommerce.enums.PaymentMethod;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    private Long id;
    private BigDecimal paidPrice;
    @OneToOne
    private Orders order;
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;
}
