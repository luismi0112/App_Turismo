package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;

public class Medios {

	public int idmedio;
	public String nombre;
	public String observacion;
	public int idTipomedio;

	public Medios() {
		super();
	}

	/**
	 * @return the idmedio
	 */
	public int getIdmedio() {
		return idmedio;
	}

	/**
	 * @param idmedio the idmedio to set
	 */
	public void setIdmedio(int idmedio) {
		this.idmedio = idmedio;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	/**
	 * @return the observacion
	 */
	public String getObservacion() {
		return observacion;
	}

	/**
	 * @param observacion the observacion to set
	 */
	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	/**
	 * @return the idTipomedio
	 */
	public int getIdTipomedio() {
		return idTipomedio;
	}

	/**
	 * @param idTipomedio the idTipomedio to set
	 */
	public void setIdTipomedio(int idTipomedio) {
		this.idTipomedio = idTipomedio;
	}

	Conexion conector = new Conexion();

	public void create(String nombre, String observacion, int idTipomedio) {

		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "insert into tblmedios (nombre, observacion, idtipomedio) VALUES (?, ?, ?)";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);

			pst.setString(1, nombre);
			pst.setString(2, observacion);
			pst.setInt(3, idTipomedio);

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro con exito");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(int idmedio) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "DELETE FROM tblmedios WHERE idmedio = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idmedio);

			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. " + idmedio + "?",
					"Confirmacion", JOptionPane.YES_NO_OPTION);

			if (resp == JOptionPane.YES_OPTION) {
				int filasafectadas = pst.executeUpdate();

				if (filasafectadas > 0) {
					JOptionPane.showMessageDialog(null, "Registro No. " + idmedio + " eliminado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro el ID " + idmedio + " en la base de datos",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void readOne(int idmedio, JTextField nombre, JTextField observacion, JTextField idTipomedio) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String script = "select * from tblmedios where idmedio = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idmedio);

			rs = pst.executeQuery();

			if (rs.next()) {
				nombre.setText(rs.getString("nombre"));
				observacion.setText(rs.getString("observacion"));
				idTipomedio.setText(rs.getString("idTipomedio"));
			} else {
				JOptionPane.showMessageDialog(null, "No se encontró el ID " + idmedio, "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al buscar: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	public void update(int idmedio, int idTipomedio, String nombre, String observacion) {

		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "update tblmedios set nombre = ?, observacion = ?, idTipomedio = ? where idmedio = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);

			pst.setString(1, nombre);
			pst.setString(2, observacion);
			pst.setInt(3, idmedio);
			pst.setInt(4, idTipomedio);

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