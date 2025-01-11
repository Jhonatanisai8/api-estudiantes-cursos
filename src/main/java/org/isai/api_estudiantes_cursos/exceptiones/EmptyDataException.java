package org.isai.api_estudiantes_cursos.exceptiones;

public class EmptyDataException
        extends IllegalArgumentException {
    public EmptyDataException(Object datum) {
        super("Empty data: " + datum);
    }
}
