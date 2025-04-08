package vista;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Agencias;
import modelo.Clientes;
import modelo.Medios;
import modelo.Tipomedios;
import modelo.Tipotransporte;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class medios_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textnombre;
	private JTextField textobservacion;
	private JLabel lblidTipomedio;
	private JTextField textidTipomedio;
	private JLabel lblmedios;
	private JButton btnborrarid;
	private JLabel lblidmedio;
	private JTextField textidmedio;
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
					medios_view frame = new medios_view();
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
	public medios_view() {
		setTitle("Medios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 541, 309);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblnombre.setBounds(125, 53, 56, 14);
		contentPane.add(lblnombre);

		textnombre = new JTextField();
		textnombre.setBounds(191, 50, 124, 20);
		contentPane.add(textnombre);
		textnombre.setColumns(10);

		JLabel lblobservacion = new JLabel("Observacion");
		lblobservacion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblobservacion.setBounds(108, 96, 84, 14);
		contentPane.add(lblobservacion);

		textobservacion = new JTextField();
		textobservacion.setBounds(191, 84, 124, 39);
		contentPane.add(textobservacion);
		textobservacion.setColumns(10);

		JButton btnguardar = new JButton("");
		btnguardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666542_guardaricon.png"));
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Medios cr = new Medios();
				cr.create(textnombre.getText(), textobservacion.getText(), Integer.parseInt(textidTipomedio.getText()));
			}
		});
		btnguardar.setBounds(186, 170, 89, 56);
		contentPane.add(btnguardar);

		lblidTipomedio = new JLabel("ID Tipo medio");
		lblidTipomedio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblidTipomedio.setBounds(108, 142, 73, 14);
		contentPane.add(lblidTipomedio);

		textidTipomedio = new JTextField();
		textidTipomedio.setColumns(10);
		textidTipomedio.setBounds(191, 139, 124, 20);
		contentPane.add(textidTipomedio);

		lblmedios = new JLabel("MEDIOS");
		lblmedios.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblmedios.setBounds(259, 11, 56, 14);
		contentPane.add(lblmedios);

		btnborrarid = new JButton("");
		btnborrarid.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666597_eliminar_2_icon.png"));
		btnborrarid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medios cr = new Medios();
				cr.delete(Integer.parseInt(textidmedio.getText()));
			}
		});
		btnborrarid.setBounds(402, 91, 89, 50);
		contentPane.add(btnborrarid);

		lblidmedio = new JLabel("ID Medios");
		lblidmedio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblidmedio.setBounds(419, 50, 56, 14);
		contentPane.add(lblidmedio);

		textidmedio = new JTextField();
		textidmedio.setBounds(413, 68, 62, 20);
		contentPane.add(textidmedio);
		textidmedio.setColumns(10);

		table = new JTable();
		table.setBounds(362, 0, 11, 270);
		contentPane.add(table);

		btnbuscar = new JButton("");
		btnbuscar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666693_buscar_icon.png"));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medios cr = new Medios();
				cr.readOne(Integer.parseInt(textidmedio.getText()), textnombre, textobservacion, textidTipomedio);
			}
		});
		btnbuscar.setBounds(402, 152, 89, 47);
		contentPane.add(btnbuscar);

		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Medios cr = new Medios();
				cr.update(Integer.parseInt(textidmedio.getText()), Integer.parseInt(textidTipomedio.getText()), textobservacion.getText(), textnombre.getText());
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\134221_actualizar_icon.png"));
		btnNewButton.setBounds(402, 210, 89, 50);
		contentPane.add(btnNewButton);
	}
}
