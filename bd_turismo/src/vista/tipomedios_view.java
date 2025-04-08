package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Agencias;
import modelo.Medios;
import modelo.Tipomedios;

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

public class tipomedios_view extends JFrame {

	private static final long serialVersionUID = 1L;
	protected static final Tipomedios cr = null;
	private JPanel contentPane;
	private JTextField textnombre;
	private JTextField textobservacion;
	private JTextField textidtipomedio;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tipomedios_view frame = new tipomedios_view();
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
	public tipomedios_view() {
		setTitle("Tipomedios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 559, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblnombre.setBounds(91, 53, 39, 14);
		contentPane.add(lblnombre);

		textnombre = new JTextField();
		textnombre.setBounds(162, 50, 164, 20);
		contentPane.add(textnombre);
		textnombre.setColumns(10);

		JLabel iblobservacion = new JLabel("Observacion");
		iblobservacion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		iblobservacion.setBounds(80, 104, 62, 14);
		contentPane.add(iblobservacion);

		textobservacion = new JTextField();
		textobservacion.setBounds(162, 101, 164, 20);
		contentPane.add(textobservacion);
		textobservacion.setColumns(10);

		JButton btnguardar = new JButton("");
		btnguardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666542_guardaricon.png"));
		btnguardar.setBounds(201, 132, 89, 68);
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tipomedios cr = new Tipomedios(textnombre.getText(), textobservacion.getText());
				cr.create(textnombre.getText(), textobservacion.getText()) ;
				
			}
		});
		contentPane.add(btnguardar);
		
		JLabel lbltipomedios = new JLabel("TIPOS DE MEDIOS");
		lbltipomedios.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lbltipomedios.setBounds(245, 11, 110, 14); 
		contentPane.add(lbltipomedios);
		
		JButton btnborrarid = new JButton("");
		btnborrarid.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666597_eliminar_2_icon.png"));
		btnborrarid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tipomedios cr = new Tipomedios();
				cr.delete(Integer.parseInt(textidtipomedio.getText()));
			}
		});
		btnborrarid.setBounds(423, 100, 89, 55);
		contentPane.add(btnborrarid);
		
		JLabel lblidtipomedio = new JLabel("ID Tipo medios");
		lblidtipomedio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblidtipomedio.setBounds(435, 53, 77, 14);
		contentPane.add(lblidtipomedio);
		
		textidtipomedio = new JTextField();
		textidtipomedio.setBounds(439, 78, 58, 20);
		contentPane.add(textidtipomedio);
		textidtipomedio.setColumns(10);
		
		table = new JTable();
		table.setBounds(375, 0, 9, 311);
		contentPane.add(table);
		
		JButton btnbuscar = new JButton("");
		btnbuscar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666693_buscar_icon.png"));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			  Tipomedios cr = new Tipomedios();
			  cr.readOne(Integer.parseInt(textidtipomedio.getText()), textnombre, textobservacion);
			}
		});
		btnbuscar.setBounds(423, 166, 89, 68);
		contentPane.add(btnbuscar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tipomedios cr = new Tipomedios();
				cr.update(Integer.parseInt(textidtipomedio.getText()), textnombre.getText(), textobservacion.getText());
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\134221_actualizar_icon.png"));
		btnNewButton.setBounds(423, 245, 89, 55);
		contentPane.add(btnNewButton);
	}
}
