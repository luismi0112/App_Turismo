package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Medios;
import modelo.Operadores;
import modelo.Tipomedios;
import modelo.Vehiculos;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.ImageIcon;

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
	private JTable table;

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
		setBounds(100, 100, 564, 391);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblidoperador = new JLabel("ID Operador");
		lblidoperador.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblidoperador.setBounds(443, 98, 66, 14);
		contentPane.add(lblidoperador);

		textidoperador = new JTextField();
		textidoperador.setBounds(429, 123, 89, 20);
		contentPane.add(textidoperador);
		textidoperador.setColumns(10);

		JLabel lbltipodocumento = new JLabel("Tipo de Documento");
		lbltipodocumento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbltipodocumento.setBounds(79, 67, 97, 14);
		contentPane.add(lbltipodocumento);

		texttipodocumento = new JTextField();
		texttipodocumento.setColumns(10);
		texttipodocumento.setBounds(186, 64, 86, 20);
		contentPane.add(texttipodocumento);

		JLabel lbldocumento = new JLabel("Documento");
		lbldocumento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbldocumento.setBounds(94, 98, 63, 14);
		contentPane.add(lbldocumento);

		textdocumento = new JTextField();
		textdocumento.setColumns(10);
		textdocumento.setBounds(186, 95, 86, 20);
		contentPane.add(textdocumento);

		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblnombre.setBounds(103, 128, 46, 14);
		contentPane.add(lblnombre);

		textnombre = new JTextField();
		textnombre.setColumns(10);
		textnombre.setBounds(186, 125, 86, 20);
		contentPane.add(textnombre);

		JLabel lblapellido = new JLabel("Apellido");
		lblapellido.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblapellido.setBounds(103, 159, 46, 14);
		contentPane.add(lblapellido);

		textapellido = new JTextField();
		textapellido.setColumns(10);
		textapellido.setBounds(186, 156, 86, 20);
		contentPane.add(textapellido);

		JLabel lbldireccion = new JLabel("Direccion");
		lbldireccion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbldireccion.setBounds(99, 190, 58, 14);
		contentPane.add(lbldireccion);

		textdireccion = new JTextField();
		textdireccion.setColumns(10);
		textdireccion.setBounds(186, 187, 86, 20);
		contentPane.add(textdireccion);

		JLabel lblcorreo = new JLabel("Correo");
		lblcorreo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblcorreo.setBounds(103, 221, 46, 14);
		contentPane.add(lblcorreo);

		textcorreo = new JTextField();
		textcorreo.setColumns(10);
		textcorreo.setBounds(186, 218, 86, 20);
		contentPane.add(textcorreo);

		JLabel lbltelefono = new JLabel("Telefono");
		lbltelefono.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbltelefono.setBounds(103, 252, 46, 14);
		contentPane.add(lbltelefono);

		texttelefono = new JTextField();
		texttelefono.setColumns(10);
		texttelefono.setBounds(186, 249, 86, 20);
		contentPane.add(texttelefono);

		JLabel lblidvehiculo = new JLabel("ID Vehiculo");
		lblidvehiculo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblidvehiculo.setBounds(86, 283, 63, 14);
		contentPane.add(lblidvehiculo);

		textidvehiculo = new JTextField();
		textidvehiculo.setColumns(10);
		textidvehiculo.setBounds(186, 280, 86, 20);
		contentPane.add(textidvehiculo);

		JButton btnguardar = new JButton("");
		btnguardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666542_guardaricon.png"));
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int documento = Integer.parseInt(textdocumento.getText());
				Operadores cr = new Operadores();
				 cr.create(texttipodocumento.getText(), documento, textnombre.getText(), textapellido.getText(), textdireccion.getText(), textcorreo.getText(), texttelefono.getText());
				
			}
		});
		btnguardar.setBounds(282, 147, 89, 57);
		contentPane.add(btnguardar);
		
		JButton btnborrarid = new JButton("");
		btnborrarid.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666597_eliminar_2_icon.png"));
		btnborrarid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operadores cr = new Operadores();
				cr.delete(Integer.parseInt(textidoperador.getText()));
			}
		});
		btnborrarid.setBounds(429, 154, 92, 50);
		contentPane.add(btnborrarid);
		
		JLabel lbloperadores = new JLabel("OPERADORES");
		lbloperadores.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lbloperadores.setBounds(250, 23, 86, 14);
		contentPane.add(lbloperadores);
		
		table = new JTable();
		table.setBounds(395, 0, 11, 352);
		contentPane.add(table);
		
		JButton btnbuscar = new JButton("");
		btnbuscar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666693_buscar_icon.png"));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operadores cr = new Operadores();
				cr.readOne(Integer.parseInt(textidoperador.getText()), textidvehiculo, texttipodocumento, textdocumento, textnombre, textapellido, textdireccion, textcorreo, texttelefono);
			}
		});
		btnbuscar.setBounds(429, 209, 89, 57);
		contentPane.add(btnbuscar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Operadores cr = new Operadores();
				cr.update(Integer.parseInt(textidoperador.getText()), texttipodocumento.getText(), Integer.parseInt(textdocumento.getText()), textnombre.getText(), textapellido.getText(), textdireccion.getText(), textcorreo.getText(), texttelefono.getText());
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\134221_actualizar_icon.png"));
		btnNewButton.setBounds(429, 283, 89, 50);
		contentPane.add(btnNewButton);
	}
}
