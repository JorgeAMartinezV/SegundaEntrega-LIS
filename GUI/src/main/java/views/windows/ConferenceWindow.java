package views.windows;

import infraestructura.Observer;
import utilities.Components;
import views.conferencePanels.ListConferencesPanel;
import views.conferencePanels.RegisterConferencePanel;
import views.mainWindowPanels.MainPanel;
import views.util.CardPanelManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import services.ConferenciaServices;

/**
 *
 * @author Default
 */
public class ConferenceWindow extends JInternalFrame {
    private final CardPanelManager cardManager;
    private final ConferenciaServices conferenceService;

   public ConferenceWindow(MainPanel adminWindow) {
        conferenceService = new ConferenciaServices();
        setLayout(new BorderLayout());
        cardManager = new CardPanelManager(new JPanel(new CardLayout()));
        linkPanels(adminWindow, "Mis Conferencias");
        add(cardManager.getCardPane(), BorderLayout.CENTER);
        setIconifiable(true);
        setSize(Components.getRelativeSize(.55,.65));
    }

    
   public ConferenceWindow(MainPanel adminWindow, boolean flag) {
        conferenceService = new ConferenciaServices();
        setLayout(new BorderLayout());
        cardManager = new CardPanelManager(new JPanel(new CardLayout()));
        add(cardManager.getCardPane(), BorderLayout.CENTER);
        setIconifiable(true);
        setSize(Components.getRelativeSize(.55,.65));
    }
    
    private void linkPanels(MainPanel adminWindow,String titleConference)
    {   
        ListConferencesPanel ListPanel = new ListConferencesPanel(adminWindow, cardManager, titleConference);
        RegisterConferencePanel registerPanel = new RegisterConferencePanel( cardManager );

        conferenceService.addObserver((Observer) ListPanel);
        ((Observer) ListPanel).update();
        
        cardManager.addPanel(ListPanel, "listPanel");
        cardManager.addPanel(registerPanel, "registerPanel");
        cardManager.showPanel("listPanel");
    }

    private void linkPanels(MainPanel adminWindow,String titleConference, boolean flag)
    {   
        ListConferencesPanel ListPanel = new ListConferencesPanel(adminWindow, cardManager, titleConference);
        RegisterConferencePanel registerPanel = new RegisterConferencePanel( cardManager);
        
        cardManager.addPanel(ListPanel, "listPanel");
        cardManager.addPanel(registerPanel, "registerPanel");
        cardManager.showPanel("listPanel"); 
    }

}
