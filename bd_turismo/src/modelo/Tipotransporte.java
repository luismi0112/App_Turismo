package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;

public class Tipotransporte {

	public int idtipotransporte;
	public String nombre;
	public String observacion;

	public Tipotransporte() {
		super();
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
	Conexion conector = new Conexion();

    public void create (String nombre, String observacion) {
    	
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "insert into tbltipotransporte (nombre, observacion) VALUES (?, ?)";

        try {
            dbConnection = Conexion.conectarBD();
            pst = dbConnection.prepareStatement(script);


            pst.setString(1, nombre);
            pst.setString(2, observacion);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro con exito");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        }
    public void delete(int idtipotransporte) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "DELETE FROM tbltipotransporte WHERE idtipotransporte = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idtipotransporte);

			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. " + idtipotransporte + "?",
					"Confirmacion", JOptionPane.YES_NO_OPTION);

			if (resp == JOptionPane.YES_OPTION) {
				int filasafectadas = pst.executeUpdate();

				if (filasafectadas > 0) {
					JOptionPane.showMessageDialog(null, "Registro No. " + idtipotransporte + " eliminado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro el ID " + idtipotransporte + " en la base de datos",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
    public void readOne(int idtipotransporte, JTextField nombres, JTextField observacion) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String script = "SELECT * FROM tbltipotransporte WHERE idtipotransporte = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idtipotransporte);
			rs = pst.executeQuery();

			if (rs.next()) {
				nombres.setText(rs.getString("nombre"));
				observacion.setText(rs.getString("observacion"));
			} else {
				JOptionPane.showMessageDialog(null, "No se encontro el ID " + idtipotransporte, "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al buscar: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
    public void update(int idtipotransporte, String nombre, String observacion) {

		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "update tbltipotransporte set nombre = ?, observacion = ? where idtipotransporte = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);

			pst.setString(1, nombre);
			pst.setString(2, observacion);
			pst.setInt(3, idtipotransporte);

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