package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Conexion;

public class Vehiculos {

	public int idVehiculo;
	public String matricula;
	public String marca;
	public int puestos;
	public String modelo;
	public String numeromotor;
	public String categoria;

	public Vehiculos() {
		super();
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

	/**
	 * @return the matricula
	 */
	public String getMatricula() {
		return matricula;
	}

	/**
	 * @param matricula the matricula to set
	 */
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	/**
	 * @return the marca
	 */
	public String getMarca() {
		return marca;
	}

	/**
	 * @param marca the marca to set
	 */
	public void setMarca(String marca) {
		this.marca = marca;
	}

	/**
	 * @return the puestos
	 */
	public int getPuestos() {
		return puestos;
	}

	/**
	 * @param puestos the puestos to set
	 */
	public void setPuestos(int puestos) {
		this.puestos = puestos;
	}

	/**
	 * @return the modelo
	 */
	public String getModelo() {
		return modelo;
	}

	/**
	 * @param modelo the modelo to set
	 */
	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	/**
	 * @return the numeroMotor
	 */
	public String getNumeroMotor() {
		return numeromotor;
	}

	/**
	 * @param numeroMotor the numeroMotor to set
	 */
	public void setNumeroMotor(String numeroMotor) {
		this.numeromotor = numeroMotor;
	}

	/**
	 * @return the categoria
	 */
	public String getCategoria() {
		return categoria;
	}

	/**
	 * @param categoria the categoria to set
	 */
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	Conexion conector = new Conexion();

	public void create(String matricula, String marca, int puestos, String modelo, String numeromotor, String categoria,
			int idTipotransporte) {

		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "insert into tblvehiculos (matricula, marca, puestos, modelo, numeromotor, categoria, idTipotransporte) VALUES (?, ?, ?, ?, ?, ?, ?)";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);

			pst.setString(1, matricula);
			pst.setString(2, marca);
			pst.setInt(3, puestos);
			pst.setString(4, modelo);
			pst.setString(5, numeromotor);
			pst.setString(6, categoria);
			pst.setInt(7, idTipotransporte);

			pst.executeUpdate();
			JOptionPane.showMessageDialog(null, "Registro con exito");

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}

	public void delete(int idvehiculo) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "DELETE FROM tblvehiculos WHERE idvehiculo = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idvehiculo);

			int resp = JOptionPane.showConfirmDialog(null, "¿Desea eliminar el registro No. " + idvehiculo + "?",
					"Confirmacion", JOptionPane.YES_NO_OPTION);

			if (resp == JOptionPane.YES_OPTION) {
				int filasafectadas = pst.executeUpdate();

				if (filasafectadas > 0) {
					JOptionPane.showMessageDialog(null, "Registro No. " + idvehiculo + " eliminado correctamente");
				} else {
					JOptionPane.showMessageDialog(null, "No se encontro el ID " + idvehiculo + " en la base de datos",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Error al eliminar el registro: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void readOne(int idvehiculo, JTextField idTipotransporte,JTextField matricula, JTextField marca, JTextField puestos, JTextField modelo,
			JTextField numeromotor, JTextField categoria) {
		Connection dbConnection = null;
		PreparedStatement pst = null;
		ResultSet rs = null;

		String script = "SELECT * FROM tblvehiculos WHERE idvehiculo = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);
			pst.setInt(1, idvehiculo);
			rs = pst.executeQuery();

			if (rs.next()) {
				matricula.setText(rs.getString("matricula"));
				marca.setText(rs.getString("marca"));
				puestos.setText(String.valueOf(rs.getInt("puestos")));
				modelo.setText(rs.getString("modelo"));
				numeromotor.setText(rs.getString("numeromotor"));
				categoria.setText(rs.getString("categoria"));
				idTipotransporte.setText(rs.getString("idTipotransporte"));

			} else {
				JOptionPane.showMessageDialog(null, "No se encontro el ID " + idvehiculo, "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al buscar: " + e.getMessage(), "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}
	public void update(int idvehiculo, int puestos, int idTipotransporte, String matricula, String marca, String modelo, String numeromotor, String categoria) {
		Connection dbConnection = null;
		PreparedStatement pst = null;

		String script = "update tblvehiculos set matricula = ?, marca = ?, puestos = ?, modelo = ?, numeromotor = ?, categoria = ?, idTipotransporte = ? where idvehiculo = ?";

		try {
			dbConnection = Conexion.conectarBD();
			pst = dbConnection.prepareStatement(script);


			pst.setString(1, matricula);
			pst.setString(2, marca);
			pst.setString(3, modelo);
			pst.setString(4, numeromotor);
			pst.setString(5, categoria);
			pst.setInt(6, idvehiculo);
			pst.setInt(7, puestos);
			pst.setInt(8, idTipotransporte);

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