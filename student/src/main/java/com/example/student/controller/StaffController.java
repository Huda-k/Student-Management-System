package com.example.student.controller;


import com.example.student.entity.Staff;
import com.example.student.repository.StaffRepo;
import com.example.student.service.StaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StaffController {
    @Autowired
    private StaffService service;


    @PostMapping("/saveStaff")
    public Staff saveStaff(@RequestBody Staff staff) {
        return service.saveStaff(staff);
    }

    @GetMapping("/staffList")
    public List<Staff> getAllStaff() {
        return service.getAllStaff();
    }

    @GetMapping("/getStaffById/{staffId}")
    public Staff getStaffById(@PathVariable("staffId") int staffId) {
        return service.getStaffById(staffId).orElse(null);
    }

    @PutMapping("/updateStaff/{staffId}")
    public Staff updateStaff(@PathVariable("staffId") int staffId, @RequestBody Staff updateStaff) {
        return service.updateStaff(staffId, updateStaff);
    }

    @DeleteMapping("/deleteStaff/{staffId}")
    public String deleteStaff(@PathVariable("staffId") int staffId) {
        service.deleteStaff(staffId);
        return "Deleted Successfully";
    }
}