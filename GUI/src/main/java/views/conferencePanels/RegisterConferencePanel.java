package views.conferencePanels;

import utilities.CustomDateChooser;
import utilities.CustomTextField;
import utilities.Components;
import utilities.FieldConfig;
import views.genericPanels.RegisterPanel;
import views.util.CardPanelManager;
import views.windows.AssignTopicWindow;
import views.windows.PopUpWindow;

import com.toedter.calendar.JDateChooser;
import java.awt.Window;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import models.Conferencia;
import services.ConferenciaServices;

public class RegisterConferencePanel extends RegisterPanel{
    private final CardPanelManager cardManager;
    private final ArrayList<String> selectedTopics; 

    public RegisterConferencePanel (CardPanelManager cardManager) {
        super(new JLabel("Registrar Conferencia"), createInputFields());
        selectedTopics = new ArrayList<>();
        this.cardManager = cardManager;
    }
    
    private static LinkedHashMap<String, FieldConfig> createInputFields() {
        JDateChooser startDate = new CustomDateChooser("Fecha de inicio: ");
        startDate.setDateFormatString("dd/MM/yyyy");

        JDateChooser endDate = new CustomDateChooser("Fecha de fin: ");
        endDate.setDateFormatString("dd/MM/yyyy");

        int maxLength = 9; 

        LinkedHashMap<String, FieldConfig> inputFields = new LinkedHashMap<>();
        inputFields.put("Nombre:", new FieldConfig(new CustomTextField("Nombre: ")));
        inputFields.put("Fecha de inicio:", new FieldConfig(startDate));
        inputFields.put("Fecha de fin:", new FieldConfig(endDate));
        inputFields.put("Costo de inscripcion:", new FieldConfig(Components.createNumberField(maxLength,"Costo de incripción: ")));
        inputFields.put("Ubicacion:", new FieldConfig(new CustomTextField("Ubicacion: ")));
        inputFields.put("", new FieldConfig(new JButton("Temas relacionados")));
        
        return inputFields;
    }
    
 
    @Override
    protected void registerAction() {
        ArrayList<String> values = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        fieldConfigs.values().stream()
            .map(FieldConfig::getFieldType)
            .forEach(field -> {
            switch (field) {
                case JTextField jTextField -> 
                    values.add(jTextField.getText());
                case JDateChooser jDateChooser -> 
                    values.add(jDateChooser.getDate() != null ? dateFormat.format(jDateChooser.getDate()) : "");
                default -> {
                }
            }
        });

        for(String value: values){
            System.out.println(value);
        }
        

        try {
            Date startDate = dateFormat.parse(values.get(1));
            Date endDate = dateFormat.parse(values.get(2));

            if (endDate.before(startDate)) {
                new PopUpWindow((JFrame) SwingUtilities.getWindowAncestor(this), 
                PopUpWindow.PopUpType.ERROR, 
                "La fecha de fin debe ser posterior a la fecha de inicio");
                return;
            }
            
            if(selectedTopics.isEmpty())
            {
                new PopUpWindow((JFrame) SwingUtilities.getWindowAncestor(this),
                PopUpWindow.PopUpType.ERROR,
                "Debe seleccionar al menos un tema");
                return;
            }

            float cost = Float.parseFloat(values.get(3));
            Conferencia conference = new Conferencia(values.get(0), startDate, endDate, cost, values.get(4),selectedTopics);

            ConferenciaServices conferenceService = new ConferenciaServices();

            conferenceService.save(conference); //Save conference in micro
        
            cardManager.showPanel("listPanel");
            cleanInputs();
            new PopUpWindow((JFrame) SwingUtilities.getWindowAncestor(this), 
                PopUpWindow.PopUpType.SUCCESS, 
                "Conferencia registrada con éxito");

        } catch (NumberFormatException ex) {
            new PopUpWindow((JFrame) SwingUtilities.getWindowAncestor(this), 
                PopUpWindow.PopUpType.WARNING, 
                "El costo de inscripción debe ser un número");
        } catch (ParseException ex) {
            new PopUpWindow((JFrame) SwingUtilities.getWindowAncestor(this), 
                PopUpWindow.PopUpType.WARNING, 
                "La fecha no tiene un formato válido");
        }
    }
    
    @Override
    protected void extraButtonAction() {
        String[] conferenceTopics = {
            "Inteligencia Artificial", "Ciencia de Datos", "Ciberseguridad", "Internet de las Cosas",
            "Blockchain", "Desarrollo Web", "Computación en la Nube", "Realidad Virtual", 
            "Desarrollo de Software", "Ingeniería de Sistemas", "Automatización de Pruebas",
            "Machine Learning", "Big Data", "Robótica", "Computación Cuántica", 
            "Sistemas Embebidos", "Algoritmos y Complejidad", "Redes de Computadoras", 
            "Bases de Datos", "Tecnologías Emergentes","Otro"
        };
        
       Window window = SwingUtilities.getWindowAncestor(this);
        
        if (window instanceof JFrame parentFrame) {
            AssignTopicWindow.openAssignTopicWindow(parentFrame, selectedTopics, conferenceTopics);
        }     
        
        
    }   
}
