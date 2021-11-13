package de.jonas.teacherrating.gui;

import de.jonas.teacherrating.object.Gui;
import org.jetbrains.annotations.NotNull;

import java.awt.Graphics;

import static java.awt.Color.LIGHT_GRAY;

/**
 * Ein {@link StartGui} stammt von einem {@link Gui} ab und es stellt das {@link Gui} dar, welches als erstes geöffnet
 * wird, nachdem die Anwendung gestartet wurde.
 */
public final class StartGui extends Gui {

    //<editor-fold desc="CONSTANTS">
    /** Der Titel des Fensters. */
    private static final String TITLE = "Sammle Daten...";
    /** Die Breite des Fensters. */
    private static final int WIDTH = 750;
    /** Die Höhe des Fensters. */
    private static final int HEIGHT = 500;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">

    /**
     * Erzeugt eine neue Instanz eines {@link StartGui}, welches von einem {@link Gui} abstammt.
     */
    public StartGui() {
        super(
            TITLE,
            WIDTH,
            HEIGHT,
            LIGHT_GRAY
        );
    }
    //</editor-fold>


    //<editor-fold desc="implementation">
    @Override
    public void draw(@NotNull final Graphics g) {

    }
    //</editor-fold>
}
