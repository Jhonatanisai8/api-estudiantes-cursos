package org.isai.api_estudiantes_cursos.models;

import java.util.List;

public class Cource {

    private Long idCource;
    private String name;
    private String descripcion;
    private Integer capacity;

    private Teacher teacher;
    
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
