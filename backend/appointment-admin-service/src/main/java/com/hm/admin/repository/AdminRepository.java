package com.hm.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.admin.model.Doctor;




public interface AdminRepository extends JpaRepository<Doctor,Long>{

	Doctor findByDoctorPhone(double doctorPhone);

	void deleteByDoctorPhone(Long doctorPhone);

	

}
