/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_u4;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.Enumeration;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Usuario extends JFrame implements ActionListener{
    int ganancias, total;
    JLabel lblbien;
    JLabel lblusu;
    JLabel  lblcon;
    JLabel seg;
     ImageIcon imaSeg= new ImageIcon("C:\\Users\\Acer\\Downloads\\ivg3.png");
    JTextField txtusu;
    JPasswordField con;
    JButton Ingresar;
    
    public Usuario(){
        super("Usuario");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(250,400);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        this.setBackground(Color.blue);
        setVisible(true);
        
  
        
        //etiquetas
        lblbien=new JLabel("Bienvenido");
        lblbien.setBounds(25,50,200,50);//x,y,ancho, alto
        lblbien.setFont(new Font("arial",Font.PLAIN,40));
        
       // seg=new JLabel(imaSeg);
        //seg.setBounds(25,40,200,148);//x,y,ancho, alto
        //Usuario
        lblusu=new JLabel("Número de Control");
        lblusu.setBounds(25,170,150,30);//x,y,ancho, alto
        txtusu=new JTextField();
        txtusu.setBounds(25,200,200,30);//x,y,ancho, alto
        //Contraseña
        lblcon=new JLabel("NIP");
        lblcon.setBounds(25,230,100,30);//x,y,ancho, alto
        con=new JPasswordField();
        con.setBounds(25,260,200,30);//x,y,ancho, alto
        //boton ingreso
        Ingresar=new JButton("Ingresar");
        Ingresar.setBounds(75,320,100,30);//x,y,ancho, alto
        

        this.add(lblbien);
        this.add(lblusu);
        //this.add(seg);
        this.add(txtusu);
        this.add(lblcon);
        this.add(con);
        this.add(Ingresar);
        
        Ingresar.addActionListener(this);
        
        this.getContentPane().setBackground(Color.WHITE);
  
    }
    
         public void actionPerformed(ActionEvent ev){
        
        //devuelve una referencia al objeto donde se genero el evento
       Object objeto=ev.getSource();
       String Usu, Con,UP="Admin",CP="1234";
       
       
       Usu=txtusu.getText();
       Con=con.getText();
       
       if(objeto instanceof JButton){//si se pulso el boton
     
           if(Usu.equals(UP) && Con.equals(CP)){
               //Opc_reg obj=new Opc_reg();
               setVisible(false);
           }
           else if(Usu!=UP && Con!=CP){
               JOptionPane.showMessageDialog(null,"Número de Control y/o NIP Incorrectos");
           }
        
         
           
}
     }
   
    public static void main(String[] args) {
        Usuario obj= new Usuario();
        obj.show();
                
    }

}
