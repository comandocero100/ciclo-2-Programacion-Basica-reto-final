/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;

/**
 *
 * @author Cristian
 */
public class Persona implements Serializable{

    private String nombres;
    private String apellidos;
    private String fechaNacimiento;
    private String correoInstitucional;
    private String correoPersonal;
    private long numTelefonocelular;
    private long numTelefonofijo;
    private String programaAcademico;

    public Persona(String nombres, String apellidos, String fechaNacimiento, String correoInstitucional, String correoPersonal, long numTelefonocelular, long numTelefonofijo, String programaAcademico) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.correoInstitucional = correoInstitucional;
        this.correoPersonal = correoPersonal;
        this.numTelefonocelular = numTelefonocelular;
        this.numTelefonofijo = numTelefonofijo;
        this.programaAcademico = programaAcademico;
    }

    //constructores
    public Persona() {
    }
//métodos

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getCorreoInstitucional() {
        return correoInstitucional;
    }

    public void setCorreoInstitucional(String correoInstitucional) {
        this.correoInstitucional = correoInstitucional;
    }

    public String getCorreoPersonal() {
        return correoPersonal;
    }

    public void setCorreoPersonal(String correoPersonal) {
        this.correoPersonal = correoPersonal;
    }

    public long getNumTelefonocelular() {
        return numTelefonocelular;
    }

    public void setNumTelefonocelular(long numTelefonocelular) {
        this.numTelefonocelular = numTelefonocelular;
    }

    public long getNumTelefonofijo() {
        return numTelefonofijo;
    }

    public void setNumTelefonofijo(long numTelefonofijo) {
        this.numTelefonofijo = numTelefonofijo;
    }

    public String getProgramaAcademico() {
        return programaAcademico;
    }

    public void setProgramaAcademico(String programaAcademico) {
        this.programaAcademico = programaAcademico;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", fechaNacimiento=" + fechaNacimiento + ", correoInstitucional=" + correoInstitucional + ", correoPersonal=" + correoPersonal + ", numTelefonocelular=" + numTelefonocelular + ", numTelefonofijo=" + numTelefonofijo + ", programaAcademico=" + programaAcademico + '}';
    }

}
