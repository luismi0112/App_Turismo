package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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

    public void create (String matricula, String marca, int puestos, String modelo, String numeromotor,
			String categoria, int idTipotransporte) {
    	
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "insert into tblvehiculos (matricula, marca, puestos, modelo, numeromotor, categoria, idTipotransporte) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            dbConnection = conector.conectarBD();
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
    }
