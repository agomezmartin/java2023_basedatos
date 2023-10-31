package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JMenuEmpleados extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMenuEmpleados frame = new JMenuEmpleados();
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
	public JMenuEmpleados() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Acciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuAlta = new JMenuItem("Alta empleado");
		menuAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JAltas();
			}
		});
		mnNewMenu.add(menuAlta);
		
		JMenuItem menuEliminar = new JMenuItem("Eliminar empleado");
		menuEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JBajas();
			}
		});
		mnNewMenu.add(menuEliminar);
		
		JMenuItem menuActualizar = new JMenuItem("Actualizar salario");
		menuActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JModificaciones();
			}
		});
		mnNewMenu.add(menuActualizar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
