package views.articlePanels;

import utilities.CustomTextField;
import utilities.Components;
import utilities.FieldConfig;
import views.genericPanels.RegisterPanel;
import views.util.CardPanelManager;
import views.windows.PopUpWindow;

import static javax.swing.SwingUtilities.getWindowAncestor;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.SwingUtilities.getWindowAncestor;
import models.Articulo;
import services.ArticuloServices;
import services.ConferenciaServices;

public class RegisterArticlePanel extends RegisterPanel{
    private final CardPanelManager cardManager;
    private final int conferenceID;
    private final ArticuloServices articleService;

    public RegisterArticlePanel(CardPanelManager cardManager, int conferenceID) {
        super(new JLabel("Registrar Articulo"), createInputFields());
        this.conferenceID = conferenceID;
        this.cardManager = cardManager;
        this.articleService = new ArticuloServices();
    }

    private static LinkedHashMap<String, FieldConfig> createInputFields() {
        int maxLength = 9;
        LinkedHashMap<String, FieldConfig> inputFields = new LinkedHashMap<>();
        inputFields.put("Nombre: ", new FieldConfig(new CustomTextField("Nombre: ")));
        inputFields.put("Revista: ", new FieldConfig(new CustomTextField("Revista: ")));
        inputFields.put("Abstract: ", new FieldConfig(new CustomTextField("Abstract: ")));
        inputFields.put("Palabras clave: ", new FieldConfig(new CustomTextField("Palabras clave: ")));
        inputFields.put("Cantidad de autores: ", new FieldConfig(Components.createNumberField(maxLength,"Cantidad de autores: ")));
        return inputFields;
    }

    @Override
    protected void registerAction() {
        if(!Components.valuesAreCorrect(fieldConfigs)){
            new PopUpWindow((JFrame) getWindowAncestor(this), 
            PopUpWindow.PopUpType.ERROR, 
            "Debe llenar todos los campos");
            return;
        }

        ArrayList<String> values = Components.extractTextFields(fieldConfigs);
        Articulo article = new Articulo(values.get(0), values.get(1), values.get(2), values.get(3), Integer.valueOf(values.get(4)));

        int articleID = articleService.storeArticle(article).getId();
        
        ConferenciaServices conferenceService = new ConferenciaServices();
        conferenceService.addArticleToConference(conferenceID, articleID);

        cardManager.showPanel("listPanel");
        new PopUpWindow((JFrame) getWindowAncestor(this), 
            PopUpWindow.PopUpType.SUCCESS, 
            "Articulo registrado con exito");
        cleanInputs();
    }

}
