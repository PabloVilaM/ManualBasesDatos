package pruebabasesdatos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

public class GUI {
        
    JFrame frame;
    JPanel panel;
    JButton crear, conexion, eliminar, modificar, revisar, revisarIndividual, regenerar, aniquilar;
    JLabel titulo, presenta;
    JSeparator separador1;
    
    public void crearEventos(){
        Font fuente = new Font("A",1,34);
        frame = new JFrame("Eventos");
        frame.setSize(600, 500);
        panel = new JPanel();
        panel.setSize(600, 500);
        panel.setLayout(null);
        
        titulo = new JLabel("Bienvenido administrador/a");
        titulo.setBounds(70, 0, 600, 100);
        titulo.setFont(fuente);
        
        presenta = new JLabel("Que quiere hacer en este momento?");
        presenta.setBounds(200,30, 300, 200);
        
        separador1 = new JSeparator();
        separador1.setBounds(0, 100, 700, 10);
        
        crear = new JButton("Añadir usuario");
        crear.setBounds(350, 200, 150, 50);
        
        eliminar = new JButton("Eliminar");
        eliminar.setBounds(350, 280, 150, 50);
        
        modificar = new JButton("Modificar");
        modificar.setBounds(100, 280, 150, 50);
        
        conexion = new JButton("Conectar");
        conexion.setBounds(100, 200, 150, 50);
        
        revisar = new JButton("Consultar");
        revisar.setBounds(100,360,150,50);
        
        revisarIndividual = new JButton("Consulta única");
        revisarIndividual.setBounds(350,360,150,50);
        
        regenerar = new JButton ("Regenerar");
        regenerar.setBounds(485, 441, 100, 20);
        
        aniquilar = new JButton ("Aniquilar");
        aniquilar.setBounds(385, 441, 100, 20);
        
        
        //ponemos los componentes al panel.
        panel.add(aniquilar);
        panel.add(regenerar);
        panel.add(revisarIndividual);
        panel.add(revisar);
        panel.add(conexion);
        panel.add(modificar);
        panel.add(titulo);
        panel.add(eliminar);
        panel.add(presenta);
        panel.add(crear);
        panel.add(separador1);
        frame.add(panel);
        frame.setLocationRelativeTo(frame);
        //xestion de eventos
        conexion.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                Connection con = null;
                
                try{
                    con = DriverManager.getConnection( "jdbc:sqlite:data.sqlite" );
                if ( con != null ){
                      System.out.println("Conexión exitosa, puedes trabajar tranquilo! Recuerda que la consola te irá guiando con las instruccionea necesarias para cada parte del programa");
                        }
             }  catch (SQLException ex) {
                    System.out.println("Algo ha fallado en la conexión, es probable que pasará algo con el archivo");
                }}
        });
        crear.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
              JFrame framecr = new JFrame("Añadir usuario");
              framecr.setSize(600,500);
              framecr.setLocationRelativeTo(framecr);
              
              JPanel panelcr = new JPanel();
              panelcr.setSize(600,500);
              panelcr.setLayout(null);
              
              JButton boton = new JButton("Crear");
              boton.setBounds(300,350, 100, 50);
              
                System.out.println("Bienvenido al apartado de añadir usuario administrador/a, aqui tiene que insertar los datos necesarios"
                        + "para registrar a un usuario, que por conveniencia para el hotel es su nombre completo junto a telefono y DNI.\n Los 5 son campos de texto"
                        + "por que nos conviene a si que debe tener cuidado y rellenarlo"
                        + "correctamente, es importante para el resto de funciones de la base de datos, gracias.\n IMPORTANTE: EL DNI NO SE PUEDE REPETIR POR MOTIVOS OBVIOS Y EL BOTON DE REGENERAR ES POR SI LA SE ROMPIO LA BASE."
                        + "\n EL BOTON ANIQUILAR ES PARA CARGARSE LA BASE ENTERA");
         
              
              JLabel nombre = new JLabel("Nombre:");
              nombre.setBounds(50, 50, 100, 100);
              
              JLabel primerApellido = new JLabel("Primer apellido:");
              primerApellido.setBounds(50, 100, 150, 100);
              
              JLabel segundoApellido = new JLabel("Segundo apellido:");
              segundoApellido.setBounds(50, 150, 150, 100);
              
              JLabel dni = new JLabel("DNI:");
              dni.setBounds(50, 200, 150, 100);
              
              JLabel telf = new JLabel("Número telefono:");
              telf.setBounds(50, 250, 150, 100);
              
              JTextField nombreCampo = new JTextField();
              nombreCampo.setBounds(220, 85, 300, 30);
              
              JTextField primerApellidoCampo = new JTextField();
              primerApellidoCampo.setBounds(220, 135, 300, 30);
              
              JTextField segundoApellidoCampo = new JTextField();
              segundoApellidoCampo.setBounds(220, 185, 300, 30);
              
              JTextField dniCampo = new JTextField();
              dniCampo.setBounds(220, 235, 300, 30);
              
              JTextField telfCampo = new JTextField();
              telfCampo.setBounds(220, 285, 300, 30);
              
              boton.addActionListener(new ActionListener(){
                    public void actionPerformed(ActionEvent e){
                        framecr.dispose();
                        String nome = nombreCampo.getText();
                        String apel = primerApellidoCampo.getText();
                        String segunApel = segundoApellidoCampo.getText();
                        String dnii = dniCampo.getText();
                        String telefono = telfCampo.getText();
                        
                        Database.insertar(nome, apel, segunApel, dnii, telefono);
                        
                    }
                    
              });
              
              framecr.add(boton);
              framecr.add(nombreCampo);
              framecr.add(primerApellidoCampo);
              framecr.add(segundoApellidoCampo);
              framecr.add(dniCampo);
              framecr.add(telfCampo);
              framecr.add(telf);
              framecr.add(primerApellido);
              framecr.add(segundoApellido);
              framecr.add(dni);
              framecr.add(nombre);
              framecr.add(panelcr);
              framecr.setVisible(true);
            }
        });
        eliminar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Bienvenido administrador/a, si deconoces que hace esto te lo explico. Lo que hace es eliminar el registro entero de una persona según el DNI que le des. ");
              String dni = JOptionPane.showInputDialog("Dime el DNI de la persona que quieres eliminar");
              Database.eliminar(dni);
            }
        });
        modificar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Bienvenido administrador/a, si desconoces que hace esto te lo explico. \nLo que hace es modificar el dato del campo que eliges (importante poner la opción como esta escrita)"
                        + "con el dato nuevo que le otorgas. Para marcar a quien se lo cambias tambien te solicita el DNI.");
              String datoModificar = JOptionPane.showInputDialog("Dime uno de los siguientes datos a modificar del cliente \na)DNI \nb)NOMBRE \nc)APELLIDO \nd)SEGUNDOAPELLIDO \ne)TELEFONO");
              String dni = JOptionPane.showInputDialog("Dni del usuario a modificar");
              String datoNuevo = JOptionPane.showInputDialog("Dato nuevo a colocar");
              Database.modificar(datoModificar, datoNuevo, dni);
            }
        });
        revisar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Bienvenido administrador/a, si deconoces que hace esto te lo explico. Te saca una consulta de TODA la base de datos.");
              Database.consultar();
            }
        });
        revisarIndividual.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                System.out.println("Bienvenido administrador/a, si deconoces que hace esto te lo explico. Te saca una consulta del usuario que eliges pasandole el dni correspondiente.");
                String dni = JOptionPane.showInputDialog("Dime el DNI de la persona que quieres consultar");
              Database.consultarIndividualmente(dni);
            }
        });
        regenerar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Database.crearTabla();
            }
        });
        aniquilar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Database.eliminarCompletamente();
            }
        });
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
