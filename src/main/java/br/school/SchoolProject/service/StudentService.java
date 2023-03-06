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
import br.school.SchoolProject.domain.form.StudentCreateForm;
import br.school.SchoolProject.domain.form.StudentUpdateForm;
import br.school.SchoolProject.repository.StudentRepository;
import br.school.SchoolProject.utils.Conditions;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentService extends Conditions<Student> {

	private final StudentRepository repository;

	private final ModelMapper mapper;
	
	private Long count = 1l;

	public Page<Student> findStudents(StudentFilter filter, Pageable pageable) {

		return repository.findAll(where(equals(ID_ALUNO, filter.getStudentId()))
				.and(equals(ID_TURMA, filter.getClassId()))
				.and(like(STUDENT_NAME, filter.getStudentName())), pageable);
	}

	public Student createStudent(StudentCreateForm form) {

		var newStudent = new Student();
		mapper.map(form, newStudent);

		getId(newStudent);
		
		return repository.save(newStudent);
	}
	
	private void getId(Student student) {
		
		
		if(repository.existsById(count)) {
			count = count + 1L;
			getId(student);
		} else {
			student.setStudentId(count);
		}
	}
	
	
	public Student updateStudent(StudentUpdateForm form, Long id) {
		var student = repository.findById(id).orElse(null);
		
		mapper.map(form, student);
		
		return repository.save(student);
	}
	
	public void deleteStudent(Long id) {
		if(repository.existsById(id)) {			
			repository.deleteById(id);
			
		}
	}
}