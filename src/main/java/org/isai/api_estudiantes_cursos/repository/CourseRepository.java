package org.isai.api_estudiantes_cursos.repository;

import org.isai.api_estudiantes_cursos.models.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository
        extends CrudRepository<Course, Long> {

}