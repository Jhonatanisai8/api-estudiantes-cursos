package org.isai.api_estudiantes_cursos.models;

import java.util.List;

public class Student {

    private Long idStudent;
    private String name;
    private String email;
    private Integer edad;
    private List<Cource> cources;

    public Long getIdStudent() {
        return idStudent;
    }

    public String getName() {
        return name;
    }

    public List<Cource> getCources() {
        return cources;
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
