package org.isai.api_estudiantes_cursos.exceptiones;

import jakarta.persistence.EntityExistsException;

public class StudentExistingException
        extends EntityExistsException {
    public StudentExistingException(Long id) {
        super("Student with id " + id + " already exists.");
    }
}
