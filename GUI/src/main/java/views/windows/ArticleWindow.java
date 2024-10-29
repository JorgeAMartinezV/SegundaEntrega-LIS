package views.windows;

import infraestructura.Observer;
import utilities.Components;
import views.articlePanels.ListArticlesPanel;
import views.articlePanels.RegisterArticlePanel;
import views.util.CardPanelManager;
import java.awt.CardLayout;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import services.ArticuloServices;

public class ArticleWindow extends JInternalFrame {

    private final CardPanelManager cardManager;
    private final int conferenceID;
    private final ArticuloServices articleService;

    public ArticleWindow (int conferenceID) {

        this.conferenceID =conferenceID;
        articleService = new ArticuloServices();
        cardManager = new CardPanelManager(new JPanel(new CardLayout()));
        linkPanels();
        getContentPane().add(cardManager.getCardPane());
        setIconifiable(true);
        setSize(Components.getRelativeSize(.65,.55));
    }

    public ArticleWindow(int conferenceID, boolean isThirdPartyConference) {
        this.conferenceID = conferenceID;
        articleService = new ArticuloServices();
        cardManager = new CardPanelManager(new JPanel(new CardLayout()));
        linkPanels(isThirdPartyConference);
        getContentPane().add(cardManager.getCardPane());
        setIconifiable(true);
        setSize(Components.getRelativeSize(.65,.55));
    }

    private void linkPanels()
    {   
        ListArticlesPanel ListPanel = new ListArticlesPanel(cardManager, conferenceID);
        RegisterArticlePanel registerPanel = new RegisterArticlePanel( cardManager, conferenceID); 
        
        articleService.addObserver((Observer) ListPanel);
        ((Observer) ListPanel).update();

        articleService.observersToString();
        
        cardManager.addPanel(ListPanel, "listPanel");
        cardManager.addPanel(registerPanel, "registerPanel");
    }

    private void linkPanels(boolean isThirdPartyConference) {
        ListArticlesPanel ListPanel = new ListArticlesPanel(cardManager, conferenceID, isThirdPartyConference);
        RegisterArticlePanel registerPanel = new RegisterArticlePanel(cardManager, conferenceID);

        articleService.addObserver((Observer) ListPanel);
        ((Observer) ListPanel).update();
        
        cardManager.addPanel(ListPanel, "listPanel");
        cardManager.addPanel(registerPanel, "registerPanel");
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
