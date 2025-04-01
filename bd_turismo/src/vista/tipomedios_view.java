package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class tipomedios_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textnombre;
	private JTextField textobservacion;
	private JTextField textidtipomedio;

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
		setBounds(100, 100, 509, 232);
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
		btnguardar.setBounds(201, 132, 89, 23);
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Tipomedios cr = new Tipomedios(textnombre.getText(), textobservacion.getText());
				cr.create(textnombre.getText(), textobservacion.getText());
				
			}
		});
		contentPane.add(btnguardar);
		
		JLabel lbltipomedios = new JLabel("TIPOS DE MEDIOS");
		lbltipomedios.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lbltipomedios.setBounds(185, 21, 110, 14);
		contentPane.add(lbltipomedios);
		
		JButton btnborrarid = new JButton("BORRAR ID");
		btnborrarid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Tipomedios cr = new Tipomedios();
				cr.delete(Integer.parseInt(textidtipomedio.getText()));
			}
		});
		btnborrarid.setBounds(345, 104, 89, 23);
		contentPane.add(btnborrarid);
		
		JLabel lblidtipomedio = new JLabel("ID Tipo medios");
		lblidtipomedio.setBounds(354, 55, 70, 14);
		contentPane.add(lblidtipomedio);
		
		textidtipomedio = new JTextField();
		textidtipomedio.setBounds(364, 80, 46, 20);
		contentPane.add(textidtipomedio);
		textidtipomedio.setColumns(10);
	}

}
