/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_u4;

import java.sql.*;
import javax.swing.JOptionPane;

    public class ConectarT {
    Connection con=null;
    public Connection conexion(){
    try {
    //Driver

    Class.forName("com.mysql.jdbc.Driver");
    //Tipo de conexión, el servidor, base de datos, usuario, password

    con=DriverManager.getConnection("jdbc:mysql://localhost/escuela","root","");
    System.out.println("Conexión realizada");
    } catch (ClassNotFoundException | SQLException e) {
    JOptionPane.showMessageDialog(null, "Problemas al conectar " + e); 
    }
    return con;
    }
    }
