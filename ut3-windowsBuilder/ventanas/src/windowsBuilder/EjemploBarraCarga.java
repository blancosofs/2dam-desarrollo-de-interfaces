package windowsBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class EjemploBarraCarga {

	private JFrame frame;

	Timer intervalo;
	int i = 4;

	Timer barra;
	int j = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EjemploBarraCarga window = new EjemploBarraCarga();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EjemploBarraCarga() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_contador = new JLabel("");
		lbl_contador.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_contador.setBackground(new Color(0, 204, 0));
		lbl_contador.setOpaque(true);
		lbl_contador.setBounds(351, 39, 43, 40);
		frame.getContentPane().add(lbl_contador);

		JProgressBar progressBar = new JProgressBar();
		progressBar.setStringPainted(true);
		progressBar.setOpaque(true);
		progressBar.setBounds(33, 153, 361, 49);
		frame.getContentPane().add(progressBar);

		JLabel lbl_mensje = new JLabel("cargando..");
		lbl_mensje.setBounds(43, 213, 64, 14);
		frame.getContentPane().add(lbl_mensje);

		JButton btn_start = new JButton("START");
		btn_start.setBounds(33, 39, 116, 40);
		frame.getContentPane().add(btn_start);
		
		JLabel lbl_mensje2 = new JLabel("fin");
		lbl_mensje2.setBounds(400, 236, 24, 14);
		frame.getContentPane().add(lbl_mensje2);
		lbl_mensje2.setVisible(false);
		
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				intervalo.start();
				barra.start();
			}
		});

		intervalo = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				i--;
				lbl_contador.setText(String.valueOf(i));
				if (i == 0) {
					intervalo.stop();
					btn_start.setEnabled(false);
				}

			}
		});

		barra = new Timer(1000, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				j++;
				lbl_contador.setText(String.valueOf(i));
				progressBar.setValue(j * 25);
				lbl_mensje.setLocation(lbl_mensje.getLocation().x, lbl_mensje.getLocation().x);
				if (j == 4) {
					barra.stop();
					lbl_mensje2.setVisible(true);
					lbl_mensje.setVisible(false);
				}

			}
		});
		
		/* ejemplo porfe
		 
		  progressBar.setValue(progressBar.getValue()+2.5)
		  }
		});
		  
		 */
		
		/*ventana*/
		progressBar.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (progressBar.getValue()==100) {
					String msg = "ENHORABUENA \n\n Vamos que ya no queda nada \n\n animo";
					JOptionPane.showMessageDialog(null, msg,"Al Recreo?",1);
				}
				
			}
		});
		
	}
}
