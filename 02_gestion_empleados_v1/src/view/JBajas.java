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

public class JBajas extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtEmail;

	
	/**
	 * Create the frame.
	 */
	public JBajas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduce email:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(72, 64, 122, 19);
		contentPane.add(lblNewLabel);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(204, 65, 145, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JButton btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				var service=new EmpleadosService();
				service.eliminarEmpleado(txtEmail.getText());
				JBajas.this.dispose();
			}
		});
		btnEliminar.setBounds(140, 143, 89, 23);
		contentPane.add(btnEliminar);
		this.setVisible(true);
	}
}
