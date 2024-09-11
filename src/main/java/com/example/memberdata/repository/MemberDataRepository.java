package com.example.memberdata.repository;

import com.example.memberdata.entity.MemberData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberDataRepository extends JpaRepository<MemberData, Integer> {
}
