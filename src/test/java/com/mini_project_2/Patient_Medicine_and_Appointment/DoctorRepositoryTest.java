package com.mini_project_2.Patient_Medicine_and_Appointment;

import java.time.LocalDate;

import com.mini_project_2.Patient_Medicine_and_Appointment.Entity.Doctor;
import com.mini_project_2.Patient_Medicine_and_Appointment.Repository.DoctorRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class DoctorRepositoryTest {

	@Mock
	private DoctorRepository doctorRepository;

	Doctor doctor = new Doctor();

	@BeforeEach
	public void init() {
		MockitoAnnotations.openMocks(this);

		doctor.setDoctor_name("Girisha");
		doctor.setDob(LocalDate.of(1996, 11, 03));
		doctor.setSpecialization("Surgeon");
		doctor.setSex("Female");
		doctor.setMobile_no("7861111369");
		doctor.setAddress("136 J1");
		doctor.setEmail("girisha@outlook.com");
		doctor.setLogin_password("girisha@");

		doctorRepository.save(doctor);
	}

	@Test
	public void getByName() {
		// Check if the searched doctor name is same as the doctor record that is
		// saved
		String search_doctor_name_1 = "Girisha";
		Assertions.assertEquals(search_doctor_name_1, doctor.getDoctor_name());

		// Check if the searched doctor name is not same as the doctor record that
		// is saved
		String search_doctor_name_2 = "Giri";
		Assertions.assertNotEquals(search_doctor_name_2, doctor.getDoctor_name());
	}

}
