package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Agencias;
import modelo.Operadores;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class agencias_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textidagencias;
	private JTextField textnombre;
	private JTextField textdireccion;
	private JTextField textcorreo;
	private JTextField texttelefono;
	private JTextField textweb;
	private JLabel lblnombre;
	private JLabel lblidireccion;
	private JLabel lblcorreo;
	private JLabel lbltelefono;
	private JLabel iblweb;
	private JLabel lblagencias;
	private JButton btnborrar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					agencias_view frame = new agencias_view();
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
	public agencias_view() {
		setTitle("Agencias");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 478, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblidagencias = new JLabel("ID Agencias");
		lblidagencias.setBounds(144, 79, 63, 14);
		contentPane.add(lblidagencias);
		
		textidagencias = new JTextField();
		textidagencias.setBounds(217, 76, 86, 20);
		contentPane.add(textidagencias);
		textidagencias.setColumns(10);
		
		textnombre = new JTextField();
		textnombre.setBounds(217, 102, 86, 20);
		contentPane.add(textnombre);
		textnombre.setColumns(10);
		
		textdireccion = new JTextField();
		textdireccion.setBounds(217, 129, 86, 20);
		contentPane.add(textdireccion);
		textdireccion.setColumns(10);
		
		textcorreo = new JTextField();
		textcorreo.setBounds(217, 157, 86, 20);
		contentPane.add(textcorreo);
		textcorreo.setColumns(10);
		
		texttelefono = new JTextField();
		texttelefono.setBounds(217, 186, 86, 20);
		contentPane.add(texttelefono);
		texttelefono.setColumns(10);
		
		textweb = new JTextField();
		textweb.setBounds(217, 214, 86, 20);
		contentPane.add(textweb);
		textweb.setColumns(10);
		
		lblnombre = new JLabel("Nombre");
		lblnombre.setBounds(154, 104, 37, 14);
		contentPane.add(lblnombre);
		
		lblidireccion = new JLabel("Direccion");
		lblidireccion.setBounds(144, 132, 43, 14);
		contentPane.add(lblidireccion);
		
		lblcorreo = new JLabel("Correo Electronico");
		lblcorreo.setBounds(115, 160, 92, 14);
		contentPane.add(lblcorreo);
		
		lbltelefono = new JLabel("Telefono");
		lbltelefono.setBounds(144, 189, 43, 14);
		contentPane.add(lbltelefono);
		
		iblweb = new JLabel("Web");
		iblweb.setBounds(154, 217, 53, 14);
		contentPane.add(iblweb);
		
		JButton btnguardar = new JButton("GUARDAR");
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Agencias cr = new Agencias();
				 cr.create(Integer.parseInt(textidagencias.getText()), textnombre.getText(), textdireccion.getText(), textcorreo.getText(), texttelefono.getText(), textweb.getText());
				
			}
		});
		
		btnguardar.setBounds(185, 245, 89, 23);
		contentPane.add(btnguardar);
		
		lblagencias = new JLabel("AGENCIAS");
		lblagencias.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblagencias.setBounds(205, 37, 70, 14);
		contentPane.add(lblagencias);
		
		btnborrar = new JButton("BORRAR ID");
		btnborrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Agencias cr = new Agencias();
				cr.delete(Integer.parseInt(textidagencias.getText()));
			}
		});
		btnborrar.setBounds(328, 75, 89, 23);
		contentPane.add(btnborrar);
	}
}
