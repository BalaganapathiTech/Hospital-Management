package com.mini_project_2.Hospital_Management_Application.Repository;

import java.util.List;

import com.mini_project_2.Hospital_Management_Application.Entity.Medical_History;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Medical History - Rest API Controllers", description = "Medical History API")
@RepositoryRestResource(collectionResourceRel = "medical_history", path = "medical_history")
public interface MedicalHistoryRepository extends JpaRepository<Medical_History, Integer> {
	public List<Medical_History> findByPatientId(@Param("id") int id);

}