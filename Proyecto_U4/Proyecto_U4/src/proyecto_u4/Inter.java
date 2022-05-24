/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_u4;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Inter extends JFrame implements ActionListener {
    
    //presentacion
     JLabel logo;
     ImageIcon imagen= new ImageIcon("C:\\Users\\Acer\\Downloads\\ivg.png");
     
     //botones
     JButton btnins, btndains, btnact, btndagen;
     
    
    public Inter(){
        super("Instituto Valle del Guadiana");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,700);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        this.getContentPane().setBackground(Color.WHITE);
        
        
        logo=new JLabel(imagen);
        logo.setBounds(100,100,800,450);//x,y,ancho, alto
        
        //botones interfaz
        btnins=new JButton("Inscripciones");
        btnins.setBounds(137,600,150,30);//x,y,ancho, alto
        btnins.setBackground(Color.WHITE);
        btnins.setBorderPainted(false);
        btnins.setFont(new Font("arial",Font.PLAIN,20));
        btndains=new JButton("Registros");
        btndains.setBounds(424,600,150,30);//x,y,ancho, alto
        btndains.setBackground(Color.WHITE);
        btndains.setBorderPainted(false);
        btndains.setFont(new Font("arial",Font.PLAIN,20));
        btnact=new JButton("Datos Generales");
        btnact.setBounds(711,600,200,30);//x,y,ancho, alto
        btnact.setBackground(Color.WHITE);
        btnact.setBorderPainted(false);
        btnact.setFont(new Font("arial",Font.PLAIN,20));
//        btndagen=new JButton("Datos Generales");
//        btndagen.setBounds(750,600,200,30);//x,y,ancho, alto
//        btndagen.setBackground(Color.WHITE);
//        btndagen.setBorderPainted(false);
//        btndagen.setFont(new Font("arial",Font.PLAIN,20));
        
        
        
        this.add(logo);
        this.add(btnins);
        this.add(btndains);
           this.add(btnact);
//        this.add(btndagen);
        
        btnins.addActionListener(this);
        btndains.addActionListener(this);
        btnact.addActionListener(this);
    }
    
    public static void main(String[] args) {
        Inter obj= new Inter();
    }
    
      public void actionPerformed(ActionEvent ev){
        
        //devuelve una referencia al objeto donde se genero el evento
       Object objeto=ev.getSource();
       if(objeto instanceof JButton){//si se pulso el boton

         if (objeto==btnins){
            int respuesta= JOptionPane.showConfirmDialog(null,"El alumno cuenta con algun hermano inscrito en Instituto "
                    + "Valle del Guadiana.","Confirmacion",
                +JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
             if(respuesta==0){
                 
                 Padres obj=new Padres();
             }else if(respuesta==1){
                 Inscripciones obj= new Inscripciones();
             }
             
             
            

         }
         
         if(objeto==btndains){
             Usuario obj= new Usuario();
         }
         
         if(objeto==btnact){
             Usuario1 obj= new Usuario1();
         }
}
     }
}
