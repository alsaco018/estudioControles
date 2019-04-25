package estudioControles;

import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//FrmEjemplo frame = new FrmEjemplo();
					//frame.setVisible(true);
					//EstudioJFrame frame = new EstudioJFrame();
					//EstudioBoton frame = new EstudioBoton();
					//FrmEventos frame = new FrmEventos();
					//FrmTablaMultiplicar frame = new FrmTablaMultiplicar();
					//FrmTablaMultiplicar2 frame = new FrmTablaMultiplicar2();
					//FrmCajasTexto frame = new FrmCajasTexto();
					//FrmRadioButtons frame = new FrmRadioButtons();
					//FrmCheckBox frame = new FrmCheckBox();
					//FrmPrimitiva frame = new FrmPrimitiva();
					//FrmLista frame = new FrmLista();
					//FrmCompleto frame = new FrmCompleto();
					FrmBingo frame = new FrmBingo();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
