package estudioControles;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class FrmPrimitiva extends JFrame {

	private JPanel panel;
	private int[][] numerosApuestas = new int[7][6];			//7 apuestas de 6 numeros cada una, la 7ª es la del sorteo
	private ButtonGroup grupoRadioButtons;
	private JLabel lblNumeroapuestas ;
	private JRadioButton radioButton_1, radioButton_2, radioButton_3, radioButton_4, radioButton_5, radioButton_6;
	private JButton btnSorteo, btnApuestas;
	private List<JLabel> apuesta = new ArrayList<JLabel>(), sorteo = new ArrayList<JLabel>(), lblNAciertos = new ArrayList<JLabel>();
	private int nApuestas = 0;
	private JLabel lblResultadoDelSorteo, lblAcierto;
	private JFrame frame;
	/**
	 * Create the frame.
	 */
	public FrmPrimitiva() {
		setForeground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		definirVentana();
		definirEventos();
		setVisible(true);
	}


	private void inicializarArray(int[][] apuestas, int nApuestas) {		//inicializamos los arrays de apuestas
		for(int i = 0; i < 7; ++i) {
			for(int j = 0; j < 6; ++j) {
				numerosApuestas[i][j] = generarNumero(i);
			}
		}
		
	}


	private int generarNumero(int i) {							//método que genera un numero aleatorio entre 1 y 49 y que no hayamos cogido anteriormente en la apuesta.
		int n = 0;
		do{
			n = (int) (Math.random()*49-1);
		}while(repetido(n, numerosApuestas[i]));
		return n;
	}


	private boolean repetido(int n, int[] apuestas) {
		for(int i = 0; i < apuestas.length; ++i) {				//Comprobamos si que no esté repetido en la apuesta
			if(apuestas[i] == n)
				return true;
		}
		return false;
	}


	private void definirEventos() {
		btnApuestas.addActionListener(new ActionListener() {		//Al pulsar el boton de apuestas generamos x apuestas
			public void actionPerformed(ActionEvent e) {
				if(radioButton_1.isSelected()) {					//observamos cual es el radioButton seleccionado 
					nApuestas = 1;
				}else if(radioButton_2.isSelected()) {
					nApuestas = 2;
				}else if(radioButton_3.isSelected()) {
					nApuestas = 3;
				}else if(radioButton_4.isSelected()) {
					nApuestas = 4;
				}else if(radioButton_5.isSelected()) {
					nApuestas = 5;
				}else if(radioButton_6.isSelected()) {
					nApuestas = 6;
				}
				inicializarArray(numerosApuestas, nApuestas);
				for(int i = 0; i < nApuestas; ++i) {
					int posicion = i * 7;
					generarApuesta(posicion);
				}
				
				btnApuestas.setEnabled(false);
			}

		});
		
		btnSorteo.addActionListener(new ActionListener() {						//Al pulsar el boton del sorteo, mostramos los numeros del sorteo y comprobamos el numero de aciertos de cada apuesta
			public void actionPerformed(ActionEvent e) {
				lblResultadoDelSorteo.setText("Resultado del sorteo:");
				generarSorteo();
				lblAcierto.setText("Aciertos:");
				comprobarAciertos();
				pintarAciertos();
				
			}

		});
	}
	
	private void pintarAciertos() {
		int[] nAciertos = comprobarAciertos();
		for(int i = 0; i < nApuestas; ++i) {
			int num= nAciertos[i];
			lblNAciertos.get(i).setText(String.valueOf(num));
		}
	}
	
	private int[] comprobarAciertos() {
		int[] sorteo = numerosApuestas[6];
		int[] nAciertos = new int[6];
		int numSorteo, numApuesta;
		for(int i = 0; i < 6; ++i) {
			for(int j = 0; j < 6; ++j) {
				for(int z = 0; z < 6; ++z) {
					numSorteo = sorteo[i];
					numApuesta = numerosApuestas[j][z];
					if(numSorteo == numApuesta) {
						++nAciertos[j];
						int posicion = (7*j)+(z+1);		
						apuesta.get(posicion).setForeground(Color.green);
					}
				}
				
			}
		}
		if(ganado(nAciertos, nApuestas))
			JOptionPane.showMessageDialog(frame, "HAS GANADO LA PRIMITIVA", "¡ENHORABUENA!",JOptionPane.INFORMATION_MESSAGE);
		return nAciertos;
	}
	

	
	private boolean ganado(int[] nAciertos, int n) {			//comprobamos si alguna apuesta ha ganado la primitiva
		for(int i = 0; i < n; ++i) {
			if(nAciertos[i] == 6)
				return true;
		}
		return false;
	}


	private void generarSorteo() {
		
		for(int i = 0; i < 6; ++i) {
			sorteo.get(i).setText(String.valueOf(numerosApuestas[6][i]));
		}
	}

	
	private void generarApuesta(int posicion) {
		
		for(int j = posicion; j < posicion + 7; j++) {									//la lista de numeros de apuesta tiene 42 posiciones, con 7 etiquetas en cada fila, 1 para el numero de apuesta y 6 para los nuemeros de cada apuesta
			if(j == posicion) {
				apuesta.get(j).setText("Apuesta "+String.valueOf((posicion/7)+1)+": ");				//definimos el numero de apuesta
				
			}else if(j == posicion + 6) {
				apuesta.get(j).setText(String.valueOf(numerosApuestas[(posicion/7)][(j-1)%7]));
			}else {
				apuesta.get(j).setText(String.valueOf(numerosApuestas[(posicion/7)][(j-1)%7])+", ");
				
			}
		}
		
	
	
	
}

	private void definirVentana() {
		int posicionX = 30, posicionY = 180;
		setBounds(100, 100, 592, 421);
		panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.WHITE);
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(panel);
		panel.setLayout(null);
		
		definirEtiquetasSorteo(posicionX, posicionY);
		
		posicionX = 30;
		
		definirEtiquetasApuestas(posicionX, posicionY);
		
		posicionX = 300;
		posicionY = 180;
		
		definirEtiquetasAciertos(posicionX, posicionY);
		definirRadioButtons();
		definirBotones();
				
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmPrimitiva.class.getResource("/imagenes/La_Primitiva.svg.png")));
		lblNewLabel.setBounds(0, 0, 196, 89);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(FrmPrimitiva.class.getResource("/imagenes/loe.jpg")));
		lblNewLabel_1.setBounds(257, 85, 221, 255);
		panel.add(lblNewLabel_1);
		
		
		
	}


	private void definirBotones() {
		btnApuestas = new JButton("Apuestas");
		btnApuestas.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 11));
		btnApuestas.setBounds(435, 86, 116, 35);
		panel.add(btnApuestas);
		
		btnSorteo = new JButton("Sorteo");
		btnSorteo.setForeground(new Color(0, 128, 0));
		btnSorteo.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 16));
		btnSorteo.setBounds(401, 311, 150, 60);
		panel.add(btnSorteo);
	}


	private void definirRadioButtons() {
		lblNumeroapuestas = new JLabel("Seleccione el numero de apuestas que desea realizar:");
		lblNumeroapuestas.setForeground(new Color(0, 100, 0));
		lblNumeroapuestas.setVerticalAlignment(SwingConstants.TOP);
		lblNumeroapuestas.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumeroapuestas.setFont(new Font("Rockwell Condensed", Font.PLAIN, 15));
		lblNumeroapuestas.setBounds(307, 27, 269, 23);
		panel.add(lblNumeroapuestas);
		
		grupoRadioButtons = new ButtonGroup();
		
		radioButton_1 = new JRadioButton("1");
		radioButton_1.setBackground(Color.WHITE);
		radioButton_1.setBounds(364, 44, 35, 35);
		panel.add(radioButton_1);
		grupoRadioButtons.add(radioButton_1);
		
		radioButton_2 = new JRadioButton("2");
		radioButton_2.setBackground(Color.WHITE);
		radioButton_2.setBounds(400, 44, 35, 35);
		panel.add(radioButton_2);
		grupoRadioButtons.add(radioButton_2);
		
		radioButton_3 = new JRadioButton("3");
		radioButton_3.setBackground(Color.WHITE);
		radioButton_3.setBounds(435, 44, 35, 35);
		panel.add(radioButton_3);
		grupoRadioButtons.add(radioButton_3);
		
		radioButton_4 = new JRadioButton("4");
		radioButton_4.setBackground(Color.WHITE);
		radioButton_4.setBounds(465, 44, 35, 35);
		panel.add(radioButton_4);
		grupoRadioButtons.add(radioButton_4);
		
		radioButton_5 = new JRadioButton("5");
		radioButton_5.setBackground(Color.WHITE);
		radioButton_5.setBounds(498, 44, 35, 35);
		panel.add(radioButton_5);
		grupoRadioButtons.add(radioButton_5);
		
		radioButton_6 = new JRadioButton("6");
		radioButton_6.setBackground(Color.WHITE);
		radioButton_6.setBounds(531, 44, 35, 35);
		panel.add(radioButton_6);
		grupoRadioButtons.add(radioButton_6);
		
		
	}


	private void definirEtiquetasAciertos(int posicionX, int posicionY) {
		lblAcierto = new JLabel("");
		
		lblAcierto.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 11));
		lblAcierto.setForeground(new Color(0, 100, 0));
		lblAcierto.setBounds(posicionX, posicionY-30, 100, 14);
		panel.add(lblAcierto);
		
		
		for(int j = 0; j < 6; j++) {							//definimos las etiquetas de los numeros de aciertos sorteo
			JLabel etiqueta = new JLabel("");
			
			etiqueta.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
			etiqueta.setForeground(new Color(0, 100, 0));
			etiqueta.setBounds(posicionX+20, posicionY, 30, 14);
			lblNAciertos.add(etiqueta);
			panel.add(etiqueta);
			posicionY += 20;
			
		}
	}


	private void definirEtiquetasApuestas(int posicionX, int posicionY) {
		for(int i = 0; i < 6; i++) {									//declara las 42 etiquetas correspondientes a las posibles apuestas que vamos a realizar. 1ª posicion de cada apuesta para el numero de apuesta y el resto con los numeros de las apuestas
			for(int j = 0; j < 7; j++) {
				JLabel etiqueta = new JLabel("");
				if(j == 0) {
					etiqueta.setFont(new Font("Rockwell Condensed", Font.BOLD, 13));
					etiqueta.setBounds(posicionX, posicionY, 70, 14);
					apuesta.add(etiqueta);
					panel.add(etiqueta);
					posicionX += 62;
				}else {
					etiqueta.setFont(new Font("Rockwell Condensed", Font.PLAIN, 15));
					etiqueta.setBounds(posicionX, posicionY, 30, 14);
					apuesta.add(etiqueta);
					panel.add(etiqueta);
					posicionX += 32;
				}
			}
			
			posicionY += 20;
			posicionX = 30;
		}
	}


	private void definirEtiquetasSorteo(int posicionX, int posicionY) {
		lblResultadoDelSorteo = new JLabel("");
		lblResultadoDelSorteo.setForeground(new Color(0, 128, 0));
		lblResultadoDelSorteo.setFont(new Font("Rockwell Extra Bold", Font.ITALIC, 18));
		lblResultadoDelSorteo.setBounds(30, 80, 252, 53);
		panel.add(lblResultadoDelSorteo);
		
		for(int j = 0; j < 6; j++) {							//definimos las etiquetas de los numeros del sorteo
			JLabel etiqueta = new JLabel("");
			
			etiqueta.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
			etiqueta.setForeground(new Color(0, 100, 0));
			etiqueta.setBounds(posicionX+20, 134, 30, 14);
			sorteo.add(etiqueta);
			panel.add(etiqueta);
			posicionX += 32;
			
		}
		
	}
}
