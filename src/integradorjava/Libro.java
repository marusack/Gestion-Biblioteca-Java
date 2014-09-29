/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integradorjava;

import BaseDatos.ConexionMySQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author mariel
 */
public class Libro extends javax.swing.JFrame {
DefaultTableModel modelo;
    
    public Libro() {
        initComponents();
        btnGuardar.setEnabled(false);
        inhabilitarForm();
        CargarTablaLibro("");
        tablaLibro.setEnabled(false);
        
    }
    void inhabilitarForm()
    {
        txtIsbn.setEditable(false);
        txtTitulo.setEditable(false);
        txtEdicion.setEditable(false);
        txtEditorial.setEditable(false);
        txtAño.setEditable(false);
                
    }
     void habilitarForm()
    {
        txtIsbn.setEditable(true);
        txtTitulo.setEditable(true);
        txtEdicion.setEditable(true);
        txtEditorial.setEditable(true);
        txtAño.setEditable(true);
                
    }
public void CargarTablaLibro(String valor)
    {
        String[] titulos = {"isbn","titulo","ediciones","editorial","año","estado"};
        String [] registro = new String[7];
        String sql= "";
        modelo= new DefaultTableModel(null,titulos);
        //para q me cintroduca datos al principio
        ConexionMySQL mysql= new ConexionMySQL();
        Connection cn= mysql.Conectar();
        
        sql="select isbn , titulo , ediciones , editorial , año , estado from libro "
                + "where concat(isbn,' ',titulo,' ',editorial) like '%"+ valor+"%'"; //para q me busque todos los tipos de coincidencia
        try
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //rs es una matriz q puedo recorrer
            while(rs.next())
            {
                registro[0]= rs.getString("isbn");
                registro[1]= rs.getString("titulo");
                registro[2]= rs.getString("ediciones");
                registro[3]= rs.getString("editorial");
                registro[4]= rs.getString("año");
                registro[5]= rs.getString("estado");
               
                modelo.addRow(registro);//agrego ese arreglo a la table para q se muestre
            }
            tablaLibro.setModel(modelo);
            
        } 
        catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null, ex);
        }
        
       
       
       
       
       
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PnlSocioVista = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibro = new javax.swing.JTable();
        txtBuscarLibro = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnBuscarLibro = new javax.swing.JButton();
        PnlSocio = new javax.swing.JPanel();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTitulo = new javax.swing.JTextField();
        txtEdicion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtIsbn = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txtAño = new javax.swing.JTextField();
        txtEditorial = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        PnlSocioVista.setBorder(javax.swing.BorderFactory.createTitledBorder("Consulta de Libros"));

        tablaLibro.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tablaLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaLibro);

        txtBuscarLibro.setText(" ");
        txtBuscarLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarLibroKeyTyped(evt);
            }
        });

        jLabel4.setText("Nombre del Libro");

        btnBuscarLibro.setText("Buscar Libro");
        btnBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLibroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PnlSocioVistaLayout = new javax.swing.GroupLayout(PnlSocioVista);
        PnlSocioVista.setLayout(PnlSocioVistaLayout);
        PnlSocioVistaLayout.setHorizontalGroup(
            PnlSocioVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlSocioVistaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlSocioVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 625, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PnlSocioVistaLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(27, 27, 27)
                        .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarLibro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        PnlSocioVistaLayout.setVerticalGroup(
            PnlSocioVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlSocioVistaLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(PnlSocioVistaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(btnBuscarLibro))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 196, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PnlSocio.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Libro"));

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

        jLabel1.setText("Titulo :");

        jLabel2.setText("Editorial:");

        jLabel3.setText("Edicion :");

        txtTitulo.setText(" ");
        txtTitulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTituloActionPerformed(evt);
            }
        });

        txtEdicion.setText("      ");
        txtEdicion.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEdicionKeyTyped(evt);
            }
        });

        jLabel5.setText("Isbn  :");

        txtIsbn.setText(" ");
        txtIsbn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtIsbnActionPerformed(evt);
            }
        });
        txtIsbn.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtIsbnKeyTyped(evt);
            }
        });

        jLabel6.setText("Año :");

        txtAño.setText(" ");
        txtAño.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAñoActionPerformed(evt);
            }
        });
        txtAño.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAñoKeyTyped(evt);
            }
        });

        txtEditorial.setText("       ");
        txtEditorial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEditorialKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout PnlSocioLayout = new javax.swing.GroupLayout(PnlSocio);
        PnlSocio.setLayout(PnlSocioLayout);
        PnlSocioLayout.setHorizontalGroup(
            PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlSocioLayout.createSequentialGroup()
                .addGap(166, 166, 166)
                .addComponent(btnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnGuardar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCancelar))
            .addGroup(PnlSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6))
                .addGap(41, 41, 41)
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtAño)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.DEFAULT_SIZE, 275, Short.MAX_VALUE)
                    .addComponent(txtEdicion)
                    .addComponent(txtTitulo)
                    .addComponent(txtEditorial, javax.swing.GroupLayout.Alignment.TRAILING)))
        );
        PnlSocioLayout.setVerticalGroup(
            PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PnlSocioLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtEditorial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtEdicion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtAño, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(PnlSocioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar)
                    .addComponent(btnNuevo)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PnlSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PnlSocioVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(PnlSocioVista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(PnlSocio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLibroActionPerformed
        CargarTablaLibro(txtBuscarLibro.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarLibroActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        ConexionMySQL mysql= new ConexionMySQL();
        Connection cn= mysql.Conectar();
        String p_isbn,p_titulo,p_edicion,p_editorial,p_año,p_estado;//p_ indica q son parametros q utilizare, contendran los valores q se capten del formu

        String sql ="";
        p_isbn= txtIsbn.getText();
        p_titulo = txtTitulo.getText();
        p_edicion= txtEdicion.getText();
        p_editorial= txtEditorial.getText();
        p_año= txtAño.getText();
        p_estado="libre";
        sql= "insert into libro(isbn , titulo , ediciones , editorial , año , estado) "
        + "values(?,?,?,?,?,?)";
        String mensaje = "El nuevo Libro se ha cargado de manera Satisfactoria...";
        try {

            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, p_isbn);//considera desde el 0 pero el campo 0 es incremental
            pst.setString(2, p_titulo);
            pst.setString(3, p_edicion);
            pst.setString(4, p_editorial);
            pst.setString(5, p_año);
            pst.setString(6, p_estado);
            int n = pst.executeUpdate();
            if(n> 0)
            {
                JOptionPane.showMessageDialog(null,mensaje);
            }

        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        inhabilitarForm();
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        habilitarForm();
        btnGuardar.setEnabled(true);
        txtIsbn.setText("");
        txtAño.setText("");
        txtTitulo.setText("");
        txtEdicion.setText("");
        txtEditorial.setText("");
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtTituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTituloActionPerformed
        txtTitulo.transferFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_txtTituloActionPerformed

    private void txtIsbnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtIsbnActionPerformed
     
        txtIsbn.transferFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtIsbnActionPerformed

    private void txtAñoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAñoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAñoActionPerformed

    private void txtIsbnKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtIsbnKeyTyped
char car = evt.getKeyChar();
if((car<'0' || car>'9')) evt.consume();      
    }//GEN-LAST:event_txtIsbnKeyTyped

    private void txtEdicionKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEdicionKeyTyped
char car = evt.getKeyChar();
if((car<'0' || car>'9')) evt.consume();         // TODO add your handling code here:
    }//GEN-LAST:event_txtEdicionKeyTyped

    private void txtAñoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAñoKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume(); 
    }//GEN-LAST:event_txtAñoKeyTyped

    private void txtEditorialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEditorialKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtEditorialKeyTyped

    private void txtBuscarLibroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarLibroKeyTyped
    char car = evt.getKeyChar();
    if((car<'a' || car>'z') && (car<'A' || car>'Z')) evt.consume();
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarLibroKeyTyped

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
            java.util.logging.Logger.getLogger(Libro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Libro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Libro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Libro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Libro().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PnlSocio;
    private javax.swing.JPanel PnlSocioVista;
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaLibro;
    private javax.swing.JTextField txtAño;
    private javax.swing.JTextField txtBuscarLibro;
    private javax.swing.JTextField txtEdicion;
    private javax.swing.JTextField txtEditorial;
    private javax.swing.JTextField txtIsbn;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables
}
