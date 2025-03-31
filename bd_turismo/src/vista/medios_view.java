package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Medios;
import modelo.Tipotransporte;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class medios_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textnombre;
	private JTextField textobservacion;
	private JLabel lblidTipomedio;
	private JTextField textidTipomedio;
	private JLabel lblmedios;
	private JButton btnLimpiar;

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
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblnombre = new JLabel("Nombre");
		lblnombre.setBounds(133, 71, 56, 14);
		contentPane.add(lblnombre);

		textnombre = new JTextField();
		textnombre.setBounds(191, 68, 124, 20);
		contentPane.add(textnombre);
		textnombre.setColumns(10);

		JLabel lblobservacion = new JLabel("Observacion");
		lblobservacion.setBounds(119, 96, 73, 14);
		contentPane.add(lblobservacion);

		textobservacion = new JTextField();
		textobservacion.setBounds(191, 93, 124, 39);
		contentPane.add(textobservacion);
		textobservacion.setColumns(10);

		JButton btnguardar = new JButton("GUARDAR");
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Medios cr = new Medios();
				 cr.create(textnombre.getText(), textobservacion.getText(), Integer.parseInt(textidTipomedio.getText()));
				 
			}
		});
		btnguardar.setBounds(133, 180, 89, 36);
		contentPane.add(btnguardar);
		
		lblidTipomedio = new JLabel("ID Tipo medio");
		lblidTipomedio.setBounds(108, 142, 73, 14);
		contentPane.add(lblidTipomedio);
		
		textidTipomedio = new JTextField();
		textidTipomedio.setColumns(10);
		textidTipomedio.setBounds(191, 139, 124, 20);
		contentPane.add(textidTipomedio);
		
		lblmedios = new JLabel("MEDIOS");
		lblmedios.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblmedios.setBounds(202, 25, 56, 14);
		contentPane.add(lblmedios);
		
		btnLimpiar = new JButton("LIMPIAR");
		btnLimpiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textnombre.setText("");
				textobservacion.setText("");
				textidTipomedio.setText("");
			}
		});
		btnLimpiar.setBounds(232, 180, 89, 36);
		contentPane.add(btnLimpiar);
	}

}
