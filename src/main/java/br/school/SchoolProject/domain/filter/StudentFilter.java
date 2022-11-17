package br.school.SchoolProject.domain.filter;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentFilter {

	private Long studentId;
	
	private Long classId;
	
	private String studentName;
}
