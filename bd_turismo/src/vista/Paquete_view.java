package vista;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Agencias;
import modelo.Medios;
import modelo.Paquetes;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;

public class Paquete_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textiddestino;
	private JTextField textidorigen;
	private JTextField textfechaventa;
	private JTextField textfechaejecucion;
	private JTextField texthoraventa;
	private JLabel lblHoraSalida;
	private JTextField texthorasalida;
	private JLabel lblObservacion;
	private JTextField textobservacion;
	private JLabel lblPrecio;
	private JTextField textprecio;
	private JButton btnborrarcodigo;
	private JLabel lblcodigo;
	private JTextField textcodigo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Paquete_view frame = new Paquete_view();
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
	public Paquete_view() {
		getContentPane().setLayout(null);
		setTitle("Paquetes");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblIddestino = new JLabel("ID destino");
		lblIddestino.setBounds(77, 48, 50, 14);
		contentPane.add(lblIddestino);
		
		textiddestino = new JTextField();
		textiddestino.setBounds(137, 45, 86, 20);
		contentPane.add(textiddestino);
		textiddestino.setColumns(10);
		
		JLabel lblIdorigen = new JLabel("ID origen");
		lblIdorigen.setBounds(74, 73, 46, 14);
		contentPane.add(lblIdorigen);
		
		textidorigen = new JTextField();
		textidorigen.setBounds(137, 70, 86, 20);
		contentPane.add(textidorigen);
		textidorigen.setColumns(10);
		
		JLabel lblfechaventa = new JLabel("Fecha Venta");
		lblfechaventa.setBounds(67, 98, 60, 14);
		contentPane.add(lblfechaventa);
		
		textfechaventa = new JTextField();
		textfechaventa.setBounds(137, 95, 86, 20);
		contentPane.add(textfechaventa);
		textfechaventa.setColumns(10);
		
		JLabel lblFechaEjecucion = new JLabel("Fecha Ejecucion");
		lblFechaEjecucion.setBounds(50, 123, 77, 14);
		contentPane.add(lblFechaEjecucion);
		
		textfechaejecucion = new JTextField();
		textfechaejecucion.setBounds(137, 120, 86, 20);
		contentPane.add(textfechaejecucion);
		textfechaejecucion.setColumns(10);
		
		JLabel lblhoraventa = new JLabel("Hora Venta");
		lblhoraventa.setBounds(67, 148, 60, 14);
		contentPane.add(lblhoraventa);
		
		texthoraventa = new JTextField();
		texthoraventa.setBounds(137, 145, 86, 20);
		contentPane.add(texthoraventa);
		texthoraventa.setColumns(10);
		
		lblHoraSalida = new JLabel("Hora Salida");
		lblHoraSalida.setBounds(67, 173, 60, 14);
		contentPane.add(lblHoraSalida);
		
		texthorasalida = new JTextField();
		texthorasalida.setBounds(137, 170, 86, 20);
		contentPane.add(texthorasalida);
		texthorasalida.setColumns(10);
		
		lblObservacion = new JLabel("Observacion");
		lblObservacion.setBounds(67, 198, 60, 14);
		contentPane.add(lblObservacion);
		
		textobservacion = new JTextField();
		textobservacion.setBounds(137, 195, 86, 20);
		contentPane.add(textobservacion);
		textobservacion.setColumns(10);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(87, 223, 33, 14);
		contentPane.add(lblPrecio);
		
		textprecio = new JTextField();
		textprecio.setBounds(137, 220, 86, 20);
		contentPane.add(textprecio);
		textprecio.setColumns(10);
		
		JButton btnguardar = new JButton("GUARDAR");
		btnguardar.setBounds(256, 144, 89, 23);
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Paquetes cr = new Paquetes();
				 cr.create(Integer.parseInt(textiddestino.getText()),(Integer.parseInt(textidorigen.getText())), textfechaventa.getText(), textfechaejecucion.getText(), texthoraventa.getText(), texthorasalida.getText(), textobservacion.getText(), Double.parseDouble(textprecio.getText()));
		 
			}
		});
		contentPane.add(btnguardar);
		
		JLabel lblPaquetes = new JLabel("PAQUETES");
		lblPaquetes.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblPaquetes.setBounds(188, 11, 67, 14);
		contentPane.add(lblPaquetes);
		
		btnborrarcodigo = new JButton("BORRAR CODIGO");
		btnborrarcodigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Paquetes cr = new Paquetes();
				cr.delete(Integer.parseInt(textcodigo.getText()));
			}
		});
		btnborrarcodigo.setBounds(233, 94, 119, 23);
		contentPane.add(btnborrarcodigo);
		
		lblcodigo = new JLabel("Codigo");
		lblcodigo.setBounds(278, 48, 46, 14);
		contentPane.add(lblcodigo);
		
		textcodigo = new JTextField();
		textcodigo.setBounds(256, 70, 86, 20);
		contentPane.add(textcodigo);
		textcodigo.setColumns(10);
	}
}
