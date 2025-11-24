package proyectoTraductor;

import java.awt.EventQueue;


public class PrincipalTraductor {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					VentanaTraductor miVentana = new VentanaTraductor();
					miVentana.setSize(1200, 800);
					miVentana.setVisible(true);
					//miVentana es el frame de Traductor, si quieres llamar cosas con eso desde aqui tmb se puede
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});
	}

}
