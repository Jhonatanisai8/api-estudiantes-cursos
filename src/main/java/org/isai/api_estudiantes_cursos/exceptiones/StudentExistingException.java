package org.isai.api_estudiantes_cursos.exceptiones;

import jakarta.persistence.EntityExistsException;

public class StudentExistingException
        extends EntityExistsException {
    public StudentExistingException(String name) {
        super("Student with id " + name + " already exists.");
    }
}
