
package com.wordpress.erenha.java.desktop.entry.view.model;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;

/**
 * ButtonGroupJenisKelamin.java
 * Turunan class ButtonGroup.
 * Atribut selectedText ditambahkan agar dapat digunakan untuk 
 * medukung binding dengan model
 * @author Irfan Hidayat Amarulloh
 */
public class ButtonGroupJenisKelamin extends ButtonGroup {

    private transient final PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(this);
    private String selectedText;
    public static final String PROP_SELECTEDTEXT = "selectedText";

    public String getSelectedText() {
        if (!buttons.isEmpty()) {
            for (AbstractButton abstractButton : buttons) {
                if (abstractButton instanceof JRadioButton) {
                    JRadioButton nextElement = (JRadioButton) abstractButton;
                    if (nextElement.isSelected()) {
                        selectedText = nextElement.getText();
                        return selectedText;
                    }
                }
            }
        }
        return selectedText;
    }

    public void setSelectedText(String selectedText) {
        String oldSelectedText = this.selectedText;
        this.selectedText = selectedText;
        if (!buttons.isEmpty()) {
            for (AbstractButton abstractButton : buttons) {
                if (abstractButton instanceof JRadioButton) {
                    JRadioButton nextElement = (JRadioButton) abstractButton;
                    if (selectedText.equals(nextElement.getText())) {
                        nextElement.setSelected(true);
                        break;
                    } else {
                        nextElement.setSelected(false);
                    }
                }
            }
        }
        propertyChangeSupport.firePropertyChange(PROP_SELECTEDTEXT, oldSelectedText, selectedText);
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(listener);
    }
}
