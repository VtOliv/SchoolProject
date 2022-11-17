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
@Table(name = "TB_TURMA", schema = "escola_db")
public class Classes {
	
	@Id
	@Column(name = "ID_TURMA")
	private Long classId;
	
	@Column(name = "NOME_TURMA")
	private String className;
	
	@Column(name = "QTD_ALUNOS")
	private Long stundentAmount;
	
	@Column(name = "ID_SALA")
	private Long classroomId;
	
	@Column(name = "ID_PROFESSOR")
	private Long teacherId;
	
	@Column(name = "ID_DISCIPLINA")
	private Long subjectId;
}
