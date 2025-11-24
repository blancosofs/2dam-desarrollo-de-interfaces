package moscaEjercicio;

import javax.swing.JFrame;

import moscaEjercicio.PanelMosca;

public class VentanaMosca extends JFrame {

public VentanaMosca() {
	
	PanelMosca miPanel= new PanelMosca(); //esto ya es tu panel personalizado como en el design
	add(miPanel);

}

}
