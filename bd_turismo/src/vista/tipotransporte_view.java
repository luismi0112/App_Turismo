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

import modelo.Medios;
import modelo.Paquetes;
import modelo.Tipomedios;
import modelo.Tipotransporte;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.ImageIcon;

public class tipotransporte_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textnombre;
	private JTextField textobservacion;
	private JTextField textidtipotransporte;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tipotransporte_view frame = new tipotransporte_view();
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
	public tipotransporte_view() {
		setTitle("Tipotransporte");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 319);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblnombre.setBounds(96, 58, 46, 14);
		contentPane.add(lblnombre);
		
		textnombre = new JTextField();
		textnombre.setBounds(162, 55, 164, 20);
		contentPane.add(textnombre);
		textnombre.setColumns(10);
		
		JLabel iblobservacion = new JLabel("Observacion");
		iblobservacion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		iblobservacion.setBounds(80, 104, 72, 14);
		contentPane.add(iblobservacion);
		
		textobservacion = new JTextField();
		textobservacion.setBounds(162, 101, 164, 20);
		contentPane.add(textobservacion);
		textobservacion.setColumns(10);
		
		JButton btnguardar = new JButton("");
		btnguardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666542_guardaricon.png"));
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tipotransporte cr = new Tipotransporte();
				 cr.create(textnombre.getText(), textobservacion.getText());
				
			}
		});
		btnguardar.setBounds(189, 140, 97, 69);
		contentPane.add(btnguardar);
		
		JLabel ibntipotransporte = new JLabel("TIPO DE TRANSPORTES");
		ibntipotransporte.setFont(new Font("Arial Black", Font.PLAIN, 11));
		ibntipotransporte.setBounds(201, 11, 152, 14);
		contentPane.add(ibntipotransporte);
		
		JButton btnborrarid = new JButton("");
		btnborrarid.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666597_eliminar_2_icon.png"));
		btnborrarid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tipotransporte cr = new Tipotransporte();
				cr.delete(Integer.parseInt(textidtipotransporte.getText()));
			}
		});
		btnborrarid.setBounds(409, 100, 97, 49);
		contentPane.add(btnborrarid);
		
		JLabel lbltipotransporte = new JLabel("Tipo Transporte");
		lbltipotransporte.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lbltipotransporte.setBounds(415, 42, 81, 14);
		contentPane.add(lbltipotransporte);
		
		textidtipotransporte = new JTextField();
		textidtipotransporte.setBounds(430, 67, 62, 20);
		contentPane.add(textidtipotransporte);
		textidtipotransporte.setColumns(10);
		
		table = new JTable();
		table.setBounds(363, 0, 15, 280);
		contentPane.add(table);
		
		JButton btnbuscar = new JButton("");
		btnbuscar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666693_buscar_icon.png"));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tipotransporte cr = new Tipotransporte();
				 cr.readOne(Integer.parseInt(textidtipotransporte.getText()), textnombre, textobservacion);
			}
		});
		btnbuscar.setBounds(409, 160, 99, 49);
		contentPane.add(btnbuscar);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tipotransporte cr = new Tipotransporte();
				cr.update(Integer.parseInt(textidtipotransporte.getText()), textobservacion.getText(), textnombre.getText());
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\134221_actualizar_icon.png"));
		btnNewButton.setBounds(409, 220, 97, 49);
		contentPane.add(btnNewButton);
	}
}
