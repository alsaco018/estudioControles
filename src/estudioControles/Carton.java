package estudioControles;

import java.util.Arrays;

public class Carton {

	private int posicionHueco;
	private int n;
	private int[] nHuecosFila = new int[3];
	private int[][] carton = new int[3][9];
	private boolean[][] numerosEnCarton = new boolean[3][9];
	public Carton() {
		super();
		carton = generaBoleto();

		imprimeBoleto(carton);
	}
	

	public void actualizarCarton(int j) {
		int columna = j / 10;
		if(j == 90) {
			--columna;
		}
		
		for(int fila = 0; fila < 3; ++fila) {
			if(((carton[fila][columna] % 10) == 0) && (carton[fila][columna] == j)) {
				numerosEnCarton [fila][columna] = true;
			}else if(carton[fila][columna] == j){
				numerosEnCarton [fila][columna] = true;
			}
		}
	}
	
	
	
	public boolean[][] getNumerosEnCarton() {
		return numerosEnCarton;
	}


	public void setNumerosEnCarton(boolean[][] numerosEnCarton) {
		this.numerosEnCarton = numerosEnCarton;
	}


	public int[][] getCarton() {
		return carton;
	}


	public void setCarton(int[][] carton) {
		this.carton = carton;
	}


	private void imprimeBoleto(int[][] boleto2) {
		for(int i = 0; i < 3; ++i) {
			System.out.println(Arrays.toString(boleto2[i]));
			
		}
		System.out.println();
	}

	private int generarNumeroCarton(int inf, int sup, int[] columna) {							//método que genera un numero aleatorio entre 1 y 90 y que no hayamos cogido anteriormente en la apuesta.
		int res = 0;
		for(int i = 0; i < columna.length; ++i) {
			do {
				res = (int) (Math.random()*(sup - inf + 1)+inf);
			}while(repetidoCarton(columna, res));
		}
		return res;
	}

	private int[][] generaBoleto() {
		int[][] bolet = new int[3][9];
		generaNumerosBoleto(bolet);						//generamos los numeros del boleto
		for(int fila = 0; fila < 3; ++fila) {
			
			generaHueco(bolet, fila);					//generamos el hueco vacio en la columna
			
		}
		return bolet;
	}

	

	private void generaNumerosBoleto(int[][] bolet) {
		int[] columna = new int[3];
		int sup = 9, inf = 1;
		for(int colum = 0; colum < 9; ++colum) {
			for(int fila = 0; fila < 3; ++fila) {
				numerosEnCarton[fila][colum] = false;
				
				n = generarNumeroCarton(inf, sup, columna);
				columna[fila] = n;
			}
			if(colum == 0) {
				inf += 9; 
				sup += 10;
			}else if(colum > 0 && colum < 7) {
				inf += 10;
				sup += 10;
			}else {
				inf += 10;
				sup += 11;
			}
			Arrays.sort(columna);
			for(int i = 0; i < 3; ++i) {			//metemos la columna generada en el boleto
				bolet[i][colum] = columna[i];
			}
		}
	}

	

	private boolean repetidoCarton(int[] columna, int n) {
		boolean res = false;
		
		for(int i = 0; i < columna.length; ++i) {
			if(columna[i] == n)
				res = true;
		}
		return res;
	}

	private void generaHueco(int[][] bolet, int fila) {
		while(nHuecosFila[fila] < 4) {
			posicionHueco = (int) ((Math.random()*9));
			if(!hayHueco(bolet, fila, posicionHueco) && !tresHuecos(bolet, posicionHueco)) {
				bolet[fila][posicionHueco] = -1;
				++nHuecosFila[fila];
			}
			
		}
		
	}

	private boolean tresHuecos(int[][] bolet, int posicionHueco2) {
		int nHuecos = 0;
		for(int fila = 0; fila < 3; ++fila) {
			if(hayHueco(bolet, fila, posicionHueco2)) {
				++nHuecos;
			}
			if(nHuecos >= 2) {
				return true;
			}
		}
		return false;
	}

	private boolean hayHueco(int[][] bolet, int fila, int colum) {
		if(bolet[fila][colum] == -1) {
			return true;
		}
		
		return false;
	}


	

	
}
