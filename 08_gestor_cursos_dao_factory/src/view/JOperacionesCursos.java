package view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import service.FormacionService;
import service.FormacionServiceFactory;

public class JOperacionesCursos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JOperacionesCursos frame = new JOperacionesCursos();
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
	public JOperacionesCursos() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("Acciones");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuActualizar = new JMenuItem("Actualizar cursos");
		menuActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormacionService service=FormacionServiceFactory.getFormacionService();
				service.actualizarDatos();
			}
		});
		mnNewMenu.add(menuActualizar);
		
		JMenuItem menuConsulta = new JMenuItem("Consulta");
		menuConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JCursosAlumnos();
			}
		});
		mnNewMenu.add(menuConsulta);
		
		JMenuItem menuEliminar = new JMenuItem("Eliminar alumno");
		menuEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JEliminacion();
			}
			
		});
		mnNewMenu.add(menuEliminar);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
