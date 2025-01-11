package org.isai.api_estudiantes_cursos.exceptiones;

import jakarta.persistence.EntityExistsException;

public class ObjectExistingException
        extends EntityExistsException {
    public ObjectExistingException(String name) {
        super("Object with name " + name + " already exists.");
    }
}
