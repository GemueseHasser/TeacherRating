package de.jonas.teacherrating.gui;

import de.jonas.teacherrating.object.Gui;
import org.jetbrains.annotations.NotNull;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.font.TextAttribute;
import java.util.Map;

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

    //<editor-fold desc="heading">
    /** Die Schriftart, welche für den Titel genutzt wird. */
    private static final Font HEADING_FONT = new Font("Arial", Font.BOLD, 30);
    /** Der Abstand von der Oberen Fenster-Kante, bis der Titel beginnt. */
    private static final int HEADING_MARGIN_TOP = 40;
    /** Alle {@link TextAttribute Attribute}, der {@code HEADING_FONT}. */
    private static final Map<TextAttribute, Integer> HEADING_ATTRIBUTES = Map.of(
        TextAttribute.UNDERLINE,
        TextAttribute.UNDERLINE_ON
    );
    //</editor-fold>

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
        // draw heading
        g.setFont(HEADING_FONT.deriveFont(HEADING_ATTRIBUTES));

        final int headingWidth = g.getFontMetrics().stringWidth(super.getTitle());
        final int x = (super.getWidth() / 2) - (headingWidth / 2);

        g.drawString(super.getTitle(), x, HEADING_MARGIN_TOP);
    }
    //</editor-fold>
}
