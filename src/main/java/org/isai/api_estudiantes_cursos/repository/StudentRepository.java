package org.isai.api_estudiantes_cursos.repository;

import org.isai.api_estudiantes_cursos.models.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository
        extends CrudRepository<Student, Long> {

}
