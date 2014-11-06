package invertir;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.*;

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
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class inver1 extends JFrame {
static String extencion="";
static ArrayList hot=new ArrayList();
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
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
	 

	
	
	
	
	public static void combertir1() throws IOException{
	
		 int estado=Integer.parseInt((String) hot.get(0));
			for(int p=1;p <= estado;p++){
				
			
		      String []cads=((String) hot.get(p)).split(" ");

		      for(int i=cads.length-1;i>=0;i--){
		          System.out.print(cads[i]+" ");
		          
		         
		      }
		    

		      System.out.println(" ");
			}
		
			JOptionPane.showMessageDialog(null,"revise la consola de java" );
	     
			}
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					inver1 frame = new inver1();
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
	public inver1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(10, 0, 97, 21);
		contentPane.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("archivo");
		menuBar.add(mnNewMenu);
		
		JButton btnAbrir = new JButton("abrir");
		btnAbrir.addActionListener(new ActionListener() {
		
				
				public void actionPerformed(ActionEvent evento) {
				
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
		mnNewMenu.add(btnAbrir);
		
		JButton btnEjecutar = new JButton("ejecutar");
		btnEjecutar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cargar1 ();
				try {
					combertir1();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnEjecutar.setBounds(229, 42, 89, 23);
		contentPane.add(btnEjecutar);
	}
}
