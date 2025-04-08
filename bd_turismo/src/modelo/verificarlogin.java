package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import controlador.Conexion;

public class verificarlogin {

    public static String verificarLogin(int documento, String contrasena) {
        String[][] roles = {
            {"tblpromotores", "promotor"},
            {"tbloperadores", "operador"},
            {"tblclientes", "cliente"},
            {"tblpaquetes", "paquetes"},
            {"tblcompanias", "companias"},
            {"tblagencias", "agencias"},
            {"tbltipomedios", "tipos de medios"},
            {"tblmedios", "medios"},
            {"tblvehiculos", "vehiculos"},
            {"tbltipotransporte", "tipos de transporte"}
        };

        for (String[] rol : roles) {
            String tabla = rol[0];
            String nombreRol = rol[1];

            try {
                System.out.println("buscando en tabla: " + tabla);
                System.out.println("documento: " + documento + " | Contraseña: " + contrasena);

                Connection con = Conexion.conectarBD();
                String sql = "SELECT * FROM " + tabla + " WHERE documento = ? AND contrasena = ?";
                PreparedStatement ps = con.prepareStatement(sql);
                ps.setInt(1, documento);
                ps.setString(2, contrasena);
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    System.out.println("usuario encontrado en tabla: " + tabla);
                    return nombreRol;
                } else {
                    System.out.println("no encontrado en " + tabla);
                }

            } catch (Exception e) {
                System.out.println("¡¡ERROR!! consultando en tabla " + tabla);
                e.printStackTrace();
            }
        }

        System.out.println("usuario no encontrado en ninguna tabla");
        return null;
    }
}
