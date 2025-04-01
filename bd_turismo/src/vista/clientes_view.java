package vista;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import modelo.Clientes;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class clientes_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textdocumento;
	private JTextField textnombre;
	private JTextField textapellido;
	private JTextField textdireccion;
	private JTextField textcorreopersonal;
	private JTextField texttelefono;
	private JTextField textfechanacimiento;
	private JLabel lbleps;
	private JTextField texteps;
	private JLabel lblalergias;
	private JTextField textalergias;
	private JLabel lblestadocivil;
	private JTextField textestadocivil;
	private JLabel lblclientes;
	private JButton btnborrarid;
	private JTextField textidcliente;
	private JTextField texttipodocumento;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					clientes_view frame = new clientes_view();
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
	public clientes_view() {
		setTitle("Clientes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 447);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbltipodocumento = new JLabel("Tipo de Documento");
		lbltipodocumento.setBounds(59, 47, 92, 14);
		contentPane.add(lbltipodocumento);

		JLabel lbldocumento = new JLabel("Documento");
		lbldocumento.setBounds(97, 72, 54, 14);
		contentPane.add(lbldocumento);

		textdocumento = new JTextField();
		textdocumento.setColumns(10);
		textdocumento.setBounds(162, 69, 86, 20);
		contentPane.add(textdocumento);

		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setBounds(105, 97, 46, 14);
		contentPane.add(lblnombre);

		textnombre = new JTextField();
		textnombre.setColumns(10);
		textnombre.setBounds(162, 94, 86, 20);
		contentPane.add(textnombre);

		JLabel lblapellido = new JLabel("Apellido");
		lblapellido.setBounds(105, 122, 46, 14);
		contentPane.add(lblapellido);

		textapellido = new JTextField();
		textapellido.setColumns(10);
		textapellido.setBounds(162, 119, 86, 20);
		contentPane.add(textapellido);

		JLabel lbldireccion = new JLabel("Direccion");
		lbldireccion.setBounds(105, 147, 46, 14);
		contentPane.add(lbldireccion);

		textdireccion = new JTextField();
		textdireccion.setColumns(10);
		textdireccion.setBounds(162, 144, 86, 20);
		contentPane.add(textdireccion);

		JLabel lblcorreopersonal = new JLabel("Correo Personal");
		lblcorreopersonal.setBounds(74, 172, 77, 14);
		contentPane.add(lblcorreopersonal);

		textcorreopersonal = new JTextField();
		textcorreopersonal.setColumns(10);
		textcorreopersonal.setBounds(162, 169, 86, 20);
		contentPane.add(textcorreopersonal);

		JLabel lbltelefono = new JLabel("Telefono");
		lbltelefono.setBounds(97, 223, 46, 14);
		contentPane.add(lbltelefono);

		texttelefono = new JTextField();
		texttelefono.setColumns(10);
		texttelefono.setBounds(162, 220, 86, 20);
		contentPane.add(texttelefono);

		JLabel lblfechanacimiento = new JLabel("Fecha Nacimiento");
		lblfechanacimiento.setBounds(65, 251, 86, 14);
		contentPane.add(lblfechanacimiento);

		textfechanacimiento = new JTextField();
		textfechanacimiento.setColumns(10);
		textfechanacimiento.setBounds(162, 248, 86, 20);
		contentPane.add(textfechanacimiento);

		JButton btnguardar = new JButton("GUARDAR");
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Clientes cr = new Clientes();
				cr.create(Integer.parseInt(textidcliente.getText()), texttipodocumento.getText(), Integer.parseInt(textdocumento.getText()), textnombre.getText(), textapellido.getText(), texteps.getText(), textalergias.getText(), textfechanacimiento.getText(), textcorreopersonal.getText(), textestadocivil.getText(), texttelefono.getText(), textdireccion.getText());
				
			}
		});
		btnguardar.setBounds(280, 163, 89, 23);
		contentPane.add(btnguardar);

		lbleps = new JLabel("EPS");
		lbleps.setBounds(110, 197, 41, 14);
		contentPane.add(lbleps);

		texteps = new JTextField();
		texteps.setColumns(10);
		texteps.setBounds(162, 194, 86, 20);
		contentPane.add(texteps);

		lblalergias = new JLabel("Alergias");
		lblalergias.setBounds(85, 276, 66, 14);
		contentPane.add(lblalergias);

		textalergias = new JTextField();
		textalergias.setColumns(10);
		textalergias.setBounds(162, 273, 86, 20);
		contentPane.add(textalergias);

		lblestadocivil = new JLabel("Estado Civil");
		lblestadocivil.setBounds(85, 301, 66, 14);
		contentPane.add(lblestadocivil);

		textestadocivil = new JTextField();
		textestadocivil.setColumns(10);
		textestadocivil.setBounds(162, 298, 86, 20);
		contentPane.add(textestadocivil);
		
		lblclientes = new JLabel("CLIENTES");
		lblclientes.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblclientes.setBounds(182, 11, 66, 14);
		contentPane.add(lblclientes);
		
		btnborrarid = new JButton("BORRAR ID");
		btnborrarid.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Clientes cr = new Clientes();
				cr.delete(Integer.parseInt(textidcliente.getText()));
			}
		});
		btnborrarid.setBounds(360, 68, 89, 23);
		contentPane.add(btnborrarid);
		
		
		JLabel lblidclientes = new JLabel("ID Clientes");
		lblidclientes.setBounds(272, 47, 61, 14);
		contentPane.add(lblidclientes);
		
		textidcliente = new JTextField();
		textidcliente.setBounds(262, 69, 86, 20);
		contentPane.add(textidcliente);
		textidcliente.setColumns(10);
		
		texttipodocumento = new JTextField();
		texttipodocumento.setBounds(162, 44, 86, 20);
		contentPane.add(texttipodocumento);
		texttipodocumento.setColumns(10);
	}
}
