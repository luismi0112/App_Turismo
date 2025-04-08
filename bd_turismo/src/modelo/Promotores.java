package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;
import vista.principal_view;
import vista.promotores_view;

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

	public void create(int idpromotor, String tipodocumento, int documento, String nombres, String apellidos,
			String direccion, String correopersonal, String correoCorp, String fechaNacimientoStr, String telefono) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "insert into tblpromotores (idpromotor, tipodocumento, documento, nombres, apellidos, direccion, correopersonal, correoCorp, fechanacimiento, telefono) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			dbConnection = Conexion.conectarBD();
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

		String script = "DELETE FROM tblpromotor WHERE idpromotor = ?";

		try {
			dbConnection = Conexion.conectarBD();
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
	public void readOne(int idpromotor, JTextField fechanacimiento, JComboBox<String>  tipodocumento, JTextField documento,
			JTextField nombres, JTextField apellidos, JTextField direccion, JTextField correo, JTextField correoCorp, JTextField telefono) {

		String script = "SELECT * FROM tblpromotores WHERE idpromotor = ?";

		try (Connection dbConnection = Conexion.conectarBD();
				PreparedStatement pst = dbConnection.prepareStatement(script)) {

			pst.setInt(1, idpromotor);
			try (ResultSet rs = pst.executeQuery()) {
				if (rs.next()) {
					fechanacimiento.setText(rs.getDate("fechanacimiento").toString());
					tipodocumento.setSelectedItem(rs.getString("tipodocumento"));
					documento.setText(String.valueOf(rs.getInt("documento")));
					nombres.setText(rs.getString("nombres"));
					apellidos.setText(rs.getString("apellidos"));
					direccion.setText(rs.getString("direccion"));
					correo.setText(rs.getString("correopersonal"));
					correoCorp.setText(rs.getString("correocorp"));
					telefono.setText(rs.getString("telefono"));
				} else {
					JOptionPane.showMessageDialog(null, "No se encontró el ID " + idpromotor, "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al buscar: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	public void update(int idpromotor, String tipodocumento, int documento, String nombres, String apellidos,
			String direccion, String correopersonal, String correoCorp, String fechaNacimientoStr, String telefono) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "update tblpromotores set tipodocumento = ?, documento = ?, nombres = ?, apellidos = ?, direccion =  ?, correopersonal = ?, correoCorp = ?, fechanacimiento = ?, telefono = ? where idpromotor = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);


			pst.setString(1, tipodocumento);
			pst.setInt(2, documento);
			pst.setString(3, nombres);
			pst.setString(4, apellidos);
			pst.setString(5, direccion);
			pst.setString(6, correopersonal);
			pst.setString(7, correoCorp);
			pst.setString(8, fechaNacimientoStr);
			pst.setString(9, telefono);
			pst.setInt(10, idpromotor);

			int resp = JOptionPane.showConfirmDialog(null, "¿desea actualizar esta fila?");

			if (resp == JOptionPane.OK_OPTION) {
				pst.executeUpdate();
				JOptionPane.showConfirmDialog(null, "fila actualizada");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
}