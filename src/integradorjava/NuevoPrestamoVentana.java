/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package integradorjava;

import BaseDatos.ConexionMySQL;
import java.awt.event.KeyEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
/**
 *
 * @author mariel
 */
public class NuevoPrestamoVentana extends javax.swing.JFrame {
DefaultTableModel modelo;
public String dni,cant,nombre,isbn,titulo,num,estado;

    public NuevoPrestamoVentana() {
        initComponents();
        CargarTablaSocio("");
        CargarTablaLibro("");
        inhabilitarPrestamoComp();
        
        
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
        int a=1;
        sql="select socionum, dni, nombre, rol, caracteristica, diasPrestamo, cantPrestamos from socio "
                + "where concat(socionum,' ',nombre,' ',dni) like '%"+ valor+"%'"; //para q me busque todos los tipos de coincidencia
        try
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //rs es una matriz q puedo recorrer
            while(rs.next())
            {
                if (a==1)
                {
                    a= a+1;
                    num=rs.getString("socionum");
                    dni=rs.getString("dni");
                    nombre=rs.getString("nombre");
                    cant=rs.getString("cantPrestamos");
                    
                    
                }
                registro[0]= rs.getString("socionum");
                registro[1]= rs.getString("dni");
                registro[2]= rs.getString("nombre");
                registro[3]= rs.getString("rol");
                registro[4]= rs.getString("caracteristica");
                registro[5]= rs.getString("diasPrestamo");
                registro[6]= rs.getString("cantPrestamos");
                modelo.addRow(registro);//agrego ese arreglo a la table para q se muestre
            }
            tblSocio.setModel(modelo);
            
        } 
        catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null, ex);
        }
        
       
       
       
       
       
    }
    void inhabilitarPrestamoComp()//inhabilita los campos del comprobante de prestamo
    {
        txtEstado.setEditable(false);
        txtSocio.setEditable(false);
        txtCompDNI.setEditable(false);
        txtCompCant.setEditable(false);
        txtCompNom.setEditable(false);
        txtComIsbn.setEditable(false);
        txtComTitulo.setEditable(false);
        txtFecha.setEditable(false);
    }
    void CargarTablaLibro(String valor)
    {
        String[] titulos = {"isbn","titulo","ediciones","editorial","año","estado"};
        String [] registro = new String[7];
        String sql= "";
        modelo= new DefaultTableModel(null,titulos);
        //para q me cintroduca datos al principio
        ConexionMySQL mysql= new ConexionMySQL();
        Connection cn= mysql.Conectar();
        Integer a =1;
        sql="select isbn , titulo , ediciones , editorial , año , estado from libro "
                + "where concat(isbn,' ',titulo,' ',editorial) like '%"+ valor+"%'"; //para q me busque todos los tipos de coincidencia
        try
        {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            //rs es una matriz q puedo recorrer
            
            while(rs.next())
            {
                if (a==1)
            {
                a=a+1;
                isbn= rs.getString("isbn");
                titulo= rs.getString("titulo");
                estado= rs.getString("estado");
                
        
            }
                registro[0]= rs.getString("isbn");
                registro[1]= rs.getString("titulo");
                registro[2]= rs.getString("ediciones");
                registro[3]= rs.getString("editorial");
                registro[4]= rs.getString("año");
                registro[5]= rs.getString("estado");
               
                modelo.addRow(registro);//agrego ese arreglo a la table para q se muestre
            }
            tblLibro.setModel(modelo);
            
        } 
        catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null, ex);
        }
       
    }
    void ActualizarLibroPorPrestamo(String isbn)
    {
        ConexionMySQL mysql= new ConexionMySQL();
        Connection cn= mysql.Conectar();
        String sql= "";
        sql= "update libro set estado = ? where isbn = "+Integer.valueOf(isbn);
         try{
            PreparedStatement pst = cn.prepareStatement(sql);
            
            pst.setString(1, "PRESTADO");
             int n =pst.executeUpdate();
            
            if(n>0){
            JOptionPane.showMessageDialog(null, "El libro pasara a estado prestado");
            CargarTablaSocio("");
            CargarTablaLibro("");
            }
           
}
        catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null, ex);
        }
        
       
       
        
    }
    void ActualisarSocioPorPrestamo( String socio)
    {
        ConexionMySQL mysql= new ConexionMySQL();
        Connection cn= mysql.Conectar();
  
        String sql="";
       Integer cantidad= Integer.valueOf(txtCompCant.getText());
        cantidad= cantidad+1;
       String cant= String.valueOf(cantidad);
       sql="update socio "
                + "set cantPrestamos = ?  "
                +"where socionum = "+Integer.valueOf(socio);
        
        try{
            PreparedStatement pst = cn.prepareStatement(sql);
            String can =String.valueOf(cantidad);
            pst.setString(1, can);
             int n =pst.executeUpdate();
            
            if(n>0){
            JOptionPane.showMessageDialog(null, "se modifico el socio");
            CargarTablaSocio("");
            CargarTablaLibro("");
            }
           
}
        catch (SQLException ex)
        {
           JOptionPane.showMessageDialog(null, ex);
        }
        
       
       
        
    }
    void HablilitarSeleccion()//seleccion de libro y socio
    {
       txtBuscarLibro.setEnabled(true);
        txtBusquedaSocio.setEnabled(true);
        txtBuscarLibro.setEnabled(true);
        txtBusquedaSocio.setEnabled(true);
        btnBuscarLibro.setEnabled(true);
        btnBuscarsocio.setEnabled(true); 
        tblLibro.setVisible(true);
        tblSocio.setVisible(true);
    }
    void DeshabilitarSeleccion() //seleccion de libro y socio
            
    {   txtBuscarLibro.setText("");
        txtBusquedaSocio.setText("");
        txtBuscarLibro.setEnabled(false);
        txtBusquedaSocio.setEnabled(false);
        tblLibro.setVisible(false);
        tblSocio.setVisible(false);
        btnBuscarLibro.setEnabled(false);
        btnBuscarsocio.setEnabled(false);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Prestamo = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        btnBuscarLibro = new javax.swing.JButton();
        txtBuscarLibro = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblLibro = new javax.swing.JTable();
        Prestamo1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        txtBusquedaSocio = new javax.swing.JTextField();
        btnBuscarsocio = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSocio = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtCompDNI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCompNom = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtCompCant = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtComIsbn = new javax.swing.JTextField();
        txtComTitulo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        txtSocio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();
        btnCancelar = new javax.swing.JButton();
        btnGuardarPrestamo = new javax.swing.JButton();
        btnNuevoPrestamo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Prestamo.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Prestamo"));
        Prestamo.setToolTipText("");

        jLabel2.setText("Buscar Libro");

        btnBuscarLibro.setText("Buscar");
        btnBuscarLibro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarLibroActionPerformed(evt);
            }
        });

        txtBuscarLibro.setText(" ");
        txtBuscarLibro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarLibroKeyTyped(evt);
            }
        });

        tblLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblLibro.setEditingColumn(1);
        tblLibro.setEditingRow(1);
        tblLibro.getTableHeader().setReorderingAllowed(false);
        tblLibro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLibroMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblLibro);

        javax.swing.GroupLayout PrestamoLayout = new javax.swing.GroupLayout(Prestamo);
        Prestamo.setLayout(PrestamoLayout);
        PrestamoLayout.setHorizontalGroup(
            PrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrestamoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(12, 12, 12)
                .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnBuscarLibro)
                .addContainerGap())
            .addComponent(jScrollPane2)
        );
        PrestamoLayout.setVerticalGroup(
            PrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrestamoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PrestamoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtBuscarLibro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarLibro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49))
        );

        Prestamo1.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Prestamo"));
        Prestamo1.setToolTipText("");

        jLabel3.setText("Busccar Socio");

        txtBusquedaSocio.setText(" ");
        txtBusquedaSocio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBusquedaSocioKeyTyped(evt);
            }
        });

        btnBuscarsocio.setText("Buscar");
        btnBuscarsocio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarsocioActionPerformed(evt);
            }
        });

        tblSocio.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblSocio.setEditingColumn(1);
        tblSocio.setEditingRow(1);
        tblSocio.getTableHeader().setReorderingAllowed(false);
        tblSocio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSocioMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSocio);

        javax.swing.GroupLayout Prestamo1Layout = new javax.swing.GroupLayout(Prestamo1);
        Prestamo1.setLayout(Prestamo1Layout);
        Prestamo1Layout.setHorizontalGroup(
            Prestamo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Prestamo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Prestamo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(Prestamo1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBusquedaSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnBuscarsocio)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE))
                .addContainerGap())
        );
        Prestamo1Layout.setVerticalGroup(
            Prestamo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(Prestamo1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(Prestamo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBusquedaSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnBuscarsocio))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setText("Dni .");

        txtCompDNI.setText(" ");

        jLabel4.setText("Nombre :");

        txtCompNom.setText(" ");

        jLabel5.setText("Cantidad de Prestamos");

        txtCompCant.setText(" ");

        jLabel6.setText("Isbn :");

        jLabel7.setText("Titulo :");

        txtComIsbn.setText(" ");

        txtComTitulo.setText(" ");

        jLabel8.setText("Fecha de Retiro");

        txtFecha.setText(" ");

        jLabel9.setText("N° Socio:");

        txtSocio.setText(" ");

        jLabel10.setText("Estado :");

        txtEstado.setText(" ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCompDNI, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCompNom, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(34, 34, 34)
                        .addComponent(txtCompCant))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtFecha))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtSocio, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtComIsbn)
                            .addComponent(txtEstado)
                            .addComponent(txtComTitulo))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtSocio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtCompDNI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtCompNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtCompCant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtComIsbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtComTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28))
        );

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardarPrestamo.setText("Guardar");
        btnGuardarPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarPrestamoActionPerformed(evt);
            }
        });

        btnNuevoPrestamo.setText("Nuevo Prestamo");
        btnNuevoPrestamo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoPrestamoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(Prestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Prestamo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(btnNuevoPrestamo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardarPrestamo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardarPrestamo)
                    .addComponent(btnNuevoPrestamo))
                .addGap(19, 19, 19))
            .addGroup(layout.createSequentialGroup()
                .addComponent(Prestamo1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Prestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuardarPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarPrestamoActionPerformed
 ConexionMySQL mysql= new ConexionMySQL();
        Connection cn= mysql.Conectar();
        String fretiro,fdev,isbn,num;//p_ indica q son parametros q utilizare, contendran los valores q se capten del formu

        String sql ="";
        fretiro= txtFecha.getText();
        fdev = "nodevuelto";
        isbn= txtComIsbn.getText();
        num= txtSocio.getText();
        Integer cantPrestamos = Integer.valueOf(txtCompCant.getText());
        String estado= txtEstado.getText();
        if ((estado.equals("libre"))&&(cantPrestamos<3)){
        sql= "insert into prestamo(fretiro, fdevolucion , isbn , socio) "
        + "values(?,?,?,?) ";
        
        String mensaje = "El nuevo Prestamo se ha cargado de manera Satisfactoria...";
        
        try {
            ActualizarLibroPorPrestamo(isbn);
            ActualisarSocioPorPrestamo(num);    
            PreparedStatement pst = cn.prepareStatement(sql);
            pst.setString(1, fretiro);//considera desde el 0 pero el campo 0 es incremental
            pst.setString(2, fdev);
            pst.setString(3, isbn);
            pst.setString(4, num);
            int n = pst.executeUpdate();
            if(n> 0)
            {
                
                JOptionPane.showMessageDialog(null,mensaje);
            }

        }
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        }
        else{
            JOptionPane.showMessageDialog(null, "Error: la carga no se ha realizado por q el libro esta prestado o por q no le quedan prestamos disponibles");
        }
                
        
      DeshabilitarSeleccion();  
      limpiar();

    }//GEN-LAST:event_btnGuardarPrestamoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnBuscarsocioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarsocioActionPerformed
      CargarTablaSocio(txtBusquedaSocio.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarsocioActionPerformed

    private void tblSocioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSocioMouseClicked
//        txtSocio.setText(num);
//        txtCompDNI.setText(dni);
//        txtCompNom.setText(nombre);//incluyo los datos en un tercer panel para crear los prestamos
//        txtCompCant.setText(cant);
//       JOptionPane.showMessageDialog(null, "el socio se ha incorporado al comprobante");
           int row = tblSocio.rowAtPoint(tblSocio.getMousePosition());
   txtSocio.setText(tblSocio.getValueAt(row, 0).toString());
   txtCompDNI.setText(tblSocio.getValueAt(row, 1).toString());
   txtCompNom.setText(tblSocio.getValueAt(row, 2).toString());
   txtCompCant.setText(tblSocio.getValueAt(row, 6).toString());
    JOptionPane.showMessageDialog(null, "el socio se ha incorporado al comprobante");
    }//GEN-LAST:event_tblSocioMouseClicked

    private void tblLibroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLibroMouseClicked
        
         
//        txtComIsbn.setText(isbn);
//        txtComTitulo.setText(titulo);
//        txtEstado.setText(estado);
         int row = tblSocio.rowAtPoint(tblLibro.getMousePosition());
        txtComIsbn.setText(tblLibro.getValueAt(row, 0).toString());
        txtComTitulo.setText(tblLibro.getValueAt(row, 1).toString());
        txtEstado.setText(tblLibro.getValueAt(row, 5).toString());
        
        Date fecha=new Date(); 
        SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy"); 
        txtFecha.setText(sdf.format(fecha));
        JOptionPane.showMessageDialog(null, "el libro se ha incorporado al comprobante");
        
    }//GEN-LAST:event_tblLibroMouseClicked

    private void btnBuscarLibroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarLibroActionPerformed
    CargarTablaLibro(txtBuscarLibro.getText());
    }//GEN-LAST:event_btnBuscarLibroActionPerformed

    private void txtBusquedaSocioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBusquedaSocioKeyTyped
