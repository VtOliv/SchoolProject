package br.school.SchoolProject.service;

import static br.school.SchoolProject.utils.Constants.Logs.ID_ALUNO;
import static br.school.SchoolProject.utils.Constants.Logs.ID_TURMA;
import static br.school.SchoolProject.utils.Constants.Logs.STUDENT_NAME;
import static org.springframework.data.jpa.domain.Specification.where;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.school.SchoolProject.domain.Student;
import br.school.SchoolProject.domain.filter.StudentFilter;
import br.school.SchoolProject.domain.form.StudentForm;
import br.school.SchoolProject.repository.StudentRepository;
import br.school.SchoolProject.utils.Conditions;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SchoolService extends Conditions<Student> {

	private final StudentRepository repository;

	private final ModelMapper mapper;

	public Page<Student> findStudents(StudentFilter filter, Pageable pageable) {

		return repository.findAll(where(equals(ID_ALUNO, filter.getStudentId()))
				.and(equals(ID_TURMA, filter.getClassId()))
				.and(like(STUDENT_NAME, filter.getStudentName())), pageable);
	}

	public Student createStudent(StudentForm form) {
		var count = repository.count();
		form.setStudentId(count + 1);

		var newStudent = new Student();
		mapper.map(form, newStudent);

		return repository.save(newStudent);
	}
}
