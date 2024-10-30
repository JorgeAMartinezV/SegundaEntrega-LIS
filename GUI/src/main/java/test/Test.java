package test;

import views.adminConferencia.VtnPrincipalAdmin;
import javax.swing.UIManager;
import services.ArticuloServices;
import services.ConferenciaServices;



public class Test {

    
    public static void main(String[] args) {
        seleccionarLookAndField();
        ArticuloServices articleService = new ArticuloServices();
        ConferenciaServices conferenceService = new ConferenciaServices();

        VtnPrincipalAdmin adminWindow = new VtnPrincipalAdmin();
        adminWindow.asociarServicios(articleService, conferenceService);
        adminWindow.setVisible(true);
    }
    
    private static void seleccionarLookAndField()
    {
        for(UIManager.LookAndFeelInfo laf:UIManager.getInstalledLookAndFeels()){
            if("Nimbus".equals(laf.getName()))
                try {
                UIManager.setLookAndFeel(laf.getClassName());
                 } catch (Exception ex) {
            }
        }
    }
    
    
    
}
