/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.*;
import Vista.*;
import java.util.ArrayList;

public class Controller {

    View vw = new View();
    Logica lg = new Logica();


    public ArrayList<Persona> consultarCorreo(String correo) {
        ArrayList<Persona> est =lg.correoSQL(correo);
        return est;
    }
    public ArrayList<Persona> verTotal(){
        ArrayList<Persona> est =lg.verBDSQL();
        return  est;
    }
    public String registrarEstudiant(Persona estu){
        String est =lg.registrarEstudiateDB(estu);
        return est;
    }
    public String modificarEstudiant(Persona est){
        String esti =lg.modificarEstudianteBD(est);
        return esti;
    }
    public String EliminarEstudiant(String correo){
        String esti =lg.elimiarEstudiante(correo);
        return esti;
    }
    
    
    
    
    
    
    //    public void ejecucion() throws IOException {
//        int opcion = vw.verMenu();
//        switch (opcion) {
//            case 1:
//                Persona estudiante = vw.recogerDatos();
//                String response = lg.registrarEstudiateDB(estudiante);
//                vw.verMensaje(response);
//                break;
//            case 2:
////               String correo=vw.recogerCorreo();
////               Persona est=lg.buscarEstudienteBD(correo);
////               vw.verPersona(est);
//                verSubmenu(vw.verSubMenu());
//                break;
//            case 3:
//                Persona estu = vw.recogerDatosModificar();
//                String mensaje = lg.modificarEstudianteBD(estu);
//                vw.verMensaje(mensaje);
//                break;
//            case 4:
//                String correoE = vw.recogerCorreo();
//                String mess = lg.elimiarEstudianteDB(correoE);
//                vw.verMensaje(mess);
//                break;
//            case 5:
//                ArrayList<Persona> lista = lg.verBDSQL();
//                vw.verPersonaBD(lista);
//                break;
//            case 6:
//                System.exit(0);
//                break;
//        }
//    }
//
//    public void verSubmenu(int opcion) throws IOException {
//        
//        switch (opcion) {
//            case 1:
//                String correo = vw.recogerDatos("Digite el correo electrónico");
//                ArrayList<Persona> lista = lg.correoSQL(correo);
//                if (lista != null) {
//                    vw.verPersonaBD(lista);
//                } else {
//                    vw.verMensaje("El usuario no existe");
//                }
//                break;
//            case 6:
//                long celular1 = Long.parseLong(vw.recogerDatos("Digite el Celular"));
//                ArrayList<Persona> listacelular = lg.celularSQL(celular1);
//                vw.verPersonaBD(listacelular);
//                break;
//            
//        }
//        
//    }
    ////************************************* GUI **************************************
}
