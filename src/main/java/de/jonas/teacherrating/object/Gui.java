package de.jonas.teacherrating.object;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import javax.swing.JFrame;

/**
 * Ein {@link Gui} stellt ein Objekt für ein Fenster dar, welches vererbt werden kann und für eine vereinfachte
 * Instanziierung eines {@link JFrame Fensters} genutzt werden kann.
 */
public class Gui extends JFrame {

    //<editor-fold desc="CONSTRUCTORS">

    /**
     * Erzeugt eine neue und vollständig unabhängige Instanz eines {@link Gui}. Ein {@link Gui} stellt ein Objekt für
     * ein Fenster dar, welches vererbt werden kann und für eine vereinfachte Instanziierung eines {@link JFrame
     * Fensters} genutzt werden kann.
     *
     * @param title  Der Titel, welcher das Fenster tragen soll.
     * @param width  Die Breite, die das Fenster haben soll.
     * @param height Die Höhe, die das Fenster haben soll.
     */
    public Gui(
        @NotNull final String title,
        @Range(from = 0, to = Integer.MAX_VALUE) final int width,
        @Range(from = 0, to = Integer.MAX_VALUE) final int height
    ) {
        super(title);

        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        super.setBounds(0, 0, width, height);
        super.setLocationRelativeTo(null);
        super.setLayout(null);
    }
    //</editor-fold>


    /**
     * Öffnet das bereits instanziierte Fenster.
     */
    public void open() {
        super.setVisible(true);
    }

    /**
     * Schließt das bereits instanziierte Fenster.
     */
    public void close() {
        super.dispose();
    }

}
