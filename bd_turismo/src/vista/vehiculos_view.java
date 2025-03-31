package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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
	private JButton btnlimpiar;

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
		setBounds(100, 100, 421, 310);
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
		lblimatricula.setBounds(99, 59, 48, 14);
		contentPane.add(lblimatricula);
		
		JLabel lblmarca = new JLabel("Marca");
		lblmarca.setBounds(97, 90, 38, 14);
		contentPane.add(lblmarca);
		
		JLabel lblpuestos = new JLabel("Puestos");
		lblpuestos.setBounds(99, 121, 48, 14);
		contentPane.add(lblpuestos);
		
		JLabel lblmodelo = new JLabel("Modelo");
		lblmodelo.setBounds(99, 152, 48, 14);
		contentPane.add(lblmodelo);
		
		JLabel lblnumeromotor = new JLabel("Numero Motor");
		lblnumeromotor.setBounds(80, 183, 68, 14);
		contentPane.add(lblnumeromotor);
		
		JLabel lblcategoria = new JLabel("Categoria");
		lblcategoria.setBounds(90, 214, 57, 14);
		contentPane.add(lblcategoria);
		
		JButton btnguardar = new JButton("GUARDAR");
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Vehiculos cr = new Vehiculos();
				 cr.create(textmatricula.getText(), textmarca.getText(), Integer.parseInt(textpuestos.getText()), textmodelo.getText(), textnumeromotor.getText(), textcategoria.getText() ,Integer.parseInt(textidTipotransporte.getText()) );
				
			}
		});
		btnguardar.setBounds(281, 117, 89, 23);
		contentPane.add(btnguardar);
		
		lblidTipotransporte = new JLabel("ID Tipo transporte");
		lblidTipotransporte.setBounds(58, 245, 89, 14);
		contentPane.add(lblidTipotransporte);
		
		textidTipotransporte = new JTextField();
		textidTipotransporte.setColumns(10);
		textidTipotransporte.setBounds(157, 242, 86, 20);
		contentPane.add(textidTipotransporte);
		
		lblvehiculos = new JLabel("VEHICULOS");
		lblvehiculos.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblvehiculos.setBounds(157, 25, 78, 14);
		contentPane.add(lblvehiculos);
		
		btnlimpiar = new JButton("LIMPIAR");
		btnlimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textmatricula.setText("");
				textmarca.setText("");
				textpuestos.setText("");
				textmodelo.setText("");
				textnumeromotor.setText("");
				textcategoria.setText("");
			}
		});
		btnlimpiar.setBounds(281, 149, 89, 23);
		contentPane.add(btnlimpiar);
	}

}
