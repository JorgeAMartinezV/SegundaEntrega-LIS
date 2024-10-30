package views.adminArticulos;

import utilidades.Utilidades;
import java.util.ArrayList;
import java.util.LinkedList;
import models.Articulo;
import models.Conferencia;
import services.ArticuloServices;
import services.ConferenciaServices;

/**
 *
 * @author HSVSTT2
 */
public class VtnRegistrarArticulo extends javax.swing.JFrame {

    private ArticuloServices articleServices;
    private ConferenciaServices conferenceServices;
    
    public VtnRegistrarArticulo(ArticuloServices articleServices, ConferenciaServices conferenceServices) {
        initComponents();
        this.articleServices = articleServices;
        this.conferenceServices = conferenceServices;
        cargarConferencias();
    }
    
    public void cargarConferencias()
    {
        ArrayList<Conferencia> conferencias = (ArrayList<Conferencia>) this.conferenceServices.findAll();
         for (int i = 0; i < conferencias.size(); i++) {
            this.jComboBoxConferencia.addItem(conferencias.get(i));
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        JLabelResumen = new javax.swing.JLabel();
        jTextFieldTitulo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextAreaResumen = new javax.swing.JTextArea();
        jButtonRegistrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jComboBoxConferencia = new javax.swing.JComboBox<>();
        jLabelRevista = new javax.swing.JLabel();
        jTextFieldRevista = new javax.swing.JTextField();
        jLabelPalabrasClave = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextAreaPalabras = new javax.swing.JTextArea();
        jLabelCantAut = new javax.swing.JLabel();
        jTextFieldCantAut = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setText("Registrar articulo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(231, 231, 231)
                .addComponent(jLabel3)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel3)
                .addContainerGap(49, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 603, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel1.setText("Titulo:");

        JLabelResumen.setText("Resumen");

        jTextAreaResumen.setColumns(20);
        jTextAreaResumen.setRows(5);
        jScrollPane1.setViewportView(jTextAreaResumen);

        jButtonRegistrar.setText("Registrar");
        jButtonRegistrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegistrarActionPerformed(evt);
            }
        });

        jLabel4.setText("Conferencia:");

        jComboBoxConferencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxConferenciaActionPerformed(evt);
            }
        });

        jLabelRevista.setText("Revista:");

        jLabelPalabrasClave.setText("Palabras clave:");

        jTextAreaPalabras.setColumns(20);
        jTextAreaPalabras.setRows(5);
        jScrollPane2.setViewportView(jTextAreaPalabras);

        jLabelCantAut.setText("Cantidad de autores:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(102, 102, 102)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel4)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel1)
                        .addComponent(JLabelResumen)
                        .addComponent(jLabelRevista)
                        .addComponent(jLabelPalabrasClave)
                        .addComponent(jLabelCantAut)))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jComboBoxConferencia, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addComponent(jTextFieldTitulo)
                    .addComponent(jTextFieldRevista)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldCantAut))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRegistrar)
                .addGap(32, 32, 32))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRevista)
                    .addComponent(jTextFieldRevista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(JLabelResumen)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelPalabrasClave)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCantAut)
                    .addComponent(jTextFieldCantAut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jButtonRegistrar))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jComboBoxConferencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4)))
                .addContainerGap())
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRegistrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegistrarActionPerformed
        String titulo, revista, resumen, palabrasClave, cantAut;
        Integer cantAuth = 0;
        Conferencia objConferencia;
        boolean bandera;
        
        titulo = this.jTextFieldTitulo.getText();
        revista = this.jTextAreaResumen.getText();
        resumen = this.jTextAreaResumen.getText();
        palabrasClave = this.jTextAreaPalabras.getText();
        cantAut = this.jTextFieldCantAut.getText();
        objConferencia = (Conferencia) this.jComboBoxConferencia.getSelectedItem();
        
        try {
            cantAuth = Integer.parseInt(cantAut);
            if(cantAuth <= 0) {
                throw new Exception();
            }
        } catch (Exception ex) {
                Utilidades.mensajeAdvertencia("La cantidad de autores debe ser un numero positivo", "Cantidad de autores incorrecta");
        }
        
        Articulo objArticulo = new Articulo(titulo, revista, resumen, palabrasClave, cantAuth);
        
        this.articleServices.storeArticle(objArticulo);
        
        if(!objArticulo.equals(null))
        {
            Utilidades.mensajeExito("Registro exitoso", "Registro exitoso");
            setVisible(false);
        }
        else
        {
            Utilidades.mensajeError("Articulo no almacenado","Error al almacenar el articulo");
        }
    }//GEN-LAST:event_jButtonRegistrarActionPerformed

    private void jComboBoxConferenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxConferenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboBoxConferenciaActionPerformed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel JLabelResumen;
    private javax.swing.JButton jButtonRegistrar;
    private javax.swing.JComboBox<Conferencia> jComboBoxConferencia;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelCantAut;
    private javax.swing.JLabel jLabelPalabrasClave;
    private javax.swing.JLabel jLabelRevista;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextAreaPalabras;
    private javax.swing.JTextArea jTextAreaResumen;
    private javax.swing.JTextField jTextFieldCantAut;
    private javax.swing.JTextField jTextFieldRevista;
    private javax.swing.JTextField jTextFieldTitulo;
    // End of variables declaration//GEN-END:variables
}
