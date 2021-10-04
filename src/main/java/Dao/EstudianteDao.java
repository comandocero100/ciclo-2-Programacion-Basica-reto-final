/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Persona;
import java.util.ArrayList;

/**
 *
 * @author cristian
 */
public interface EstudianteDao {

    public String registrar(Persona est);

    public String modifcar(Persona est);

    public String eliminar(String correo);

    public Persona buscar(String correo);

    public ArrayList<Persona> listar();
    public ArrayList<Persona> cosultarCorreoBD(String correo);
    public ArrayList<Persona> cosultarCelular(long numero);

}
