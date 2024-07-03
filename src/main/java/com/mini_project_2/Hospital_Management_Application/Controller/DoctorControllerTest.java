//=======================================================================
//                          For Test Purpose                            =
//=======================================================================


package com.mini_project_2.Hospital_Management_Application.Controller;

import com.mini_project_2.Hospital_Management_Application.Entity.Doctor;
import com.mini_project_2.Hospital_Management_Application.Repository.*;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Optional;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(DoctorController.class)
public class DoctorControllerTest {

    @Autowired
    private MockMvc mockMvc;



    @MockBean
    private DoctorRepository doctorRepository;

    @MockBean
    private PatientRepository patientRepository;

    @MockBean
    private AppointmentRepository appointmentRepository;

    @MockBean
    private MedicalHistoryRepository medicalHistoryRepository;

    @MockBean
    private PrescriptionRepository prescriptionRepository;


    private Doctor doctor;

    @BeforeEach
    public void setup(){
        doctor=new Doctor();
        doctor.setDoctor_id(1);
        doctor.setDoctor_name("Dr. Gannesh");
        doctor.setEmail("ganesh@example.com");
    }
    @Test
    public void testWelcome() throws Exception {
        given(doctorRepository.findById(1)).willReturn(Optional.of(doctor));

        mockMvc.perform(get("/doctor/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("doctor_welcome"))
                .andExpect(model().attribute("id", 1))
                .andExpect(model().attribute("name", "Dr. John"));
    }
}
