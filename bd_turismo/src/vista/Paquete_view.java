package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Paquetes;
import modelo.Tipomedios;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

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
	private JTable table;
	private JButton btnbuscar;
	private JButton btnactualizar;

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
		setBounds(100, 100, 538, 372);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblIddestino = new JLabel("ID destino");
		lblIddestino.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblIddestino.setBounds(74, 48, 53, 14);
		contentPane.add(lblIddestino);

		textiddestino = new JTextField();
		textiddestino.setBounds(137, 45, 86, 20);
		contentPane.add(textiddestino);
		textiddestino.setColumns(10);

		JLabel lblIdorigen = new JLabel("ID origen");
		lblIdorigen.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblIdorigen.setBounds(74, 73, 46, 14);
		contentPane.add(lblIdorigen);

		textidorigen = new JTextField();
		textidorigen.setBounds(137, 70, 86, 20);
		contentPane.add(textidorigen);
		textidorigen.setColumns(10);

		JLabel lblfechaventa = new JLabel("Fecha Venta");
		lblfechaventa.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblfechaventa.setBounds(67, 98, 60, 14);
		contentPane.add(lblfechaventa);

		textfechaventa = new JTextField();
		textfechaventa.setBounds(137, 95, 86, 20);
		contentPane.add(textfechaventa);
		textfechaventa.setColumns(10);

		JLabel lblFechaEjecucion = new JLabel("Fecha Ejecucion");
		lblFechaEjecucion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblFechaEjecucion.setBounds(50, 123, 77, 14);
		contentPane.add(lblFechaEjecucion);

		textfechaejecucion = new JTextField();
		textfechaejecucion.setBounds(137, 120, 86, 20);
		contentPane.add(textfechaejecucion);
		textfechaejecucion.setColumns(10);

		JLabel lblhoraventa = new JLabel("Hora Venta");
		lblhoraventa.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblhoraventa.setBounds(67, 148, 60, 14);
		contentPane.add(lblhoraventa);

		texthoraventa = new JTextField();
		texthoraventa.setBounds(137, 145, 86, 20);
		contentPane.add(texthoraventa);
		texthoraventa.setColumns(10);

		lblHoraSalida = new JLabel("Hora Salida");
		lblHoraSalida.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblHoraSalida.setBounds(67, 173, 60, 14);
		contentPane.add(lblHoraSalida);

		texthorasalida = new JTextField();
		texthorasalida.setBounds(137, 170, 86, 20);
		contentPane.add(texthorasalida);
		texthorasalida.setColumns(10);

		lblObservacion = new JLabel("Observacion");
		lblObservacion.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblObservacion.setBounds(67, 198, 60, 14);
		contentPane.add(lblObservacion);

		textobservacion = new JTextField();
		textobservacion.setBounds(137, 195, 86, 20);
		contentPane.add(textobservacion);
		textobservacion.setColumns(10);

		lblPrecio = new JLabel("Precio");
		lblPrecio.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblPrecio.setBounds(77, 223, 43, 14);
		contentPane.add(lblPrecio);

		textprecio = new JTextField();
		textprecio.setBounds(137, 220, 86, 20);
		contentPane.add(textprecio);
		textprecio.setColumns(10);

		JButton btnguardar = new JButton("");
		btnguardar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666542_guardaricon.png"));
		btnguardar.setBounds(233, 110, 107, 52);
		btnguardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Paquetes cr = new Paquetes();
				cr.create(Integer.parseInt(textiddestino.getText()), (Integer.parseInt(textidorigen.getText())),
						textfechaventa.getText(), textfechaejecucion.getText(), texthoraventa.getText(),
						texthorasalida.getText(), textobservacion.getText(), Double.parseDouble(textprecio.getText()));

			}
		});
		contentPane.add(btnguardar);

		JLabel lblPaquetes = new JLabel("PAQUETES");
		lblPaquetes.setFont(new Font("Arial Black", Font.PLAIN, 11));
		lblPaquetes.setBounds(256, 11, 67, 14);
		contentPane.add(lblPaquetes);

		btnborrarcodigo = new JButton("");
		btnborrarcodigo.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666597_eliminar_2_icon.png"));
		btnborrarcodigo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Paquetes cr = new Paquetes();
				cr.delete(Integer.parseInt(textcodigo.getText()));
			}
		});
		btnborrarcodigo.setBounds(396, 119, 95, 52);
		contentPane.add(btnborrarcodigo);

		lblcodigo = new JLabel("Codigo");
		lblcodigo.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblcodigo.setBounds(426, 73, 43, 14);
		contentPane.add(lblcodigo);

		textcodigo = new JTextField();
		textcodigo.setBounds(414, 92, 60, 20);
		contentPane.add(textcodigo);
		textcodigo.setColumns(10);

		table = new JTable();
		table.setBounds(350, 0, 11, 333);
		contentPane.add(table);

		btnbuscar = new JButton("");
		btnbuscar.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\8666693_buscar_icon.png"));
		btnbuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paquetes cr = new Paquetes();
				cr.readOne(Integer.parseInt(textcodigo.getText()), textiddestino, textidorigen, textfechaventa, textfechaejecucion, texthoraventa, texthorasalida, textobservacion, textprecio);
			}
		});
		btnbuscar.setBounds(396, 185, 99, 52);
		contentPane.add(btnbuscar);

		btnactualizar = new JButton("");
		btnactualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paquetes cr = new Paquetes();
				cr.update(Integer.parseInt(textcodigo.getText()), Integer.parseInt(textiddestino.getText()),
						Integer.parseInt(textidorigen.getText()), textfechaventa.getText(),
						textfechaejecucion.getText(), texthoraventa.getText(), texthorasalida.getText(),
						textobservacion.getText(), Double.parseDouble(textprecio.getText()));
			}
		});
		btnactualizar.setIcon(
				new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\134221_actualizar_icon.png"));
		btnactualizar.setBounds(396, 248, 95, 62);
		contentPane.add(btnactualizar);
	}
}
