/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import Dao.*;
import java.util.ArrayList;

public class Logica {

    EstudianteDao dao = new EstudianteDaoImpl();
    EstudianteDao daoSQL=new EstudianteDaoSqlImpl();

    public String registrarEstudiate(Persona estu) {
        String response = dao.registrar(estu);
        return response;
    }

    public Persona buscarEstudiente(String correo) {
        Persona estudiante = dao.buscar(correo);
        return estudiante;
    }

    public String modificarEstudiante(Persona est) {
        String response = dao.modifcar(est);
        return response;
    }

    public String elimiarEstudiante(String correo) {
        String response = dao.eliminar(correo);
        return response;
    }

    public ArrayList<Persona> verBD() {
        ArrayList<Persona> lista = dao.listar();
        return lista;
    }
    
    // *****************************  SQL ****************************
    public String registrarEstudiateDB(Persona estu) {
        String response = daoSQL.registrar(estu);
        return response;
    }
    public String elimiarEstudianteDB(String correo) {
        String response = daoSQL.eliminar(correo);
        return response;
    }
     public Persona buscarEstudienteBD(String correo) {
        Persona estudiante = daoSQL.buscar(correo);
        return estudiante;
    }
     public String modificarEstudianteBD(Persona est) {
        String response = daoSQL.modifcar(est);
        return response;
    }
      public ArrayList<Persona> verBDSQL() {
        ArrayList<Persona> lista = daoSQL.listar();
        return lista;
    }
      public ArrayList<Persona> correoSQL(String correo) {
        ArrayList<Persona> lista = daoSQL.cosultarCorreoBD(correo);
        return lista;
    }
      public ArrayList<Persona> celularSQL(long celular) {
        ArrayList<Persona> lista = daoSQL.cosultarCelular(celular);
        return lista;
    }
      
      
}
