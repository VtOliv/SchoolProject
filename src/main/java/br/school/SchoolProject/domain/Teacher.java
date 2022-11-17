package br.school.SchoolProject.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_PROFESSOR", schema = "escola_db")
public class Teacher {

	@Id
	@Column(name = "ID_PROFESSOR")
	private Long teacherId;
	
	@Column(name = "NOME_PROFESSOR")
	private String teacherName;
	
	@Column(name = "DT_CONTRATACAO")
	private LocalDate hiredAt;
}
