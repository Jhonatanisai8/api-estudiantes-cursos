package org.isai.api_estudiantes_cursos.exceptiones;

import jakarta.persistence.EntityNotFoundException;

public class StudentNotFoundException
        extends EntityNotFoundException {

    public StudentNotFoundException(Long id) {
        super("Student with id " + id + " not found.");
    }
}
