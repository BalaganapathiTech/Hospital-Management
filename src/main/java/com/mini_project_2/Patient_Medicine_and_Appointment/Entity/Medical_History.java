package com.mini_project_2.Patient_Medicine_and_Appointment.Entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties()
@Entity(name = "medical_history")
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
@NamedQuery(name = "Medical_History.PatientId", query = "from medical_history where patientId =:id")
public class Medical_History {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int history_id;

	@NotEmpty
	@Column(name = "history_patient_id")
	private int patientId;

	@NotEmpty
	@PastOrPresent
	private LocalDate diagnosis_date;

	private String medical_condition;
}
