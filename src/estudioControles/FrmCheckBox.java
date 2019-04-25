package estudioControles;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FrmCheckBox extends JFrame {

	private JPanel panel;
	private List<JCheckBox> checkboxes = new ArrayList<JCheckBox>();
	private List<JLabel> etiquetas = new ArrayList<JLabel>();
	private JButton btnAceptar;
	/**
	 * Create the frame.
	 */
	public FrmCheckBox() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		panel = new JPanel();
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		JLabel lblIngredientesDeLa = new JLabel("Ingredientes de la pizza: ");
		lblIngredientesDeLa.setFont(new Font("Tw Cen MT", Font.PLAIN, 18));
		lblIngredientesDeLa.setBounds(123, 11, 185, 57);
		panel.add(lblIngredientesDeLa);
		
		
		definirVentana();
		definirEventos();
		setVisible(true);
	}


	private void definirEventos() {
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
	}


	private void definirVentana() {
		int posicionY = 30, posicionX = 20;
		for(int i = 0; i < 5; ++i) {
			JCheckBox checkbx = new JCheckBox("");
			switch(i) {
			case 0: checkbx.setText("Jamón"); break;
			case 1: checkbx.setText("Bacon"); break;
			case 2: checkbx.setText("Peperoni"); break;
			case 3: checkbx.setText("Salsa barbacoa"); break;
			case 4: checkbx.setText("Champiñones"); break;
			}
			checkbx.setBounds(posicionX, posicionY, 20, 15);
			checkboxes.add(checkbx);
			panel.add(checkbx);
			JLabel etiqueta = new JLabel("");
			etiqueta.setBounds((posicionX + 30), posicionY, 20, 15);
			etiquetas.add(etiqueta);
			panel.add(etiqueta);
			posicionY += 20;
		}
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(263, 133, 89, 23);
		panel.add(btnAceptar);
		
	}

}
