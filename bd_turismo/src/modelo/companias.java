package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;
import controlador.Conexion;

public class companias {

    public String razonsocial;
    public String direccion;
    public String correo;
    public String telefono;
    public Date fechacreacion;
    public String web;

    public companias(String razonsocial, String direccion, String correo, String telefono,
                     Date fechacreacion, String web) {
        this.razonsocial = razonsocial;
        this.direccion = direccion;
        this.correo = correo;
        this.telefono = telefono;
        this.fechacreacion = fechacreacion;
        this.web = web;
    }

    public companias() {}

    Conexion conector = new Conexion();

    public void create(String razonsocial, String direccion, String correo, java.sql.Date fechacreacion, String telefono, String web) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "insert into tblcompanias (razonsocial, direccion, correo, fechacreacion, telefono, web) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);

            pst.setString(1, razonsocial);
            pst.setString(2, direccion);
            pst.setString(3, correo);
            pst.setDate(4, fechacreacion);
            pst.setString(5, telefono);
            pst.setString(6, web);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro con éxito");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public void delete(int idcompania) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "DELETE FROM tblcompanias WHERE idcompania = ?";

		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idcompania);

			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. " + idcompania + "?",
					"Confirmacion", JOptionPane.YES_NO_OPTION);

			if (resp == JOptionPane.YES_OPTION) {
				int filasafectadas = pst.executeUpdate();

				if (filasafectadas > 0) {
					JOptionPane.showMessageDialog(null, "Registro No. " + idcompania + " eliminado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro el ID " + idcompania + " en la base de datos",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}


