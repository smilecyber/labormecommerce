package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.CustomerDTO;
import com.cydeo.labormecommerce.dto.DiscountDTO;
import com.cydeo.labormecommerce.enums.DiscountType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class DiscountControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getDiscountList() throws Exception {

        ResultActions actions = mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/discount")
                        .accept(MediaType.APPLICATION_JSON));
                actions.andExpect(status().isOk());
    }


    @Test
    public void getDiscountListByName() throws Exception {

        ResultActions actions = mvc.perform(MockMvcRequestBuilders
                .get("/api/v1/discount/name")
                .accept(MediaType.APPLICATION_JSON));
        actions.andExpect(status().isOk());
    }

    @Test
    public void createDiscount() throws Exception {
        DiscountDTO discountDTO = new DiscountDTO();
        discountDTO.setDiscount(new BigDecimal(12));
        discountDTO.setName("get 15");
        discountDTO.setDiscountType(DiscountType.AMOUNT_BASED);

        mvc.perform(MockMvcRequestBuilders
                .post("/api/v1/discount")
                .content(toJsonString(discountDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void updateDiscount() throws Exception {
        DiscountDTO discountDTO = new DiscountDTO();
        discountDTO.setDiscount(new BigDecimal(12));
        discountDTO.setName("get 12");
        discountDTO.setDiscountType(DiscountType.AMOUNT_BASED);


        mvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/discount")
                        .content(toJsonString(discountDTO))
                        .contentType(MediaType.APPLICATION_JSON)
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    private static String toJsonString(final Object obj) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
            objectMapper.registerModule(new JavaTimeModule());
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
