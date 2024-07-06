package com.mini_project_2.Patient_Medicine_and_Appointment.Entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "appointment")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Appointment.PatientId", query = "from appointment where patientId =:id")
@NamedQuery(name = "Appointment.DoctorId", query = "from appointment where doctorId =:id")
@NamedQuery(name = "Appointment.DateSlot", query = "from appointment where doctorId =:id and visitDate =:vdate")
public class Appointment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int appointment_id;

	@Column(name = "appointment_doctor_id")
	private int doctorId;

	@Column(name = "appointment_patient_id")
	private int patientId;

	@PastOrPresent
	@Column(name = "visit_date")
	private LocalDate visitDate;

	private int slot;

	private boolean booked;

}
