package proyectoTraductor;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Panel extends JPanel{
	
	private JTextField textField_esp;
	
	private JLabel lbl_msgBienvenda;
	private JLabel lbl_palabraEsp;
	private JLabel lbl_palabraEng;
	private JLabel lbl_traduccion;

	private JButton btn_exit;
	private JButton btn_traducir;
	
	//aqui ya puedes abrir con design
	public Panel() {
		setLayout(null);//lo de absolute
		
		lbl_msgBienvenda = new JLabel("BIENVENIDO AL TRADUCTOR");
		lbl_msgBienvenda.setBounds(52, 32, 344, 38);
		add(lbl_msgBienvenda);
		
		textField_esp = new JTextField();
		textField_esp.setBounds(127, 103, 86, 20);
		add(textField_esp);
		textField_esp.setColumns(10);
		
		lbl_palabraEsp = new JLabel("Palabra ESP:");
		lbl_palabraEsp.setBounds(52, 106, 89, 14);
		add(lbl_palabraEsp);
		
		lbl_palabraEng = new JLabel("Palabra ENG:");
		lbl_palabraEng.setBounds(52, 181, 77, 14);
		add(lbl_palabraEng);
		
		lbl_traduccion = new JLabel();
		lbl_traduccion.setBounds(127, 181, 86, 14);
		add(lbl_traduccion);
		
		btn_exit = new JButton("X");
		btn_exit.setBounds(375, 32, 49, 38);
		btn_exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			System.exit(0);
			}
		});
		add(btn_exit);
		
		btn_traducir = new JButton("TRADUCIR");
		btn_traducir.setBounds(281, 139, 113, 20);
		btn_traducir.addActionListener(new EventoTraducir(textField_esp, lbl_traduccion, lbl_palabraEng));
		add(btn_traducir);
	
	}
}
