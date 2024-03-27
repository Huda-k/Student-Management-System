package com.example.student.service;


import com.example.student.entity.Staff;
import com.example.student.repository.StaffRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {
    private final StaffRepo staffRepo;

    @Autowired
    public StaffService(StaffRepo staffRepo) {
        this.staffRepo = staffRepo;
    }

    public List<Staff> getAllStaff() {
        return staffRepo.findAll();
    }

    public Optional<Staff> getStaffById(int staffId) {
        return staffRepo.findById(staffId);
    }

    public Staff saveStaff(Staff staff) {
        return staffRepo.save(staff);
    }

    public Staff updateStaff(int staffId, Staff updatedStaff) {
        Optional<Staff> existingStaff = staffRepo.findById(staffId);
        if (existingStaff.isPresent()) {
            Staff staffToUpdate = existingStaff.get();
            staffToUpdate.setName(updatedStaff.getName());
            staffToUpdate.setContactInformation(updatedStaff.getContactInformation());
            return staffRepo.save(staffToUpdate);
        } else {
            return null;
        }
    }

    public void deleteStaff(int staffId) {
        staffRepo.deleteById(staffId);
    }

}