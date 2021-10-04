package Dao;

import Modelo.Persona;
import java.util.ArrayList;
import java.sql.*;
import java.util.logging.Logger;
                                                                                                                                                                                                                                              
/**
 *
 * @author CRISTIAN
 */
public class EstudianteDaoSqlImpl implements EstudianteDao {

    private Connection conexion = null;//conexión
    private Statement sentencia = null;//setncias SQL
    private ResultSet resultado = null;// conjunto de resultados
    Conexion conObject = new Conexion();

    @Override
    public String registrar(Persona est) {
        String response = "";
        Connection cn = conObject.emparejarBD();//devuleve la cadena de conexión 
        if (cn != null) {
            String registros = "(Nombres,Apellidos,Fecha_nacimiento,Correo_ins,Correo_per,Num_cel,Num_fijo,Programa)";
            String valores = "('" + est.getNombres() + "',"
                    + "'" + est.getApellidos() + "',"
                    + "'" + est.getFechaNacimiento() + "',"
                    + "'" + est.getCorreoInstitucional() + "',"
                    + "'" + est.getCorreoPersonal() + "',"
                    + est.getNumTelefonocelular() + ","
                    + est.getNumTelefonofijo() + ","
                    + "'" + est.getProgramaAcademico() + "')";

            String Query = "INSERT INTO estudiantes " + registros + " VALUES " + valores;
            try {
                PreparedStatement consultaDB = cn.prepareStatement(Query);
                consultaDB.execute();
                consultaDB.close();
                response = "Se agregó el estudiante";
            } catch (Exception e) {
                response = "error..." + e.getMessage();
            }

        } else {
            response = "error de conexión";
        }
        return response;
    }

    @Override
    public String modifcar(Persona est) {
        String mensaje = "";
        Connection cn = conObject.emparejarBD();
        if (cn != null) {
            String registros = "Correo_per='" + est.getCorreoPersonal() + "',Num_cel=" + est.getNumTelefonocelular() + ",Num_fijo=" + est.getNumTelefonofijo() + ",Programa='" + est.getProgramaAcademico() + "'";
            String query = "UPDATE estudiantes SET " + registros + " WHERE Correo_ins='" + est.getCorreoInstitucional() + "'";
            System.out.println(query);

            try {
                PreparedStatement consultaDB = cn.prepareStatement(query);
                consultaDB.execute();
                consultaDB.close();
                mensaje = "Estudiante modificado";
            } catch (SQLException ex) {
                mensaje = "Error ---" + ex.getMessage();
            }
        } else {
            mensaje = "Error de conexión a la BD";
        }

        return mensaje;
    }

    @Override
    public String eliminar(String correo) {
        String response = "";
        Connection cn = conObject.emparejarBD();//
        if (cn != null) {
            String query = "DELETE FROM estudiantes WHERE Correo_ins= '" + correo + "'";
            try {
                PreparedStatement consultaBD = cn.prepareStatement(query);
                consultaBD.execute();
                consultaBD.close();
                response = "Se eliminó el estudiante\n";

            } catch (Exception e) {
                System.out.println("Error...." + e.getMessage());
            }

        } else {
            response = "Error de conexión";
        }
        return response;
    }

    @Override
    public Persona buscar(String correo) {
        Persona estudiante = new Persona();
        Connection cn = conObject.emparejarBD();
        if (cn != null) {
            try {
                String atributos = "Nombres,Apellidos,Fecha_nacimiento,Correo_ins,Correo_per,Num_cel,Num_fijo,Programa";

                String query = "SELECT " + atributos + " FROM estudiantes "
                        + "WHERE Correo_ins= '" + correo + "'";
                sentencia = cn.createStatement();
                resultado = sentencia.executeQuery(query);

                estudiante.setNombres(resultado.getString("Nombres"));
                estudiante.setApellidos(resultado.getString("Apellidos"));
                estudiante.setFechaNacimiento(resultado.getString("Fecha_nacimiento"));
                estudiante.setCorreoInstitucional(resultado.getString("Correo_ins"));
                estudiante.setCorreoPersonal(resultado.getString("Correo_per"));
                estudiante.setNumTelefonocelular(resultado.getLong("Num_cel"));
                estudiante.setNumTelefonofijo(resultado.getLong("Num_fijo"));
                estudiante.setProgramaAcademico(resultado.getString("Programa"));

            } catch (SQLException e) {
            }

        } else {
            System.out.println("Error de conexión");
        }
        return estudiante;
    }

