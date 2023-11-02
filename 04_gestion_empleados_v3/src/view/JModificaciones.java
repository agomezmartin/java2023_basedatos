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

import service.EmpleadosService;

public class JModificaciones extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIdEmpleado;
	private JTextField txtSalario;

	

	/**
	 * Create the frame.
	 */
	public JModificaciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id de empleado:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(53, 38, 116, 19);
		contentPane.add(lblNewLabel);
		
		JLabel lblNuevoSalario = new JLabel("Nuevo salario:");
		lblNuevoSalario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNuevoSalario.setBounds(53, 95, 111, 19);
		contentPane.add(lblNuevoSalario);
		
		txtIdEmpleado = new JTextField();
		txtIdEmpleado.setBounds(185, 39, 111, 20);
		contentPane.add(txtIdEmpleado);
		txtIdEmpleado.setColumns(10);
		
		txtSalario = new JTextField();
		txtSalario.setColumns(10);
		txtSalario.setBounds(185, 96, 111, 20);
		contentPane.add(txtSalario);
		
		JButton btnActualizar = new JButton("Actualizar");
		btnActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var service=new EmpleadosService();
				service.modificarSalarioEmpleado(Double.parseDouble(txtSalario.getText()), 
						Integer.parseInt(txtIdEmpleado.getText()));
				JModificaciones.this.dispose();
			}
		});
		btnActualizar.setBounds(136, 179, 89, 23);
		contentPane.add(btnActualizar);
		this.setVisible(true);
	}

}
