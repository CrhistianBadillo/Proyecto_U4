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
import java.awt.Color;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
public class dg extends javax.swing.JFrame {

    /**
     * Creates new form dg
     */
    ConectarT con=new ConectarT();
          Connection reg=con.conexion();
    public dg() {
        initComponents();
                setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);
        setVisible(true);
        getContentPane().setBackground(Color.WHITE);
        verTabla();
    }
   public void verTabla(){
           int nRegistros=0;
           int nbina=0;
           int tobi=0;
              DefaultTableModel miModelo=new DefaultTableModel();
              miModelo.addColumn("Matricula");
              miModelo.addColumn("Nombre");
              miModelo.addColumn("Edad");
              miModelo.addColumn("Grado");
              miModelo.addColumn("Monto");
              miModelo.addColumn("Estado Escolar");

              int total=0;
              String matri="",matri2="";
              
              String []datos=new String[7];

              String bin="";

              String  sql="SELECT * FROM alumno";
              String sqlg="SELECT * FROM grado";
              
                 try {
                 Statement sentencia= reg.createStatement();
                 ResultSet rsa= sentencia.executeQuery(sql);
                 
                 Statement sentenciag= reg.createStatement();
                 ResultSet rsag= sentenciag.executeQuery(sqlg);
                 
                 Statement sentencia1= reg.createStatement();
                 ResultSet rsaq= sentencia1.executeQuery(sql);
                
                 
                rsaq=sentencia1.executeQuery("SELECT count(*) as total  FROM alumno");
                if(rsaq.next())
                nRegistros=Integer.parseInt(rsaq.getString("total"));
                else
                nRegistros=0;
        
 
//                while(rsag.next()){
//                    datos[3]=rsag.getString(4);
//               datos[4]=rsag.getString(5);
//                
//                }
//                
                
                 while (rsa.next() ) {

               datos[0]=rsa.getString(1);//campos de la tabla de la base de datos
               datos[1]=rsa.getString(2);
               datos[2]=rsa.getString(3);
               datos[3]=rsa.getString(5);
               
               datos[5]=rsa.getString(7);
               

                     System.out.println(datos[0]+" "+datos[1]+" "+datos[2]+" "+datos[3]+" "+datos[4]+" ");
               String idg=datos[3];
               if(idg.equals("1")){
                   datos[3]="1° Primaria";
                   datos[4]="1500";
               }
               if(idg.equals("2")){
                   datos[3]="2° Primaria";
                   datos[4]="1500";
               }
              if(idg.equals("3")){
                   datos[3]="3° Primaria";
                   datos[4]="1500";
               }
               if(idg.equals("4")){
                   datos[3]="4° Primaria";
                   datos[4]="2000";
               }
               if(idg.equals("5")){
                   datos[3]="5° Primaria";
                   datos[4]="2000";
               }
                if(idg.equals("6")){
                   datos[3]="6° Primaria";
                   datos[4]="2000";
               }
                if(idg.equals("7")){
                   datos[3]="1° Secundaria";
                   datos[4]="2500";
               }
                if(idg.equals("8")){
                   datos[3]="2° Secundaria";
                   datos[4]="2500";
               }
                if(idg.equals("9")){
                   datos[3]="3° Secundaria";
                   datos[4]="2500";
               }
                if(idg.equals("10")){
                   datos[3]="1° Preparatoria";
                   datos[4]="3000";
               }
                if(idg.equals("11")){
                   datos[3]="1° Preparatoria";
                   datos[4]="3000";
               }
                if(idg.equals("12")){
                   datos[3]="1° Preparatoria";
                   datos[4]="3000";
               }
               
               String bina=datos[5];
                     System.out.println("bina"+bina);
               
               if(bina.equals("1")){
                   String a="Activo";
                   datos[5]=a;
               }else if(bina.equals("0")){
                   String b="Baja";
                   datos[5]=b;
               }

                String gan=datos[4];
                
                System.out.println("gan"+gan);
                int ganan=Integer.parseInt(gan);
                int ganancias=(ganan);
                
                total+=ganancias;

               
               miModelo.addRow(datos);

               
               
                 
                 }
                 
                }catch (SQLException ex) {
                Logger.getLogger(Primaria.class.getName()).log(Level.SEVERE, null, ex);
                }
                 tabla.setModel(miModelo);
                 
                String t=String.valueOf(total);
                String n=String.valueOf(nRegistros);
                num.setText("El total de alumno es: "+n );
               totall.setText("Tenemos una ganancia de $"+t);
               
                 System.out.println("hola"+total);
                 
                

                 
            }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        num = new javax.swing.JLabel();
        totall = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 30)); // NOI18N
        jLabel1.setText("Datos Generales");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tabla);

        num.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        num.setText("En la base de datos hay un total de: ");

        totall.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        totall.setText("Tenemos una ganancia de $");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 680, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(237, 237, 237))
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(totall, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(num, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(51, 51, 51)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(num)
                .addGap(18, 18, 18)
                .addComponent(totall)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dg.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dg().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel num;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel totall;
    // End of variables declaration//GEN-END:variables
}
