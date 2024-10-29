package views.mainWindowPanels;

import models.Conferencia;
import utilities.Components;
import views.windows.ArticleWindow;
import views.windows.ConferenceWindow;
import views.util.CardPanelManager;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import models.Articulo;

import static utilities.Components.BCKGCOLOR;

public class MainPanel extends JPanel{
    private final Map<Class<? extends JInternalFrame>, JInternalFrame> internalFrames = new HashMap<>();
    private final Map<Class<?>, Integer> services = new HashMap<>();
    private JDesktopPane mainDesktopPane;
    private final CardPanelManager cardManager;
    private final CardPanelManager generalCardManager;

    public void associateService(Class<?> serviceClass, int ID) {
        services.put(serviceClass, ID);
        removeInternalFrameForService(serviceClass);
        relateInternalFramesToDesktopPane();
    }
    
    public void relateAllConferences()
    {
        removeInternalFrameForService(Conferencia.class);
        if (!internalFrames.containsKey(ConferenceWindow.class)) {
            internalFrames.put(ConferenceWindow.class, 
                new ConferenceWindow(this, true));
        }
        mainDesktopPane.add(internalFrames.get(ConferenceWindow.class));
    }

    public void relateAllArticles()
    {
        removeInternalFrameForService(Articulo.class);
        if (!internalFrames.containsKey(ArticleWindow.class)) {
            internalFrames.put(ArticleWindow.class, 
                new ArticleWindow(services.get(Articulo.class), true));
        }
        mainDesktopPane.add(internalFrames.get(ArticleWindow.class));
    }

    private void removeInternalFrameForService(Class<?> serviceClass) {
        JInternalFrame frameToRemove = null;

        if (serviceClass.equals(Articulo.class)) {
            frameToRemove = internalFrames.get(ArticleWindow.class);
        } else if (serviceClass.equals(Conferencia.class)) {
            frameToRemove = internalFrames.get(ConferenceWindow.class);
        }

        if (frameToRemove != null) {
            mainDesktopPane.remove(frameToRemove);
            internalFrames.remove(frameToRemove.getClass());
            frameToRemove.dispose(); // Close the frame properly
        }
    }


    private void relateInternalFramesToDesktopPane() {
        // Clear the JDesktopPane
        mainDesktopPane.removeAll();

        if (services.containsKey(Conferencia.class)) {
            if (!internalFrames.containsKey(ConferenceWindow.class)) {
                internalFrames.put(ConferenceWindow.class, 
                    new ConferenceWindow(this));
            }
            mainDesktopPane.add(internalFrames.get(ConferenceWindow.class));
        }

        if (services.containsKey(Articulo.class)) {
            if (!internalFrames.containsKey(ArticleWindow.class)) {
                internalFrames.put(ArticleWindow.class, 
                    new ArticleWindow(services.get(Articulo.class)));

            }
            mainDesktopPane.add(internalFrames.get(ArticleWindow.class));
        }
        
    }

    public MainPanel(CardPanelManager generalCardManager) {
        super(new BorderLayout()); // Main panel replacing the JFrame's content
        this.generalCardManager = generalCardManager;
        cardManager = new CardPanelManager(new JPanel(new CardLayout()));
        createMainPanel(); 
    }
    
    
    private void createMainPanel() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();
        int screenHeight = screenSize.height;

        // Create and configure the north panel
        JPanel panelNorth = new JPanel();
        panelNorth.setBackground(BCKGCOLOR);
        panelNorth.setLayout(new GridBagLayout());
        int panelNorthHeight = (int) (screenHeight * 0.2);
        panelNorth.setPreferredSize(new Dimension(screenSize.width, panelNorthHeight));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.insets = new Insets((int) (panelNorthHeight * 0.01), 0, (int) (panelNorthHeight * 0.1), 0); // Padding

        // Add title label to the north panel
        JLabel titleLabel = new JLabel("");
        setLabel(titleLabel, (int) (panelNorthHeight * 0.18), new Color(0x2c4464));
        panelNorth.add(titleLabel, gbc);

        // Set GridBagConstraints for buttons
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        // Define buttons and their actions
        String[] mainPanelLabels = {"Mis conferencias"};
        ActionListener[] mainPanelActions = {
            _ ->
            {
                removeInternalFrameForService(Conferencia.class);
                relateInternalFramesToDesktopPane();
                setVisibility(MainPanel.VisibilityState.LIST_CONFERENCES);
            }
        };

        String[] myConferencePanelLabels = {"Gestionar artículos", "Regresar"};
        ActionListener[] myConferencePanelActions = {
            _ ->
            {
                removeInternalFrameForService(Articulo.class);
                relateInternalFramesToDesktopPane();
                setVisibility(MainPanel.VisibilityState.LIST_ARTICLES);
            },
            _ -> {
                setVisibility(MainPanel.VisibilityState.NONE);
                cardManager.showPanel("firstPanel");
            }
        };
        
