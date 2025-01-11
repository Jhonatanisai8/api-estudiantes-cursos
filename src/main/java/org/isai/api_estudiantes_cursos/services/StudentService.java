package org.isai.api_estudiantes_cursos.services;

import org.isai.api_estudiantes_cursos.exceptiones.StudentNotFoundException;
import org.isai.api_estudiantes_cursos.models.Student;
import org.isai.api_estudiantes_cursos.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public Student getStudentByID(Long idStudent) {
        return repository
                .findById(idStudent)
                .orElseThrow(() -> new StudentNotFoundException(idStudent));
    }

}
