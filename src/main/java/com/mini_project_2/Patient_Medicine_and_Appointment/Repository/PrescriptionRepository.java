package com.mini_project_2.Patient_Medicine_and_Appointment.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import com.mini_project_2.Patient_Medicine_and_Appointment.Entity.Prescription;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Prescription History - Rest API Controllers", description = "Prescription API")
@RepositoryRestResource(collectionResourceRel = "prescription", path = "prescription")
public interface PrescriptionRepository extends JpaRepository<Prescription, Integer> {

	public List<Prescription> findByPatientId(@Param("id") int id);

	public List<Prescription> findByDoctorId(@Param("id") int id);
}
