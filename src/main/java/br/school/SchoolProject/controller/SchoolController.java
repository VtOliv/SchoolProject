package br.school.SchoolProject.controller;

import static org.springframework.data.domain.Sort.Direction.ASC;

import javax.validation.Valid;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.school.SchoolProject.domain.Student;
import br.school.SchoolProject.domain.filter.StudentFilter;
import br.school.SchoolProject.service.SchoolService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class SchoolController {

	public final SchoolService service;

	@GetMapping("students")
	public ResponseEntity<Page<Student>> findStudents(@Valid StudentFilter filter,
			@PageableDefault(sort = "studentId", direction = ASC, size = 20) Pageable pageable) {
		return ResponseEntity.status(HttpStatus.OK).body(service.findStudents(filter, pageable));
	}
}
