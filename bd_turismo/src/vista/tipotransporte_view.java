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
import modelo.Tipotransporte;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class tipotransporte_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textnombre;
	private JTextField textobservacion;
	private JTextField textidtipotransporte;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setBounds(90, 69, 46, 14);
		contentPane.add(lblnombre);
		
		textnombre = new JTextField();
		textnombre.setBounds(162, 66, 164, 20);
		contentPane.add(textnombre);
		textnombre.setColumns(10);
		
		JLabel iblobservacion = new JLabel("Observacion");
		iblobservacion.setBounds(80, 104, 62, 14);
		contentPane.add(iblobservacion);
		
		textobservacion = new JTextField();
		textobservacion.setBounds(162, 101, 164, 20);
		contentPane.add(textobservacion);
		textobservacion.setColumns(10);
		
		JButton btnguardar = new JButton("GUARDAR");
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tipotransporte cr = new Tipotransporte();
				 cr.create(textnombre.getText(), textobservacion.getText());
				
			}
		});
		btnguardar.setBounds(197, 132, 89, 23);
		contentPane.add(btnguardar);
		
		JLabel ibntipotransporte = new JLabel("TIPO DE TRANSPORTES");
		ibntipotransporte.setFont(new Font("Arial Black", Font.PLAIN, 11));
		ibntipotransporte.setBounds(156, 28, 152, 14);
		contentPane.add(ibntipotransporte);
		
		JButton btnborrarid = new JButton("BORRAR ID");
		btnborrarid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tipotransporte cr = new Tipotransporte();
				cr.delete(Integer.parseInt(textidtipotransporte.getText()));
			}
		});
		btnborrarid.setBounds(336, 132, 89, 23);
		contentPane.add(btnborrarid);
		
		JLabel lbltipotransporte = new JLabel("Tipo Transporte");
		lbltipotransporte.setBounds(348, 69, 76, 14);
		contentPane.add(lbltipotransporte);
		
		textidtipotransporte = new JTextField();
		textidtipotransporte.setBounds(338, 101, 86, 20);
		contentPane.add(textidtipotransporte);
		textidtipotransporte.setColumns(10);
	}
}
