
package integradorjava;

import BaseDatos.ConexionMySQL;
import java.net.ConnectException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.plaf.synth.SynthOptionPaneUI;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author  Sack Ceppi Mariel
 */
public class Socio extends javax.swing.JFrame {
DefaultTableModel modelo;
    public Socio() {
        initComponents();
        CargarTablaSocio("");
        txtDias.setEnabled(false); 
        btnGuardar.setEnabled(false);
         Inhabilitar();
         tablaSocio.setEnabled(false);
        
    }
    void Inhabilitar()
    {
        txtDni.setEnabled(false);
        txtDias.setEnabled(false);
        txtAreaCarrera.setEnabled(false);
        txtNombre.setEnabled(false);
        cboRol.setEnabled(false);
        
    }
    void Habilitar()
    {
        txtDni.setEnabled(true);
        
        txtAreaCarrera.setEnabled(true);
        txtNombre.setEnabled(true);
        cboRol.setEnabled(true);
        
    }
    void CargarTablaSocio(String valor)
    {
        String[] titulos = {"n° socio","dni","nombre","rol","area/carrera","dias","cant Prestamos"};
        String [] registro = new String[7];
        String sql= "";
        modelo= new DefaultTableModel(null,titulos);
        //para q me cintroduca datos al principio
        ConexionMySQL mysql= new ConexionMySQL();
        Connection cn= mysql.Conectar();
        
        sql="select socionum, dni, nombre, rol, caracteristica, diasPrestamo, cantPrestamos from socio "
                + "where concat(socionum,' ',nombre,' ',dni) like '%"+ valor+"%'"; //para q me busque todos los tipos de coincidencia
        try
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //rs es una matriz q puedo recorrer
            while(rs.next())
            {
                registro[0]= rs.getString("socionum");
                registro[1]= rs.getString("dni");
                registro[2]= rs.getString("nombre");
                registro[3]= rs.getString("rol");
                registro[4]= rs.getString("caracteristica");
                registro[5]= rs.getString("diasPrestamo");
                registro[6]= rs.getString("cantPrestamos");
                modelo.addRow(registro);//agrego ese arreglo a la table para q se muestre
            }
            tablaSocio.setModel(modelo);
            
        } 
        catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null, ex);
        }
        
       
       
       
       
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlSocio = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtAreaCarrera = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtDni = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtDias = new javax.swing.JTextField();
        cboRol = new javax.swing.JComboBox();
        PnlSocioVista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaSocio = new javax.swing.JTable();
        txtBuscarSocio = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBuscarSocio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PnlSocio.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Socio"));

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel1.setText("Nombre");

        jLabel2.setText("Rol");

        jLabel3.setText("Area/Carrera");

        txtNombre.setText(" ");
        txtNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNombreActionPerformed(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        txtAreaCarrera.setText(" ");
        txtAreaCarrera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAreaCarreraKeyTyped(evt);
            }
        });

        jLabel5.setText("Dni");

        txtDni.setText(" ");
        txtDni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDniActionPerformed(evt);
            }
        });
        txtDni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtDniKeyTyped(evt);
            }
        });

        jLabel6.setText("Dias Prestamo");

        txtDias.setText(" ");

        cboRol.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Docente", "Alumno" }));
        cboRol.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboRolActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlSocioLayout = new javax.swing.GroupLayout(PnlSocio);
        PnlSocio.setLayout(PnlSocioLayout);
        PnlSocioLayout.setHorizontalGroup(
            PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PnlSocioLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnNuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGuardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(PnlSocioLayout.createSequentialGroup()
                        .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5))
                        .addGap(41, 41, 41)
                        .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDni)
                            .addComponent(txtAreaCarrera)
                            .addComponent(txtNombre)
                            .addComponent(cboRol, 0, 275, Short.MAX_VALUE))
                        .addGap(53, 53, 53)
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37)
                        .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PnlSocioLayout.setVerticalGroup(
            PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtDni, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(txtDias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cboRol, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtAreaCarrera, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PnlSocioVista.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de Socios"));

        tablaSocio.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaSocio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaSocio);

        txtBuscarSocio.setText(" ");

        jLabel4.setText("Nombre del Socio");

        btnBuscarSocio.setText("Buscar Socio");
        btnBuscarSocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarSocioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlSocioVistaLayout = new javax.swing.GroupLayout(PnlSocioVista);
        PnlSocioVista.setLayout(PnlSocioVistaLayout);
        PnlSocioVistaLayout.setHorizontalGroup(
            PnlSocioVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlSocioVistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlSocioVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(PnlSocioVistaLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(txtBuscarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        PnlSocioVistaLayout.setVerticalGroup(
            PnlSocioVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlSocioVistaLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(PnlSocioVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnBuscarSocio))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PnlSocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PnlSocioVista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PnlSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(PnlSocioVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDniActionPerformed
    txtDni.isValidateRoot();
        txtDni.transferFocus(); 
    // TODO add your handling code here:
    }//GEN-LAST:event_txtDniActionPerformed

    private void txtNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNombreActionPerformed
    txtNombre.transferFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreActionPerformed

    private void cboRolActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboRolActionPerformed
    if (cboRol.getSelectedItem().toString()== "Alumno" )
    {   txtDias.setText("3");  }
    if (cboRol.getSelectedItem().toString()== "Docente" )
    { txtDias.setText("15"); }
    }//GEN-LAST:event_cboRolActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
    this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        Habilitar();
    btnGuardar.setEnabled(true);   
    txtDni.setText("");
    txtDias.setText("");
    txtNombre.setText("");
    txtAreaCarrera.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed
String accion= "Insertar";
    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
       ConexionMySQL mysql= new ConexionMySQL();
       Connection cn= mysql.Conectar();
       String p_rol,p_caracteristica,p_nombre,p_numSocio, p_dias,p_cant,p_dni;//p_ indica q son parametros q utilizare, contendran los valores q se capten del formu
       
       String sql ="";
       p_dni= txtDni.getText();
       p_nombre = txtNombre.getText();
       p_rol= cboRol.getSelectedItem().toString();
       p_caracteristica= txtAreaCarrera.getText();
       p_dias= txtDias.getText();
       p_cant="0";
       sql= "insert into socio(dni , nombre , rol , caracteristica , diasPrestamo , cantPrestamos)"
               + "values(?,?,?,?,?,?)";
       String mensaje = "El nuevo Socio se ha cargado de manera Satisfactoria...";
       try {
       
        
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, p_dni);//considera desde el 0 pero el campo 0 es incremental
            pst.setString(2, p_nombre);
            pst.setString(3, p_rol);
            pst.setString(4, p_caracteristica);
            pst.setString(5, p_dias);
            pst.setString(6, p_cant);
            int n = pst.executeUpdate();
            if(n> 0)
            {
                JOptionPane.showMessageDialog(null,mensaje);
            }
              
            
        } 
       catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
       
       
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnBuscarSocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarSocioActionPerformed
            CargarTablaSocio(txtBuscarSocio.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarSocioActionPerformed

    private void txtDniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtDniKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume(); 
    }//GEN-LAST:event_txtDniKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
       char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume(); // TODO add your handling code here:
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtAreaCarreraKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAreaCarreraKeyTyped
        char car = evt.getKeyChar();
        if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
    }//GEN-LAST:event_txtAreaCarreraKeyTyped

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
            java.util.logging.Logger.getLogger(Socio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Socio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Socio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Socio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Socio().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlSocio;
    private javax.swing.JPanel PnlSocioVista;
    private javax.swing.JButton btnBuscarSocio;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox cboRol;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaSocio;
    private javax.swing.JTextField txtAreaCarrera;
    private javax.swing.JTextField txtBuscarSocio;
    private javax.swing.JTextField txtDias;
    private javax.swing.JTextField txtDni;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
