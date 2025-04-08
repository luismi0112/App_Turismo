package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;

public class Agencias {

	public int idagencias;
	public String nombre;
	public String direccion;
	public String correo;
	public String telefono;
	public String web;

	public Agencias(int idagencias, String nombre, String direccion, String correo, String telefono, String web) {
		this.idagencias = idagencias;
		this.nombre = nombre;
		this.direccion = direccion;
		this.correo = correo;
		this.telefono = telefono;
		this.web = web;
	}

	public Agencias() {
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
	 * @return the web
	 */
	public String getWeb() {
		return web;
	}

	/**
	 * @param web the web to set
	 */
	public void setWeb(String web) {
		this.web = web;
	}

	Conexion conector = new Conexion();

	public void create(int idagencias, String nombre, String direccion, String correo, String telefono, String web) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "INSERT INTO tblagencias (idagencias, nombre, direccion, correo, telefono, web) VALUES (?, ?, ?, ?, ?, ?)";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);

			pst.setInt(1, idagencias);
			pst.setString(2, nombre);
			pst.setString(3, direccion);
			pst.setString(4, correo);
			pst.setString(5, telefono);
			pst.setString(6, web);

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro con exito");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(int idagencias) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "DELETE FROM tblagencias WHERE idagencia = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idagencias);

			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. " + idagencias + "?",
					"Confirmacion", JOptionPane.YES_NO_OPTION);

			if (resp == JOptionPane.YES_OPTION) {
				int filasafectadas = pst.executeUpdate();

				if (filasafectadas > 0) {
					JOptionPane.showMessageDialog(null, "Registro No. " + idagencias + " eliminado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro el ID " + idagencias + " en la base de datos",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	public void readOne(int idagencias, JTextField nombre, JTextField direccion, JTextField correo, JTextField telefono, JTextField web) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String script = "select * from tblagencias WHERE idagencia = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idagencias);

			rs = pst.executeQuery();

			if (rs.next()) {

				nombre.setText(rs.getString("nombre"));
				direccion.setText(rs.getString("direccion"));
				correo.setText(rs.getString("correo"));
				telefono.setText(rs.getString("telefono"));
				web.setText(rs.getString("web"));

			} else {
				JOptionPane.showMessageDialog(null, "No se encontro el ID " + idagencias, "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al buscar: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	 public void update(int idagencias, String nombre, String direccion, String correo, String telefono, String web) {

			Connection dbConnection = null;
			PreparedStatement pst = null;

			String script = "update tblagencias set nombre = ?, direccion = ?, correo = ?, telefono = ?, web = ?  where idagencia = ?";

			try {
				dbConnection = Conexion.conectarBD();
				pst = dbConnection.prepareStatement(script);
				
				pst.setString(1, nombre);
				pst.setString(2, direccion);
				pst.setString(3, correo);
				pst.setString(4, telefono);
				pst.setString(5, web);
				pst.setInt(6, idagencias);

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