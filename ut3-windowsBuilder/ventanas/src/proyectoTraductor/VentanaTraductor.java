package proyectoTraductor;



import javax.swing.JFrame;

public class VentanaTraductor extends JFrame { //objeto ventana traductor
/* OTRAS OPCIONES EN LUGAR DE ESATR EN EL MAIN
 * this.setSize(800,600);
 * 
 * @Override --> aqui reescribes desd lo del padre, si lo sacas fuera puedes
	public void setTitle(String title) {
		// TODO Auto-generated method stub
		super.setTitle(title);
	}
 * */
	
	/*CONCEPTOS:
	 * Esto es un clase y necesita contructores pque lo estas llamando en el otro lado como objeto
	 * 
	 * */
	
	public VentanaTraductor() {
		System.out.println("llega a ventana");
		setTitle("TRADUCTOR ES-IN");
		setSize(800,600);
		setResizable(false);
		setLocationRelativeTo(null);
		
		Panel miPanel= new Panel(); //esto ya es tu panel personalizado como en el design
		add(miPanel);
		//te vas dividiendo cada panel es una clase que ectiende lo grande que es JPanel. VentanaTraductor es el marco que contiene todo
		
	}
	

	
}
