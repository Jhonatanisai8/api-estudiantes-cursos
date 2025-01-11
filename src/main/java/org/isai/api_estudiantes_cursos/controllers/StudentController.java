package org.isai.api_estudiantes_cursos.controllers;

import java.net.URI;
import java.util.List;

import org.isai.api_estudiantes_cursos.exceptiones.StudentExistingException;
import org.isai.api_estudiantes_cursos.models.Student;
import org.isai.api_estudiantes_cursos.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService service;

    @PostMapping
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        try {
            service.saveStudent(student);
            URI locacion = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(student.getIdStudent())
                    .toUri();
            return ResponseEntity
                    .created(locacion)
                    .body(student);
        } catch (StudentExistingException e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Student>> getStudents() {
        return ResponseEntity
                .ok(service.getStudents());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@RequestBody Student student, @PathVariable Long id) {
        try {
            Student student2 = service.updateStudentByID(id, student);
            return ResponseEntity
                    .ok()
                    .body(student2);
        } catch (Exception e) {
            return ResponseEntity
                    .badRequest()
                    .body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudentById(@PathVariable Long id) {
        try {
            Student student = service.deleteStudentByID(id);
            return ResponseEntity
                    .ok()
                    .body(student);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(e.getMessage());
        }
    }

}
