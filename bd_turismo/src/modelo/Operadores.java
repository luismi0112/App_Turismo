package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;

public class Operadores {

	public String tipodocumento;
	public int documento;
	public String nombres;
	public String apellidos;
	public String direccion;
	public String correo;
	public String telefono;
	public int idVehiculo;



	/**
	 * @return the tipodocumento
	 */
	public String getTipodocumento() {
		return tipodocumento;
	}

	/**
	 * @param tipodocumento the tipodocumento to set
	 */
	public void setTipodocumento(String tipodocumento) {
		this.tipodocumento = tipodocumento;
	}

	/**
	 * @return the documento
	 */
	public int getDocumento() {
		return documento;
	}

	/**
	 * @param documento the documento to set
	 */
	public void setDocumento(int documento) {
		this.documento = documento;
	}

	/**
	 * @return the nombres
	 */
	public String getNombres() {
		return nombres;
	}

	/**
	 * @param nombres the nombres to set
	 */
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	/**
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}

	/**
	 * @param apellidos the apellidos to set
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	/**
	 * @return the direccion
	 */
	public String getDireccion() {
		return direccion;
	}

	/**
	 * @param direccion the direccion to set
	 */
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}

	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	/**
	 * @return the idVehiculo
	 */
	public int getIdVehiculo() {
		return idVehiculo;
	}

	/**
	 * @param idVehiculo the idVehiculo to set
	 */
	public void setIdVehiculo(int idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	Conexion conector = new Conexion();

    public void create (String tipodocumento, int documento, String nombres, String apellidos, String direccion, String correo, String telefono) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "INSERT INTO tbloperadores (tipodocumento, documento, nombres, apellidos, direccion, correo, telefono) values (?, ?, ?, ?, ?, ?, ?)";

        try {
            dbConnection = Conexion.conectarBD();
            pst = dbConnection.prepareStatement(script);

            
            pst.setString(1, tipodocumento);
            pst.setInt(2, documento);
            pst.setString(3, nombres);
            pst.setString(4, apellidos);
            pst.setString(5, direccion);
            pst.setString(6, correo);
            pst.setString(7, telefono);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro con exito");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        }
    public void delete(int idoperador) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "DELETE FROM tbloperadores WHERE idoperador = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idoperador);

			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. " + idoperador + "?",
					"Confirmacion", JOptionPane.YES_NO_OPTION);

			if (resp == JOptionPane.YES_OPTION) {
				int filasafectadas = pst.executeUpdate();

				if (filasafectadas > 0) {
					JOptionPane.showMessageDialog(null, "Registro No. " + idoperador + " eliminado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro el ID " + idoperador + " en la base de datos",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
    public void readOne(int idoperador, JTextField idvehiculo, JTextField tipodocumento, JTextField documento, JTextField nombres, JTextField apellidos, JTextField direccion, JTextField correo, JTextField telefono) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String script = "SELECT * FROM tbloperadores WHERE idoperador = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idoperador);
			rs = pst.executeQuery();

			if (rs.next()) {
				tipodocumento.setText(rs.getString("tipodocumento"));
				documento.setText(String.valueOf(rs.getInt("documento")));
				nombres.setText(rs.getString("nombres"));
				apellidos.setText(rs.getString("apellidos"));
				direccion.setText(rs.getString("direccion"));
				correo.setText(rs.getString("correo"));
				telefono.setText(rs.getString("telefono"));
				idvehiculo.setText(rs.getString("idvehiculo"));

			} else {
				JOptionPane.showMessageDialog(null, "No se encontro el ID " + idoperador, "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al buscar: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
    public void update(int idoperador, String tipodocumento, int documento, String nombres, String apellidos, String direccion, String correo, String telefono) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "update tbloperadores set tipodocumento = ?, documento = ?, nombres = ? , apellidos = ?, direccion =?, correo = ?, telefono = ? where idoperador = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);


			pst.setString(1, tipodocumento);
			pst.setInt(2, documento);
			pst.setString(3, nombres);
			pst.setString(4, apellidos);
			pst.setString(5, direccion);
			pst.setString(6, correo);
			pst.setString(7, telefono);
			pst.setInt(8, idoperador);

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