package org.isai.api_estudiantes_cursos.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "teacher")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_teacher", nullable = false)
    private Long idTeacher;

    @NotNull
    private String name;

    @NotNull
    private String email;

    @NotNull
    private String speciality;

    @OneToMany(mappedBy = "teacher")
    private List<Course> courses = new ArrayList<>();

    public Long getIdTeacher() {
        return idTeacher;
    }

    public List<Course> getCources() {
        return courses;
    }

    public String getName() {
        return name;
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

}
