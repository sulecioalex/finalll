package teclado;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JFileChooser;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class t9 extends JFrame {
	static String extencion="";
	static ArrayList hot=new ArrayList();
	private JPanel contentPane;
public void com(){
	
	char c; 
	ArrayList letras = new ArrayList(); 
	ArrayList numeros = new ArrayList(); 
	numeros.add(2);
	numeros.add(22);
	numeros.add(222);
	numeros.add(3);
	numeros.add(33);
	numeros.add(333);
	numeros.add(4);
	numeros.add(44);
	numeros.add(444);
	numeros.add(5);
	numeros.add(55);
	numeros.add(555);
	numeros.add(6);
	numeros.add(66);
	numeros.add(666);
	numeros.add(7);
	numeros.add(77);
	numeros.add(777);
	numeros.add(7777);
	numeros.add(8);
	numeros.add(88);
	numeros.add(888);
	numeros.add(9);
	numeros.add(99);
	numeros.add(999);
	numeros.add(9999);	
	for (int i = 97; i < 123; i++) { 
	c = (char) i;  
	letras.add(c); 
	} 
	
	for (int i = 0; i < letras.size(); i++) { 
	System.out.println(letras.get(i) + " " + numeros.get(i)); 
	} 
	 int estado=Integer.parseInt((String) hot.get(0));
		for(int p=1;p <= estado-1;p++){ 
	String palabra = (String) hot.get(p); 

	for (int i = 0; i < palabra.length(); i++) { 
	if (letras.contains(palabra.charAt(i))) { 
	System.out.print(numeros.get( letras.indexOf( palabra.charAt( i ) ) )+" " ); 
	} 
	} 
	System.out.println(); 

	}
		JOptionPane.showMessageDialog(null,"revise la consola de java" );
	    
} 

	
	
	public static void cargar1 (){
		try{
     // Abrimos el archivo
     FileInputStream fstream = new FileInputStream(extencion);
     // Creamos el objeto de entrada
     DataInputStream entrada = new DataInputStream(fstream);
     // Creamos el Buffer de Lectura
     BufferedReader buffer = new BufferedReader(new InputStreamReader(entrada));
     String strLinea;
     // Leer el archivo linea por linea
     
     while ((strLinea = buffer.readLine()) != null)   {
         // Imprimimos la línea por pantalla
           hot.add(strLinea);
           System.out.println(strLinea);
     }
     // Cerramos el archivo
     entrada.close();
 }catch (Exception e){ //Catch de excepciones
     System.err.println("Ocurrio un error: " + e.getMessage());
 }						
}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					t9 frame = new t9();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public t9() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 11, 97, 21);
		contentPane.add(menuBar);
		
		JMenu mnArchivo = new JMenu("archivo");
		menuBar.add(mnArchivo);
		
		JButton btnAbrir = new JButton("abrir");
		btnAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				JFileChooser elegir = new JFileChooser();
                int opcion = elegir.showOpenDialog(btnAbrir);
           
                //Si presionamos el boton ABRIR en pathArchivo obtenemos el path del archivo
                if (opcion == JFileChooser.APPROVE_OPTION) {
                    String pathArchivo = elegir.getSelectedFile().getPath(); //Obtiene path del archivo
                    String nombre = elegir.getSelectedFile().getName(); //obtiene nombre del archivo
                   
                    System.out.println("El nombre del archivo es: "+ nombre);
                    System.out.println("El path del archivo es: "+ pathArchivo);
                    extencion=pathArchivo;
                }
			}
		});
		mnArchivo.add(btnAbrir);
		
		JButton btnComberitr = new JButton("comberitr");
		btnComberitr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargar1();
				com();
			}
		});
		btnComberitr.setBounds(281, 140, 89, 23);
		contentPane.add(btnComberitr);
	}
}
