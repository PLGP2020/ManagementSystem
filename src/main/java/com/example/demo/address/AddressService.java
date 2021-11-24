package com.example.demo.address;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class AddressService {


    private  AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public List<Address> getAddresses() {
        return addressRepository.findAll();
    }


    public Address saveAddress(Address address) {
        return  addressRepository.saveAndFlush(address);
    }

    public void deleteAddress(Address address,Long id) {
        addressRepository.deleteById(id);
    }

    public Address editAddress(Address address,Long id) {
        return addressRepository.saveAndFlush(address);
    }
}
