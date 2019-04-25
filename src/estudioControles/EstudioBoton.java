package estudioControles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import com.sun.glass.events.KeyEvent;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JToggleButton;

public class EstudioBoton extends JFrame implements ActionListener{

	private JPanel contentPane, panel;
	private JButton btnRojo, btnVerde, btnAzul, btnAmarillo, btnLeft, btnMiddle, btnRight;
	private JToggleButton tglbtnHabilitado;
	private JFrame frame;

	/**
	 * Create the frame.
	 */
	public EstudioBoton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(157, 79, 121, 95);
		panel.setBackground(Color.WHITE);
		contentPane.add(panel);
		this.definirVentana();
		this.DefinirEventos();
		this.setVisible(true);
	}



	private void DefinirEventos() {
		btnRojo.addActionListener(this);
		btnVerde.addActionListener(this);
		btnAzul.addActionListener(this);
		btnAmarillo.addActionListener(this);
		tglbtnHabilitado.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent arg0) {
				if(tglbtnHabilitado.isSelected()) {
					tglbtnHabilitado.setText("Deshabilitado");
					habilitar(false);
				}else {
					tglbtnHabilitado.setText("Habilitado");
					habilitar(true);
				}
				
			}

			
			
		});
		btnLeft.addActionListener(this);
		btnRight.addActionListener(this);
	}


	private void habilitar(boolean b) {
		btnRojo.setEnabled(b); btnVerde.setEnabled(b); btnAzul.setEnabled(b); btnAmarillo.setEnabled(b);	//desabilitamos todos los botones
	}

	private void definirVentana() {
		
		btnRojo = new JButton("Rojo");
		btnRojo.setBounds(10, 11, 89, 23);
		btnRojo.setActionCommand("rojo");
		contentPane.add(btnRojo);
		
		btnAmarillo = new JButton("Amarillo");
		btnAmarillo.setBounds(335, 11, 89, 23);
		btnAmarillo.setActionCommand("amarillo");
		contentPane.add(btnAmarillo);
		
		btnVerde = new JButton("Verde");
		btnVerde.setBounds(10, 187, 89, 23);
		btnVerde.setActionCommand("verde");
		contentPane.add(btnVerde);
		
		btnAzul = new JButton("Azul");
		btnAzul.setBounds(335, 187, 89, 23);
		btnAzul.setActionCommand("azul");
		contentPane.add(btnAzul);
		
		tglbtnHabilitado = new JToggleButton("Habilitado");
		tglbtnHabilitado.setBounds(157, 45, 121, 23);
		tglbtnHabilitado.setActionCommand("habilitado");
		contentPane.add(tglbtnHabilitado);
		
		Icon leftIcon = new ImageIcon("imagenes/arrow.png"); Icon middleIcon = new ImageIcon("imagenes/javaIcon.jpg"); Icon rigthIcon = new ImageIcon("imagenes/back.png");
		
		
		btnLeft = new JButton("Disable center button");
		btnLeft.setBounds(86, 221, 98, 40);
		btnLeft.setVerticalTextPosition(AbstractButton.CENTER);
		btnLeft.setHorizontalTextPosition(AbstractButton.LEADING);
		btnLeft.setMnemonic(KeyEvent.VK_D);
		btnLeft.setActionCommand("disable");
		btnLeft.setToolTipText("Disable center button");
		btnLeft.setIcon(new ImageIcon(EstudioBoton.class.getResource("/imagenes/arrow.png")));
		contentPane.add(btnLeft);
		
		btnMiddle = new JButton("Centre Button");
		btnMiddle.setBounds(189, 221, 89, 40);
		btnMiddle.setVerticalTextPosition(AbstractButton.BOTTOM);
		btnMiddle.setHorizontalTextPosition(AbstractButton.CENTER);
		btnMiddle.setMnemonic(KeyEvent.VK_C);
		btnMiddle.setToolTipText("Center button");
		btnMiddle.setIcon(middleIcon);
		contentPane.add(btnMiddle);
		
		btnRight = new JButton("Enable centre button");
		btnRight.setBounds(278, 221, 89, 40);
		contentPane.add(btnRight);
		
		
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("rojo")) {
			panel.setBackground(Color.red);
		}
		if(e.getActionCommand().equals("amarillo")) {
			panel.setBackground(Color.yellow);
		}
		if(e.getActionCommand().equals("verde")) {
			panel.setBackground(Color.green);
			JOptionPane.showMessageDialog(frame, "Vaya color más feo", "ATENCION",JOptionPane.INFORMATION_MESSAGE);
		}
		if(e.getActionCommand().equals("azul")) {
			panel.setBackground(Color.blue);
		}
		if(e.getActionCommand().equals("disable")) {
			btnMiddle.setEnabled(false);
			btnLeft.setEnabled(false);
			btnRight.setEnabled(true);
		}
	}
}
