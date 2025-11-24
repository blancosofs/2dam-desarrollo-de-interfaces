package proyectoTraductor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EventoTraducir implements ActionListener {

	JTextField textField_esp;
	JLabel lbl_traduccion, lbl_palabraEng;

	
	public EventoTraducir(JTextField textField_esp, JLabel lbl_traduccion, JLabel lbl_palabraEng) {
		this.textField_esp = textField_esp;
		this.lbl_traduccion = lbl_traduccion;
		this.lbl_palabraEng = lbl_palabraEng;
	}

	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// 1.Control de errores
		if (textField_esp.getText().isBlank() != true) {
			// Operaciones va a ser una clase solo con operaciones. no es un ojeto solo una
			// clase con metodos
			try {
				lbl_traduccion.setText(Operaciones.traducir(textField_esp.getText()));
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		} else {
			JOptionPane.showMessageDialog(null, "NO se ha introducido un texto correcto", "ERROR", 0);
		}

	}

}
