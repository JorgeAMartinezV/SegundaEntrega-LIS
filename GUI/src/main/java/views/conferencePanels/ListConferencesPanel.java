package views.conferencePanels;

import utilities.*;
import views.genericPanels.ListPanel;
import views.mainWindowPanels.MainPanel;
import views.util.ButtonClickListener;
import views.util.ButtonEditor;
import views.util.CardPanelManager;
import views.util.StyledButtonRenderer;
import views.util.NonEditableTableModel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.JTableHeader;
import models.Articulo;
import models.Conferencia;
import services.ConferenciaServices;
import views.windows.PopUpWindow;

public class ListConferencesPanel extends ListPanel{
    private final CardPanelManager cardManager;
    private final  MainPanel adminWindow;
    private final ConferenciaServices conferenceService;
    
    public ListConferencesPanel(MainPanel adminWindow, CardPanelManager cardManager, String title) {
        super(title, "Registrar Conferencias", 
                new String[]{"Nombre", "Fecha Inicio", "Fecha Fin", "Costo", "Ubicacion","Temas", "", "Actualizar", "Eliminar"},false,true);
        this.adminWindow = adminWindow;
        this.cardManager = cardManager;
        this.conferenceService = new ConferenciaServices();
    }
  
    @Override
    protected void registerAction(){
        cardManager.showPanel("registerPanel");
    }

    public void clearTable(){

        NonEditableTableModel model = (NonEditableTableModel) this.table.getModel();
        int rows = this.table.getRowCount();
        for (int i = 0; rows > i; i++) {
            model.removeRow(0);
        }        
    }

    private void fillTable() {
        final int BUTTONCOLUMN = 6;
        final int BUTTONACTUALIZAR = 7;
        final int BUTTONELIMINAR = 8;
        // Especificamos la tabla como no editable (Ninguna columna aparecera editable por defecto)
        NonEditableTableModel model = (NonEditableTableModel) table.getModel();
        // Limpiar la tabla antes de llenarla
        clearTable();

        // Obtener la lista de conferencias
        ArrayList<Conferencia> conferenceList;
        
        conferenceList = (ArrayList<Conferencia>) conferenceService.findAll();

        for(Conferencia conference : conferenceList)
            System.out.println("Conf :" + conference.getId() + conference.getName());

        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    
        // Llenar la tabla con la informacion de las conferencias
        for (Conferencia conference : conferenceList) {
            String[] row = {
                    conference.getName(),
                    formatter.format(conference.getStartDate()),
                    formatter.format(conference.getEndDate()),
                    "$" + conference.getRegistrationCost() + "COP",
                    conference.getLocation(),
                    conference.topicsToString(),
                    "Seleccionar",
                    "Actualizar",
                    "Eliminar"
            };
            model.addRow(row);
        }

        //Especificar la columna que contendra el boton como editable
        model.addEditableColumn(BUTTONCOLUMN);
        model.addEditableColumn(BUTTONACTUALIZAR);
        model.addEditableColumn(BUTTONELIMINAR);
    
        ButtonClickListener listener = (int row) -> {
            Conferencia selectedConference = conferenceList.get(row);
    
            adminWindow.associateService(Articulo.class, selectedConference.getId());
            adminWindow.getCardManager().showPanel("myConferencePanel");
    
            adminWindow.setVisibility(MainPanel.VisibilityState.NONE);
    
            setVisible(false);
        };
        
        ButtonClickListener eliminar = (int row) -> {
            Conferencia selectedConference = conferenceList.get(row);
            System.out.println(selectedConference.getId());
            System.out.println(conferenceService.delete(selectedConference.getId()));
            if(conferenceService.delete(selectedConference.getId())) {
                new PopUpWindow((JFrame) SwingUtilities.getWindowAncestor(this), 
                PopUpWindow.PopUpType.SUCCESS, 
                "Conferencia eliminada con exito");
            }
        };
        // Cargar la imagen desde los recursos
        ImageIcon icon = new ImageIcon(getClass().getResource("/resources/abajo.png"));

        // Obtener la altura de la fila para escalar la imagen del encabezado
        int rowHeight = table.getRowHeight();
    
        // Aplicar el HeaderRendererWithIcon al encabezado de la columna correspondiente
        JTableHeader header = table.getTableHeader();
        header.getColumnModel().getColumn(BUTTONCOLUMN).setHeaderRenderer(new HeaderRendererWithIcon(icon, rowHeight));
    
        // Configure the renderer and editor only for the last column
        table.getColumnModel().getColumn(BUTTONCOLUMN).setCellRenderer(new StyledButtonRenderer());
        table.getColumnModel().getColumn(BUTTONCOLUMN).setCellEditor(new ButtonEditor(new JCheckBox(), listener));
        
        table.getColumnModel().getColumn(BUTTONACTUALIZAR).setCellRenderer(new StyledButtonRenderer());
        table.getColumnModel().getColumn(BUTTONACTUALIZAR).setCellEditor(new ButtonEditor(new JCheckBox(), listener));
        
        table.getColumnModel().getColumn(BUTTONELIMINAR).setCellRenderer(new StyledButtonRenderer());
        table.getColumnModel().getColumn(BUTTONELIMINAR).setCellEditor(new ButtonEditor(new JCheckBox(), eliminar));
    }

    @Override
    public void update() {
        System.out.println("Im in update man");
        fillTable();
    }

    @Override
    protected void returnAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
