package views.adminArticulos;

import utilidades.Utilidades;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import models.Articulo;
import models.Conferencia;
import services.ArticuloServices;
import services.ConferenciaServices;

public class VtnListarArticulos extends javax.swing.JInternalFrame {
    public ArticuloServices articleService;
    public ConferenciaServices conferenceServices;
    
    public VtnListarArticulos(ArticuloServices articleService, ConferenciaServices conferenceServices) {
        initComponents();
        this.articleService = articleService;
        this.conferenceServices = conferenceServices;
        this.jTableListarArticulos.setDefaultRenderer(Object.class, new Render());
        inicializarTabla();
    }

     private void inicializarTabla()
    {
       DefaultTableModel model= new DefaultTableModel();       
       model.addColumn("Id");       
       model.addColumn("Titulo");
       model.addColumn("Revista");
       model.addColumn("Resumen");
       model.addColumn("Palabras clave");
       model.addColumn("Cantidad de autores");
       model.addColumn("Eliminar");
       model.addColumn("Actualizar");       
       this.jTableListarArticulos.setModel(model);
    }
     
     public void limpiarTabla(){
        DefaultTableModel modelo=(DefaultTableModel) this.jTableListarArticulos.getModel();
        int filas=this.jTableListarArticulos.getRowCount();
        for (int i = 0;filas>i; i++) {
            modelo.removeRow(0);
        }        
    }
     
    private void llenarTabla()
    {
        DefaultTableModel model=(DefaultTableModel) this.jTableListarArticulos.getModel();
        limpiarTabla();
        ArrayList<Articulo> listaArticulos = (ArrayList<Articulo>) this.articleService.findAll();
        
        JButton JButtonEliminarArticulo = new JButton();
        JButtonEliminarArticulo.setName("Eliminar");
        JButtonEliminarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/remove.png")));

        JButton JButtonActualizarArticulo = new JButton();
        JButtonActualizarArticulo.setName("Actualizar");
        JButtonActualizarArticulo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/aplicar.png")));

            
        for (int i = 0; i < listaArticulos.size(); i++) {
            Object [] fila= { 
                listaArticulos.get(i).getId(),
                listaArticulos.get(i).getTitle(),
                listaArticulos.get(i).getJournal(),
                listaArticulos.get(i).getAbstractText(),
                listaArticulos.get(i).getKeywords(),
                listaArticulos.get(i).getCantAuthors(),
                JButtonEliminarArticulo,
                JButtonActualizarArticulo};
            model.addRow(fila);
        }
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableListarArticulos = new javax.swing.JTable();
        jButtonRegistrar = new javax.swing.JButton();
        jButtonActalizar = new javax.swing.JButton();

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Gestionar articulos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(206, 206, 206)
                .addComponent(jLabel1)
                .addContainerGap(220, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addContainerGap(55, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setForeground(new java.awt.Color(0, 0, 153));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 586, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel3.setForeground(new java.awt.Color(0, 0, 153));

        jTableListarArticulos.setModel(new javax.swing.table.DefaultTableModel(
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
        jTableListarArticulos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableListarArticulosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableListarArticulos);

        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jButtonActalizar.setText("Actualizar");
        jButtonActalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jButtonActalizar)
                .addGap(291, 291, 291)
                .addComponent(jButtonRegistrar)
                .addContainerGap(76, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegistrar)
                    .addComponent(jButtonActalizar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActalizarActionPerformed
       llenarTabla();
    }//GEN-LAST:event_jButtonActalizarActionPerformed

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        VtnRegistrarArticulo objVtnRegistrarArticulo=new VtnRegistrarArticulo(articleService, conferenceServices);
        objVtnRegistrarArticulo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        objVtnRegistrarArticulo.setVisible(true);
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jTableListarArticulosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableListarArticulosMouseClicked
        
        int column = this.jTableListarArticulos.getColumnModel().getColumnIndexAtX(evt.getX());
        int row = evt.getY()/jTableListarArticulos.getRowHeight();
        
        if(row < jTableListarArticulos.getRowCount() && row >= 0 && column < jTableListarArticulos.getColumnCount() && column >= 0){
            Object value = jTableListarArticulos.getValueAt(row, column);
            
            if(value instanceof JButton){
                
                ((JButton)value).doClick();
                JButton boton = (JButton) value;
                
                String idArticulo = jTableListarArticulos.getValueAt(row, 0).toString();
                int idArticuloConvertido = Integer.parseInt(idArticulo);
                if(boton.getName().equals("Eliminar")){
                    try{  
                        if(Utilidades.mensajeConfirmacion("¿ Estás seguro de que quieres eliminar el artículo con identificador " + idArticulo + " " 
                            +" ?", "Confirmación") == 0){
                           boolean bandera = this.articleService.delete(idArticuloConvertido);
                           if(bandera==true)
                           {
                               Utilidades.mensajeAdvertencia("El artículo con identificador " + idArticuloConvertido + " no fue eliminado", "Error al eliminar");
                           }
                           else
                           {
                               Utilidades.mensajeExito("El articulo con identificador " + idArticuloConvertido + " fue eliminado exitosamente", "Articulo eliminado");
                               llenarTabla();
                           }
                        }
                    }catch(Exception ex){
                        Utilidades.mensajeError("Error al eliminar usuario. Intentelo de nuevo más tarde", "Error");
                    }  
                }
                else if(boton.getName().equals("Actualizar")){
                    VtnActualizarArticulo objVtnActualizarArticulo= 
                            new VtnActualizarArticulo(articleService);
                    objVtnActualizarArticulo.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    objVtnActualizarArticulo.cargarDatos(idArticuloConvertido);
                    objVtnActualizarArticulo.setVisible(true);
                            
                }
            }
        }
        
        
    }//GEN-LAST:event_jTableListarArticulosMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActalizar;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableListarArticulos;
    // End of variables declaration//GEN-END:variables
}
