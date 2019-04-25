package estudioControles;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.HeadlessException;
import java.awt.LayoutManager;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.ColorModel;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

public class EstudioJFrame extends JFrame {

	private JPanel contentPane;
	
	private JLabel label;
	private JPanel panel;

	/**
	 * Launch the application.
	 
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EstudioJFrame frame = new EstudioJFrame();
					//JFrame frame1 = new JFrame();					//crea un marco con los botones de opciones unicamente
					
					//JFrame frame2 = new JFrame(new GraphicsConfigurations gc); 	//crea un marco con la cofiguración gráfica de gc
					String titulo = "Hola que tal?";
					//JFrame frame3 = new JFrame(titulo);				//crea el marco con el titulo indicado.
					//JFrame frame4 = new JFrame(titulo, GraphicsConfiguration gc); 	//crea un marco con el titulo y la configuracion indicados.
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
*/
	public EstudioJFrame() throws HeadlessException {
		super();
		setBounds(100, 100, 483, 366);
		Container contentPane = getContentPane();
		label  = new JLabel("Etiqueta");
		label.setFont(new Font("Tempus Sans ITC", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //El metodo define la forma en que se cerrará el marco. Con EXIT_ON_CLOSE al cerrar la ventana se termina el programa
		//setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); //no hace nada al pulsar en el icono de cerrar la ventana
		//setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);		//esconde la ventana al pulsar en el icono de cerrar la ventana, pero sigue su ejecucion
		//setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);		//esconde la ventana y el programa no terminar hasta haber cerrado todas las ventanas abiertas
		setResizable(true);		//permite redimensionar el tamaño de la ventana
		String titulo = "Hola que tal?";
		setTitle(titulo);		//establece el titulo de la ventana indicado
		//pack();					//ajusta la ventana al tamaño de los elementos que contiene
		setState(Frame.NORMAL);	//coloca la ventana en el modo especificado, en este caso normal
		//setState(Frame.ICONIFIED);	//en este caso la crea minimizada
		//setExtendedState(JFrame.MAXIMIZED_HORIZ); // maximiza la ventana en horizontal
		//setExtendedState(JFrame.MAXIMIZED_VERT);	// maximiza la ventana en veertical
		//setExtendedState(JFrame.MAXIMIZED_BOTH);	//maximiza la ventana
		//int estado = getState();
		//System.out.println(estado);		//devuelve el estado en el que se encuentra la ventana
		panel = new JPanel();		//creamos el panel
		panel.setBorder(new EmptyBorder(5, 5, 5, 5));	//establece el tamaño del borde del panel
		//panel.setLayout(new BorderLayout(0,0));	
		//FlowLayout flowLayout = (FlowLayout) panel.getLayout();			//obtiene la posicion donde se mostraran los elementos
		
		//JPanel panel = new JPanel(true);	//crea un panel con doble buffer
		//JPanel panel = new JPanel(LayoutManager);	//crea un panel con el gestor de presentacion indicado
		//JPanel panel = new JPanel(LayoutManager, true);	//crea un panel con los valores que se indican
		setContentPane(panel);	//establece el panel en el contenido
		panel.setLayout(null);
		panel.add(label);		//añade al panel el componente especificado
		//panel.add(label, -1);	//añade al panel el componente en la posicion especificada mediante el int
		//panel.add(label, titulo);	//añade al panel el componente y el objeto especificará la posicion del mismo
		//panel.add(label, titulo, 0); //igual, añade el componente en la posicion especificada
		//panel.add(titulo, label); //añade al panel el componente label con el titulo especificado
		//panel.remove(label);	//elimina del panel el componente especificado
		//panel.remove(0);		//elimina del panel el componente en la posicion int
		//panel.removeAll();		//elimina todos los componentes del panel
		int nPaneles = panel.getComponentCount();	//devuelve el numero de componentes en el panel
		System.out.println(nPaneles);
		panel.setBackground(Color.cyan);		//establece el color de fondo del panel
		
	}
}
