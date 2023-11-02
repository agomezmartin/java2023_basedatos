package view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.Empleado;
import service.EmpleadosService;

public class JAltas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombre;
	private JTextField txtEmail;
	private JTextField txtDep;
	private JTextField txtSalario;

	

	/**
	 * Create the frame.
	 */
	public JAltas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre:");
		lblNewLabel.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 15));
		lblNewLabel.setBounds(49, 37, 91, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 15));
		lblEmail.setBounds(49, 79, 91, 14);
		contentPane.add(lblEmail);
		
		JLabel lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 15));
		lblDepartamento.setBounds(49, 117, 122, 14);
		contentPane.add(lblDepartamento);
		
		JLabel lblSalario = new JLabel("Salario:");
		lblSalario.setFont(new Font("Source Serif Pro Black", Font.PLAIN, 15));
		lblSalario.setBounds(49, 164, 91, 14);
		contentPane.add(lblSalario);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(194, 36, 132, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setColumns(10);
		txtEmail.setBounds(194, 78, 132, 20);
		contentPane.add(txtEmail);
		
		txtDep = new JTextField();
		txtDep.setColumns(10);
		txtDep.setBounds(194, 116, 132, 20);
		contentPane.add(txtDep);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(194, 163, 132, 20);
		contentPane.add(txtSalario);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var service=new EmpleadosService();
				service.altaEmpleado(new Empleado(txtNombre.getText(),
						txtEmail.getText(),
						txtDep.getText(),
						Double.parseDouble(txtSalario.getText())));
				JAltas.this.dispose();
			}
			
		});
		btnGuardar.setBounds(145, 227, 89, 23);
		contentPane.add(btnGuardar);
		this.setVisible(true);
	}
}
