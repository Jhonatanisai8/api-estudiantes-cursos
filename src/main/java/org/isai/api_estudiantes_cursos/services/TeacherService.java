package org.isai.api_estudiantes_cursos.services;

import java.util.List;

import org.isai.api_estudiantes_cursos.exceptiones.ObjectExistingException;
import org.isai.api_estudiantes_cursos.models.Teacher;
import org.isai.api_estudiantes_cursos.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository repository;

    public List<Teacher> getTeachers() {
        return (List<Teacher>) repository.findAll();
    }

    public Teacher saveTeacher(Teacher teacher) {
        boolean teacherExist = getTeachers()
                .stream()
                .anyMatch(existingTeacher -> existingTeacher.getName().equals(teacher.getName()));
        if (teacherExist) {
            throw new ObjectExistingException(teacher.getName());
        }
        return repository.save(teacher);
    }
}
