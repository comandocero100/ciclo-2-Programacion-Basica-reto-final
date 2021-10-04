/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Modelo.Persona;
import java.util.ArrayList;
import java.io.*;


/**
 *
 * @author Cristian
 */
public class EstudianteDaoImpl implements EstudianteDao {

    ArrayList<Persona> listaEstudiante = new ArrayList<>();

    @Override
    public String registrar(Persona est) {

        String response = "";
        try {
            listaEstudiante.add(est);
            FileOutputStream cursorSalida = new FileOutputStream("file_data.dat");
            ObjectOutputStream escribirArchivo = new ObjectOutputStream(cursorSalida);
            escribirArchivo.writeObject(listaEstudiante);
            escribirArchivo.close();

            response = "Se agregó el estudiante\n";
        } catch (IOException e) {
            response = "Error---" + e;
        }
        return response;
    }

    @Override
    public String modifcar(Persona est) {
        String response = "";
        try {
            FileInputStream cursorEntrada = new FileInputStream("file_data.dat");
            ObjectInputStream leerArchivo = new ObjectInputStream(cursorEntrada);
            listaEstudiante = (ArrayList<Persona>) leerArchivo.readObject();
            leerArchivo.close();

            for (int i = 0; i < listaEstudiante.size(); i++) {
                if (listaEstudiante.get(i).getCorreoInstitucional().equals(est.getCorreoInstitucional())) {
                    listaEstudiante.get(i).setCorreoPersonal(est.getCorreoPersonal());
                    listaEstudiante.get(i).setNumTelefonocelular(est.getNumTelefonocelular());
                    listaEstudiante.get(i).setNumTelefonofijo(est.getNumTelefonofijo());
                    listaEstudiante.get(i).setProgramaAcademico(est.getProgramaAcademico());
                    response = "Se modificó el estudiante";
                }
            }
            FileOutputStream cursorSalida = new FileOutputStream("file_data.dat");
            ObjectOutputStream escribirArchivo = new ObjectOutputStream(cursorSalida);
            escribirArchivo.writeObject(listaEstudiante);
            escribirArchivo.close();
        } catch (Exception e) {
            response = "Error -- " + e;
        }
        return response;
    }

    @Override
    public String eliminar(String correo) {

        String response = "";
        try {
            FileInputStream cursorEntrada = new FileInputStream("file_data.dat");
            ObjectInputStream leerArchivo = new ObjectInputStream(cursorEntrada);
            listaEstudiante = (ArrayList<Persona>) leerArchivo.readObject();
            leerArchivo.close();
            for (int i = 0; i < listaEstudiante.size(); i++) {
                if (listaEstudiante.get(i).getCorreoInstitucional().equals(correo)) {
                    listaEstudiante.remove(i);
                }
            }
            FileOutputStream cursorSalida = new FileOutputStream("file_data.dat");
            ObjectOutputStream escribirArchivo = new ObjectOutputStream(cursorSalida);
            escribirArchivo.writeObject(listaEstudiante);
            escribirArchivo.close();
        } catch (Exception e) {

        }
        return response;
    }

    @Override
    public Persona buscar(String correo) {
        
        Persona estudiante = new Persona();
        try {
            FileInputStream cursorEntrada = new FileInputStream("file_data.dat");
            ObjectInputStream leerArchivo = new ObjectInputStream(cursorEntrada);
            listaEstudiante = (ArrayList<Persona>) leerArchivo.readObject();
            leerArchivo.close();
            for (int i = 0; i < listaEstudiante.size(); i++) {
                if (listaEstudiante.get(i).getCorreoInstitucional().equals(correo)) {
                    estudiante = listaEstudiante.get(i);
                }
            }
        } catch (Exception e) {
        }
        return estudiante;
    }

    @Override
    public ArrayList<Persona> listar() {
        try {
            FileInputStream cursorEntrada = new FileInputStream("file_data.dat");
            ObjectInputStream leerArchivo = new ObjectInputStream(cursorEntrada);
            listaEstudiante = (ArrayList<Persona>) leerArchivo.readObject();
            leerArchivo.close();
        } catch (Exception e) {
        }
        
        return this.listaEstudiante;
    }

    @Override
    public ArrayList<Persona> cosultarCorreoBD(String correo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Persona> cosultarCelular(long numero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
