package com.dona.tarealabo5.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;


@Entity
@Table(schema="public",name="estudiante")
public class Estudiante {
    
    @Column(name = "id_estudiante")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer codStudent;

    @NotEmpty
    @Size(max = 50, message = "50 caracteres maximo")
    @Column(name = "nombre")
    private String name;

    @NotEmpty
    @Size(max = 50, message = "50 caracteres maximo")
    @Column(name = "apellido")
    private String lastName;

    @NotEmpty
    @Size(max = 10, message = "10 caracteres maximo")
    @Column(name = "carne")
    private String carne;

    @NotEmpty
    @Size(max = 100, message = "100 caracter maximo")
    @Column(name = "carrera")
    private String career;

    public Estudiante() {
    }

    public Integer getCodStudent() {
        return this.codStudent;
    }

    public void setCodStudent(Integer codStudent) {
        this.codStudent = codStudent;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCarne() {
        return this.carne;
    }

    public void setCarne(String carne) {
        this.carne = carne;
    }

    public String getCareer() {
        return this.career;
    }

    public void setCareer(String career) {
        this.career = career;
    }


}