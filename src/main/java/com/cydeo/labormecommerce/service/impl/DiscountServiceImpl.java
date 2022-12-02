package com.cydeo.labormecommerce.service.impl;

import com.cydeo.labormecommerce.dto.DiscountDTO;
import com.cydeo.labormecommerce.dto.OrderDTO;
import com.cydeo.labormecommerce.entity.Discount;
import com.cydeo.labormecommerce.mapper.MapperUtil;
import com.cydeo.labormecommerce.repository.DiscountRepository;
import com.cydeo.labormecommerce.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiscountServiceImpl implements DiscountService {
    private final DiscountRepository discountRepository;
    private final MapperUtil mapperUtil;

    public DiscountServiceImpl(DiscountRepository discountRepository, MapperUtil mapperUtil) {
        this.discountRepository = discountRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<DiscountDTO> retrieveDiscountList() {
        return discountRepository.findAll().stream().map(discount -> mapperUtil.convert(discount, new DiscountDTO())).collect(Collectors.toList());
    }

    @Override
    public DiscountDTO retrieveByName(String name) {
        return mapperUtil.convert(discountRepository.findFirstByName(name), new DiscountDTO());
    }

    @Override
    public DiscountDTO updateDiscount(DiscountDTO discountDTO) {
        Discount discount = mapperUtil.convert(discountDTO, new Discount());
        Discount discount1 = discountRepository.save(discount);
        return mapperUtil.convert(discount1, new DiscountDTO());
    }

    @Override
    public DiscountDTO createDiscount(DiscountDTO discountDTO) {
        Discount discount = mapperUtil.convert(discountDTO, new Discount());
        Discount discount1 = discountRepository.save(discount);
        return mapperUtil.convert(discount1, new DiscountDTO());
    }
}
