/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;
import java.sql.*;
/**
 *
 * @author Cristian
 */
public class Conexion {
    public Connection emparejarBD(){
        Connection cn=null;
        try {
           cn=DriverManager.getConnection("jdbc:sqlite:bd_estudiantes.db");
        } catch (SQLException e) {
            System.out.println("Error----"+e.getMessage());
        }
        return cn;
}
    
}
