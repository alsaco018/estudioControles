package estudioControles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class FrmRadioButtons extends JFrame {

	private JPanel panel;
	//private JRadioButton rdbtnSoltero, rdbtnCasado, rdbtnSeparado;
	private JLabel lblEstadoCivil;
	private String estadoCivil = "";
	private ButtonGroup grupoRadioButton;
	private JButton btnAceptar;
	private List<JRadioButton> radios = new ArrayList<JRadioButton>();
	/**
	 * Create the frame.
	 */
	public FrmRadioButtons() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		
		definirVentana();
		definirEventos();
		setVisible(true);
		}

	private void definirEventos() {
			
		
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < radios.size(); ++i) {
					if(radios.get(i).isSelected()) {
						estadoCivil = radios.get(i).getText();
						lblEstadoCivil.setText("Estado Civil: "+estadoCivil);
					}
				}
			}
		});
	}

	private void definirVentana() {
	
		
		grupoRadioButton = new ButtonGroup();
		
		int posicionY = 30;
		for(int i = 0; i < 3; ++i) {
			JRadioButton radio = new JRadioButton("");		
			switch(i) {
			case 0: radio.setText("Casado");break;
			case 1: radio.setText("Separado");break;
			case 2: radio.setText("Soltero");break;
			}
			radio.setBounds(16, posicionY, 120, 23);
			radios.add(radio);
			panel.add(radio);
			grupoRadioButton.add(radio);
			posicionY += 24;
		}
		
		lblEstadoCivil = new JLabel("Estado Civil: ");
		lblEstadoCivil.setBounds(152, 48, 158, 23);
		panel.add(lblEstadoCivil);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(152, 113, 89, 23);
		panel.add(btnAceptar);
		
	}
}
