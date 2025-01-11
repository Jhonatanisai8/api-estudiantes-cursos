package org.isai.api_estudiantes_cursos.repository;

import org.isai.api_estudiantes_cursos.models.Teacher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository
        extends CrudRepository<Teacher, Long> {

}
