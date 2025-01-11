package org.isai.api_estudiantes_cursos;

import java.net.URI;

import org.isai.api_estudiantes_cursos.exceptiones.ObjectExistingException;
import org.isai.api_estudiantes_cursos.models.Teacher;
import org.isai.api_estudiantes_cursos.services.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService service;

    @PostMapping
    public ResponseEntity<?> saveTeacher(@RequestBody Teacher teacher) {
        try {
            service.saveTeacher(teacher);
            URI locacion = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(teacher.getIdTeacher())
                    .toUri();
            return ResponseEntity
                    .created(locacion)
                    .body(teacher);
        } catch (ObjectExistingException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }
}
