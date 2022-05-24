/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_u4;

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

public class Inscripciones extends JFrame {
   // ConectarT con=new ConectarT();
     //     Connection reg=con.conexion();
    
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
     JLabel tit,nom,apep,apem,lbldia,lblmes,año,lblgrado,alum,act;
     JTextField txtnom,txtapep,txtapem,txtaño;
    
     //tutor
     JLabel tut,tnom,tapep,tapem,calle,fracc,cp,dir,tel,rfc;
     JTextField txttnom,txttapep,txttapem,txttaño,txtcalle,txtfracc,txtcp,txttel,txtrfc;
     
     JButton btnins;
     
    public Inscripciones(){
        super("Inscripciones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,700);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        
        logo=new JLabel(imagen);
        logo.setBounds(250,10,200,120);//x,y,ancho, alto
        
        tit=new JLabel("Datos Generales");
        tit.setBounds(275,120,150,30);//x,y,ancho, alto
        tit.setFont(new Font("arial",Font.PLAIN,20));
        alum=new JLabel("Datos del Alumno");
        alum.setBounds(25,150,200,30);//x,y,ancho, alto
        alum.setFont(new Font("arial",Font.PLAIN,20));
           
        nom=new JLabel("Nombre: ");
        nom.setBounds(25,180,100,30);//x,y,ancho, alto
        nom.setFont(new Font("arial",Font.PLAIN,15));
        txtnom=new JTextField();
        txtnom.setBounds(25,210,200,20);//x,y,ancho, alto
        txtnom.setFont(new Font("arial",Font.PLAIN,15));
        
        apep=new JLabel("Apellido Paterno: ");
        apep.setBounds(250,180,200,30);//x,y,ancho, alto
        apep.setFont(new Font("arial",Font.PLAIN,15));
        txtapep=new JTextField();
        txtapep.setBounds(250,210,200,20);//x,y,ancho, alto
        txtapep.setFont(new Font("arial",Font.PLAIN,15));   
        
        apem=new JLabel("Apellido Materno: ");
        apem.setBounds(475,180,200,30);//x,y,ancho, alto
        apem.setFont(new Font("arial",Font.PLAIN,15));
        txtapem=new JTextField();
        txtapem.setBounds(475,210,200,20);//x,y,ancho, alto
        txtapem.setFont(new Font("arial",Font.PLAIN,15));
        
        lbldia=new JLabel("Dia de nacimiento:");
        lbldia.setBounds(50,240,150,30);
        lbldia.setFont(new Font("arial",Font.PLAIN,15));
        cbDia=new JComboBox(dia);
        cbDia.setBounds(50, 280, 100, 25);
        cbDia.setEditable(true);
        lblmes=new JLabel("Mes de nacimiento:");
        lblmes.setBounds(200,240,150,30);
        lblmes.setFont(new Font("arial",Font.PLAIN,15));
        cbMes=new JComboBox(mes);
        cbMes.setBounds(200, 280, 100, 25);
        cbMes.setEditable(true);
        año=new JLabel("Año de Nacimiento:");
        año.setBounds(350,240,150,30);
        año.setFont(new Font("arial",Font.PLAIN,15));
        txtaño=new JTextField();
        txtaño.setBounds(350,280,100,30);
        lblgrado=new JLabel("Grado:");
        lblgrado.setBounds(500,240,150,30);
        lblgrado.setFont(new Font("arial",Font.PLAIN,15));
        cbGrado=new JComboBox(grado);
        cbGrado.setBounds(500, 280, 150, 25);
        cbGrado.setEditable(true);
        //tutor
        tut=new JLabel("Datos del Tutor");
        tut.setBounds(25,320,200,30);//x,y,ancho, alto
        tut.setFont(new Font("arial",Font.PLAIN,20));
          
        tnom=new JLabel("Nombre: ");
        tnom.setBounds(25,350,100,30);//x,y,ancho, alto
        tnom.setFont(new Font("arial",Font.PLAIN,15));
        txttnom=new JTextField();
        txttnom.setBounds(25,380,200,20);//x,y,ancho, alto
        txttnom.setFont(new Font("arial",Font.PLAIN,15));
        
        tapep=new JLabel("Apellido Paterno: ");
        tapep.setBounds(250,350,200,30);//x,y,ancho, alto
        tapep.setFont(new Font("arial",Font.PLAIN,15));
        txttapep=new JTextField();
        txttapep.setBounds(250,380,200,20);//x,y,ancho, alto
        txttapep.setFont(new Font("arial",Font.PLAIN,15));   
        
        tapem=new JLabel("Apellido Materno: ");
        tapem.setBounds(475,350,200,30);//x,y,ancho, alto
        tapem.setFont(new Font("arial",Font.PLAIN,15));
        txttapem=new JTextField();
        txttapem.setBounds(475,380,200,20);//x,y,ancho, alto
        txttapem.setFont(new Font("arial",Font.PLAIN,15));
        
        calle=new JLabel("Calle: ");
        calle.setBounds(25,440,100,30);//x,y,ancho, alto
        calle.setFont(new Font("arial",Font.PLAIN,15));
        txtcalle=new JTextField();
        txtcalle.setBounds(25,470,200,20);//x,y,ancho, alto
        txtcalle.setFont(new Font("arial",Font.PLAIN,15));
        
        fracc=new JLabel("Fraccionamiento: ");
        fracc.setBounds(250,440,200,30);//x,y,ancho, alto
        fracc.setFont(new Font("arial",Font.PLAIN,15));
        txtfracc=new JTextField();
        txtfracc.setBounds(250,470,200,20);//x,y,ancho, alto
        txtfracc.setFont(new Font("arial",Font.PLAIN,15));   
        
        cp=new JLabel("Codigo Postal: ");
        cp.setBounds(475,440,200,30);//x,y,ancho, alto
        cp.setFont(new Font("arial",Font.PLAIN,15));
        txtcp=new JTextField();
        txtcp.setBounds(475,470,200,20);//x,y,ancho, alto
        txtcp.setFont(new Font("arial",Font.PLAIN,15));
        
        dir=new JLabel("Dirección ");
        dir.setBounds(25,410,100,30);//x,y,ancho, alto
        dir.setFont(new Font("arial",Font.PLAIN,15));
        
        tel=new JLabel("Teléfono: ");
        tel.setBounds(25,500,100,30);//x,y,ancho, alto
        tel.setFont(new Font("arial",Font.PLAIN,15));
        txttel=new JTextField();
        txttel.setBounds(25,530,200,20);//x,y,ancho, alto
        txttel.setFont(new Font("arial",Font.PLAIN,15));
        
        rfc=new JLabel("RFC: ");
        rfc.setBounds(250,500,100,30);//x,y,ancho, alto
        rfc.setFont(new Font("arial",Font.PLAIN,15));
        txtrfc=new JTextField();
        txtrfc.setBounds(250,530,200,20);//x,y,ancho, alto
        txtrfc.setFont(new Font("arial",Font.PLAIN,15));
        
        act=new JLabel("Actividad: ");
        act.setBounds(475,500,150,30);
        act.setFont(new Font("arial",Font.PLAIN,15));
        cbAct=new JComboBox(acti);
        cbAct.setBounds(475,530, 150, 25);
        cbAct.setEditable(true);
        
        
        
        btnins=new JButton("INSCRIBIR");
        btnins.setBounds(275,600,150,30);//x,y,ancho, alto
        btnins.setBackground(Color.WHITE);
        btnins.setFont(new Font("arial",Font.PLAIN,20));
        
        
       
        
        this.add(logo);
        this.add(tit);
        this.add(nom);
        this.add(txtnom);
        this.add(apep);
        this.add(txtapep);
        this.add(apem);
        this.add(txtapem);
        this.add(lbldia); 
        this.add(cbDia);   
        this.add(lblmes); 
        this.add(cbMes);
        this.add(año); 
        this.add(txtaño);  
        this.add(lblgrado); 
        this.add(cbGrado);
        this.add(alum);
        this.add(tut);
        this.add(tnom);
        this.add(txttnom);
        this.add(tapep);
        this.add(txttapep);
        this.add(tapem);
        this.add(txttapem);
        this.add(calle);
        this.add(txtcalle);
        this.add(fracc);
        this.add(txtfracc);
        this.add(cp);
        this.add(txtcp);
        this.add(dir);
        this.add(tel);
        this.add(txttel);
        this.add(rfc);
        this.add(txtrfc);
        this.add(btnins);
        this.add(act);
        this.add(cbAct);
        
//        btnins.addActionListener(this);
    }
    
   /* public void actionPerformed(ActionEvent ev){
        
        //devuelve una referencia al objeto donde se genero el evento
       Object objeto=ev.getSource();
       if(objeto instanceof JButton){//si se pulso el boton

         if (objeto==btnins){
             String bin="1";
             //fecha actual
             Calendar fechas = new GregorianCalendar();
             int añoC = fechas.get(Calendar.YEAR);
             int mesC = fechas.get(Calendar.MONTH)+1;
             int diaC = fechas.get(Calendar.DAY_OF_MONTH);
             
             //datos alumno
             String nomb=txtnom.getText().toUpperCase();           
             String ap=txtapep.getText().toUpperCase();
             String am=txtapem.getText().toUpperCase();
             int añoA=0;
             String nombc=nomb+" "+ap+" "+am;
             String Dia=(String)cbDia.getSelectedItem();
             String Mes=(String)cbMes.getSelectedItem();
             String Año=txtaño.getText();
             int Act=cbAct.getSelectedIndex();
             String Acts=String.valueOf(Act);
             //datos alumno convertidos en enteros
             int diaA=cbDia.getSelectedIndex();
             int mesA=cbMes.getSelectedIndex();
             if(Año.equals("")){
                 System.out.println("Esta vacio año");
             }else{
              añoA=Integer.parseInt(Año);
             }
             //edad del alumno actualmente
             int añoR=(añoC-añoA);
             int mesR=(mesC-mesA);
             int añoT=0;             
             if(mesR<0){
                 añoT=(añoR-1);
             }else{
                 añoT=añoR; 
            }
            String Edad=Integer.toString(añoT);
            String Grado=(String)cbGrado.getSelectedItem();
             //datos tutor
             String tnomb=txttnom.getText().toUpperCase();
             String tap=txttapep.getText().toUpperCase();
             String tam=txttapem.getText().toUpperCase();
             String nombct=tnomb+" "+tap+" "+tam;
             String Calle=txtcalle.getText().toUpperCase();
             String Fracc=txtfracc.getText().toUpperCase();
             String Cp=txtcp.getText().toUpperCase();
             String Dir=Calle+" "+Fracc+" "+Cp;
             String Tel=txttel.getText();
             String Rfc=txtrfc.getText().toUpperCase();
             
            if(nomb.equals("") || ap.equals("") || am.equals("") || Dia.equals("Dia") || Mes.equals("Mes") || Año.equals("") ||
                Tel.equals("") || Grado.equals("Seleccione una opción") || tnomb.equals("") || tap.equals("") || tam.equals("") 
                    || Rfc.equals("") || Calle.equals("") || Fracc.equals("") || Cp.equals("") || Acts.equals("Seleccione una opción")){
            
                JOptionPane.showMessageDialog(null,"No deje el espacio vacio y/o seleccione una opción correcta");
                    
             }else{
            
            
             int respuesta= JOptionPane.showConfirmDialog(null,"Desea inscribir al alumno.","Confirmacion",
                +JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
             if(respuesta==0){
            

//                agreDT( nombct, Tel,Dir, Rfc);
//                agreDA( nombc, Edad, Acts,bin);

            String sql="INSERT INTO tutor (nombre,telefono,direccion,RFC) VALUES (?,?,?,?)";
        
            PreparedStatement ps;
             try {
           ps = reg.prepareStatement(sql);
            ps.setString(1, nombct);
            ps.setString(2, Tel);
            ps.setString(3, Dir);
            ps.setString(4, Rfc);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro del Tutor Guardado");
            } catch (SQLException ex) {
                 Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
             }
             
             
             Random r= new Random ();
              String ales="";
              String idt="";
              String matri="";
            int ale=r.nextInt(9999);
            if (ale<1000){
                ales="0"+String.valueOf(ale);
            }else {
                ales=String.valueOf(ale);
            }
            
            String []datos=new String[5];
           
           
             sql="SELECT * FROM tutor WHERE nombre='"+nombct+"'";
            try{
                Statement sentencia=reg.createStatement();
                ResultSet rs= sentencia.executeQuery(sql);
                while(rs.next()){
                    datos[0]=rs.getString(1);
                    datos[1]=rs.getString(2);
                    datos[2]=rs.getString(3);
                    datos[3]=rs.getString(4);
                    datos[4]=rs.getString(5);
                }
                
                idt=datos[0];
                System.out.println("idtutor"+idt);
                
            }catch(SQLException ex){
                Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE,null,ex);
            }
            
            
            int Grados=cbGrado.getSelectedIndex();
            String Gras=String.valueOf(Grados);
            
            if(Grados==1){
                 matri="0104"+ales; 
            }
            if(Grados==2){
                 matri="0204"+ales; 
            }
            if(Grados==3){
                 matri="0304"+ales; 
            }
           if(Grados==4){
                 matri="0404"+ales; 
            }
            if(Grados==5){
                 matri="0504"+ales; 
            }
            if(Grados==6){
                 matri="0604"+ales; 
            }
            if(Grados==7){
                 matri="0704"+ales; 
            }
            if(Grados==8){
                 matri="0804"+ales; 
            }
            if(Grados==9){
                 matri="0904"+ales; 
            }
           if(Grados==10){
                 matri="1004"+ales; 
            }
            if(Grados==11){
                 matri="1104"+ales; 
            }
             if(Grados==12){
                 matri="1204"+ales; 
            }
             
             System.out.println("matri"+matri+"grado "+Gras+"idtutor "+idt);
             
            sql="INSERT INTO alumno (matricula,nombre,edad,idtutor,idgrado,idactividad,bin) VALUES (?,?,?,?,?,?,?)";
        
             try {
            ps = reg.prepareStatement(sql);
            ps.setString(1, matri);
            ps.setString(2, nombc);
            ps.setString(3, Edad);
            ps.setString(4, idt);
            ps.setString(5, Gras);
            ps.setString(6, Acts);
            ps.setString(7, bin);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro del Alumno Guardado");
            JOptionPane.showMessageDialog(null, "Matricula: "+matri+"\n"+"Nombre completo del alumno: "+nombc+"\n"+
            "Edad: "+Edad+"\n"+"Grado: "+(String)cbGrado.getSelectedItem()+"\n"+"Actividad: "+(String)cbAct.getSelectedItem()+"\nNombre completo del tutor: "+nombct+"\n"+
                   "Dirección: "+Dir+"\n"+"Telefono: "+Tel+"\n"+"RFC: "+Rfc);
            } catch (SQLException ex) {
                 Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
             }
             
            setVisible(false); 
             }
         }
     }
  
         }
       }
    */
    

    public static void main(String[] args) {
        Inscripciones obj= new Inscripciones();
        obj.show();
    }

}
    

    

