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
import modelo.Promotores;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JComboBox;

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
	private JButton btnlimpiar;
	private JLabel lblpromotores;
	private JComboBox combotipodocumento;

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
		setBounds(100, 100, 432, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblidpromotor = new JLabel("ID Promotor");
		lblidpromotor.setBounds(59, 72, 66, 14);
		contentPane.add(lblidpromotor);

		textidpromotor = new JTextField();
		textidpromotor.setBounds(162, 69, 86, 20);
		contentPane.add(textidpromotor);
		textidpromotor.setColumns(10);

		JLabel lbltipodocumento = new JLabel("Tipo de Documento");
		lbltipodocumento.setBounds(44, 103, 92, 14);
		contentPane.add(lbltipodocumento);

		JLabel lbldocumento = new JLabel("Documento");
		lbldocumento.setBounds(59, 134, 54, 14);
		contentPane.add(lbldocumento);

		textdocumento = new JTextField();
		textdocumento.setColumns(10);
		textdocumento.setBounds(162, 131, 86, 20);
		contentPane.add(textdocumento);

		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setBounds(74, 165, 46, 14);
		contentPane.add(lblnombre);

		textnombre = new JTextField();
		textnombre.setColumns(10);
		textnombre.setBounds(162, 162, 86, 20);
		contentPane.add(textnombre);

		JLabel lblapellido = new JLabel("Apellido");
		lblapellido.setBounds(74, 196, 46, 14);
		contentPane.add(lblapellido);

		textapellido = new JTextField();
		textapellido.setColumns(10);
		textapellido.setBounds(162, 193, 86, 20);
		contentPane.add(textapellido);

		JLabel lbldireccion = new JLabel("Direccion");
		lbldireccion.setBounds(74, 227, 46, 14);
		contentPane.add(lbldireccion);

		textdireccion = new JTextField();
		textdireccion.setColumns(10);
		textdireccion.setBounds(162, 224, 86, 20);
		contentPane.add(textdireccion);

		JLabel lblcorreopersonal = new JLabel("Correo Personal");
		lblcorreopersonal.setBounds(59, 258, 77, 14);
		contentPane.add(lblcorreopersonal);

		textcorreopersonal = new JTextField();
		textcorreopersonal.setColumns(10);
		textcorreopersonal.setBounds(162, 255, 86, 20);
		contentPane.add(textcorreopersonal);

		JLabel lbltelefono = new JLabel("Telefono");
		lbltelefono.setBounds(85, 351, 46, 14);
		contentPane.add(lbltelefono);

		texttelefono = new JTextField();
		texttelefono.setColumns(10);
		texttelefono.setBounds(162, 348, 86, 20);
		contentPane.add(texttelefono);

		JLabel lblfechanacimiento = new JLabel("Fecha Nacimiento");
		lblfechanacimiento.setBounds(65, 320, 86, 14);
		contentPane.add(lblfechanacimiento);

		textfechanacimiento = new JTextField();
		textfechanacimiento.setColumns(10);
		textfechanacimiento.setBounds(162, 317, 86, 20);
		contentPane.add(textfechanacimiento);

		JButton btnguardar = new JButton("GUARDAR");
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Promotores cr = new Promotores();
				try {
					java.sql.Date fechaSQL = java.sql.Date.valueOf(textfechanacimiento.getText());
					
			   cr.create(Integer.parseInt(textidpromotor.getText()), combotipodocumento.getSelectedItem().toString(), Integer.parseInt(textdocumento.getText()), textnombre.getText(),
						textapellido.getText(), textdireccion.getText(), textcorreopersonal.getText(),
						textcorreocorp.getText(),textfechanacimiento.getText(),
						texttelefono.getText());

				} catch (IllegalArgumentException ex) {
					JOptionPane.showMessageDialog(null, "Formato de fecha incorrecto Usar AÑO-MES-DIA");
				}
			}
		});
		btnguardar.setBounds(280, 192, 89, 23);
		contentPane.add(btnguardar);

		lblcorreocorp = new JLabel("Correo Corp");
		lblcorreocorp.setBounds(74, 289, 67, 14);
		contentPane.add(lblcorreocorp);

		textcorreocorp = new JTextField();
		textcorreocorp.setColumns(10);
		textcorreocorp.setBounds(162, 286, 86, 20);
		contentPane.add(textcorreocorp);
		
		btnlimpiar = new JButton("LIMPIAR");
		btnlimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Promotores cr = new Promotores();
				cr.delete(Integer.parseInt(textidpromotor.getText()));
			}
		});
		btnlimpiar.setBounds(280, 223, 89, 23);
		contentPane.add(btnlimpiar);
		
		lblpromotores = new JLabel("PROMOTOTRES");
		lblpromotores.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblpromotores.setBounds(162, 28, 103, 14);
		contentPane.add(lblpromotores);
		
		String[] tiposdocumento = {"CC", "TI", "CE", "RC", "PASAPORTE"};
		JComboBox<String> combotipodocumento = new JComboBox<>(tiposdocumento);
		combotipodocumento.setBounds(162, 100, 86, 20);
		contentPane.add(combotipodocumento);
	}

}
