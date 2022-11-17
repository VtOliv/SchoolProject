package br.school.SchoolProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import br.school.SchoolProject.domain.Classes;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long>, JpaSpecificationExecutor<Classes> {
	
}
