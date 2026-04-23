package view;

import org.openstreetmap.gui.jmapviewer.Coordinate;
import org.openstreetmap.gui.jmapviewer.JMapViewer;
import org.openstreetmap.gui.jmapviewer.MapMarkerDot;
import org.openstreetmap.gui.jmapviewer.MapPolygonImpl;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class JMapGrafos {

	private JFrame frame;
	private JMapViewer mapa;
	


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		System.setProperty("http.agent", "TrabajoPracticoGrafos_UNGS/1.0");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JMapGrafos window = new JMapGrafos();
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
	public JMapGrafos() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Coordinate[] memoria = new Coordinate[2];
		final Coordinate[] mouseActual = new Coordinate[1];
		
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panelMapa = new JPanel();
		mapa = new JMapViewer();
		panelMapa.setLayout(new BorderLayout());
		panelMapa.add(mapa, BorderLayout.CENTER);
		mapa.setFocusable(true);
		mapa.requestFocusInWindow();
		
		/*
		 * CREAR COORDENADA CON CLICK IZQUIERDO
		 */
		
		mapa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e ) {
				if(e.getButton() == MouseEvent.BUTTON1) {
					Coordinate coord = (Coordinate) mapa.getPosition(e.getPoint());
					
					String texto = String.format("%.4f, %.4f", coord.getLat(), coord.getLon());
					
					MapMarkerDot nodo = new MapMarkerDot(texto, coord);
					mapa.addMapMarker(nodo);
					mapa.requestFocusInWindow();
				}
			}
		});
		
		/*
		 * RASTREAR MOUSE EN TIEMPO REAL
		 */
		
		mapa.addMouseMotionListener(new MouseAdapter() {
		    @Override
		    public void mouseMoved(MouseEvent e) {
		        // Guardamos constantemente dónde está el mouse
		        mouseActual[0] = (Coordinate) mapa.getPosition(e.getPoint());
		    }
		});
		
		/*
		 * EVENTO I=ORIGEN, J=DESTINO, N=CREAR ARISTA
		 */
		
		mapa.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char tecla = Character.toLowerCase(e.getKeyChar());
				
				if(tecla == 'i') {
					memoria[0] = mouseActual[0];
					System.out.println("Origen fijado en: " + memoria[0]);
				}
				else if (tecla == 'j') {
		            memoria[1] = mouseActual[0];
		            System.out.println("Destino fijado en: " + memoria[1]);
		        }
				else if (tecla == 'n') {
					if (memoria[0] != null && memoria[1] != null) {
		                List<Coordinate> ruta = new ArrayList<>();
		                ruta.add(memoria[0]);
		                ruta.add(memoria[1]);
		                ruta.add(memoria[1]); // Truco del polígono cerrado
		                
		                MapPolygonImpl arista = new MapPolygonImpl(ruta);
		                mapa.addMapPolygon(arista);
		                System.out.println("¡Arista creada!");
		                
		                // Opcional: Limpiar memoria después de conectar
		                memoria[0] = null;
		                memoria[1] = null;
		            } else {
		                System.out.println("Falta fijar origen (i) o destino (j)");
		            }
				}
			}
		});
		frame.add(panelMapa);
		

		
	}

}
