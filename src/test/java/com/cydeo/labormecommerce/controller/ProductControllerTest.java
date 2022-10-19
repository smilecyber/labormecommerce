package com.cydeo.labormecommerce.controller;

import com.cydeo.labormecommerce.dto.ProductDTO;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class ProductControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getProductList() throws Exception {

        ResultActions actions = mvc.perform(MockMvcRequestBuilders
                        .get("/api/v1/product")
                        .accept(MediaType.APPLICATION_JSON));
                actions.andExpect(status().isOk());
    }


    @Test
    public void getProductListByName() throws Exception {

        ResultActions actions = mvc.perform(MockMvcRequestBuilders
                .get("/api/v1/product/name")
                .accept(MediaType.APPLICATION_JSON));
        actions.andExpect(status().isOk());
    }

    @Test
    public void createProduct() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("milk");
        productDTO.setQuantity(123);
        productDTO.setRemainingQuantity(123);
        productDTO.setPrice(BigDecimal.valueOf(34));

        mvc.perform(MockMvcRequestBuilders
                .post("/api/v1/product")
                .content(toJsonString(productDTO))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }

    @Test
    public void updateProduct() throws Exception {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setName("milk");
        productDTO.setQuantity(123);
        productDTO.setRemainingQuantity(123);
        productDTO.setPrice(BigDecimal.valueOf(34));

        mvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/product")
                        .content(toJsonString(productDTO))
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
