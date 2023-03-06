package br.school.SchoolProject.service;

import static br.school.SchoolProject.utils.Constants.Logs.ID_TURMA;
import static org.springframework.data.jpa.domain.Specification.where;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.school.SchoolProject.domain.Classes;
import br.school.SchoolProject.domain.filter.StudentFilter;
import br.school.SchoolProject.domain.form.StudentCreateForm;
import br.school.SchoolProject.domain.form.StudentUpdateForm;
import br.school.SchoolProject.repository.ClassesRepository;
import br.school.SchoolProject.utils.Conditions;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClassesService extends Conditions<Classes> {

	private final ClassesRepository repository;

	private final ModelMapper mapper;

	private Long count = 1l;

	public Page<Classes> findStudents(StudentFilter filter, Pageable pageable) {

		return repository.findAll(where(equals(ID_TURMA, filter.getClassId())), pageable);
	}

	public Classes createClass(StudentCreateForm form) {

		var newClass = new Classes();
		mapper.map(form, newClass);

		getId(newClass);

		return repository.save(newClass);
	}

	private void getId(Classes classes) {

		if (repository.existsById(count)) {
			count = count + 1L;
			getId(classes);
		} else {
			classes.setClassId(count);
		}
	}

	public Classes updateClass(StudentUpdateForm form, Long id) {
		var classes = repository.findById(id).orElse(null);

		mapper.map(form, classes);

		return repository.save(classes);
	}

	public void deleteClass(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);

		}
	}
}