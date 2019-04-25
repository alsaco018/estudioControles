package estudioControles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class FrmResultadoCompleto extends JFrame {

	private JPanel contentPane;
	private JTextArea textArea;
	private String curriculum;
	private JScrollPane scrollPane;
	/**
	 * Create the frame.
	 */



	private void definirVentana() {
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane= new JScrollPane();
		scrollPane.setBounds(10, 43, 281, 383);
		getContentPane().add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setText(curriculum);
		scrollPane.setViewportView(textArea);
		
		
	}


	private void definirEvento() {
		// TODO Auto-generated method stub
		
	}


	public FrmResultadoCompleto(String curriculum) {
		this.curriculum = curriculum;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 470, 499);
		definirVentana();
		definirEvento();
		setVisible(true);
	}

}
