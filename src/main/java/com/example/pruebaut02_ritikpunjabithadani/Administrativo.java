package com.example.pruebaut02_ritikpunjabithadani;

import java.sql.*;

/**
 * Clase Administrativo que tiene todos los métodos principales,
 */

public class Administrativo {
    private static final String ruta ="jdbc:mysql://localhost:3306/consejeriaEdu";
    private static  final String usuario="root";
    private static final String contra ="1234";
    private static Connection con;

    /**
     * Método para realizar la conexión con nuestra base de datos.
     * @return
     */

    public static boolean connection(){
        try {
            con = DriverManager.getConnection(ruta, usuario, contra);
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    /**
     * Método que comprueba en nuestra BD el nombre de usuario y la contraseña.
     * @param usuario
     * @param contra
     * @return
     */

    public static boolean comprobarUsuario(String usuario, String contra){
        String sentenciaSQL = "select nombreUsuario, contraseña from administrativo where nombreUsuario=? and contraseña=?";
        if(con!=null){
            try {
                PreparedStatement sentencia = con.prepareStatement(sentenciaSQL);
                sentencia.setString(1, usuario);
                sentencia.setString(2, contra);
                ResultSet resultado = sentencia.executeQuery();
                if(resultado.next()){
                    return true;
                }
            } catch (SQLException e) {
                return false;
            }
        }
        return false;
    }

    /**
     * Método que matricula/añade un estudiante en nuestra base de datos.
     * @param CIAL
     * @param nombre
     * @param apellidos
     * @param direccion
     * @param email
     * @param tlf
     * @param ciclo
     * @param curso
     * @return
     */

    public static boolean matricularEnBD(String CIAL, String nombre, String apellidos,String direccion, String email, String tlf, String ciclo, String curso){
        String sql = "insert into estudiante (CIAL, nombre, apellidos, direccion, email, tlf, ciclo, curso) values (?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            PreparedStatement sentencia = con.prepareStatement(sql);
            sentencia.setString(1, CIAL);
            sentencia.setString(2, nombre);
            sentencia.setString(3, apellidos);
            sentencia.setString(4, direccion);
            sentencia.setString(5, email);
            sentencia.setString(6, tlf);
            sentencia.setString(7,ciclo);
            sentencia.setString(8,curso);

            sentencia.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    /**
     * Método que nos sirve para dar de baja a un estudiante según su CIAL.
     * @param CIAL
     * @return
     */

    public static boolean darBajaEnBD(String CIAL){
        String sql = "delete from estudiante where CIAL=?";
        try{
            PreparedStatement sentencia=con.prepareStatement(sql);
            sentencia.setString(1, CIAL);
            sentencia.execute();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    /**
     * Método que nos muestra los datos de todos los estudiantes.
     * @return
     */

    public static String mostrarDatosdeBD(){
        String sentenciaSQL = "select * from estudiante";
        String datos ="";
        if(con!=null){
            try {
                PreparedStatement sentencia = con.prepareStatement(sentenciaSQL);
                ResultSet resultado = sentencia.executeQuery();
                while(resultado.next()){
                    datos += "Nombre: "+resultado.getString("nombre" ) +" Apellidos: "+ resultado.getString("apellidos") +" Dirección:"+
                            resultado.getString("direccion") +" Email: "+ resultado.getString("email")+
                            " Ciclo: "+ resultado.getString("ciclo")+"\n";
                }
            } catch (SQLException e) {
                return null;
            }
        }
        return datos;
    }
}
