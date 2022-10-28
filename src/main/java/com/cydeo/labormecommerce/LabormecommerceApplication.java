package com.cydeo.labormecommerce;

import com.cydeo.labormecommerce.enums.CartState;
import com.cydeo.labormecommerce.model.*;
import com.cydeo.labormecommerce.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.util.List;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.cydeo.labormecommerce.repository"})

public class LabormecommerceApplication {

    private final CustomerRepository customerRepository;
    private final ProductRepository productRepository;
    private final OrderRepository orderRepository;
    private final CategoryRepository categoryRepository;
    private final CartItemRepository cartItemRepository;

    public LabormecommerceApplication(CustomerRepository customerRepository, ProductRepository productRepository, OrderRepository orderRepository, CategoryRepository categoryRepository, CartItemRepository cartItemRepository) {
        this.customerRepository = customerRepository;
        this.productRepository = productRepository;
        this.orderRepository = orderRepository;
        this.categoryRepository = categoryRepository;
        this.cartItemRepository = cartItemRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(LabormecommerceApplication.class, args);
    }

    @PostConstruct
    public void startup(){
        Customer customer = customerRepository.findCustomerById(1L);


        List<Product> productList = productRepository.retrieveProductListGreaterThanPriceAndLowerThanRemainingQuantity(new BigDecimal(4),25);
        List<Order> orderList = orderRepository.retrieveOrdersByProductName("Zucchini - Mini, Green");
        List<Order> orderList2 = orderRepository.retrieveOrdersByProductCategoryId(10L);
        Category category = categoryRepository.findFirstByName("Site Furnishings");
        List<Product> products = productRepository.findProductByCategoryListContaining(category);
        List<Order> orders = orderRepository.retrieveOrdersPaidPriceAndTotalPriceAreNotEqualAndDiscountIsNull();

        List<CartItem> cartItems = cartItemRepository.retriveCartItemThatSold(313L, CartState.SOLD.name());
        List<CartItem> cartItems2 = cartItemRepository.retriveCartItemThatSoldWithOutDiscount(313L, CartState.SOLD.name());
        System.out.println(customer.getEmail());

    }

}
