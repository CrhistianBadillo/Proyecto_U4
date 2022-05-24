
package proyecto_u4;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class Hermano extends JFrame implements ActionListener{
    
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
     JLabel tit,nom,apep,apem,lbldia,lblmes,año,lblgrado,alum,act,n;
     JTextField txtnom,txtapep,txtapem,txtaño;
    
     //tutor
     JLabel tut,tnom,tapep,tapem,calle,fracc,cp,dir,tel,rfc;
     JTextField txttnom,txttapep,txttapem,txttaño,txtcalle,txtfracc,txtcp,txttel,txtrfc;
     
     JButton btnins;
     public Hermano(String nombre){
         super("Inscripciones");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(700,650);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
       
        n= new JLabel(nombre); 
        String nombret="";
                String telefono="";
                String direccion="";
                String RFC="";
        String []datos=new String[6]; 
        String sql="SELECT * FROM tutor WHERE nombre='"+nombre+"'";      
           
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
                
                nombret=datos[1];
                telefono=datos[2];
                direccion=datos[3];
                RFC=datos[4];
                
                }catch(SQLException ex){
                Logger.getLogger(Hermano.class.getName()).log(Level.SEVERE,null,ex);
            }
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
        
        act=new JLabel("Actividad: ");
        act.setBounds(25,310,150,30);
        act.setFont(new Font("arial",Font.PLAIN,15));
        cbAct=new JComboBox(acti);
        cbAct.setBounds(25,340, 150, 25);
        cbAct.setEditable(true);
        
        tut=new JLabel("Datos del Tutor");
        tut.setBounds(25,380,200,30);//x,y,ancho, alto
        tut.setFont(new Font("arial",Font.PLAIN,20));    
        tnom=new JLabel("Nombre: "+nombret);
        tnom.setBounds(25,420,500,30);//x,y,ancho, alto
        tnom.setFont(new Font("arial",Font.PLAIN,15));
        
        dir=new JLabel("Dirección: "+direccion);
        dir.setBounds(25,450,500,30);//x,y,ancho, alto
        dir.setFont(new Font("arial",Font.PLAIN,15));
        
        tel=new JLabel("Teléfono: "+telefono);
        tel.setBounds(25,480,500,30);//x,y,ancho, alto
        tel.setFont(new Font("arial",Font.PLAIN,15));
        
        rfc=new JLabel("RFC: "+RFC);
        rfc.setBounds(25,510,500,30);//x,y,ancho, alto
        rfc.setFont(new Font("arial",Font.PLAIN,15));

        
        btnins=new JButton("INSCRIBIR");
        btnins.setBounds(275,540,150,30);//x,y,ancho, alto
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
        this.add(act);
        this.add(cbAct);
        this.add(tut);
        this.add(tnom);
        this.add(dir);
         this.add(tel);
         this.add(rfc);
         this.add(btnins);
         
         btnins.addActionListener(this);
     }
     
      public void actionPerformed(ActionEvent ev){

                String idt="";
                     String []datos=new String[6]; 
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
             String nombre=n.getText().toUpperCase();
             String nombc=nomb+" "+ap+" "+am;
             String Dia=(String)cbDia.getSelectedItem();
             String Mes=(String)cbMes.getSelectedItem();
             String Año=txtaño.getText();
             int Act=cbAct.getSelectedIndex();
             String Acts=String.valueOf(Act);
             //datos alumno convertidos en enteros
             int diaA=cbDia.getSelectedIndex();
             int mesA=cbMes.getSelectedIndex();
             int añoA=Integer.parseInt(Año);
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
                 
             
            if(nomb.equals("") || ap.equals("") || am.equals("") || Dia.equals("Dia") || Mes.equals("Mes") || Año.equals("") ||
                  Grado.equals("Seleccione una opción") || Acts.equals("Seleccione una opción")  ){
             JOptionPane.showMessageDialog(null,"No deje el espacio vacio y/o seleccione una opción correcta");

             }else{
             int respuesta= JOptionPane.showConfirmDialog(null,"Desea inscribir al alumno.","Confirmacion",
                +JOptionPane.YES_NO_OPTION,JOptionPane.INFORMATION_MESSAGE);
             if(respuesta==0){
            

        String sql="SELECT * FROM tutor WHERE nombre='"+nombre+"'";      
           
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
 
                
                }catch(SQLException ex){
                Logger.getLogger(Hermano.class.getName()).log(Level.SEVERE,null,ex);
            }
            
             
             Random r= new Random ();
              String ales="";
              
              String matri="";
            int ale=r.nextInt(9999);
            if (ale<1000){
                ales="0"+String.valueOf(ale);
            }else {
                ales=String.valueOf(ale);
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
             
             System.out.println("matri"+matri+"grado "+Gras+"idtutor "+idt+" acti"+ Acts);
             
            sql="INSERT INTO alumno (matricula,nombre,edad,idtutor,idgrado,idactividad,bin) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement ps;
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
            "Edad: "+Edad+"\n"+"Grado: "+(String)cbGrado.getSelectedItem()+"\n"+"Actividad: "+(String)cbAct.getSelectedItem()+"\nNombre completo del tutor: "+
                    tnom.getText()+"\n"+"Dirección: "+dir.getText()+"\n"+
                    tel.getText()+"\n"+rfc.getText());
            } catch (SQLException ex) {
                 Logger.getLogger(Inscripciones.class.getName()).log(Level.SEVERE, null, ex);
             }
             setVisible(false);
    }
         }
     }
  
         }
       }
}
