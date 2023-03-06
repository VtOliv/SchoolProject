package br.school.SchoolProject.domain;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "TB_ALUNO", schema = "escola_db")
public class Student {

	@Id
	@Column(name = "ID_ALUNO")
	private Long studentId;
	
	@Column(name = "ID_TURMA")
	private Long classId;
	
	@Column(name = "NOME_ALUNO")
	private String studentName;
	
	@Column(name = "DATA_NASC")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate birthday;
	
	@Column(name = "ALUNO_TEL")
	private String studentTelephone;
	
	@Column(name = "ALUNO_EMAIL")
	private String studentEmail;
	
	@Column(name = "NOME_END")
	private String address;
	
	@Column(name = "NOME_BAIRRO")
	private String neighborhood;
	
	@Column(name = "NOME_CIDADE")
	private String city;
	
	@Column(name = "CEP")
	private Long cep;
}
