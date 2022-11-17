package br.school.SchoolProject.domain;

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
@Table(name = "TB_DISCIPLINA", schema = "escola_db")
public class Subject {

	@Id
	@Column(name = "ID_DISCIPLINA")
	private Long subjectId;
	
	@Column(name = "NOME_MATERIA")
	private String subjectName;
	
	@Column(name = "DESC_MATERIA")
	private String subjectDescription;
}
