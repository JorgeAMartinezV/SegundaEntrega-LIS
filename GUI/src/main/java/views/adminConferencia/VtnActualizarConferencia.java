/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package views.adminConferencia;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import models.Conferencia;
import services.ConferenciaServices;
import utilidades.Utilidades;

/**
 *
 * @author Jorge Varon
 */
public class VtnActualizarConferencia extends javax.swing.JFrame {
    
    private ConferenciaServices conferenciaServices;
    
    public VtnActualizarConferencia(ConferenciaServices conferenciaServices) {
        initComponents();
        this.conferenciaServices = conferenciaServices;
    }
    
    public void cargarDatos(int idConferencia)
    {
        Conferencia objConferencia = this.conferenciaServices.findById(idConferencia);
        this.jTextFieldId.setText(objConferencia.getId()+"");
        this.jTextFieldNombre.setText(objConferencia.getName());
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); 
        this.jTextFieldFechaInicio.setText(sdf.format(objConferencia.getStartDate()));
        this.jTextFieldFechaFin.setText(sdf.format(objConferencia.getEndDate()));
        this.jTextFieldCosto.setText(String.valueOf(objConferencia.getRegistrationCost()));
        this.jTextFieldUbicacion.setText(objConferencia.getLocation());
        this.jTextFieldCantMaxArticles.setText(String.valueOf(objConferencia.getCantMaxArticles()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelSuperior = new javax.swing.JPanel();
        jLabelTitulo = new javax.swing.JLabel();
        jPanelCentral = new javax.swing.JPanel();
        jLabelNombre = new javax.swing.JLabel();
        jLabelFechaInicio = new javax.swing.JLabel();
        jLabelFechaFin = new javax.swing.JLabel();
        jLabelCosto = new javax.swing.JLabel();
        jButtonActualizar = new javax.swing.JButton();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldFechaInicio = new javax.swing.JTextField();
        jTextFieldFechaFin = new javax.swing.JTextField();
        jTextFieldCosto = new javax.swing.JTextField();
        jLabelUbicacion = new javax.swing.JLabel();
        jTextFieldCantMaxArticles = new javax.swing.JTextField();
        jLabelCantArticles = new javax.swing.JLabel();
        jTextFieldUbicacion = new javax.swing.JTextField();
        jTextFieldId = new javax.swing.JTextField();
        jLabelId = new javax.swing.JLabel();
        jPanelInferior = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelSuperior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelTitulo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabelTitulo.setForeground(new java.awt.Color(0, 0, 204));
        jLabelTitulo.setText("Actualizar conferencia");

        javax.swing.GroupLayout jPanelSuperiorLayout = new javax.swing.GroupLayout(jPanelSuperior);
        jPanelSuperior.setLayout(jPanelSuperiorLayout);
        jPanelSuperiorLayout.setHorizontalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap(200, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(167, 167, 167))
        );
        jPanelSuperiorLayout.setVerticalGroup(
            jPanelSuperiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSuperiorLayout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addComponent(jLabelTitulo)
                .addGap(41, 41, 41))
        );

        getContentPane().add(jPanelSuperior, java.awt.BorderLayout.PAGE_START);

        jPanelCentral.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabelNombre.setText("Nombre:");

        jLabelFechaInicio.setText("Fecha Inicio:");

        jLabelFechaFin.setText("Fecha Fin:");

        jLabelCosto.setText("Costo:");

        jButtonActualizar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButtonActualizar.setForeground(new java.awt.Color(0, 0, 153));
        jButtonActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/recursos/grabar.png"))); // NOI18N
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jLabelUbicacion.setText("Ubicacion:");

        jLabelCantArticles.setText("Cantidad maxima de articulos:");

        jTextFieldId.setEditable(false);

