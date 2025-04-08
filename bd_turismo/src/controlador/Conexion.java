package controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	public static Connection conectarBD() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_turismo", "root", "2556229");
            System.out.println("Connected With the database successfully");
        } catch (SQLException e) {
            System.out.println("Error while connecting to the database");
        }
        return connection; 
    }

}
