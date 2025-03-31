package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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

    public void create (String nombre, String observacion, int idTipomedio) {
    	
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "insert into tblmedios (nombre, observacion, idtipomedio) VALUES (?, ?, ?)";

        try {
            dbConnection = conector.conectarBD();
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
    }
