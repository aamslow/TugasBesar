
package com.wordpress.erenha.java.desktop.entry.utility;

import com.wordpress.erenha.java.desktop.entry.view.MainFrame;
import javax.swing.JOptionPane;

/**
 * Message.java
 * Hanya class untuk memudahkan pemanggilan JOptionPane
 * @author Irfan Hidayat Amarulloh
 */
public class Message {

    public static void errorMessage(String message) {
        JOptionPane.showMessageDialog(MainFrame.getInstance(), message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void infoMessage(String message) {
        JOptionPane.showMessageDialog(MainFrame.getInstance(), message, "Info", JOptionPane.INFORMATION_MESSAGE);
    }
}