    @Override
    public ArrayList<Persona> listar() {
        ArrayList<Persona> listaEst = new ArrayList<>();
        Connection cn = conObject.emparejarBD();
        if (cn != null) {
            String atributos = "Nombres,Apellidos,Fecha_nacimiento,Correo_ins,Correo_per,Num_cel,Num_fijo,Programa";
            String query = "SELECT " + atributos + " FROM estudiantes ";
            try {
                sentencia = cn.createStatement();
                resultado = sentencia.executeQuery(query);
                
                while (resultado.next()) {
                    listaEst.add(new Persona(resultado.getString("Nombres"),
                            resultado.getString("Apellidos"),
                            resultado.getString("Fecha_nacimiento"),
                            resultado.getString("Correo_ins"),
                            resultado.getString("Correo_per"),
                            resultado.getLong("Num_cel"),
                            resultado.getLong("Num_fijo"),
                            resultado.getString("Programa")));
                }

            } catch (SQLException ex) {
                System.out.println("Error..." + ex.getMessage());
            }

        } else {
            System.out.println("Error de conexión");
        }

        return listaEst;
    }

    @Override
    public ArrayList<Persona> cosultarCorreoBD(String correo) {
        ArrayList<Persona> listaEst = new ArrayList<>();
        Connection cn = conObject.emparejarBD();
        if (cn != null) {
            String atributos = "Nombres,Apellidos,Fecha_nacimiento,Correo_ins,Correo_per,Num_cel,Num_fijo,Programa";
            String query = "SELECT " + atributos + " FROM estudiantes "
                    + "WHERE Correo_ins= '" + correo + "'";
            try {
                sentencia = cn.createStatement();
                resultado = sentencia.executeQuery(query);
                System.out.println(resultado);
                while (resultado.next()) {
                    listaEst.add(new Persona(resultado.getString("Nombres"),
                            resultado.getString("Apellidos"),
                            resultado.getString("Fecha_nacimiento"),
                            resultado.getString("Correo_ins"),
                            resultado.getString("Correo_per"),
                            resultado.getLong("Num_cel"),
                            resultado.getLong("Num_fijo"),
                            resultado.getString("Programa")));
                }
            } catch (SQLException ex) {
                System.out.println("Error..." + ex.getMessage());
            }
        } else {
            System.out.println("Error de conexión");
        }
        return listaEst;
    }

    public ArrayList<Persona> cosultarApellidosBD(String apellido) {
        ArrayList<Persona> listaEst = new ArrayList<>();
        Connection cn = conObject.emparejarBD();
        if (cn != null) {
            String atributos = "Nombres,Apellidos,Fecha_nacimiento,Correo_ins,Correo_per,Num_cel,Num_fijo,Programa";
            String query = "SELECT " + atributos + " FROM estudiantes "
                    + "WHERE Apellidos= '" + apellido + "'";
            try {
                sentencia = cn.createStatement();
                resultado = sentencia.executeQuery(query);
                while (resultado.next()) {
                    listaEst.add(new Persona(resultado.getString("Nombres"),
                            resultado.getString("Apellidos"),
                            resultado.getString("Fecha_nacimiento"),
                            resultado.getString("Correo_ins"),
                            resultado.getString("Correo_per"),
                            resultado.getLong("Num_cel"),
                            resultado.getLong("Num_fijo"),
                            resultado.getString("Programa")));
                }
            } catch (SQLException ex) {
                System.out.println("Error..." + ex.getMessage());
            }
        } else {
            System.out.println("Error de conexión");
        }
        return listaEst;
    }

