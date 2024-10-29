package views.articlePanels;

import utilities.Components;
import views.genericPanels.ListPanel;
import views.util.ButtonClickListener;
import views.util.ButtonEditor;
import views.util.ButtonRenderer;
import views.util.CardPanelManager;
import views.util.NonEditableTableModel;

import java.util.ArrayList;
import java.util.List;
import views.util.StyledButtonRenderer;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import models.Articulo;
import models.Conferencia;
import services.ArticuloServices;
import services.ConferenciaServices;
import views.mainWindowPanels.MainPanel;
import views.windows.PopUpWindow;

public class ListArticlesPanel extends ListPanel {
    private final CardPanelManager cardManager;
    private final int conferenceID;
    private boolean isThirdPartyConference;
    private ArticuloServices articleService;
    private ConferenciaServices conferenceService;



    public ListArticlesPanel(CardPanelManager cardManager, int conferenceID) 
    {
        super("Listado de Articulos", "Registrar Articulos", new String[]{"Nombre", "Revista","Abstract","Palabras claves","Cantidad de autores","Actualizar", "Eliminar"},false,true);
        this.conferenceID = conferenceID;
        this.cardManager = cardManager;
        this.articleService = new ArticuloServices();
        this.conferenceService = new ConferenciaServices();
    }
    
    public ListArticlesPanel(CardPanelManager cardManager, int conferenceID, boolean isThirdPartyConference) 
    {
        super("Listado de Articulos", "Registrar Articulos", new String[]{"Nombre", "Revista","Abstract","Palabras claves","Cantidad de autores","Actualizar", "Eliminar"},false,true);
        this.conferenceID = conferenceID;
        this.cardManager = cardManager;
        this.isThirdPartyConference = isThirdPartyConference;
        this.articleService = new ArticuloServices();
        this.conferenceService = new ConferenciaServices();
    }

    @Override
    protected void registerAction() {
         cardManager.showPanel("registerPanel");
    }

    public void clearTable() {
        NonEditableTableModel model = (NonEditableTableModel) this.table.getModel();
        int rows = this.table.getRowCount();
        for (int i = 0; i < rows; i++) {
            model.removeRow(0);
        }        
    }

    private void fillTable() {
        final int BUTTONACTUALIZAR = 5;
        final int BUTTONELIMINAR = 6;
        // Obtener el modelo de tabla y asegurarse de que no sea editable por defecto
        NonEditableTableModel model = (NonEditableTableModel) this.table.getModel();
    
        // Limpiar la tabla antes de llenarla
        clearTable();
    
        // Obtener la lista de artículos de la conferencia utilizando el ID de la conferencia
        ArrayList<Articulo> articleList = (ArrayList<Articulo>) conferenceService.getArticlesByConferenceId(conferenceID);

        System.out.println("I receive this atrticl:" + articleList.size());
        // Formatear la tabla con la información de los artículos
        for (int i = 0; i < articleList.size(); i++) {
            // Crear una fila con los datos del artículo actual
            List<String> row = new ArrayList<>();
            row.add(articleList.get(i).getTitle());  // Título del artículo
            row.add(articleList.get(i).getJournal());  // Revista del artículo
            row.add(articleList.get(i).getAbstractText());  // Resumen del artículo
            row.add(articleList.get(i).getKeywords());  // Palabras clave
            row.add(String.valueOf(articleList.get(i).getCantAuthors()));
            row.add("Actualizar");
            row.add("Eliminar");
            // Agregar la fila al modelo de la tabla
            model.addRow(row.toArray());       
        }
        
        model.addEditableColumn(BUTTONACTUALIZAR);
        model.addEditableColumn(BUTTONELIMINAR);
        
        ButtonClickListener listener = (int row) -> {
            
        };
        
        ButtonClickListener eliminar = (int row) -> {
            Articulo selectedArticle = articleList.get(row);
            System.out.println(articleService.delete(selectedArticle.getId()));
            if(articleService.delete(selectedArticle.getId())) {
                System.out.println("Prueba");
                new PopUpWindow((JFrame) SwingUtilities.getWindowAncestor(this), 
                PopUpWindow.PopUpType.SUCCESS, 
                "Articulo eliminado con exito");
            }
        };
    
        table.getColumnModel().getColumn(BUTTONACTUALIZAR).setCellRenderer(new StyledButtonRenderer());
        table.getColumnModel().getColumn(BUTTONACTUALIZAR).setCellEditor(new ButtonEditor(new JCheckBox(), listener));
        
        table.getColumnModel().getColumn(BUTTONELIMINAR).setCellRenderer(new StyledButtonRenderer());
        table.getColumnModel().getColumn(BUTTONELIMINAR).setCellEditor(new ButtonEditor(new JCheckBox(), eliminar));
        
        // Si es una conferencia de terceros, no se añade funcionalidad para botones
        if (isThirdPartyConference)
            return;
 
    }
    
    @Override
    public void update() 
    {
        fillTable();
    }

    @Override
    protected void returnAction() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
