package org.isai.api_estudiantes_cursos.services;

import java.util.List;

import org.isai.api_estudiantes_cursos.exceptiones.EmptyDataException;
import org.isai.api_estudiantes_cursos.exceptiones.StudentExistingException;
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

    public List<Student> getStudents() {
        return (List<Student>) repository.findAll();
    }

    public Student saveStudent(Student student) {
        getStudents()
                .stream()
                .filter(studentWanted -> studentWanted.equals(student))
                .findFirst()
                .ifPresent(studentWanted -> {
                    throw new StudentExistingException(studentWanted.getName());
                });
        return repository.save(student);
    }

    public Student deleteStudentByID(Long idStudent) {
        Student student = getStudentByID(idStudent);
        repository.delete(student);
        return student;
    }

    public Student updateStudentByID(Long idStudent, Student student) {
        Student studentToUpdate = getStudentByID(idStudent);
        if (student.getEdad() != null || student.getEdad() >= 0) {
            studentToUpdate.setName(student.getName());
        } else {
            throw new EmptyDataException(student.getEdad());
        }
        if (student.getEmail() != null || !student.getEmail().isBlank()) {
            studentToUpdate.setEmail(student.getEmail());
        } else {
            throw new EmptyDataException(student.getEmail());
        }
        if (student.getName() != null || !student.getName().isBlank()) {
            studentToUpdate.setName(student.getName());
        } else {
            throw new EmptyDataException(student.getName());
        }
        return saveStudent(studentToUpdate);
    }
}
