package org.isai.api_estudiantes_cursos.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Long idCource;

    @NotNull
    private String name;

    @NotNull
    private String descripcion;

    @NotNull
    private Integer capacity;

    // relacion de muchos a uno
    @ManyToOne
    @JoinColumn(name = "id_teacher")
    @JsonBackReference
    private Teacher teacher;

    @ManyToMany
    @JoinTable(name = "students_courses", 
    joinColumns = @JoinColumn(name = "cource_id", referencedColumnName = "cource_id"), inverseJoinColumns = @JoinColumn(name = "student_id", referencedColumnName = "student_id"))
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public Long getIdCource() {
        return idCource;
    }

    public void setIdCource(Long idCource) {
        this.idCource = idCource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

}
