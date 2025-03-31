package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controlador.Conexion;

public class Agencias {
	
	
	public int idcompania;
	public String nombre;
	public String direccion;
	public String correo;
	public String telefono;
	public String web;
	
	public Agencias(int idcompania, String nombre, String direccion, String correo, String telefono, String web) {
		this.idcompania = idcompania;
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

    public void create (int idcompania,String nombre, String direccion, String correo, String telefono, String web) {
        Connection dbConnection = null;
        PreparedStatement pst = null;

        String script = "INSERT INTO tblagencias (idcompania, nombre, direccion, correo, telefono, web) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            dbConnection = conector.conectarBD();
            pst = dbConnection.prepareStatement(script);

            pst.setInt(1, idcompania);
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
    }
	

