package de.jonas.teacherrating.gui;

import de.jonas.teacherrating.object.Gui;
import de.jonas.teacherrating.object.ObjectLocation;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;

import javax.swing.JButton;

import java.awt.Graphics;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import static java.awt.Color.LIGHT_GRAY;

/**
 * Das {@link BuggyGui} stammt von dem {@link Gui} ab und auf diesem Fenster werden die verschiedenen Optionen
 * dargestellt, wie man seinen Lehrer bewerten möchte.
 */
@NotNull
public final class BuggyGui extends Gui implements ActionListener, MouseListener {

    //<editor-fold desc="CONSTANTS">
    /** Der Titel des {@link Gui}. */
    @NotNull
    private static final String TITLE = "Bewerte";
    /** Die Breite des {@link Gui}. */
    private static final int WIDTH = 500;
    /** Die Höhe des {@link Gui}. */
    private static final int HEIGHT = 400;
    /** Die Schriftgröße der Schrift auf den Buttons, mit dessen Hilfe man seine Option wählen kann. */
    private static final float BUTTON_FONT_SIZE = 15F;
    /** Die Schriftgröße des kleinen Info-Textes, welcher sich unter den Buttons befindet. */
    private static final float INFO_FONT_SIZE = 13F;
    /** Die Position des 'korrekten' Buttons. */
    @NotNull
    private static final ObjectLocation CORRECT_LOCATION = new ObjectLocation(50, 120, 150, 150);
    /** Die Position des 'inkorrekten' Buttons. */
    @NotNull
    private static final ObjectLocation INCORRECT_LOCATION = new ObjectLocation(300, 120, 150, 150);
    /** Die Position des Haupt-Text (welcher eine Bedeutung hat). */
    @NotNull
    private static final ObjectLocation MAIN_TEXT_LOCATION = new ObjectLocation(50, 70);
    /** Die Position des Info-Textes (welcher nur informativ dort steht). */
    @NotNull
    private static final ObjectLocation INFO_TEXT_LOCATION = new ObjectLocation(50, 350);
    //</editor-fold>


    //<editor-fold desc="LOCAL FIELDS">
    /** Der {@link Robot}, mit dessen Hilfe die Maus bewegt wird. */
    @NotNull
    private final Robot robot;
    /** Der Name des Lehrers. */
    @NotNull
    private final String name;
    /** Das Fach, welches der Lehrer unterrichtet. */
    @NotNull
    private final String subject;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">

    /**
     * Erzeugt eine neue Instanz eines {@link BuggyGui}. Das {@link BuggyGui} stammt von dem {@link Gui} ab und auf
     * diesem Fenster werden die verschiedenen Optionen dargestellt, wie man seinen Lehrer bewerten möchte.
     *
     * @param name    Der Name des Lehrers.
     * @param subject Das Fach, welches der Lehrer unterrichtet.
     */
    @SneakyThrows
    public BuggyGui(
        @NotNull final String name,
        @NotNull final String subject
    ) {
        super(
            TITLE,
            WIDTH,
            HEIGHT,
            LIGHT_GRAY
        );

        this.name = name;
        this.subject = subject;
        this.robot = new Robot();

        super.setUndecorated(true);

        final JButton correct = new JButton("<html>Ich habe nichts auszusetzen!</html>");
        super.addAttributes(correct, DEFAULT_FONT.deriveFont(BUTTON_FONT_SIZE));
        super.placeComponent(correct, CORRECT_LOCATION);
        correct.addActionListener(this);

        final JButton incorrect = new JButton("<html>Ich muss negatives zurückmelden!</html>");
        super.addAttributes(incorrect, DEFAULT_FONT.deriveFont(BUTTON_FONT_SIZE));
        super.placeComponent(incorrect, INCORRECT_LOCATION);
        incorrect.addMouseListener(this);

        super.add(correct);
        super.add(incorrect);

        // realize draw object
        super.draw();
    }
    //</editor-fold>


    //<editor-fold desc="implementation">
    @Override
    public void draw(@NotNull final Graphics g) {
        // draw main text
        g.setFont(DEFAULT_FONT);
        g.drawString(
            "Bitte wähle die passende Option:",
            MAIN_TEXT_LOCATION.getPositionX(),
            MAIN_TEXT_LOCATION.getPositionY()
        );

        g.drawString(
            "(" + this.name + " | " + this.subject + ")",
            MAIN_TEXT_LOCATION.getPositionX(),
            MAIN_TEXT_LOCATION.getPositionY() + DEFAULT_FONT.getSize()
        );

        // draw info text
        g.setFont(DEFAULT_FONT.deriveFont(INFO_FONT_SIZE));
        g.drawString(
            "Du kannst das Fenster nicht schließen,",
            INFO_TEXT_LOCATION.getPositionX(),
            INFO_TEXT_LOCATION.getPositionY()
        );

        g.drawString(
            "bevor du eine Option gewählt hast!",
            INFO_TEXT_LOCATION.getPositionX(),
            (int) (INFO_TEXT_LOCATION.getPositionY() + INFO_FONT_SIZE)
        );
    }

    @Override
    public void actionPerformed(@NotNull final ActionEvent actionEvent) {
        // close current gui
        this.close();

        // open result gui
        final ResultGui resultGui = new ResultGui(this.name, this.subject);
        resultGui.open();
    }

    @Override
    public void mouseClicked(@NotNull final MouseEvent mouseEvent) {

    }

    @Override
    public void mousePressed(@NotNull final MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(@NotNull final MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(@NotNull final MouseEvent mouseEvent) {
        this.robot.mouseMove(0, 0);
    }

    @Override
    public void mouseExited(@NotNull final MouseEvent mouseEvent) {

    }
    //</editor-fold>
}
