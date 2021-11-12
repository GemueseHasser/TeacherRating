package de.jonas.teacherrating;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import javax.swing.JFrame;

/**
 * Ein {@link Gui} stellt ein Objekt für ein Fenster dar, welches vererbt werden kann und für eine vereinfachte
 * Instanziierung eines {@link JFrame Fensters} genutzt werden kann.
 */
public class Gui {

    //<editor-fold desc="LOCAL FIELDS">
    /** Das Basis-Fenster, auf welches das {@link Gui} aufbaut. */
    private final JFrame frame;
    //</editor-fold>


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
        this.frame = new JFrame(title);

        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setBounds(0, 0, width, height);
        this.frame.setLocationRelativeTo(null);
        this.frame.setLayout(null);
    }
    //</editor-fold>


    /**
     * Öffnet das bereits instanziierte Fenster.
     */
    public void open() {
        this.frame.setVisible(true);
    }

    /**
     * Schließt das bereits instanziierte Fenster.
     */
    public void close() {
        this.frame.dispose();
    }

}