        String[] otherConferencePanelLabels = {"Gestionar artículos", "Regresar"};
        ActionListener[] otherConferencePanelActions = {
            _ -> {
                relateAllArticles();
                setVisibility(MainPanel.VisibilityState.LIST_ARTICLES);
            },
            _ -> {
                setVisibility(MainPanel.VisibilityState.NONE);
                cardManager.showPanel("firstPanel");
            }
        };


        // Create and add button panels to CardLayout
        JPanel buttonsMainPanel = createButtonPanel(mainPanelLabels, mainPanelActions);
        JPanel buttonsMyConferencePanel = createButtonPanel(myConferencePanelLabels, myConferencePanelActions);
        JPanel buttonsOtherConferencePanel = createButtonPanel(otherConferencePanelLabels, otherConferencePanelActions);
        
        cardManager.addPanel(buttonsMainPanel, "firstPanel");
        cardManager.addPanel(buttonsMyConferencePanel, "myConferencePanel");
        panelNorth.add(cardManager.getCardPane(), gbc);

        // Create and configure the center panel with JDesktopPane
        mainDesktopPane = new JDesktopPane();
        JPanel panelCenter = new JPanel(new BorderLayout());
        panelCenter.setBackground(Color.GREEN);
        panelCenter.add(mainDesktopPane, BorderLayout.CENTER); // Add JDesktopPane to the center panel

        // Create and configure the south panel
        JPanel panelSouth = new JPanel();
        panelSouth.setBackground(new Color(0x696A78));
        int panelSouthHeight = (int) (screenHeight * 0.01);
        panelSouth.setPreferredSize(new Dimension(screenSize.width, panelSouthHeight));
        JLabel logoLabel = new JLabel("");
        setOrgIcon(logoLabel, (int) (panelNorthHeight * 0.18), new Color(0x2c4464));
        panelSouth.add(logoLabel, gbc);

        // Add panels to the main panel
        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);

        // Adjust font size dynamically based on window size
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustFontSize(titleLabel, buttonsMainPanel, buttonsMyConferencePanel, buttonsOtherConferencePanel);
            }
        });
    }
    
    private void adjustFontSize(JLabel label, JPanel... panels) {
        // Get current window size
        int width = this.getWidth();
        int height = this.getHeight();

        // Adjust title label font size
        int titleFontSize = Math.min(width, height) / 30; 
        label.setFont(new Font("Leelawadee UI", Font.BOLD, titleFontSize));

        // Adjust button font size for each panel
        int buttonFontSize = Math.min(width, height) / 48; 
        for (JPanel panel : panels) {
            Component[] components = panel.getComponents();
            for (Component component : components) {
                if (component instanceof JButton button) {
                    button.setFont(new Font("Cascadia Code", Font.PLAIN, buttonFontSize));
                }
            }

            // Revalidate and repaint to update layout and centering for each panel
            panel.revalidate();
            panel.repaint();
        }
    }


    private void setOrgIcon(JLabel label, int fontsize, Color textColor) {
        Image img1 = new ImageIcon(getClass().getResource("/resources/logo.png")).getImage();
        ImageIcon img2 = new ImageIcon(img1.getScaledInstance(40, 40, Image.SCALE_SMOOTH));
        label.setIcon(img2);
        label.setFont(new Font("Lucida Console", Font.BOLD, fontsize));
        label.setForeground(textColor);
    }

    private void setLabel(JLabel label, int fontsize, Color textColor) {
        label.setText("<html><center>EASY CONFERENCE</center></html>");
        label.setFont(new Font("Lucida Console", Font.BOLD, fontsize));
        label.setForeground(textColor);
    }

    public enum VisibilityState {
        LIST_CONFERENCES,
        LIST_ARTICLES,
        NONE
    }

    public void setVisibility(VisibilityState state) {
  
        for (JInternalFrame frame : internalFrames.values()) {
            frame.setVisible(false);
        }
        switch (state) {
            case LIST_CONFERENCES -> setFrameVisible(ConferenceWindow.class);
            case LIST_ARTICLES -> setFrameVisible(ArticleWindow.class);
            case NONE -> {
            }
        }
        
        mainDesktopPane.revalidate();
        mainDesktopPane.repaint();

    }

    private void setFrameVisible(Class<? extends JInternalFrame> frameClass) {
        JInternalFrame frame = internalFrames.get(frameClass);
        if (frame != null) {

            Components.centerJIF(frame, mainDesktopPane);
        }
    }

    // Method to configure panel with common settings
    private JPanel createButtonPanel(String[] buttonLabels, ActionListener[] actions) {
        JPanel panel = new JPanel();
        panel.setBackground(BCKGCOLOR);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createHorizontalGlue());

        for (int i = 0; i < buttonLabels.length; i++) {
            JButton button = Components.addButton(buttonLabels[i], panel);
            button.addActionListener(actions[i]);
        }

        panel.add(Box.createHorizontalGlue());
        return panel;
    }

    public CardPanelManager getCardManager() {
        return cardManager;
    }
}
