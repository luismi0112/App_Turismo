package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Paquetes;
import modelo.companias;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class companias_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textrazonsocial;
	private JTextField textdireccion;
	private JTextField textcorreo;
	private JTextField textfechacreacion;
	private JTextField texttelefono;
	private JButton btnguardar;
	private JTextField textweb;
	private JLabel lblcompanias;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					companias_view frame = new companias_view();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public companias_view() {
		setTitle("Companias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 391, 289);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblrazonsocial = new JLabel("Razon Social");
		lblrazonsocial.setBounds(59, 63, 70, 14);
		contentPane.add(lblrazonsocial);

		textrazonsocial = new JTextField();
		textrazonsocial.setBounds(156, 60, 86, 20);
		contentPane.add(textrazonsocial);
		textrazonsocial.setColumns(10);

		JLabel lbldireccion = new JLabel("Direccion");
		lbldireccion.setBounds(68, 94, 50, 14);
		contentPane.add(lbldireccion);

		textdireccion = new JTextField();
		textdireccion.setBounds(156, 91, 86, 20);
		contentPane.add(textdireccion);
		textdireccion.setColumns(10);

		JLabel lblcorreo = new JLabel("Correo Electronico");
		lblcorreo.setBounds(47, 125, 98, 14);
		contentPane.add(lblcorreo);

		textcorreo = new JTextField();
		textcorreo.setBounds(156, 122, 86, 20);
		contentPane.add(textcorreo);
		textcorreo.setColumns(10);

		JLabel lbltelefono = new JLabel("Fecha de  Creacion");
		lbltelefono.setBounds(47, 158, 98, 14);
		contentPane.add(lbltelefono);

		textfechacreacion = new JTextField();
		textfechacreacion.setBounds(156, 155, 86, 20);
		contentPane.add(textfechacreacion);
		textfechacreacion.setColumns(10);

		JLabel ibltelefono = new JLabel("Telefono");
		ibltelefono.setBounds(68, 189, 46, 14);
		contentPane.add(ibltelefono);

		texttelefono = new JTextField();
		texttelefono.setBounds(156, 186, 86, 20);
		contentPane.add(texttelefono);
		texttelefono.setColumns(10);

		btnguardar = new JButton("GUARDAR");
		btnguardar.setBounds(252, 100, 89, 39);
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					java.sql.Date fechaSQL = java.sql.Date.valueOf(textfechacreacion.getText());

					companias cr = new companias();
					cr.create(textrazonsocial.getText(), textdireccion.getText(), textcorreo.getText(), fechaSQL,
							texttelefono.getText(), textweb.getText());

				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto Usar AÑO-MES-DIA");
				}
			}
		});
		contentPane.add(btnguardar);

		JLabel iblweb = new JLabel("Web");
		iblweb.setBounds(78, 220, 22, 14);
		contentPane.add(iblweb);

		textweb = new JTextField();
		textweb.setBounds(156, 217, 86, 20);
		textweb.setColumns(10);
		contentPane.add(textweb);
		
		lblcompanias = new JLabel("COMPANIAS");
		lblcompanias.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblcompanias.setBounds(156, 23, 75, 14);
		contentPane.add(lblcompanias);
		
		JButton btnlimpiar = new JButton("LIMPIAR");
		btnlimpiar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textrazonsocial.setText("");
				textdireccion.setText("");
				textcorreo.setText("");
				textfechacreacion.setText("");
				texttelefono.setText("");
				textweb.setText("");
			}
		});
		btnlimpiar.setBounds(252, 154, 89, 33);
		contentPane.add(btnlimpiar);
	}
}
