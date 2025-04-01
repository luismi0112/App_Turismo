package modelo;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Clientes {

	public int idcliente;
	public String tipodocumento;
	public int documento;
	public String nombres;
	public String apellidos;
	public String eps;
	public String alergias;
	public String fechanacimiento;
	public String correo;
	public String estadocivil;
	public String telefono;
	public String direccion;


	public Clientes(int idcliente, String tipodocumento, int documento, String nombres, String apellidos, String eps,
			String alergias, String fechanacimiento, String correo, String estadocivil, String telefono,
			String direccion) {
		super();
		this.idcliente = idcliente;
		this.tipodocumento = tipodocumento;
		this.documento = documento;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.eps = eps;
		this.alergias = alergias;
		this.fechanacimiento = fechanacimiento;
		this.correo = correo;
		this.estadocivil = estadocivil;
		this.telefono = telefono;
		this.direccion = direccion;
	}

	public Clientes() {
	
	}

	/**
	 * @return the idcliente
	 */
	public int getIdcliente() {
		return idcliente;
	}

	/**
	 * @param idcliente the idcliente to set
	 */
	public void setIdcliente(int idcliente) {
		this.idcliente = idcliente;
	}

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
	 * @return the eps
	 */
	public String getEps() {
		return eps;
	}

	/**
	 * @param eps the eps to set
	 */
	public void setEps(String eps) {
		this.eps = eps;
	}

	/**
	 * @return the alergias
	 */
	public String getAlergias() {
		return alergias;
	}

	/**
	 * @param alergias the alergias to set
	 */
	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	/**
	 * @return the fechanacimiento
	 */
	public String getFechanacimiento() {
		return fechanacimiento;
	}

	/**
	 * @param fechanacimiento the fechanacimiento to set
	 */
	public void setFechanacimiento(String fechanacimiento) {
		this.fechanacimiento = fechanacimiento;
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
	 * @return the estadocivil
	 */
	public String getEstadocivil() {
		return estadocivil;
	}

	/**
	 * @param estadocivil the estadocivil to set
	 */
	public void setEstadocivil(String estadocivil) {
		this.estadocivil = estadocivil;
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

	Conexion conector = new Conexion();

    public void create (int idcliente, String tipodocumento, int documento, String nombres, String apellidos, String eps,
	String alergias, String fechanacimiento, String correo, String estadocivil, String telefono,
	String direccion) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "INSERT INTO tblclientes (tipodocumento, documento, nombres, apellidos, eps, alergias, fechanacimiento, correo, estadocivil, telefono, direccion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);

            pst.setString(1, tipodocumento);
            pst.setInt(2, documento);
            pst.setString(3, nombres);
            pst.setString(4, apellidos);
            pst.setString(5, eps);
            pst.setString(6, alergias);
            pst.setDate(7, Date.valueOf(fechanacimiento));
            pst.setString(8, correo);
            pst.setString(9, estadocivil);
            pst.setString(10, telefono);
            pst.setString(11, direccion);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro con exito");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        }
    public void delete(int idcliente) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "DELETE FROM tblclientes WHERE idcliente = ?";

		try {
			dbConnection = conector.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idcliente);

			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. " + idcliente + "?",
					"Confirmacion", JOptionPane.YES_NO_OPTION);

			if (resp == JOptionPane.YES_OPTION) {
				int filasafectadas = pst.executeUpdate();

				if (filasafectadas > 0) {
					JOptionPane.showMessageDialog(null, "Registro No. " + idcliente + " eliminado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro el ID " + idcliente + " en la base de datos",
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