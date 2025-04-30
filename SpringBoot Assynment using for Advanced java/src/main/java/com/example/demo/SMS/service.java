package com.example.demo.SMS;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

@Service  // Marks this as a Spring service
public class service {
    private final Map<Long, Staff> staffMap = new HashMap<>();
    private Long nextId = 1L;  // Auto-increment ID

    // Get all staff
    public List<Staff> getAllStaff() {
        return new ArrayList<>(staffMap.values());
    }

    // Get staff by ID
    public Staff getStaffById(Long id) {
        return staffMap.get(id);
    }

    // Create new staff
    public Staff createStaff(Staff staff) {
        staff.setId(nextId);
        staffMap.put(nextId, staff);
        nextId++;
        return staff;
    }

    // Update staff
    public Staff updateStaff(Long id, Staff updatedStaff) {
        if (!staffMap.containsKey(id)) {
            throw new RuntimeException("Staff not found with ID: " + id);
        }
        updatedStaff.setId(id);
        staffMap.put(id, updatedStaff);
        return updatedStaff;
    }

    // Delete staff
    public void deleteStaff(Long id) {
        if (!staffMap.containsKey(id)) {
            throw new RuntimeException("Staff not found with ID: " + id);
        }
        staffMap.remove(id);
    }
}
