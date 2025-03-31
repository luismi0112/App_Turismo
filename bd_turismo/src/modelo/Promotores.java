package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Promotores {

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

	public void create(String tipodocumento, int documento, String nombres, String apellidos, String direccion,
			String correopersonal, String correoCorp, String fechaNacimientoStr, String telefono) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "insert into tblpromotores (tipodocumento, documento, nombres, apellidos, direccion, correopersonal, correoCorp, fechanacimiento, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);

			Date fechaSQL = Date.valueOf(fechaNacimientoStr);
			pst.setString(1, tipodocumento);
			pst.setInt(2, documento);
			pst.setString(3, nombres);
			pst.setString(4, apellidos);
			pst.setString(5, direccion);
			pst.setString(6, correopersonal);
			pst.setString(7, correoCorp);
			pst.setDate(8, fechaSQL);
			pst.setString(9, telefono);

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro con exito");

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al registrar: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

}
