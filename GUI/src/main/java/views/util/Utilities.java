package views.util;

import java.awt.Window;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import utilities.CustomDateChooser;
import utilities.CustomTextField;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import utilities.CustomTextField;
import utilities.FieldConfig;

public class Utilities {
    
    // Static method to add a window listener that closes the application
    public static void exit(Window window) {
        window.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0); 
            }
        });
    }
    
     public static void cleanInputs(LinkedHashMap<String, FieldConfig> fieldConfigs) {
        List<String> labelsText = new ArrayList<>(fieldConfigs.keySet());
        int nComponents = fieldConfigs.size();
        if ("".equals(labelsText.get(labelsText.size() - 1))) {
            nComponents--;
            System.out.println("Se eliminó");
        }
        for (int i = 0; i < nComponents; i++) {
            String labelText = labelsText.get(i);
            System.out.println(labelText + "-");
            FieldConfig config = fieldConfigs.get(labelText);
            JComponent input = config.getFieldType();

            switch (input) {
                case CustomTextField customTextField -> customTextField.resetToInitialState(); // Limpia el JTextField
                case CustomDateChooser customDateChooser -> customDateChooser.setInitialState(); // Limpia el JDateChooser
                case JComboBox comboBox -> comboBox.setSelectedIndex(0); // Restablece el JComboBox al primer valor
                default -> {
                }
            }
        }
    }   
}