    public ArrayList<Persona> cosultarProgramaBD(String programa) {
        ArrayList<Persona> listaEst = new ArrayList<>();
        Connection cn = conObject.emparejarBD();
        if (cn != null) {
            String atributos = "Nombres,Apellidos,Fecha_nacimiento,Correo_ins,Correo_per,Num_cel,Num_fijo,Programa";
            String query = "SELECT " + atributos + " FROM estudiantes "
                    + "WHERE Programa= '" + programa + "'";
            try {
                sentencia = cn.createStatement();
                resultado = sentencia.executeQuery(query);
                while (resultado.next()) {
                    listaEst.add(new Persona(resultado.getString("Nombres"),
                            resultado.getString("Apellidos"),
                            resultado.getString("Fecha_nacimiento"),
                            resultado.getString("Correo_ins"),
                            resultado.getString("Correo_per"),
                            resultado.getLong("Num_cel"),
                            resultado.getLong("Num_fijo"),
                            resultado.getString("Programa")));
                }
            } catch (SQLException ex) {
                System.out.println("Error..." + ex.getMessage());
            }
        } else {
            System.out.println("Error de conexión");
        }
        return listaEst;
    }

    public int cosultarProgramaConteoBD(String programa) {
        int contador = 0;
        Connection cn = conObject.emparejarBD();
        if (cn != null) {
            String atributos = "count (Correo_ins) as Conteo";
            String query = "SELECT " + atributos + " FROM estudiantes "
                    + "WHERE Programa= '" + programa + "'";
            try {
                sentencia = cn.createStatement();
                resultado = sentencia.executeQuery(query);
                contador = resultado.getInt("Conteo");
            } catch (SQLException ex) {
                System.out.println("Error..." + ex.getMessage());
            }
        } else {
            System.out.println("Error de conexión");
        }
        return contador;
    }

    public ArrayList<Persona> cosultarFecha(String fecha) {
        ArrayList<Persona> listaEst = new ArrayList<>();
        Connection cn = conObject.emparejarBD();
        if (cn != null) {
            String atributos = "Nombres,Apellidos,Fecha_nacimiento,Correo_ins,Correo_per,Num_cel,Num_fijo,Programa";
            String query = "SELECT " + atributos + " FROM estudiantes "
                    + "WHERE Fecha_nacimiento= '" + fecha + "'";
            try {
                sentencia = cn.createStatement();
                resultado = sentencia.executeQuery(query);
                while (resultado.next()) {
                    listaEst.add(new Persona(resultado.getString("Nombres"),
                            resultado.getString("Apellidos"),
                            resultado.getString("Fecha_nacimiento"),
                            resultado.getString("Correo_ins"),
                            resultado.getString("Correo_per"),
                            resultado.getLong("Num_cel"),
                            resultado.getLong("Num_fijo"),
                            resultado.getString("Programa")));
                }
            } catch (SQLException ex) {
                System.out.println("Error..." + ex.getMessage());
            }
        } else {
            System.out.println("Error de conexión");
        }
        return listaEst;
    }
@Override
    public ArrayList<Persona> cosultarCelular(long numero) {
        ArrayList<Persona> listaEst = new ArrayList<>();
        Connection cn = conObject.emparejarBD();
        if (cn != null) {
            String atributos = "Nombres,Apellidos,Fecha_nacimiento,Correo_ins,Correo_per,Num_cel,Num_fijo,Programa";
            String query = "SELECT " + atributos + " FROM estudiantes "
                    + "WHERE Num_cel= " + numero + "";
            try {
                sentencia = cn.createStatement();
                resultado = sentencia.executeQuery(query);
                while (resultado.next()) {
                    listaEst.add(new Persona(resultado.getString("Nombres"),
                            resultado.getString("Apellidos"),
                            resultado.getString("Fecha_nacimiento"),
                            resultado.getString("Correo_ins"),
                            resultado.getString("Correo_per"),
                            resultado.getLong("Num_cel"),
                            resultado.getLong("Num_fijo"),
                            resultado.getString("Programa")));
                }
            } catch (SQLException ex) {
                System.out.println("Error..." + ex.getMessage());
            }
        } else {
            System.out.println("Error de conexión");
        }
        return listaEst;
    }

}
