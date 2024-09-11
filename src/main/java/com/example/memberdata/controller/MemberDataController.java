package com.example.memberdata.controller;

import com.example.memberdata.entity.MemberData;
import com.example.memberdata.repository.MemberDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000") 

@RestController
@RequestMapping("/api/members")
public class MemberDataController {

    @Autowired
    private MemberDataRepository repository;

    // Retrieve all members
    @GetMapping
    public List<MemberData> getAllMembers() {
        return repository.findAll();
    }

    // Retrieve a member by ID
    @GetMapping("/{id}")
    public Optional<MemberData> getMemberById(@PathVariable Integer id) {
        return repository.findById(id);
    }

    // Create a new member
    @PostMapping
    public MemberData createMember(@RequestBody MemberData memberData) {
        return repository.save(memberData);
    }

    // Update an existing member
    @PutMapping("/{id}")
    public MemberData updateMember(@PathVariable Integer id, @RequestBody MemberData memberData) {
        MemberData existingMember = repository.findById(id).orElseThrow(() -> new RuntimeException("Member not found"));
        existingMember.setMember(memberData.getMember());
        existingMember.setMonth(memberData.getMonth());
        existingMember.setValue(memberData.getValue());
        return repository.save(existingMember);
    }

    // Delete a member
    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Integer id) {
        repository.deleteById(id);
    }
}
