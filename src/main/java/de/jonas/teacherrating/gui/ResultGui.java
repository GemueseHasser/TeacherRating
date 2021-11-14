package de.jonas.teacherrating.gui;

import de.jonas.teacherrating.object.Gui;
import de.jonas.teacherrating.object.ObjectLocation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.Color.DARK_GRAY;

/**
 * Ein {@link ResultGui} erbt von dem {@link Gui} und auf dem {@link ResultGui} wird das ausgewertete Ergebnis zu dem
 * Lehrer (je nachdem welche Option man gewählt hat xDD) dargestellt.
 */
@NotNull
public final class ResultGui extends Gui implements ActionListener {

    //<editor-fold desc="CONSTANTS">
    /** Der Titel des {@link Gui}. */
    @NotNull
    private static final String TITLE = "Auswertung";
    /** Die Breite des {@link Gui}. */
    private static final int WIDTH = 500;
    /** Die Höhe des {@link Gui}. */
    private static final int HEIGHT = 400;
    /** Die Schriftgröße des Akzeptieren-Buttons. */
    private static final float BUTTON_FONT_SIZE = 15F;
    /** Der normale Zeilenabstand. */
    private static final int DEFAULT_LINE_MARGIN = 10;
    /** Die Position des Akzeptieren-Buttons. */
    @NotNull
    private static final ObjectLocation ACCEPT_BUTTON_LOCATION = new ObjectLocation(90, 280, 300, 50);
    /** Die Position, an der der Text startet. */
    @NotNull
    private static final ObjectLocation TEXT_START_LOCATION = new ObjectLocation(20, 30);
    /** Der Abstand zu dem zweiten Teil des Textes. */
    private static final int SECOND_PART_MARGIN = 75;
    //</editor-fold>


    //<editor-fold desc="LOCAL FIELDS">
    /** Der Name des Lehrers. */
    @NotNull
    private final String name;
    /** Das Fach, welches der Lehrer unterrichtet. */
    @NotNull
    private final String subject;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">

    /**
     * Erzeugt eine neue Instanz eines {@link ResultGui}. Ein {@link ResultGui} erbt von dem {@link Gui} und auf dem
     * {@link ResultGui} wird das ausgewertete Ergebnis zu dem Lehrer (je nachdem welche Option man gewählt hat xDD)
     * dargestellt.
     *
     * @param name    Der Name des Lehrers.
     * @param subject Das Fach, welches der Lehrer unterrichtet.
     */
    public ResultGui(
        @NotNull final String name,
        @NotNull final String subject
    ) {
        super(
            TITLE,
            WIDTH,
            HEIGHT,
            DARK_GRAY
        );

        this.name = name;
        this.subject = subject;

        super.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        final JButton accept = new JButton("uneingeschränkt akzeptieren");
        accept.setBounds(
            ACCEPT_BUTTON_LOCATION.getPositionX(),
            ACCEPT_BUTTON_LOCATION.getPositionY(),
            ACCEPT_BUTTON_LOCATION.getWidth(),
            ACCEPT_BUTTON_LOCATION.getHeight()
        );
        super.addAttributes(accept, DEFAULT_FONT.deriveFont(BUTTON_FONT_SIZE));
        accept.setBackground(Color.LIGHT_GRAY);
        accept.setForeground(Color.BLACK);
        accept.addActionListener(this);

        super.add(accept);
        super.draw();
    }
    //</editor-fold>


    /**
     * Berechnet mithilfe einer Position (Zeilenabfolge von '0' an) die Y-Koordinate für einen Text.
     *
     * @param position Die Position, an der der Text steht (Zeilenabfolge von '0' an).
     *
     * @return die Y-Koordinate für den Text.
     */
    @Range(from = 0, to = Integer.MAX_VALUE)
    private int getYCoordinate(@Range(from = 0, to = Integer.MAX_VALUE) final int position) {
        return TEXT_START_LOCATION.getPositionY() + (position * (DEFAULT_FONT.getSize() + DEFAULT_LINE_MARGIN));
    }

    //<editor-fold desc="implementation">
    @Override
    public void draw(@NotNull final Graphics g) {
        g.setColor(Color.WHITE);
        g.setFont(DEFAULT_FONT);

        g.drawString(
            "Sie sind also voll und ganz zufrieden!",
            TEXT_START_LOCATION.getPositionX(),
            getYCoordinate(0)
        );

        g.drawString(
            "Es ist schön zu hören, dass es noch solche",
            TEXT_START_LOCATION.getPositionX(),
            getYCoordinate(1)
        );

        g.drawString(
            "derart perfekten Lehrer gibt! :)",
            TEXT_START_LOCATION.getPositionX(),
            getYCoordinate(2)
        );

        g.drawString(
            "Gut, dass du von diesem Lehrer",
            TEXT_START_LOCATION.getPositionX(),
            getYCoordinate(3) + SECOND_PART_MARGIN
        );

        g.drawString(
            "(" + this.name + ") in " + this.subject + " unterrichtet wirst!",
            TEXT_START_LOCATION.getPositionX(),
            getYCoordinate(4) + SECOND_PART_MARGIN
        );
    }

    @Override
    public void actionPerformed(@NotNull final ActionEvent actionEvent) {
        // exit program
        System.exit(0);
    }
    //</editor-fold>
}
