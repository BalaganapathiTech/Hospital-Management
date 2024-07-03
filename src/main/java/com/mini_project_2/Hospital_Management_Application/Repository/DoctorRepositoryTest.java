//=======================================================================
//                          For Test Purpose only                       =
//=======================================================================

package com.mini_project_2.Hospital_Management_Application.Repository;

import com.mini_project_2.Hospital_Management_Application.Entity.Doctor;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJdbcTest
public class DoctorRepositoryTest {

    @Autowired
    private DoctorRepository doctorRepository;

    @Test
    public void testFindByEmail() {
        Doctor doctor = new Doctor();
        doctor.setDoctor_name("Dr. Ganesh");
        doctor.setEmail("ganesh@example.com");
        doctorRepository.save(doctor);

        Doctor found = doctorRepository.findByEmail("ganesh@example.com");
        assertThat(found).isNotNull();
        assertThat(found.getDoctor_name()).isEqualTo("Dr. Ganesh");
    }
}