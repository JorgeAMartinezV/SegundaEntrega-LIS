package test;

import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import views.windows.MainWindow;

public class Test {

    public static void main() {
        lookAndField();
        MainWindow adminWindow = new MainWindow(); // Create the main window and show it
        adminWindow.setVisible(true);       
    }
    
    /**
     * Method to change the appearance of the application
     */
    private static void lookAndField()
    {
        // Set the Nimbus look and feel
        for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(laf.getName()))
                try {
                UIManager.setLookAndFeel(laf.getClassName());
                 } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | UnsupportedLookAndFeelException _) {
            }
        }
    }
    
}
