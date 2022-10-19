package com.cydeo.labormecommerce;

import com.cydeo.labormecommerce.enums.CartState;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LabormecommerceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LabormecommerceApplication.class, args);
    }

    @Bean
    public ModelMapper mapper(){
        return new ModelMapper();
    }

}
