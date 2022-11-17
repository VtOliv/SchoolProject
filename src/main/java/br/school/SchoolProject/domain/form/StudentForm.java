package br.school.SchoolProject.domain.form;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentForm {

	private Long studentId;
	
	private Long classId;
	
	private String studentName;
	
	private LocalDate birthday;
	
	private String studentTelephone;
	
	private String studentEmail;
	
	private String address;
	
	private String neighborhood;
	
	private String city;
	
	private Long cep;
}
