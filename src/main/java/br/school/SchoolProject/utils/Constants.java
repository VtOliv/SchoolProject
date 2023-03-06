package br.school.SchoolProject.utils;

import static br.school.SchoolProject.utils.Constants.Logs.INFO;
import static br.school.SchoolProject.utils.Constants.Logs.WARN;

import lombok.extern.slf4j.Slf4j;

public interface Constants {

	interface Logs {

		public static final String INFO = "info";
		public static final String WARN = "warn";

		public static final String LOG_SEARCH = "Filtro={} Resultados={}";
		public static final String LOG_BASE = "Id={} Resultado={}";

		public static final String ID_ALUNO = "studentId";
		public static final String ID_TURMA = "classId";
		public static final String STUDENT_NAME = "studentName";

	}

	@Slf4j
	class Teste {

		public void generateLog(String type, String fields, String... args) {

			if (INFO.equals(type)) {
				log.info(fields, args);
			}

			if (WARN.equals(type)) {
				log.warn(fields, args);
			}
		}
	}
}
