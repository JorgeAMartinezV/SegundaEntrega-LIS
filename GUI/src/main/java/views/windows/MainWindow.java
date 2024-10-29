package views.windows;

import models.*;
import views.mainWindowPanels.MainPanel;
import views.util.CardPanelManager;
import views.util.Utilities;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainWindow extends JFrame {
    private final CardPanelManager cardManager;
    
    public MainWindow() {
        super("Easy Conference");
        cardManager = new CardPanelManager(new JPanel(new CardLayout()));
        configWindow();       
        linkPanels();
        getContentPane().add(cardManager.getCardPane());
        MainPanel mainPanel = (MainPanel) cardManager.getPanel("mainPanel");
        mainPanel.associateService(Conferencia.class, 0);
        cardManager.showPanel("mainPanel");
    }
    
    private void linkPanels()
    {
        MainPanel mainPanel = new MainPanel(cardManager);
        cardManager.addPanel(mainPanel, "mainPanel");
    }

    public CardPanelManager getCardManager() {
        return cardManager;
    }
    
    private void configWindow()
    {
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        Utilities.exit(this);    
    }
   
}

    
