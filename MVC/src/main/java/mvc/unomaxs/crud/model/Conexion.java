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

    String base = "tienda";
    String url = "jdbc:mysql://localhost:3306/" + base;
    String user = "root";
    String password = "password";

    public Connection getConexion() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
        return con;
    }
}
