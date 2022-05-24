/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_u4;

/**
 *
 * @author Acer
 */
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Info extends JFrame implements ActionListener{
    
       ConectarT con=new ConectarT();
          Connection reg=con.conexion();
    
    String[] dia= {"Dia","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15",
                    "16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
    String[] mes= {"Mes","Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic"};
    String[] acti= {"Seleccione una opcion","Futbol","Basquetbol","Taekwondo","Ajedrez","Voleibol"};
    String[] grado={"Seleccione una opción","1° Primaria","2° Primaria","3° Primaria","4° Primaria","5° Primaria",
        "6° Primaria","1° Secundaria","2° Secundaria","3° Secundaria","1° Preparatoria","2° Preparatoria","3° Preparatoria",};
   
    JComboBox cbDia,cbMes,cbGrado,cbAct;
    
     JLabel logo;
     ImageIcon imagen= new ImageIcon("C:\\Users\\Acer\\Downloads\\ivg3.png");
     //alumno
     JLabel tit,lblnom,apep,apem,lbldia,lblmes,año,lblgrado,alum,act,lbledad,lblmonto;
     JTextField txtnom,txtapep,txtapem,txtedad;
    
     //tutor
     JLabel tut,tnom,tapep,tapem,calle,fracc,cp,dir,tel,rfc;
     JTextField txttnom,txttapep,txttapem,txttaño,txtcalle,txtfracc,txtcp,txttel,txtrfc;
    
     JButton modi,eli;
     
     JLabel m,i;
     
    public Info(String matricula, String nom, String edad,String ggrado,String monto,String nomt, String num, String dire,String Rfc,String idact,String itd){
        super("Informacion");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(650,700);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        m=new JLabel(matricula);
        i=new JLabel(itd);
        
        int sg=Integer.parseInt(ggrado);
        int sa=Integer.parseInt(idact);

        logo=new JLabel(imagen);
        logo.setBounds(250,10,200,120);//x,y,ancho, alto
        
        tit=new JLabel("Datos Generales");
        tit.setBounds(275,120,150,30);//x,y,ancho, alto
        tit.setFont(new Font("arial",Font.PLAIN,20));
        alum=new JLabel("Matricula: "+matricula);
        alum.setBounds(25,150,200,30);//x,y,ancho, alto
        alum.setFont(new Font("arial",Font.PLAIN,20));
           
        lblnom=new JLabel("Nombre Completo: ");
        lblnom.setBounds(25,180,150,30);//x,y,ancho, alto
        lblnom.setFont(new Font("arial",Font.PLAIN,15));
        txtnom=new JTextField(nom);
        txtnom.setBounds(25,210,400,20);//x,y,ancho, alto
        txtnom.setFont(new Font("arial",Font.PLAIN,15));
        
        
        lblgrado=new JLabel("Grado:");
        lblgrado.setBounds(250,240,150,30);
        lblgrado.setFont(new Font("arial",Font.PLAIN,15));
        cbGrado=new JComboBox(grado);
        cbGrado.setBounds(250, 280, 150, 25);
        cbGrado.setEditable(true);
        cbGrado.setSelectedIndex(sg);
        
        lbledad=new JLabel("Edad:");
        lbledad.setBounds(25,240,150,30);
        lbledad.setFont(new Font("arial",Font.PLAIN,15));
        txtedad=new JTextField(edad);
        txtedad.setBounds(25, 280, 150, 25);
        txtedad.setFont(new Font("arial",Font.PLAIN,15));
        
        lblmonto=new JLabel("Monto: $"+monto);
        lblmonto.setBounds(475,280,150,30);
        lblmonto.setFont(new Font("arial",Font.PLAIN,15));
        
        
        tut=new JLabel("Datos del Tutor");
        tut.setBounds(25,320,200,30);//x,y,ancho, alto
        tut.setFont(new Font("arial",Font.PLAIN,20));
          
        tnom=new JLabel("Nombre Completo: ");
        tnom.setBounds(25,350,150,30);//x,y,ancho, alto
        tnom.setFont(new Font("arial",Font.PLAIN,15));
        txttnom=new JTextField(nomt);
        txttnom.setBounds(25,380,400,20);//x,y,ancho, alto
        txttnom.setFont(new Font("arial",Font.PLAIN,15));

        calle=new JLabel("Calle/Fraccionamiento/Codigo Postal: ");
        calle.setBounds(25,440,300,30);//x,y,ancho, alto
        calle.setFont(new Font("arial",Font.PLAIN,15));
        txtcalle=new JTextField(dire);
        txtcalle.setBounds(25,470,500,20);//x,y,ancho, alto
        txtcalle.setFont(new Font("arial",Font.PLAIN,15));
         
        dir=new JLabel("Dirección ");
        dir.setBounds(25,410,100,30);//x,y,ancho, alto
        dir.setFont(new Font("arial",Font.PLAIN,15));
        
        tel=new JLabel("Teléfono: ");
        tel.setBounds(25,500,100,30);//x,y,ancho, alto
        tel.setFont(new Font("arial",Font.PLAIN,15));
        txttel=new JTextField(num);
        txttel.setBounds(25,530,200,20);//x,y,ancho, alto
        txttel.setFont(new Font("arial",Font.PLAIN,15));
        
        rfc=new JLabel("RFC: ");
        rfc.setBounds(250,500,100,30);//x,y,ancho, alto
        rfc.setFont(new Font("arial",Font.PLAIN,15));
        txtrfc=new JTextField(Rfc);
        txtrfc.setBounds(250,530,200,20);//x,y,ancho, alto
        txtrfc.setFont(new Font("arial",Font.PLAIN,15));
        
        act=new JLabel("Actividad: ");
        act.setBounds(475,500,150,30);
        act.setFont(new Font("arial",Font.PLAIN,15));
        cbAct=new JComboBox(acti);
        cbAct.setBounds(475,530, 150, 25);
        cbAct.setEditable(true);
        cbAct.setSelectedIndex(sa);
        
        modi=new JButton("Modificar");
        modi.setBounds(115,600,150,30);//x,y,ancho, alto
        modi.setBackground(Color.WHITE);
        modi.setFont(new Font("arial",Font.PLAIN,20));
        
        eli=new JButton("Eliminar");
        eli.setBounds(382,600,150,30);//x,y,ancho, alto
        eli.setBackground(Color.WHITE);
        eli.setFont(new Font("arial",Font.PLAIN,20));
        

        this.add(logo);
        this.add(tit);
        this.add(lblnom);
        this.add(txtnom);
        this.add(lblgrado); 
        this.add(cbGrado);
        this.add(tut);
        this.add(tnom);
        this.add(txttnom);
        this.add(calle);
        this.add(txtcalle);
        this.add(dir);
        this.add(tel);
        this.add(txttel);
        this.add(rfc);
        this.add(txtrfc);
        this.add(act);
        this.add(cbAct);
        this.add(alum);
        this.add(lbledad);
        this.add(txtedad);
        this.add(lblmonto);
        this.add(modi);
        this.add(eli);
        
        modi.addActionListener(this);
        eli.addActionListener(this);
        
        
    }

    
     public void actionPerformed(ActionEvent ev){
        
        //devuelve una referencia al objeto donde se genero el evento
       Object objeto=ev.getSource();
       if(objeto instanceof JButton){//si se pulso el boton

         if (objeto==modi){
            
             modificar();
       
     }
         
         if(objeto==eli){
             eliminar();
         }
  
         }
       }
     
     
     public void modificar(){
         String idt=i.getText();
         String matricula=m.getText();
         String nomtutor=txttnom.getText().toUpperCase();
         String tele=txttel.getText().toUpperCase();
         String direc=txtcalle.getText().toUpperCase();
         String rfct=txtrfc.getText().toUpperCase();
         
         String nomal=txtnom.getText().toUpperCase();
         String ed=txtedad.getText().toUpperCase();
         int idgrado=cbGrado.getSelectedIndex();
         String idg=String.valueOf(idgrado);
         int idacti=cbAct.getSelectedIndex();
         String ida=String.valueOf(idacti);
         String bin="1";
         
         int respuesta;
         respuesta = JOptionPane.showConfirmDialog(null,"Seguro de MODIFICAR el registro","ADVERTENCIA",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE);
        if (respuesta==0) {          
        try{
            PreparedStatement ps=reg.prepareStatement("UPDATE tutor SET nombre='"+nomtutor+"',telefono='"+tele
            +"',direccion='"+direc+"',RFC='"+rfct
                   +"'WHERE idtutor='"+idt+"'");
            ps.executeUpdate();
           
            System.out.println("Modificacion realizada al tutor correcta");
            
            System.out.println("UPDATE alumno SET nombre='"+nomal+"',edad='"+ed
            +"',idtutor='"+idt+"',idgrado='"+idg+"',idactividad='"+ida+"',bin='"+bin
                   +"'WHERE matricula='"+matricula+"'");
            
            PreparedStatement ps1=reg.prepareStatement("UPDATE alumno SET nombre='"+nomal+"',edad='"+ed
            +"',idtutor='"+idt+"',idgrado='"+idg+"',idactividad='"+ida+"',bin='"+bin
                   +"'WHERE matricula='"+matricula+"'");
            ps1.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Modificacion realizada");
        }catch(SQLException ex){
             Logger.getLogger(Info.class.getName()).log(Level.SEVERE,null,ex);
        }
        setVisible(false);
        
}
     }
     
     public void eliminar(){
                  String idt=i.getText();
         String matricula=m.getText();
         String nomtutor=txttnom.getText().toUpperCase();
         String tele=txttel.getText().toUpperCase();
         String direc=txtcalle.getText().toUpperCase();
         String rfct=txtrfc.getText().toUpperCase();
         
         String nomal=txtnom.getText().toUpperCase();
         String ed=txtedad.getText().toUpperCase();
         int idgrado=cbGrado.getSelectedIndex();
         String idg=String.valueOf(idgrado);
         int idacti=cbAct.getSelectedIndex();
         String ida=String.valueOf(idacti);
         String bin="0";
         
         int respuesta;
         respuesta = JOptionPane.showConfirmDialog(null,"Seguro de Eliminar al alumno","ADVERTENCIA",
        JOptionPane.YES_NO_OPTION,
        JOptionPane.WARNING_MESSAGE);
        if (respuesta==0) {          
        try{
            PreparedStatement ps=reg.prepareStatement("UPDATE tutor SET nombre='"+nomtutor+"',telefono='"+tele
            +"',direccion='"+direc+"',RFC='"+rfct
                   +"'WHERE idtutor='"+idt+"'");
            ps.executeUpdate();
            System.out.println("Modificacion realizada al tutor correcta");
            PreparedStatement ps1=reg.prepareStatement("UPDATE alumno SET nombre='"+nomal+"',edad='"+ed
            +"',idtutor='"+idt+"',idgrado='"+idg+"',idactividad='"+ida+"',bin='"+bin
                   +"'WHERE matricula='"+matricula+"'");
            ps1.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Modificacion realizada");
        }catch(SQLException ex){
             Logger.getLogger(Info.class.getName()).log(Level.SEVERE,null,ex);
        }
        setVisible(false);
        
}
     }
    
}
