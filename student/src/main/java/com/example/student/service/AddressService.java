package com.example.student.service;


import com.example.student.entity.Address;
import com.example.student.repository.AddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressService {

    private final AddressRepo addressRepo;

    // Constructor to inject the AddressRepo dependency.
    @Autowired
    public AddressService(AddressRepo addressRepo) {
        this.addressRepo = addressRepo;
    }

    // Retrieve a list of all addresses.
    public List<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    // Retrieve an address by its ID.
    public Optional<Address> getAddressById(int addressId) {
        return addressRepo.findById(addressId);
    }

    // Save a new address.
    public Address saveAddress(Address address) {
        return addressRepo.save(address);
    }

    // Update an existing address.
    public Address updateAddress(int addressId, Address updatedAddress) {
        // Attempt to find the existing address by its ID.
        Optional<Address> existingAddress = addressRepo.findById(addressId);
        if (existingAddress.isPresent()) {
            // If the address exists, update its details.
            Address addressToUpdate = existingAddress.get();
            addressToUpdate.setStreetAddress(updatedAddress.getStreetAddress());
            addressToUpdate.setCity(updatedAddress.getCity());
            addressToUpdate.setState(updatedAddress.getState());
            addressToUpdate.setPincode(updatedAddress.getPincode());
            // Save the updated address to the repository and return it.
            return addressRepo.save(addressToUpdate);
        } else {
            // If no matching address is found, return null.
            return null;
        }
    }

    // Delete an address by its ID.
    public void deleteAddress(int addressId) {
        addressRepo.deleteById(addressId);
    }
}

