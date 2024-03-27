package com.example.student.controller;


import com.example.student.entity.Address;
import com.example.student.repository.AddressRepo;
import com.example.student.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {

    // Inject the AddressService for handling address-related operations.
    @Autowired
    private AddressService service;

    // Define a post endpoint for saving an Address.
    @PostMapping("/saveAddress")
    public Address saveAddress(@RequestBody Address address) {
        return service.saveAddress(address);
    }

    // Define a get endpoint for retrieving a list of all Addresses.
    @GetMapping("/addressList")
    public List<Address> getAllAddress() {
        return service.getAllAddress();
    }

    // Define a get endpoint for retrieving an Address by its Id.
    @GetMapping("/getAddressById/{addressId}")
    public Address getAddressById(@PathVariable("addressId") int addressId) {
        return service.getAddressById(addressId).orElse(null);
    }

    // Define a put endpoint for updating an existing Address by its Id.
    @PutMapping("/updateAddress/{addressId}")
    public Address updateAddress(@PathVariable("addressId") int addressId, @RequestBody Address updateAddress) {
        return service.updateAddress(addressId, updateAddress);
    }

    // Define a delete endpoint for deleting an Address by its Id.
    @DeleteMapping("/deleteAddress/{addressId}")
    public String deleteAddress(@PathVariable("addressId") int addressId) {
        // Call the service to delete the Address by Id.
        service.deleteAddress(addressId);
        return "Deleted Successfuly";
    }
}
