package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Tipomedios {

	public int idtipomedio;
	public String nombre;
	public String observacion;

	public Tipomedios(String nombre, String observacion) {
		this.nombre = nombre;
		this.observacion = observacion;
	}

	public Tipomedios() {
		
	}

	/**
	 * @return the idtipomedio
	 */
	public int getIdtipomedio() {
		return idtipomedio;
	}

	/**
	 * @param idtipomedio the idtipomedio to set
	 */
	public void setIdtipomedio(int idtipomedio) {
		this.idtipomedio = idtipomedio;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	Conexion conector = new Conexion();

    public void create(String nombre, String observacion) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "INSERT INTO tbltipomedios (nombre, observacion) values (?, ?)";

        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);

            pst.setString(1, nombre);
            pst.setString(2, observacion);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro con exito");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        }
    public void delete(int idtipomedio) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "DELETE FROM tbltipomedios WHERE idtipomedio = ?";

		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idtipomedio);

			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. " + idtipomedio + "?",
					"Confirmacion", JOptionPane.YES_NO_OPTION);

			if (resp == JOptionPane.YES_OPTION) {
				int filasafectadas = pst.executeUpdate();

				if (filasafectadas > 0) {
					JOptionPane.showMessageDialog(null, "Registro No. " + idtipomedio + " eliminado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro el ID " + idtipomedio + " en la base de datos",
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