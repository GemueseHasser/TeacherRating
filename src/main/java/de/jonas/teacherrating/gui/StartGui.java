package de.jonas.teacherrating.gui;

import de.jonas.teacherrating.object.Gui;

/**
 * Ein {@link StartGui} stammt von einem {@link Gui} ab und es stellt das {@link Gui} dar, welches als erstes geöffnet
 * wird, nachdem die Anwendung gestartet wurde.
 */
public final class StartGui extends Gui {

    /** Der Titel des Fensters. */
    private static final String TITLE = "Sammle Daten...";
    /** Die Breite des Fensters. */
    private static final int WIDTH = 750;
    /** DIe Höhe des Fensters. */
    private static final int HEIGHT = 500;


    /**
     * Erzeugt eine neue Instanz eines {@link StartGui}, welches von einem {@link Gui} abstammt.
     */
    public StartGui() {
        super(TITLE, WIDTH, HEIGHT);
    }
}
