package mvc.unomaxs.crud.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
Esta clase nos permite conectarnos a MySQL, debes cambiar los valores de las variables base,
url, user y password correspondientes a tus datos que configuraste en la instalación de MySQL.
 */

public class Conexion {

    Connection con = null;

    String base = "db";
    String url = "jdbc:mysql://localhost:3306/" + base;
    String user = "admin";
    String password = "password";

    public Connection getConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver MySQL no encontrado: " + e.getMessage());
            throw new SQLException(e);
        } catch (SQLException e) {
            System.err.println("Error de conexión a la base de datos: " + e.getMessage());
            throw e;
        }
        return con;
    }

}
