package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Medios;
import modelo.Paquetes;
import modelo.companias;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

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
	private JLabel lblidcompania;
	private JTextField textidcompania;
	private JTable table;
	private JButton btnbuscar;
	private JButton btnNewButton;

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
		setBounds(100, 100, 481, 380);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblrazonsocial = new JLabel("Razon Social");
		lblrazonsocial.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblrazonsocial.setBounds(47, 63, 82, 14);
		contentPane.add(lblrazonsocial);

		textrazonsocial = new JTextField();
		textrazonsocial.setBounds(156, 60, 86, 20);
		contentPane.add(textrazonsocial);
		textrazonsocial.setColumns(10);

		JLabel lbldireccion = new JLabel("Direccion");
		lbldireccion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbldireccion.setBounds(57, 94, 61, 14);
		contentPane.add(lbldireccion);

		textdireccion = new JTextField();
		textdireccion.setBounds(156, 91, 86, 20);
		contentPane.add(textdireccion);
		textdireccion.setColumns(10);

		JLabel lblcorreo = new JLabel("Correo Electronico");
		lblcorreo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblcorreo.setBounds(35, 125, 110, 14);
		contentPane.add(lblcorreo);

		textcorreo = new JTextField();
		textcorreo.setBounds(156, 122, 86, 20);
		contentPane.add(textcorreo);
		textcorreo.setColumns(10);

		JLabel lbltelefono = new JLabel("Fecha de  Creacion");
		lbltelefono.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbltelefono.setBounds(35, 158, 110, 14);
		contentPane.add(lbltelefono);

		textfechacreacion = new JTextField();
		textfechacreacion.setBounds(156, 155, 86, 20);
		contentPane.add(textfechacreacion);
		textfechacreacion.setColumns(10);

		JLabel ibltelefono = new JLabel("Telefono");
		ibltelefono.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		ibltelefono.setBounds(53, 189, 61, 14);
		contentPane.add(ibltelefono);

		texttelefono = new JTextField();
		texttelefono.setBounds(156, 186, 86, 20);
		contentPane.add(texttelefono);
		texttelefono.setColumns(10);

		btnguardar = new JButton("");
		btnguardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666542_guardaricon.png"));
		btnguardar.setBounds(138, 248, 89, 51);
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
		iblweb.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		iblweb.setBounds(63, 220, 37, 14);
		contentPane.add(iblweb);

		textweb = new JTextField();
		textweb.setBounds(156, 217, 86, 20);
		textweb.setColumns(10);
		contentPane.add(textweb);

		lblcompanias = new JLabel("COMPANIAS");
		lblcompanias.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblcompanias.setBounds(220, 11, 75, 26);
		contentPane.add(lblcompanias);

		JButton btnborrarid = new JButton("");
		btnborrarid.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666597_eliminar_2_icon.png"));
		btnborrarid.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				companias cr = new companias();
				cr.delete(Integer.parseInt(textidcompania.getText()));
			}
		});
		btnborrarid.setBounds(340, 155, 89, 48);
		contentPane.add(btnborrarid);

		lblidcompania = new JLabel("ID Compania");
		lblidcompania.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblidcompania.setBounds(353, 107, 73, 14);
		contentPane.add(lblidcompania);

		textidcompania = new JTextField();
		textidcompania.setBounds(353, 124, 73, 20);
		contentPane.add(textidcompania);
		textidcompania.setColumns(10);

		table = new JTable();
		table.setBounds(305, 0, 14, 341);
		contentPane.add(table);

		btnbuscar = new JButton("");
		btnbuscar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666693_buscar_icon.png"));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				companias cr = new companias();
				cr.readOne(Integer.parseInt(textidcompania.getText()), textrazonsocial, textdireccion, textcorreo,
						textfechacreacion, texttelefono, textweb);
			}
		});
		btnbuscar.setBounds(337, 211, 89, 51);
		contentPane.add(btnbuscar);

		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				companias cr = new companias();
				java.sql.Date fechaSQL = java.sql.Date.valueOf(textfechacreacion.getText());
				cr.update(Integer.parseInt(textidcompania.getText()), textrazonsocial.getText(),
						textdireccion.getText(), textcorreo.getText(), fechaSQL, texttelefono.getText(),
						textweb.getText());
			}
		});
		btnNewButton.setIcon(
				new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\134221_actualizar_icon.png"));
		btnNewButton.setBounds(337, 276, 89, 51);
		contentPane.add(btnNewButton);
	}
}
