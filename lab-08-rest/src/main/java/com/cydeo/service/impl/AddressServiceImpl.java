package com.cydeo.service.impl;
import com.cydeo.dto.AddressDTO;
import com.cydeo.entity.Address;
import com.cydeo.entity.Customer;
import com.cydeo.mapper.MapperUtil;
import com.cydeo.repository.AddressRepository;
import com.cydeo.service.AddressService;
import com.cydeo.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AddressServiceImpl implements AddressService {


    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final CustomerService customerService;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, CustomerService customerService) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.customerService = customerService;
    }

    @Override
    public List<AddressDTO> readAll() {
        return addressRepository.findAll().stream()
                .map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public AddressDTO update(AddressDTO addressDTO) {

        Address address = mapperUtil.convert(addressDTO, new Address());

        address.setCustomer(mapperUtil
                .convert(customerService.findById(addressDTO.getCustomerId()), new Customer()));

        Address updatedAddress = addressRepository.save(address);

        return mapperUtil.convert(updatedAddress, new AddressDTO());

    }

    @Override
    public AddressDTO create(AddressDTO addressDTO) {

        Address address = mapperUtil.convert(addressDTO, new Address());

        address.setCustomer(mapperUtil
                .convert(customerService.findById(addressDTO.getCustomerId()), new Customer()));

        Address savedAddress = addressRepository.save(address);

        return mapperUtil.convert(savedAddress, new AddressDTO());

    }

    @Override
    public List<AddressDTO> readByStartsWith(String address) {
        return addressRepository.findAllByStreetStartingWith(address)
                .stream().map(address1 -> mapperUtil.convert(address1, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> readAllByCustomerId(Long id) {
        return addressRepository.retrieveByCustomerId(id)
                .stream().map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> readAllByCustomerIdAndName(Long customerId, String name) {
        return addressRepository.findAllByCustomerIdAndName(customerId, name)
                .stream().map(address -> mapperUtil.convert(address, new AddressDTO()))
                .collect(Collectors.toList());
    }

}
