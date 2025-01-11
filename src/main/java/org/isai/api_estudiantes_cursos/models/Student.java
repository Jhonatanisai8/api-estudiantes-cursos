package org.isai.api_estudiantes_cursos.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_student", nullable = false)
    private Long idStudent;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private Integer edad;

    @ManyToMany
    @JsonBackReference
    @JoinTable(name = "students_cources", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"), inverseJoinColumns = @JoinColumn(name = "cource_id", referencedColumnName = "cource_id"))
    private List<Course> courses;

    public Long getIdStudent() {
        return idStudent;
    }

    public String getName() {
        return name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

}
