package com.cydeo.labormecommerce.service;

import com.cydeo.labormecommerce.dto.AddressDTO;
import com.cydeo.labormecommerce.entity.Category;

import java.util.List;

public interface AddressService {
    AddressDTO createAddress(AddressDTO addressDTO);

    AddressDTO updateAddress(AddressDTO addressDTO);

    List<AddressDTO> findAllAddress();

    List<AddressDTO> findAddressListByCustomer(Long customerId);

    List<AddressDTO> findAddressListByStartsWith(String address);

    List<AddressDTO> findAddressListByCustomerAndName(Long customerId, String name);
}