        jLabelId.setText("Id:");

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelCentralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonActualizar)
                .addGap(31, 31, 31))
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelUbicacion)
                            .addComponent(jLabelCosto)
                            .addComponent(jLabelFechaFin)
                            .addComponent(jLabelFechaInicio)
                            .addComponent(jLabelNombre)
                            .addComponent(jLabelId)))
                    .addGroup(jPanelCentralLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabelCantArticles)))
                .addGap(54, 54, 54)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextFieldUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jTextFieldNombre)
                        .addComponent(jTextFieldFechaInicio)
                        .addComponent(jTextFieldCosto, javax.swing.GroupLayout.DEFAULT_SIZE, 258, Short.MAX_VALUE)
                        .addGroup(jPanelCentralLayout.createSequentialGroup()
                            .addComponent(jTextFieldCantMaxArticles, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addGap(132, 132, 132)))
                    .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCentralLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelId)
                    .addComponent(jTextFieldId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelNombre, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaInicio)
                    .addComponent(jTextFieldFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelFechaFin)
                    .addComponent(jTextFieldFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCosto)
                    .addComponent(jTextFieldCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelUbicacion)
                    .addComponent(jTextFieldUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelCantArticles)
                    .addComponent(jTextFieldCantMaxArticles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addComponent(jButtonActualizar)
                .addGap(25, 25, 25))
        );

        getContentPane().add(jPanelCentral, java.awt.BorderLayout.CENTER);

        jPanelInferior.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanelInferiorLayout = new javax.swing.GroupLayout(jPanelInferior);
        jPanelInferior.setLayout(jPanelInferiorLayout);
        jPanelInferiorLayout.setHorizontalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );
        jPanelInferiorLayout.setVerticalGroup(
            jPanelInferiorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelInferior, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        String nombre = this.jTextFieldNombre.getText();
        String fechaInicio = this.jTextFieldFechaInicio.getText();
        String fechaFin = this.jTextFieldFechaFin.getText();
        String costo = this.jTextFieldCosto.getText();
        String ubicacion = this.jTextFieldUbicacion.getText();
        String cantMaxArticles = this.jTextFieldCantMaxArticles.getText();
        String id = this.jTextFieldId.getText();
        Integer idConference = Integer.parseInt(id);;

        Date fechaInicioDate = null, fechaFinDate = null;
        float costoInscripcion;
        Integer cantMaximArticles;

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

        // Intentar parsear la fecha de inicio
        try {
            fechaInicioDate = formatter.parse(fechaInicio);
        } catch (ParseException ex) {
            Utilidades.mensajeAdvertencia("La fecha de inicio no sigue el formato dd/MM/yyyy", "Fecha incorrecta");
            return;
        }

        // Intentar parsear la fecha de fin
        try {
            fechaFinDate = formatter.parse(fechaFin);
        } catch (ParseException ex) {
            Utilidades.mensajeAdvertencia("La fecha de fin no sigue el formato dd/MM/yyyy", "Fecha incorrecta");
            return;
        }

        // Validar si la fecha de fin es posterior a la fecha de inicio
        if (fechaFinDate.before(fechaInicioDate)) {
            Utilidades.mensajeError("La fecha final no puede estar antes de la inicial", "Error en el registro");
            return;
        }

        // Intentar convertir el costo a float
        try {
            costoInscripcion = Float.parseFloat(costo);
        } catch (NumberFormatException ex) {
            Utilidades.mensajeAdvertencia("El costo debe ser un número válido", "Error en el registro");
            return;
        }

        try {
            cantMaximArticles = Integer.valueOf(cantMaxArticles);
        } catch (NumberFormatException ex) {
            Utilidades.mensajeAdvertencia("Debe ser un número válido", "Error en el registro");
            return;
        }

        // Crear y guardar la conferencia
        Conferencia objConferencia = new Conferencia(nombre, fechaInicioDate, fechaFinDate, costoInscripcion, ubicacion, cantMaximArticles);
        this.conferenciaServices.update(idConference, objConferencia);

        if (objConferencia != null) {
            Utilidades.mensajeExito("Conferencia actualizada correctamente", "Conferencia actualizada");
            setVisible(false);
        } else {
            Utilidades.mensajeError("Error al actualizar la conferencia", "Error al actualizar");
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JLabel jLabelCantArticles;
    private javax.swing.JLabel jLabelCosto;
    private javax.swing.JLabel jLabelFechaFin;
    private javax.swing.JLabel jLabelFechaInicio;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelNombre;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUbicacion;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelInferior;
    private javax.swing.JPanel jPanelSuperior;
    private javax.swing.JTextField jTextFieldCantMaxArticles;
    private javax.swing.JTextField jTextFieldCosto;
    private javax.swing.JTextField jTextFieldFechaFin;
    private javax.swing.JTextField jTextFieldFechaInicio;
    private javax.swing.JTextField jTextFieldId;
    private javax.swing.JTextField jTextFieldNombre;
    private javax.swing.JTextField jTextFieldUbicacion;
    // End of variables declaration//GEN-END:variables
}