package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import view.adapters.TablaEmpleadosModel;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JEmpleadosDepartamentos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtDepartamento;
	private JTable tbEmpleados;

	
	/**
	 * Create the frame.
	 */
	public JEmpleadosDepartamentos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Introduce departamento:");
		lblNewLabel.setBounds(25, 28, 149, 14);
		contentPane.add(lblNewLabel);
		
		txtDepartamento = new JTextField();
		txtDepartamento.setBounds(190, 25, 149, 20);
		contentPane.add(txtDepartamento);
		txtDepartamento.setColumns(10);
		
		JButton btnEmpleados = new JButton("Ver empleados");
		btnEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tbEmpleados.setModel(new TablaEmpleadosModel(txtDepartamento.getText()));
			}
		});
		btnEmpleados.setBounds(111, 73, 177, 23);
		contentPane.add(btnEmpleados);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 120, 329, 72);
		contentPane.add(scrollPane);
		
		tbEmpleados = new JTable();
		scrollPane.setViewportView(tbEmpleados);
		this.setVisible(true);
	}
}
