package de.jonas.teacherrating.object;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

/**
 * Ein {@link Gui} stellt ein Objekt für ein Fenster dar, welches vererbt werden kann und für eine vereinfachte
 * Instanziierung eines {@link JFrame Fensters} genutzt werden kann.
 */
@NotNull
public abstract class Gui extends JFrame {

    //<editor-fold desc="CONSTANTS">
    /** Die Standard-Schriftart, die genutzt werden kann. */
    @NotNull
    public static final Font DEFAULT_FONT = new Font("Arial", Font.BOLD, 20);
    //</editor-fold>


    //<editor-fold desc="LOCAL FIELDS">
    /** Das {@link Draw Zeichen-Objekt}, welches hinzugefügt werden muss, um die Zeichnung zu realisieren. */
    @NotNull
    private final Draw draw;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">

    /**
     * Erzeugt eine neue und vollständig unabhängige Instanz eines {@link Gui}. Ein {@link Gui} stellt ein Objekt für
     * ein Fenster dar, welches vererbt werden kann und für eine vereinfachte Instanziierung eines {@link JFrame
     * Fensters} genutzt werden kann.
     *
     * @param title      Der Titel, welcher das Fenster tragen soll.
     * @param width      Die Breite, die das Fenster haben soll.
     * @param height     Die Höhe, die das Fenster haben soll.
     * @param background Die Hintergrund-Farbe für das Fenster.
     */
    public Gui(
        @NotNull final String title,
        @Range(from = 0, to = Integer.MAX_VALUE) final int width,
        @Range(from = 0, to = Integer.MAX_VALUE) final int height,
        @NotNull final Color background
    ) {
        super(title);

        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setBounds(0, 0, width, height);
        super.setLocationRelativeTo(null);
        super.setLayout(null);
        super.setResizable(false);

        this.draw = new Draw(background);
        this.draw.setBounds(0, 0, width, height);
        this.draw.setVisible(true);
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

    /**
     * Stattet einen bestimmten {@link JButton} mit allen nötigen Attributen aus, welche in diesem Fenster gewünscht
     * sind, damit er gut aussieht.
     *
     * @param button Der {@link JButton}, dem alle nötigen Attribute hinzugefügt werden.
     * @param font   Die Schriftart, die der {@link JButton} haben soll.
     */
    public void addAttributes(@NotNull final JButton button, @NotNull final Font font) {
        button.setFont(font);
        button.setFocusable(false);
        button.setOpaque(true);
        button.setBackground(Color.DARK_GRAY);
        button.setForeground(Color.WHITE);
    }

    /**
     * Platziert einen bestimmten {@link Component Komponenten} an einer bestimmten {@link ObjectLocation Position} auf
     * dem {@link Gui}.
     *
     * @param component Der {@link Component Komponent}, der in dem Fenster platziert werden soll.
     * @param location  Die {@link ObjectLocation Position}, an der der Komponent platziert werden soll.
     */
    public void placeComponent(@NotNull final Component component, @NotNull final ObjectLocation location) {
        component.setBounds(
            location.getPositionX(),
            location.getPositionY(),
            location.getWidth(),
            location.getHeight()
        );
    }

    /**
     * Fügt das Zeichen-Objekt des {@link Gui} hinzu. Somit wird dann die Zeichnung realisiert.
     */
    public void draw() {
        this.add(this.draw);
    }

    /**
     * Zeichnet auf das {@link Gui}, mithilfe des {@link Graphics Graphics-Objekt}.
     *
     * @param g Die {@link Graphics}, mit denen auf das {@link Gui} gezeichnet werden.
     */
    public abstract void draw(@NotNull Graphics g);


    //<editor-fold desc="Draw">

    /**
     * Die Klasse, mit dessen Hilfe alle Zeichnungen auf dem {@link Gui} vorgenommen werden.
     */
    @NotNull
    private final class Draw extends JLabel {

        //<editor-fold desc="LOCAL FIELDS">
        /** Die Hintergrund-Farbe, die das {@link Gui} haben soll. */
        @NotNull
        private final Color background;
        //</editor-fold>


        //<editor-fold desc="CONSTRUCTORS">

        /**
         * Erzeugt eine neue Instanz eines {@link Draw}, mit dessen Hilfe alle Zeichnungen auf dem {@link Gui}
         * vorgenommen werden.
         *
         * @param background Die Hintergrund-Farbe, die das {@link Gui} haben soll.
         */
        private Draw(@NotNull final Color background) {
            this.background = background;
        }
        //</editor-fold>


        //<editor-fold desc="implementation">
        @Override
        protected void paintComponent(@NotNull final Graphics g) {
            super.paintComponent(g);

            final Graphics2D g2d = (Graphics2D) g;

            // define render quality
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // draw background
            g.setColor(this.background);
            g.fillRect(0, 0, this.getWidth(), this.getHeight());

            g.setColor(Color.BLACK);

            Gui.this.draw(g);
        }
        //</editor-fold>
    }
    //</editor-fold>

}
