package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Paquetes {

	public int iddestino;
	public int idorigen;
	public String fechaventa;
	public String fechaejecucion;
	public String horaventa;
	public String horasalida;
	public String observacion;
	public String precio;

	public Paquetes(int iddestino, int idorigen, String fechaventa, String fechaejecucion, String horaventa,
			String horasalida, String observacion, String precio) {
		super();
		this.iddestino = iddestino;
		this.idorigen = idorigen;
		this.fechaventa = fechaventa;
		this.fechaejecucion = fechaejecucion;
		this.horaventa = horaventa;
		this.horasalida = horasalida;
		this.observacion = observacion;
		this.precio = precio;
	}

	public Paquetes() {
	}

	/**
	 * @return the iddestino
	 */
	public int getIddestino() {
		return iddestino;
	}

	/**
	 * @param iddestino the iddestino to set
	 */
	public void setIddestino(int iddestino) {
		this.iddestino = iddestino;
	}

	/**
	 * @return the idorigen
	 */
	public int getIdorigen() {
		return idorigen;
	}

	/**
	 * @param idorigen the idorigen to set
	 */
	public void setIdorigen(int idorigen) {
		this.idorigen = idorigen;
	}

	/**
	 * @return the fechaventa
	 */
	public String getFechaventa() {
		return fechaventa;
	}

	/**
	 * @param fechaventa the fechaventa to set
	 */
	public void setFechaventa(String fechaventa) {
		this.fechaventa = fechaventa;
	}

	/**
	 * @return the fechaejecucion
	 */
	public String getFechaejecucion() {
		return fechaejecucion;
	}

	/**
	 * @param fechaejecucion the fechaejecucion to set
	 */
	public void setFechaejecucion(String fechaejecucion) {
		this.fechaejecucion = fechaejecucion;
	}

	/**
	 * @return the horaventa
	 */
	public String getHoraventa() {
		return horaventa;
	}

	/**
	 * @param horaventa the horaventa to set
	 */
	public void setHoraventa(String horaventa) {
		this.horaventa = horaventa;
	}

	/**
	 * @return the horasalida
	 */
	public String getHorasalida() {
		return horasalida;
	}

	/**
	 * @param horasalida the horasalida to set
	 */
	public void setHorasalida(String horasalida) {
		this.horasalida = horasalida;
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
	 * @return the precio
	 */
	public String getPrecio() {
		return precio;
	}

	/**
	 * @param precio the precio to set
	 */
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	Conexion conector = new Conexion();

    public void create (int iddestino, int idorigen, String fechaventa, String fechaejecucion, String horaventa,
			String horasalida, String observacion, double precio) {
    	
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "insert into tblpaquetes (iddestino, idorigen, fechaventa, fechaejecucion, horaventa, horasalida, observacion, precio) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";


        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);

            pst.setInt(1, iddestino);
            pst.setInt(2, idorigen);
            pst.setString(3, fechaventa);
            pst.setString(4, fechaejecucion);
            pst.setString(5, horaventa);
            pst.setString(6, horasalida);
            pst.setString(7, observacion);
            pst.setDouble(8, precio);

            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro con exito");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            }
        }
    }