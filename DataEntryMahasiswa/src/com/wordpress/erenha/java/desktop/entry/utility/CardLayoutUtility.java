
package com.wordpress.erenha.java.desktop.entry.utility;

import com.wordpress.erenha.java.desktop.entry.view.MainFrame;
import java.awt.CardLayout;

/**
 * CardLayoutUtility.java
 * Digunakan untuk pindah dari card yang satu ke yang lain
 * @author Irfan Hidayat Amarulloh
 */
public class CardLayoutUtility {

    private static CardLayout card = (CardLayout) MainFrame.getInstance().getContentPane().getLayout();

    public static void next() {
        card.next(MainFrame.getInstance().getContentPane());
    }

    public static void previous() {
        card.previous(MainFrame.getInstance().getContentPane());
    }
}
