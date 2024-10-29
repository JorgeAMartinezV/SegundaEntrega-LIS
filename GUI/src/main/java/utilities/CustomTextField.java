/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utilities;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.MatteBorder;

import static utilities.Components.*;

/**
 * Custom TextField
 * This class is a custom text field that allows to set a placeholder
 * It has a placeholder, a placeholder color, a text color, a background color, and a border color
 * It also has a default font and a default border
 */

public class CustomTextField extends JTextField {
    private final String placeholder;
    private final Font defaultFont;
    private final MatteBorder initialBorder = new MatteBorder(0, 0, 2, 0, BUTTONCOLOR);

    /**
     * Constructor
     * @param pholderText The placeholder text which will be used.
     * 
     * The constructor initializes the custom text field with the given placeholder
     */
    public CustomTextField(String pholderText) {
        super(20);
        this.placeholder = pholderText;
        Dimension dimensions = Components.getRelativeSize();
        defaultFont = new Font("Leelawadee UI", Font.PLAIN, Math.min(dimensions.width, dimensions.height) / 51);

        // Initial set up
        setText(pholderText);
        setForeground(TEXTCOLOR);
        setFont(defaultFont);
        setBackground(BCKGCOLOR);
        setHorizontalAlignment(JLabel.CENTER);
        setBorder(createCompoundBorder(initialBorder)); // Add padding

        addFocusListener(new FocusAdapter() {
            // Eventos de foco
            @Override
            public void focusGained(FocusEvent e) {
                /*
                * Si el texto es igual al placeholder o el color del texto es el de error
                * se borra el texto y se cambia el color del texto al color por defecto
                */
                if (isPlaceholder() )
                    setText("");
                setForeground(ACTIVECOLOR);
                setFont(defaultFont.deriveFont(Font.BOLD));
                /*
                 * Se cambia el borde inferior al color activo
                 */
                setBorder(createCompoundBorder(new MatteBorder(0, 0, 2, 0, ACTIVECOLOR))); // Add padding
            }

            // Evento de pérdida de foco
            @Override
            public void focusLost(FocusEvent e) {
                // If text is empty we change the text for placeholder text
                if (getText().isEmpty()) {
                    setText(pholderText);
                }
                // If lost focus we reset the field to base color, Plain and the initial border
                setForeground(TEXTCOLOR);
                setFont(getFont().deriveFont(Font.PLAIN));
                setBorder(createCompoundBorder(initialBorder)); // Add padding
            }
        });
    }

    /**
     * Helper method to create a compound border with padding
     * @param border The main border
     * @return The compound border with padding
     */
    protected Border createCompoundBorder(Border border) {
        return BorderFactory.createCompoundBorder(
                border,
                BorderFactory.createEmptyBorder(0, 0, 5, 0)
        );
    }

    /**
     * Method to set the custom text field back to its initial state
     */
    public void resetToInitialState() {
        setText(placeholder);
        setForeground(TEXTCOLOR);
        setFont(defaultFont);
        setBorder(BorderFactory.createCompoundBorder(
                initialBorder, 
                BorderFactory.createEmptyBorder(0, 2, 0, 2)
        ));
    }

    /*
     * isPlaceholder
     * @return True if the text is empty (equal to the placeholder)
     * False otherwise
     */
    public boolean isPlaceholder() {
        return getText().equals(placeholder);
    }


}