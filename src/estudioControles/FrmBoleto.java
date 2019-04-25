package estudioControles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.graalvm.compiler.lir.constopt.ConstantLoadOptimization_OptionDescriptors;

import java.awt.GridLayout;

public class FrmBoleto extends JFrame {

	private JPanel contentPane;
	
	private List<JButton> numerosBoleto = new ArrayList<JButton>();
	private int[][] carton = new int[3][9];
	private JButton[][] botones = new JButton[3][9];
	private JFrame linea, bingo;
	private String titulo;
	private boolean lineaCantada = false, bingoCantado = false;
	/**
	 * Create the frame.
	 * @param titulo 
	 */
	public FrmBoleto(int[][] carton, String titulo) {
		super(titulo);
		this.titulo = titulo;
		this.carton = carton;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 557, 301);
		
		definirVentana();
		definirEventos();
		setVisible(true);
	}
	
	public void actualizarCarton(boolean[][] numerosSalidos) {
		for(int fila = 0; fila < 3; ++fila) {
			for(int colum = 0; colum < 9; ++colum) {
				if(numerosSalidos[fila][colum]) {
					JButton boton = botones[fila][colum];
					boton.setForeground(Color.green);
				}
				if(!lineaCantada) {											//si no se ha cantado ya fila, lo comprobamos
					compruebaLinea(numerosSalidos, fila);
				}
				
			}
			
		}
		compruebaBingo(numerosSalidos);
	}

	private void compruebaBingo(boolean[][] numerosSalidos) {					//comprobamos si hay bingo
		int contAciertos = 0;
		for(int fila = 0; fila < numerosSalidos.length; ++fila)
			for(int colum = 0; colum < numerosSalidos[fila].length; ++colum) {
				if(numerosSalidos[fila][colum])
					++contAciertos;
			}
		if(contAciertos == 15) {
			String titulo = "BINGO en "+this.titulo;
			JOptionPane.showMessageDialog(bingo, "ENHORABUENA HAS CONSEGUIDO BINGO", titulo,JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void compruebaLinea(boolean[][] numerosSalidos, int fila) {			//comprobamos si hay linea
		int contadorSalidos = 0;
		for(int colum = 0; colum  < numerosSalidos[fila].length; ++colum) {
			if(numerosSalidos[fila][colum]) {
				++contadorSalidos;
			}
		}
		if(contadorSalidos == 5) {
			lineaCantada = true;
			String titulo = "LINEA en "+this.titulo;
			JOptionPane.showMessageDialog(linea, "Has conseguido una linea", titulo,JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void definirVentana() {
		
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.CYAN);
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(3, 9, 0, 0));
		
		
		//int posicionX = 46, posicionY;
		//posicionY = 66;
			for(int fila = 0; fila < 3; ++fila) {
				
				//posicionX = 46;
				for(int col = 0; col < 9; ++col) {
					
					JButton btni = new JButton("");//String.valueOf(cont));
					//lbli.setBounds(posicionX, posicionY, 40 , 20);
					btni.setFont(new Font("Magneto", Font.PLAIN, 14));
					btni.setBackground(Color.WHITE);
					if(carton[fila][col] != -1) {
						btni.setText(String.valueOf(carton[fila][col]));
					}else {
						btni.setIcon(new ImageIcon(FrmBoleto.class.getResource("/imagenes/1232131.png")));
					}
					botones[fila][col] = btni;
					numerosBoleto.add(btni);
					contentPane.add(btni);
					//posicionX += 50;
					
				}
				//posicionY += 35;
			}
			
		}
		
	

	private void definirEventos() {
		// TODO Auto-generated method stub
		
	}

}
