package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Promotores {

	public int idpromotor;
	public String tipodocumento;
	public int documento;
	public String nombres;
	public String apellidos;
	public String direccion;
	public String correopersonal;
	public String correoCorp;
	public Date fechanacimiento;
	public String telefono;

	Conexion conector = new Conexion();

	public Promotores() {
		
	}

	public void create(int idpromotor, String tipodocumento, int documento, String nombres, String apellidos, String direccion,
			String correopersonal, String correoCorp, String fechaNacimientoStr, String telefono) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "insert into tblpromotores (idpromotor, tipodocumento, documento, nombres, apellidos, direccion, correopersonal, correoCorp, fechanacimiento, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);

			Date fechaSQL = Date.valueOf(fechaNacimientoStr);
			pst.setInt(1, idpromotor);
			pst.setString(2, tipodocumento);
			pst.setInt(3, documento);
			pst.setString(4, nombres);
			pst.setString(5, apellidos);
			pst.setString(6, direccion);
			pst.setString(7, correopersonal);
			pst.setString(8, correoCorp);
			pst.setDate(9, fechaSQL);
			pst.setString(10, telefono);

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro con exito");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al registrar: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	public void delete(int idpromotor) {
	    Connection dbConnection = null;
	    PreparedStatement pst = null;

	    String script = "DELETE FROM tblpromotor WHERE idpromotores = ?";

	    try {
			dbConnection = conector.conectarBD(); 
	        pst = dbConnection.prepareStatement(script);

	        pst.setInt(1, idpromotor);

	        int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. " + idpromotor + "?");

	        if (resp == JOptionPane.OK_OPTION) {
	            pst.executeUpdate();
	            JOptionPane.showConfirmDialog(null, "Registro No. " + idpromotor + " eliminado");
	        }

	    } catch (SQLException e) {
	        System.out.println(e.getMessage());
	    }
	}

}
