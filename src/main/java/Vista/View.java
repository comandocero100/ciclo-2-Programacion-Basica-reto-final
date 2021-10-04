/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Persona;
import java.io.*;
import java.util.ArrayList;

public class View {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public int verMenu() {
        int opcion = 0;
        try {
            System.out.println("INSTITUTO LA FLORESTA\n"
                    + "Seleccione tarea a realizar:\n"
                    + "1. Ingresar estudiante\n"
                    + "2. Buscar estudiante\n"
                    + "3. Modificar estudiante\n"
                    + "4. Eliminar Estudiante\n"
                    + "5. Ver directorio de estudiantes\n"
                    + "6. Salir\n"
                    + "Opción:");

            opcion = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("Ingrese solo datos numéricos " + e);
        }
        return opcion;
    }

    public void verMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public Persona recogerDatos() throws IOException {
        Persona estudiante = new Persona();
        try {
            System.out.println("Ingresar nombres: ");
            estudiante.setNombres(br.readLine());
            System.out.println("Ingresar apellidos: ");
            estudiante.setApellidos(br.readLine());
            System.out.println("Ingresar fecha de nacimiento (YYYY-MM-DD): ");
            estudiante.setFechaNacimiento(br.readLine());
            System.out.println("Ingresar correo institucional:");
            estudiante.setCorreoInstitucional(br.readLine());
            System.out.println("Ingresar correo personal:");
            estudiante.setCorreoPersonal(br.readLine());

            try {
                System.out.println("Ingresar número de celular: ");
                estudiante.setNumTelefonocelular(Long.parseLong(br.readLine()));
            } catch (Exception e) {
                System.out.println("Tipo de dato no valido");
                estudiante.setNumTelefonocelular(0);
            }
            try {
                System.out.println("Ingresar número fijo: ");
                estudiante.setNumTelefonofijo(Long.parseLong(br.readLine()));
            } catch (Exception e) {
                System.out.println("Tipo de dato no valido");
                estudiante.setNumTelefonofijo(0);
            }
            System.out.println("Ingresar programa:");
            estudiante.setProgramaAcademico(br.readLine());
        } catch (IOException e) {

        }
        return estudiante;
    }

    public String recogerCorreo() throws IOException {
        System.out.println("Buscar estudiante\n"
                + "Ingresar correo institucional:");
        String correo = br.readLine();
        return correo;
    }

    public String recogerCorreoEliminar() throws IOException {
        System.out.println("Eliminar estudiante\n"
                + "Ingresar correo institucional:");
        String correo = br.readLine();
        return correo;
    }

    public void verPersona(Persona est) {
        System.out.println("Información del estudiante");
        System.out.println("Nombres: " + est.getNombres());
        System.out.println("Apellidos: " + est.getApellidos());
        System.out.println("Fecha nacimiento: " + est.getFechaNacimiento());
        System.out.println("Correo institucional: " + est.getCorreoInstitucional());
        System.out.println("Correo personal: " + est.getCorreoPersonal());
        System.out.println("Número de teléfono celular: " + est.getNumTelefonocelular());
        System.out.println("Número de teléfono fijo: " + est.getNumTelefonofijo());
        System.out.println("Programa académico: " + est.getProgramaAcademico() + "\n");

    }

    public void verPersonaBD(ArrayList<Persona> lista) {
        System.out.println("Información del estudiante");
        for (int i = 0; i < lista.size(); i++) {
            System.out.println("Nombres: " + lista.get(i).getNombres());
            System.out.println("Apellidos: " + lista.get(i).getApellidos());
            System.out.println("Fecha nacimiento: " + lista.get(i).getFechaNacimiento());
            System.out.println("Correo institucional: " + lista.get(i).getCorreoInstitucional());
            System.out.println("Correo personal: " + lista.get(i).getCorreoPersonal());
            System.out.println("Número de teléfono celular: " + lista.get(i).getNumTelefonocelular());
            System.out.println("Número de teléfono fijo: " + lista.get(i).getNumTelefonofijo());
            System.out.println("Programa académico: " + lista.get(i).getProgramaAcademico() + "\n");
        }
    }

    public Persona recogerDatosModificar() {
        Persona estudiante = new Persona();

        try {
            System.out.println("Ingresar correo institucional:");
            estudiante.setCorreoInstitucional(br.readLine());
            System.out.println("Ingresar correo personal:");
            estudiante.setCorreoPersonal(br.readLine());

            try {
                System.out.println("Ingresar número de celular: ");
                estudiante.setNumTelefonocelular(Long.parseLong(br.readLine()));
            } catch (Exception e) {
                System.out.println("Tipo de dato no valido");
                estudiante.setNumTelefonocelular(0);
            }
            try {
                System.out.println("Ingresar número fijo: ");
                estudiante.setNumTelefonofijo(Long.parseLong(br.readLine()));
            } catch (Exception e) {
                System.out.println("Tipo de dato no valido");
                estudiante.setNumTelefonofijo(0);
            }
            System.out.println("Ingresar programa:");
            estudiante.setProgramaAcademico(br.readLine());
        } catch (Exception e) {
            System.out.println("Error general de escritura");
        }
        return estudiante;
    }

    public int verSubMenu(){
    int opcion = 0;
        try {
            System.out.println("Consultas\n"
                    + "Seleccione consulta a realizar:\n"
                    + "1. Buscar estudiante por correo electrónico\n"
                    + "2. Buscar estudiante por apellidos\n"
                    + "3. Bucar por programa\n"
                    + "4. Buscar cantidad de estudiantes por programa\n"
                    + "5. Buscar por fecha de nacimiento\n"
                    + "6. Buscar por número de celular\n"
                    + "Opción:");

            opcion = Integer.parseInt(br.readLine());
        } catch (Exception e) {
            System.out.println("Ingrese solo datos numéricos " + e);
        }
        return opcion;
    }
    public String recogerDatos(String mensaje) throws IOException{
        System.out.println(mensaje);
        String dato=br.readLine();
        return dato;
    }
}
