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
@Table(name = "TB_SALA", schema = "escola_db")
public class Classroom {

	@Id
	@Column(name = "ID_SALA")
	private Long classroomId;

	@Column(name = "NOME_SALA")
	private String classroomName;

	@Column(name = "NUM_SALA")
	private Long roomNumber;

	@Column(name = "QTD_LUGARES")
	private Long maxStudentsAllowed;
}
