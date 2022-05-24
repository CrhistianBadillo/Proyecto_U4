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
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;




public class Opc_reg extends JFrame implements ActionListener {
    JLabel inf;
    
    JButton pri,sec,pre;
    
    JLabel logo;
     ImageIcon imagen= new ImageIcon("C:\\Users\\Acer\\Downloads\\ivg3.png");
    
    public Opc_reg(){
        super("Opciones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500,250);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        logo=new JLabel(imagen);
        logo.setBounds(150,10,200,120);//x,y,ancho, alto
        
        inf=new JLabel("Que registro deseas ver");
        inf.setBounds(100,130,300,30);//x,y,ancho, alto
        inf.setFont(new Font("arial",Font.PLAIN,25));
        
        pri=new JButton("Primaria");
        pri.setBounds(12,180,150,30);//x,y,ancho, alto
        pri.setBackground(Color.WHITE);
        pri.setBorderPainted(false);
        pri.setFont(new Font("arial",Font.PLAIN,20));
        sec=new JButton("Secundaria");
        sec.setBounds(160,180,150,30);//x,y,ancho, alto
        sec.setBackground(Color.WHITE);
        sec.setBorderPainted(false);
        sec.setFont(new Font("arial",Font.PLAIN,20));
        pre=new JButton("Preparatoria");
        pre.setBounds(311,180,150,30);//x,y,ancho, alto
        pre.setBackground(Color.WHITE);
        pre.setBorderPainted(false);
        pre.setFont(new Font("arial",Font.PLAIN,20));
        this.add(logo);
        this.add(inf);
        this.add(pri);
        this.add(sec);
        this.add(pre);
        
        pri.addActionListener(this);
        sec.addActionListener(this);
        pre.addActionListener(this);
         
    }
    
      public void actionPerformed(ActionEvent ev){
        
        //devuelve una referencia al objeto donde se genero el evento
       Object objeto=ev.getSource();
       if(objeto instanceof JButton){//si se pulso el boton

         if (objeto==pri){
            Primaria obj= new Primaria();

         }
         
        if (objeto==sec){
            Secundaria obj= new Secundaria();
            obj.show();

         }
        
        if(objeto==pre){
            Preparatoria obj= new Preparatoria();
        }
         
}
     }
}
