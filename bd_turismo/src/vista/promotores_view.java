package vista;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Clientes;
import modelo.Operadores;
import modelo.Promotores;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class promotores_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textidpromotor;
	private JTextField textdocumento;
	private JTextField textnombre;
	private JTextField textapellido;
	private JTextField textdireccion;
	private JTextField textcorreopersonal;
	private JTextField texttelefono;
	private JTextField textfechanacimiento;
	private JLabel lblcorreocorp;
	private JTextField textcorreocorp;
	private JButton btnborrarid;
	private JLabel lblpromotores;
	private JComboBox combotipodocumento;
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
					promotores_view frame = new promotores_view();
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
	public promotores_view() {
		setTitle("Promotores");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 571, 437);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblidpromotor = new JLabel("ID Promotor");
		lblidpromotor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblidpromotor.setBounds(440, 103, 77, 14);
		contentPane.add(lblidpromotor);

		textidpromotor = new JTextField();
		textidpromotor.setBounds(431, 131, 86, 20);
		contentPane.add(textidpromotor);
		textidpromotor.setColumns(10);

		JLabel lbltipodocumento = new JLabel("Tipo de Documento");
		lbltipodocumento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbltipodocumento.setBounds(43, 76, 97, 14);
		contentPane.add(lbltipodocumento);

		JLabel lbldocumento = new JLabel("Documento");
		lbldocumento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbldocumento.setBounds(66, 103, 56, 14);
		contentPane.add(lbldocumento);

		textdocumento = new JTextField();
		textdocumento.setColumns(10);
		textdocumento.setBounds(162, 100, 86, 20);
		contentPane.add(textdocumento);

		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblnombre.setBounds(76, 134, 46, 14);
		contentPane.add(lblnombre);

		textnombre = new JTextField();
		textnombre.setColumns(10);
		textnombre.setBounds(162, 131, 86, 20);
		contentPane.add(textnombre);

		JLabel lblapellido = new JLabel("Apellido");
		lblapellido.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblapellido.setBounds(74, 165, 46, 14);
		contentPane.add(lblapellido);

		textapellido = new JTextField();
		textapellido.setColumns(10);
		textapellido.setBounds(162, 162, 86, 20);
		contentPane.add(textapellido);

		JLabel lbldireccion = new JLabel("Direccion");
		lbldireccion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbldireccion.setBounds(74, 196, 46, 14);
		contentPane.add(lbldireccion);

		textdireccion = new JTextField();
		textdireccion.setColumns(10);
		textdireccion.setBounds(162, 193, 86, 20);
		contentPane.add(textdireccion);

		JLabel lblcorreopersonal = new JLabel("Correo Personal");
		lblcorreopersonal.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblcorreopersonal.setBounds(48, 230, 92, 14);
		contentPane.add(lblcorreopersonal);

		textcorreopersonal = new JTextField();
		textcorreopersonal.setColumns(10);
		textcorreopersonal.setBounds(162, 227, 86, 20);
		contentPane.add(textcorreopersonal);

		JLabel lbltelefono = new JLabel("Telefono");
		lbltelefono.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbltelefono.setBounds(74, 323, 46, 14);
		contentPane.add(lbltelefono);

		texttelefono = new JTextField();
		texttelefono.setColumns(10);
		texttelefono.setBounds(162, 320, 86, 20);
		contentPane.add(texttelefono);

		JLabel lblfechanacimiento = new JLabel("Fecha Nacimiento");
		lblfechanacimiento.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblfechanacimiento.setBounds(48, 292, 86, 14);
		contentPane.add(lblfechanacimiento);

		textfechanacimiento = new JTextField();
		textfechanacimiento.setColumns(10);
		textfechanacimiento.setBounds(162, 289, 86, 20);
		contentPane.add(textfechanacimiento);

		JButton btnguardar = new JButton("");
		btnguardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666542_guardaricon.png"));
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Promotores cr = new Promotores();
				try {
					java.sql.Date fechaSQL = java.sql.Date.valueOf(textfechanacimiento.getText());

					cr.create(Integer.parseInt(textidpromotor.getText()),
							combotipodocumento.getSelectedItem().toString(), Integer.parseInt(textdocumento.getText()),
							textnombre.getText(), textapellido.getText(), textdireccion.getText(),
							textcorreopersonal.getText(), textcorreocorp.getText(), textfechanacimiento.getText(),
							texttelefono.getText());

				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto Usar AÑO-MES-DIA");
				}
			}
		});
		btnguardar.setBounds(278, 165, 89, 65);
		contentPane.add(btnguardar);

		lblcorreocorp = new JLabel("Correo Corp");
		lblcorreocorp.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblcorreocorp.setBounds(66, 261, 67, 14);
		contentPane.add(lblcorreocorp);

		textcorreocorp = new JTextField();
		textcorreocorp.setColumns(10);
		textcorreocorp.setBounds(162, 258, 86, 20);
		contentPane.add(textcorreocorp);

		btnborrarid = new JButton("");
		btnborrarid.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666597_eliminar_2_icon.png"));
		btnborrarid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Promotores cr = new Promotores();
				cr.delete(Integer.parseInt(textidpromotor.getText()));
			}
		});
		btnborrarid.setBounds(428, 162, 89, 68);
		contentPane.add(btnborrarid);

		lblpromotores = new JLabel("PROMOTORES");
		lblpromotores.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblpromotores.setBounds(238, 25, 103, 14);
		contentPane.add(lblpromotores);

		String[] tiposdocumento = { "CC", "TI", "CE", "RC", "PASAPORTE" };
		JComboBox<String> combotipodocumento = new JComboBox<>(tiposdocumento);
		combotipodocumento.setBounds(162, 73, 86, 20);
		contentPane.add(combotipodocumento);

		table = new JTable();
		table.setBounds(384, 0, 10, 398);
		contentPane.add(table);

		btnbuscar = new JButton("");
		btnbuscar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666693_buscar_icon.png"));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Promotores cr = new Promotores();
				cr.readOne(Integer.parseInt(textidpromotor.getText()), textfechanacimiento, combotipodocumento,
						textdocumento, textnombre, textapellido, textdireccion, textcorreopersonal, textcorreocorp,
						texttelefono);
			}
		});
		btnbuscar.setBounds(431, 241, 89, 70);
		contentPane.add(btnbuscar);

		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Promotores cr = new Promotores();
				cr.update(Integer.parseInt(textidpromotor.getText()), combotipodocumento.getSelectedItem().toString(),
						Integer.parseInt(textdocumento.getText()), textnombre.getText(), textapellido.getText(),
						textdireccion.getText(), textcorreopersonal.getText(), textcorreocorp.getText(),
						textfechanacimiento.getText(), texttelefono.getText());
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\134221_actualizar_icon.png"));
		btnNewButton.setBounds(431, 323, 89, 64);
		contentPane.add(btnNewButton);
	}

}
