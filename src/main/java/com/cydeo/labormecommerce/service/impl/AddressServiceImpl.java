package com.cydeo.labormecommerce.service.impl;

import com.cydeo.labormecommerce.dto.AddressDTO;
import com.cydeo.labormecommerce.entity.Address;
import com.cydeo.labormecommerce.entity.Customer;
import com.cydeo.labormecommerce.mapper.MapperUtil;
import com.cydeo.labormecommerce.repository.AddressRepository;
import com.cydeo.labormecommerce.repository.CustomerRepository;
import com.cydeo.labormecommerce.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {
    private final AddressRepository addressRepository;
    private final CustomerRepository customerRepository;
    private final MapperUtil mapperUtil;

    public AddressServiceImpl(AddressRepository addressRepository, CustomerRepository customerRepository, MapperUtil mapperUtil) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO){
        Address address = new Address();
        address.setName(addressDTO.getName());
        address.setStreet(addressDTO.getStreet());
        address.setZipCode(addressDTO.getZipCode());
        address.setName(addressDTO.getName());
        address.setCustomer(customerRepository.findById(addressDTO.getCustomerId()).get());
        Address address1 = addressRepository.save(address);
        return mapperUtil.convert(address1, new AddressDTO());
    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO){
        Address address = new Address();
        address.setId(addressDTO.getId());
        address.setName(addressDTO.getName());
        address.setStreet(addressDTO.getStreet());
        address.setZipCode(addressDTO.getZipCode());
        address.setName(addressDTO.getName());
        address.setCustomer(customerRepository.findById(addressDTO.getCustomerId()).get());
        Address address1 = addressRepository.save(address);
        return mapperUtil.convert(address1, new AddressDTO());
    }


    @Override
    public List<AddressDTO> findAllAddress(){
        return addressRepository.findAll().stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findAddressListByCustomer(Long customerId){
        Customer customer = customerRepository.findById(customerId).get();
        return addressRepository.findAllByCustomer(customer).stream().map(address -> mapperUtil.convert(address, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findAddressListByStartsWith(String address){
        return addressRepository.findAllByStreetStartingWith(address).stream().map(add -> mapperUtil.convert(add, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> findAddressListByCustomerAndName(Long customerId, String name){
        Customer customer = customerRepository.findById(customerId).get();
        return addressRepository.findAllByCustomerAndName(customer, name).stream().map(add -> mapperUtil.convert(add, new AddressDTO())).collect(Collectors.toList());
    }
}
