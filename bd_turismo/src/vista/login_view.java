package vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import modelo.verificarlogin;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class login_view extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textusuario;
	private JPasswordField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_view frame = new login_view();
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
	public login_view() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\APRENDIZ\\Downloads\\8666609_user_icon.png"));
		setTitle("LOGIN");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 417, 299);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		textusuario = new JTextField();
		textusuario.setBounds(172, 56, 148, 27);
		contentPane.add(textusuario);
		textusuario.setColumns(10);

		JButton btningresar = new JButton("");
		btningresar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
		            int documento = Integer.parseInt(textusuario.getText());
		            String pass = new String(password.getPassword());

		            String tipoUsuario = verificarlogin.verificarLogin(documento, pass);

		            if (tipoUsuario != null) {
		                JOptionPane.showMessageDialog(null, "Acceso permitido");
		                principal_view menu = new principal_view();
		                menu.setVisible(true);
		                dispose(); 
		            } else {
		                JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
		            }
		        } catch (NumberFormatException ex) {
		            JOptionPane.showMessageDialog(null, "El documento debe ser numerico");
		        }
		    }
		});
		btningresar.setIcon(
				new ImageIcon("C:\\Users\\APRENDIZ\\Downloads\\3994380_access_enter_input_login_sign in_icon.png"));
		btningresar.setFont(new Font("Arial Black", Font.PLAIN, 15));
		btningresar.setBounds(152, 171, 104, 63);
		contentPane.add(btningresar);

		password = new JPasswordField();
		password.setEchoChar('*');
		password.setBounds(172, 121, 148, 27);
		contentPane.add(password);

		JLabel lblusuario = new JLabel("USUARIO:");
		lblusuario.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblusuario.setBounds(91, 60, 71, 14);
		contentPane.add(lblusuario);

		JLabel lblpassword = new JLabel("CONTRASEÑA:");
		lblpassword.setFont(new Font("Arial Black", Font.PLAIN, 13));
		lblpassword.setBounds(58, 127, 104, 14);
		contentPane.add(lblpassword);
	}

	}
