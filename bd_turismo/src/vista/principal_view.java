package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class principal_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					principal_view frame = new principal_view();
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
	public principal_view() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 731, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Paquete_view paquetes = new Paquete_view();
				paquetes.setVisible(true);
			}
		});
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\7830819_warehouse_cart_packages_icon.png"));
		btnNewButton.setBounds(35, 22, 140, 78);
		contentPane.add(btnNewButton);

		JLabel lblpaquetes = new JLabel("PAQUETES");
		lblpaquetes.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblpaquetes.setBounds(64, 111, 74, 14);
		contentPane.add(lblpaquetes);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				companias_view paquetes = new companias_view();
				paquetes.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\45438_companies_icon.png"));
		btnNewButton_1.setBounds(194, 22, 140, 78);
		contentPane.add(btnNewButton_1);

		JLabel lblCompaias = new JLabel("COMPAÑIAS");
		lblCompaias.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblCompaias.setBounds(221, 112, 81, 14);
		contentPane.add(lblCompaias);

		JButton btnNewButton_1_1 = new JButton("");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agencias_view paquetes = new agencias_view();
				paquetes.setVisible(true);
			}
		});
		btnNewButton_1_1.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\4230537_business_group_team_icon.png"));
		btnNewButton_1_1.setBounds(351, 22, 140, 78);
		contentPane.add(btnNewButton_1_1);

		JLabel lblAgencias = new JLabel("AGENCIAS");
		lblAgencias.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblAgencias.setBounds(380, 111, 81, 14);
		contentPane.add(lblAgencias);

		JButton btnNewButton_1_1_1 = new JButton("");
		btnNewButton_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipomedios_view paquetes = new tipomedios_view();
				paquetes.setVisible(true);
			}
		});
		btnNewButton_1_1_1
				.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\2849812_menu_multimedia_bars_media_icon.png"));
		btnNewButton_1_1_1.setBounds(514, 22, 140, 78);
		contentPane.add(btnNewButton_1_1_1);

		JLabel lblTiposDeMedios = new JLabel("TIPOS DE MEDIOS");
		lblTiposDeMedios.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblTiposDeMedios.setBounds(524, 111, 130, 14);
		contentPane.add(lblTiposDeMedios);

		JButton btnNewButton_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				medios_view paquetes = new medios_view();
				paquetes.setVisible(true);
			}
		});
		btnNewButton_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\teamwork_1256650.png"));
		btnNewButton_1_1_1_1.setBounds(35, 169, 140, 78);
		contentPane.add(btnNewButton_1_1_1_1);

		JLabel lblMedios = new JLabel("MEDIOS");
		lblMedios.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblMedios.setBounds(75, 258, 53, 14);
		contentPane.add(lblMedios);

		JButton btnNewButton_1_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				vehiculos_view paquetes = new vehiculos_view();
				paquetes.setVisible(true);
			}
		});
		btnNewButton_1_1_1_1_1
				.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\2526578_transportation_vehicle_icon.png"));
		btnNewButton_1_1_1_1_1.setBounds(194, 169, 140, 78);
		contentPane.add(btnNewButton_1_1_1_1_1);

		JLabel lblVehiculos = new JLabel("VEHICULOS");
		lblVehiculos.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblVehiculos.setBounds(221, 259, 81, 14);
		contentPane.add(lblVehiculos);

		JButton btnNewButton_1_1_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tipotransporte_view paquetes = new tipotransporte_view();
				paquetes.setVisible(true);
			}
		});
		btnNewButton_1_1_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\transportation_14528707.png"));
		btnNewButton_1_1_1_1_1_1.setBounds(351, 169, 140, 78);
		contentPane.add(btnNewButton_1_1_1_1_1_1);

		JLabel lblTiposDeTransporte = new JLabel("TIPOS DE TRANSPORTE");
		lblTiposDeTransporte.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblTiposDeTransporte.setBounds(339, 258, 160, 14);
		contentPane.add(lblTiposDeTransporte);

		JButton btnNewButton_1_1_1_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				operadores_view paquetes = new operadores_view();
				paquetes.setVisible(true);
			}
		});
		btnNewButton_1_1_1_1_1_1_1.setIcon(new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\support_1728478.png"));
		btnNewButton_1_1_1_1_1_1_1.setBounds(514, 169, 140, 78);
		contentPane.add(btnNewButton_1_1_1_1_1_1_1);

		JLabel lblOperadores = new JLabel("OPERADORES");
		lblOperadores.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblOperadores.setBounds(539, 259, 92, 14);
		contentPane.add(lblOperadores);

		JButton btnNewButton_1_1_1_1_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				promotores_view paquetes = new promotores_view();
				paquetes.setVisible(true);
			}
		});
		btnNewButton_1_1_1_1_1_1_1_1.setIcon(
				new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\2784213_business_finance_megafone_money_icon.png"));
		btnNewButton_1_1_1_1_1_1_1_1.setBounds(194, 321, 140, 78);
		contentPane.add(btnNewButton_1_1_1_1_1_1_1_1);

		JLabel lblPromotores = new JLabel("PROMOTORES");
		lblPromotores.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblPromotores.setBounds(217, 410, 103, 14);
		contentPane.add(lblPromotores);

		JButton btnNewButton_1_1_1_1_1_1_1_1_1 = new JButton("");
		btnNewButton_1_1_1_1_1_1_1_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clientes_view paquetes = new clientes_view();
				paquetes.setVisible(true);
			}
		});
		btnNewButton_1_1_1_1_1_1_1_1_1.setIcon(
				new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\3209291_contacts_customers_family_group_team_icon.png"));
		btnNewButton_1_1_1_1_1_1_1_1_1.setBounds(351, 321, 140, 78);
		contentPane.add(btnNewButton_1_1_1_1_1_1_1_1_1);

		JLabel lblClientes = new JLabel("CLIENTES");
		lblClientes.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblClientes.setBounds(387, 410, 74, 14);
		contentPane.add(lblClientes);
	}

}
