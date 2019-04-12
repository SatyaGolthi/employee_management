package com.cg.emp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.emp.entities.GradeMaster;
import com.cg.emp.repository.GradeMasterRepository;


@Service
public class GradeMasterServiceImpl implements GradeMasterService {

	@Autowired
	GradeMasterRepository gradeRepo;
	
	@Override
	public GradeMaster addGradeMaster(GradeMaster grademaster) {
		GradeMaster gm= gradeRepo.save(grademaster);
		System.out.println(gm.toString());
		return gm;
	}

}
