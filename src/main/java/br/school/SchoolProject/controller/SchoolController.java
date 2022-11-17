package br.school.SchoolProject.controller;

import static br.school.SchoolProject.utils.Constants.Logs.LOG_CREATE;
import static br.school.SchoolProject.utils.Constants.Logs.LOG_SEARCH;
import static org.springframework.data.domain.Sort.Direction.ASC;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.school.SchoolProject.domain.Student;
import br.school.SchoolProject.domain.filter.StudentFilter;
import br.school.SchoolProject.domain.form.StudentForm;
import br.school.SchoolProject.service.SchoolService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class SchoolController {

	public final SchoolService service;

	@GetMapping("students")
	public ResponseEntity<Page<Student>> findStudents(@Valid StudentFilter filter,
			@PageableDefault(sort = "studentId", direction = ASC, size = 20) Pageable pageable) {

		var page = service.findStudents(filter, pageable);

		log.info(LOG_SEARCH, filter, page.getTotalElements());

		return ResponseEntity.status(HttpStatus.OK).body(page);
	}

	@PostMapping("students")
	public ResponseEntity<Student> newStudent(@Valid @RequestBody StudentForm form) {
		var newStudent = service.createStudent(form);

		log.info(LOG_CREATE, newStudent.getStudentId(), "Criado com Sucesso!");

		return ResponseEntity.status(HttpStatus.OK).body(newStudent);
	}
}