char car = evt.getKeyChar();
if((car<'a' || car>'z' ) && (car<'A' || car>'Z') && (car!= (char)KeyEvent.VK_SPACE)) evt.consume();
//char car = evt.getKeyChar();
//if((car<'0' || car>'9')) evt.consume();          // TODO add your handling code here:
    }//GEN-LAST:event_txtBusquedaSocioKeyTyped

    private void txtBuscarLibroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarLibroKeyTyped
//     char car = evt.getKeyChar();
//if((car<'a' || car>'z' ) && (car<'A' || car>'Z') && (car!= (char)KeyEvent.VK_SPACE)) evt.consume();   // solo letras
    }//GEN-LAST:event_txtBuscarLibroKeyTyped
public void limpiar(){
txtSocio.setText("");
    txtCompDNI.setText("");
    txtCompNom.setText("");
    txtCompCant.setText("");
    txtComIsbn.setText("");
    txtComTitulo.setText("");
    txtEstado.setText("");
    txtFecha.setText("");
}
    private void btnNuevoPrestamoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoPrestamoActionPerformed
    limpiar();
        HablilitarSeleccion();        // TODO add your handling code here:
    }//GEN-LAST:event_btnNuevoPrestamoActionPerformed

 
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoPrestamoVentana().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Prestamo;
    private javax.swing.JPanel Prestamo1;
    private javax.swing.JButton btnBuscarLibro;
    private javax.swing.JButton btnBuscarsocio;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardarPrestamo;
    private javax.swing.JButton btnNuevoPrestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tblLibro;
    private javax.swing.JTable tblSocio;
    private javax.swing.JTextField txtBuscarLibro;
    private javax.swing.JTextField txtBusquedaSocio;
    private javax.swing.JTextField txtComIsbn;
    private javax.swing.JTextField txtComTitulo;
    private javax.swing.JTextField txtCompCant;
    private javax.swing.JTextField txtCompDNI;
    private javax.swing.JTextField txtCompNom;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtFecha;
    private javax.swing.JTextField txtSocio;
    // End of variables declaration//GEN-END:variables
}
