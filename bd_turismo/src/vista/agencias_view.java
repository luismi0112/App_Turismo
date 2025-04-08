package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Agencias;
import modelo.Operadores;
import modelo.companias;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

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
		setBounds(100, 100, 564, 347);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblidagencias = new JLabel("ID Agencias");
		lblidagencias.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblidagencias.setBounds(430, 70, 77, 14);
		contentPane.add(lblidagencias);

		textidagencias = new JTextField();
		textidagencias.setBounds(418, 95, 86, 20);
		contentPane.add(textidagencias);
		textidagencias.setColumns(10);

		textnombre = new JTextField();
		textnombre.setBounds(160, 53, 86, 20);
		contentPane.add(textnombre);
		textnombre.setColumns(10);

		textdireccion = new JTextField();
		textdireccion.setBounds(160, 83, 86, 20);
		contentPane.add(textdireccion);
		textdireccion.setColumns(10);

		textcorreo = new JTextField();
		textcorreo.setBounds(160, 114, 86, 20);
		contentPane.add(textcorreo);
		textcorreo.setColumns(10);

		texttelefono = new JTextField();
		texttelefono.setBounds(160, 145, 86, 20);
		contentPane.add(texttelefono);
		texttelefono.setColumns(10);

		textweb = new JTextField();
		textweb.setBounds(160, 176, 86, 20);
		contentPane.add(textweb);
		textweb.setColumns(10);

		lblnombre = new JLabel("Nombre");
		lblnombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblnombre.setBounds(69, 56, 51, 14);
		contentPane.add(lblnombre);

		lblidireccion = new JLabel("Direccion");
		lblidireccion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblidireccion.setBounds(69, 83, 57, 14);
		contentPane.add(lblidireccion);

		lblcorreo = new JLabel("Correo Electronico");
		lblcorreo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblcorreo.setBounds(43, 117, 114, 14);
		contentPane.add(lblcorreo);

		lbltelefono = new JLabel("Telefono");
		lbltelefono.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbltelefono.setBounds(69, 148, 57, 14);
		contentPane.add(lbltelefono);

		iblweb = new JLabel("Web");
		iblweb.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		iblweb.setBounds(79, 179, 41, 14);
		contentPane.add(iblweb);

		JButton btnguardar = new JButton("");
		btnguardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666542_guardaricon.png"));
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Agencias cr = new Agencias();
				cr.create(Integer.parseInt(textidagencias.getText()), textnombre.getText(), textdireccion.getText(),
						textcorreo.getText(), texttelefono.getText(), textweb.getText());

			}
		});

		btnguardar.setBounds(267, 101, 89, 64);
		contentPane.add(btnguardar);

		lblagencias = new JLabel("AGENCIAS");
		lblagencias.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblagencias.setBounds(247, 11, 70, 14);
		contentPane.add(lblagencias);

		btnborrar = new JButton("");
		btnborrar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666597_eliminar_2_icon.png"));
		btnborrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Agencias cr = new Agencias();
				cr.delete(Integer.parseInt(textidagencias.getText()));
			}
		});
		btnborrar.setBounds(418, 126, 89, 48);
		contentPane.add(btnborrar);

		table = new JTable();
		table.setBounds(373, 0, 10, 308);
		contentPane.add(table);

		btnbuscar = new JButton("");
		btnbuscar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666693_buscar_icon.png"));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agencias cr = new Agencias();
				cr.readOne(Integer.parseInt(textidagencias.getText()), textnombre, textdireccion, textcorreo, texttelefono, textweb);
				
			}
		});
		btnbuscar.setBounds(418, 187, 89, 57);
		contentPane.add(btnbuscar);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Agencias cr = new Agencias();
				cr.update(Integer.parseInt(textidagencias.getText()), textnombre.getText(), textdireccion.getText(),
						textcorreo.getText(), texttelefono.getText(), textweb.getText());
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\134221_refresh_reload_repeat_update_arrow_icon.png"));
		btnNewButton.setBounds(418, 255, 89, 53);
		contentPane.add(btnNewButton);
	}
}
