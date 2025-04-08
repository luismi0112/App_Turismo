package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Medios;
import modelo.Tipomedios;
import modelo.Tipotransporte;
import modelo.Vehiculos;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class vehiculos_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textmatricula;
	private JTextField textmarca;
	private JTextField textpuestos;
	private JTextField textmodelo;
	private JTextField textnumeromotor;
	private JTextField textcategoria;
	private JLabel lblidTipotransporte;
	private JTextField textidTipotransporte;
	private JLabel lblvehiculos;
	private JButton btnborrarid;
	private JLabel lblidvehiculo;
	private JTextField textidvehiculo;
	private JTable table;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					vehiculos_view frame = new vehiculos_view();
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
	public vehiculos_view() {
		setTitle("Vehiculos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 526, 401);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textmatricula = new JTextField();
		textmatricula.setBounds(157, 56, 86, 20);
		contentPane.add(textmatricula);
		textmatricula.setColumns(10);
		
		textmarca = new JTextField();
		textmarca.setBounds(157, 87, 86, 20);
		contentPane.add(textmarca);
		textmarca.setColumns(10);
		
		textpuestos = new JTextField();
		textpuestos.setBounds(157, 118, 86, 20);
		contentPane.add(textpuestos);
		textpuestos.setColumns(10);
		
		textmodelo = new JTextField();
		textmodelo.setBounds(157, 149, 86, 20);
		contentPane.add(textmodelo);
		textmodelo.setColumns(10);
		
		textnumeromotor = new JTextField();
		textnumeromotor.setBounds(157, 180, 86, 20);
		contentPane.add(textnumeromotor);
		textnumeromotor.setColumns(10);
		
		textcategoria = new JTextField();
		textcategoria.setBounds(157, 211, 86, 20);
		contentPane.add(textcategoria);
		textcategoria.setColumns(10);
		
		JLabel lblimatricula = new JLabel("Matricula");
		lblimatricula.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblimatricula.setBounds(99, 59, 48, 14);
		contentPane.add(lblimatricula);
		
		JLabel lblmarca = new JLabel("Marca");
		lblmarca.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblmarca.setBounds(97, 90, 38, 14);
		contentPane.add(lblmarca);
		
		JLabel lblpuestos = new JLabel("Puestos");
		lblpuestos.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblpuestos.setBounds(99, 121, 48, 14);
		contentPane.add(lblpuestos);
		
		JLabel lblmodelo = new JLabel("Modelo");
		lblmodelo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblmodelo.setBounds(99, 152, 48, 14);
		contentPane.add(lblmodelo);
		
		JLabel lblnumeromotor = new JLabel("Numero Motor");
		lblnumeromotor.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblnumeromotor.setBounds(70, 183, 78, 14);
		contentPane.add(lblnumeromotor);
		
		JLabel lblcategoria = new JLabel("Categoria");
		lblcategoria.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblcategoria.setBounds(90, 214, 57, 14);
		contentPane.add(lblcategoria);
		
		JButton btnguardar = new JButton("");
		btnguardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666542_guardaricon.png"));
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vehiculos cr = new Vehiculos();
				 cr.create(textmatricula.getText(), textmarca.getText(), Integer.parseInt(textpuestos.getText()), textmodelo.getText(), textnumeromotor.getText(), textcategoria.getText() ,Integer.parseInt(textidTipotransporte.getText()));
				
			}
		});
		btnguardar.setBounds(253, 143, 104, 57);
		contentPane.add(btnguardar);
		
		lblidTipotransporte = new JLabel("ID Tipo transporte");
		lblidTipotransporte.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblidTipotransporte.setBounds(54, 245, 93, 14);
		contentPane.add(lblidTipotransporte);
		
		textidTipotransporte = new JTextField();
		textidTipotransporte.setColumns(10);
		textidTipotransporte.setBounds(157, 242, 86, 20);
		contentPane.add(textidTipotransporte);
		
		lblvehiculos = new JLabel("VEHICULOS");
		lblvehiculos.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblvehiculos.setBounds(200, 11, 78, 14);
		contentPane.add(lblvehiculos);
		
		btnborrarid = new JButton("");
		btnborrarid.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666597_eliminar_2_icon.png"));
		btnborrarid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vehiculos cr = new Vehiculos();
				cr.delete(Integer.parseInt(textidvehiculo.getText()));
			}
		});
		btnborrarid.setBounds(391, 148, 89, 49);
		contentPane.add(btnborrarid);
		
		lblidvehiculo = new JLabel("ID Vehiculos");
		lblidvehiculo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblidvehiculo.setBounds(399, 90, 63, 14);
		contentPane.add(lblidvehiculo);
		
		textidvehiculo = new JTextField();
		textidvehiculo.setBounds(403, 118, 57, 20);
		contentPane.add(textidvehiculo);
		textidvehiculo.setColumns(10);
		
		table = new JTable();
		table.setBounds(367, 0, 14, 362);
		contentPane.add(table);
		
		JButton btnbuscar = new JButton("");
		btnbuscar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666693_buscar_icon.png"));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vehiculos cr = new Vehiculos();
				cr.readOne(Integer.parseInt(textidvehiculo.getText()), textidTipotransporte, textmatricula, textmarca, textpuestos, textmodelo, textnumeromotor, textcategoria);
			}
		});
		btnbuscar.setBounds(391, 211, 89, 52);
		contentPane.add(btnbuscar);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vehiculos cr = new Vehiculos();
				cr.update(Integer.parseInt(textidvehiculo.getText()), Integer.parseInt(textpuestos.getText()), Integer.parseInt(textidTipotransporte.getText()), textmatricula.getText(), textmarca.getText(), textmodelo.getText(), textnumeromotor.getText(), textcategoria.getText());
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\134221_actualizar_icon.png"));
		btnNewButton.setBounds(391, 283, 89, 49);
		contentPane.add(btnNewButton);
	}
}
