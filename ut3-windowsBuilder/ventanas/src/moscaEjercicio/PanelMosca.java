package moscaEjercicio;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class PanelMosca extends JPanel {
	private JLabel panel; //aqui declaras que en algun momento va a haber uno pero tmb lo puedes meter en imagen

	public PanelMosca() {
		//no te hace falta crear otro panel. el buscar imagen te hace el panel asi no le pasas nada
		setLayout(null);
		add(buscarImagen()); // ya estas en frame asi que tampoco necesitas un getContent
		
		
	}

	public Component buscarImagen() {
		BufferedImage fondo = null;
		// Cargar la imagen 
		try {
			fondo = ImageIO.read(new File("src/moscaFinal.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Asignar la imagen a un jpanel 
	    final Image foto = fondo;
		panel = new JLabel() {
			private static final long serialVersionUID = 1L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.drawImage(foto, 0, 0, 100, 100, null);
			}
		};
		panel.setBounds(0, 0, 100, 100); //le da el tamaño visible al pannel de mosca. (x,y,ancho,alto)
		return panel;
	}
	
	
}
