package com.cg.emp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.emp.entities.GradeMaster;

@Repository
public interface GradeMasterRepository extends JpaRepository<GradeMaster, String> {

}
