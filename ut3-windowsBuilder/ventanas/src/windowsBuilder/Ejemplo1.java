package windowsBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JScrollBar;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import java.awt.FlowLayout;
import javax.swing.SwingConstants;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;

public class Ejemplo1 {

	private JFrame frame;
	 
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo1 window = new Ejemplo1();
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
	public Ejemplo1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(204, 153, 255));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 698, 475);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); //layout absolute, puedes hacer lo quieras (organizacion)
		
		JLabel lblNewLabel_sofi = new JLabel("HOLA :D");
		lblNewLabel_sofi.setBounds(91, 115, 46, 14);
		frame.getContentPane().add(lblNewLabel_sofi);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setToolTipText("escribe algo si puedes");
		textField.setBounds(147, 112, 86, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ADIOS :(");
		lblNewLabel.setBounds(91, 197, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		textField_1 = new JTextField();
		textField_1.setBounds(147, 194, 86, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("SIGUIENTE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(482, 274, 95, 23);
		frame.getContentPane().add(btnNewButton);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(271, 110, 142, 104);
		frame.getContentPane().add(textArea);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(476, 191, 107, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("New radio button");
		rdbtnNewRadioButton.setBounds(470, 108, 109, 23);
		frame.getContentPane().add(rdbtnNewRadioButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(248, 274, 168, 21);
		frame.getContentPane().add(passwordField);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(186, 273, 46, 20);
		frame.getContentPane().add(spinner);
		
		JPanel panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignOnBaseline(true);
		panel.setBackground(new Color(204, 204, 255));
		panel.setBounds(1, 355, 120, 81);
		frame.getContentPane().add(panel);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("ON/OFF");
		panel.add(tglbtnNewToggleButton);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBounds(136, 274, 1, 1);
		frame.getContentPane().add(desktopPane);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(255, 204, 255));
		tabbedPane.setBounds(502, 308, 180, 128);
		frame.getContentPane().add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(51, 102, 204));
		tabbedPane.addTab("TAB 1", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 0, 255));
		tabbedPane.addTab("TAB 2", null, panel_2, null);
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane_1.setBounds(544, 292, 5, 5);
		frame.getContentPane().add(tabbedPane_1);
	}
}
