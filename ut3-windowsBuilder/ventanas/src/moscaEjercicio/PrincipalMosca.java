package moscaEjercicio;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class PrincipalMosca {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMosca window = new VentanaMosca();
					window.setSize(800, 600);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
