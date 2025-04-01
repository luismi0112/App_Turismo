package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Medios;
import modelo.Operadores;
import modelo.Tipomedios;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class operadores_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textidoperador;
	private JTextField texttipodocumento;
	private JTextField textdocumento;
	private JTextField textnombre;
	private JTextField textapellido;
	private JTextField textdireccion;
	private JTextField textcorreo;
	private JTextField texttelefono;
	private JTextField textidvehiculo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					operadores_view frame = new operadores_view();
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
	public operadores_view() {
		setTitle("Operadores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 454, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblidoperador = new JLabel("ID Operador");
		lblidoperador.setBounds(74, 66, 66, 14);
		contentPane.add(lblidoperador);

		textidoperador = new JTextField();
		textidoperador.setBounds(162, 63, 86, 20);
		contentPane.add(textidoperador);
		textidoperador.setColumns(10);

		JLabel lbltipodocumento = new JLabel("Tipo de Documento");
		lbltipodocumento.setBounds(58, 97, 92, 14);
		contentPane.add(lbltipodocumento);

		texttipodocumento = new JTextField();
		texttipodocumento.setColumns(10);
		texttipodocumento.setBounds(162, 94, 86, 20);
		contentPane.add(texttipodocumento);

		JLabel lbldocumento = new JLabel("Documento");
		lbldocumento.setBounds(74, 128, 54, 14);
		contentPane.add(lbldocumento);

		textdocumento = new JTextField();
		textdocumento.setColumns(10);
		textdocumento.setBounds(162, 125, 86, 20);
		contentPane.add(textdocumento);

		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setBounds(85, 159, 46, 14);
		contentPane.add(lblnombre);

		textnombre = new JTextField();
		textnombre.setColumns(10);
		textnombre.setBounds(162, 156, 86, 20);
		contentPane.add(textnombre);

		JLabel lblapellido = new JLabel("Apellido");
		lblapellido.setBounds(85, 190, 46, 14);
		contentPane.add(lblapellido);

		textapellido = new JTextField();
		textapellido.setColumns(10);
		textapellido.setBounds(162, 187, 86, 20);
		contentPane.add(textapellido);

		JLabel lbldireccion = new JLabel("Direccion");
		lbldireccion.setBounds(85, 221, 58, 14);
		contentPane.add(lbldireccion);

		textdireccion = new JTextField();
		textdireccion.setColumns(10);
		textdireccion.setBounds(162, 218, 86, 20);
		contentPane.add(textdireccion);

		JLabel lblcorreo = new JLabel("Correo");
		lblcorreo.setBounds(85, 252, 46, 14);
		contentPane.add(lblcorreo);

		textcorreo = new JTextField();
		textcorreo.setColumns(10);
		textcorreo.setBounds(162, 249, 86, 20);
		contentPane.add(textcorreo);

		JLabel lbltelefono = new JLabel("Telefono");
		lbltelefono.setBounds(85, 283, 46, 14);
		contentPane.add(lbltelefono);

		texttelefono = new JTextField();
		texttelefono.setColumns(10);
		texttelefono.setBounds(162, 280, 86, 20);
		contentPane.add(texttelefono);

		JLabel lblidvehiculo = new JLabel("ID Vehiculo");
		lblidvehiculo.setBounds(74, 314, 54, 14);
		contentPane.add(lblidvehiculo);

		textidvehiculo = new JTextField();
		textidvehiculo.setColumns(10);
		textidvehiculo.setBounds(162, 311, 86, 20);
		contentPane.add(textidvehiculo);

		JButton btnguardar = new JButton("GUARDAR");
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int documento = Integer.parseInt(textdocumento.getText());
				Operadores cr = new Operadores();
				 cr.create(texttipodocumento.getText(), documento, textnombre.getText(), textapellido.getText(), textdireccion.getText(), textcorreo.getText(), texttelefono.getText());
				
			}
		});
		btnguardar.setBounds(269, 181, 89, 23);
		contentPane.add(btnguardar);
		
		JButton btnborrarid = new JButton("BORRAR ID");
		btnborrarid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operadores cr = new Operadores();
				cr.delete(Integer.parseInt(textidoperador.getText()));
			}
		});
		btnborrarid.setBounds(269, 62, 89, 23);
		contentPane.add(btnborrarid);
		
		JLabel lbloperadores = new JLabel("OPERADORES");
		lbloperadores.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lbloperadores.setBounds(186, 26, 86, 14);
		contentPane.add(lbloperadores);
	}

}
