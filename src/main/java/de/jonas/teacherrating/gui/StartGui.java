package de.jonas.teacherrating.gui;

import de.jonas.teacherrating.object.Gui;
import de.jonas.teacherrating.object.ObjectLocation;
import org.jetbrains.annotations.NotNull;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.TextAttribute;
import java.util.Map;

import static java.awt.Color.LIGHT_GRAY;

/**
 * Ein {@link StartGui} stammt von einem {@link Gui} ab und es stellt das {@link Gui} dar, welches als erstes geöffnet
 * wird, nachdem die Anwendung gestartet wurde.
 */
public final class StartGui extends Gui implements ActionListener, KeyListener {

    //<editor-fold desc="CONSTANTS">
    /** Der Titel des Fensters. */
    private static final String TITLE = "Sammle Daten...";
    /** Die Breite des Fensters. */
    private static final int WIDTH = 750;
    /** Die Höhe des Fensters. */
    private static final int HEIGHT = 300;

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

    //<editor-fold desc="name field">
    /** Die Position, an der sich der Text für das Namens-Feld befindet. */
    private static final ObjectLocation NAME_FIELD_TEXT = new ObjectLocation(40, 100);
    /** Die Position, an der sich das Namens-Feld befindet. */
    private static final ObjectLocation NAME_FIELD = new ObjectLocation(130, 75, 120, 40);
    //</editor-fold>

    //<editor-fold desc="subject field">
    /** Die Position, an der sich der Text für das Auswahlfeld des Fachs befindet. */
    private static final ObjectLocation SUBJECT_FIELD_TEXT = new ObjectLocation(40, 180);
    /** Alle Fächer, die als Option zur Auswahl stehen. */
    private static final String @NotNull [] SUBJECT_OPTIONS = {
        "Biologie",
        "Chemie",
        "Deutsch",
        "Englisch",
        "Geographie",
        "Französisch",
        "Geschichte",
        "Informatik",
        "Kunst",
        "Latein",
        "Mathematik",
        "Musik",
        "Pädagogik",
        "Philosophie",
        "Physik",
        "Politik",
        "Religion, ev.",
        "Religion, kath.",
        "Spanisch",
        "Sport",
    };
    /** Die Position, an der sich die Auswahl-Box für das Fach befindet. */
    private static final ObjectLocation SUBJECT_FIELD = new ObjectLocation(130, 155, 120, 40);
    //</editor-fold>

    /** Die Position des Buttons, um seine Auswahl zu bestätigen. */
    private static final ObjectLocation CONFIRM_BUTTON = new ObjectLocation(450, 115, 150, 40);

    //</editor-fold>


    //<editor-fold desc="LOCAL FIELDS">
    /** Das Text-Feld, wo der Name des Lehrers eingetragen wird. */
    private final JTextField textField = new JTextField();
    /** Die Auswahl-Box, wo man das Fach auswählen kann. */
    private final JComboBox<String> subjectBox = new JComboBox<>(SUBJECT_OPTIONS);
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

        super.addKeyListener(this);

        this.textField.setBounds(
            NAME_FIELD.getPositionX(),
            NAME_FIELD.getPositionY(),
            NAME_FIELD.getWidth(),
            NAME_FIELD.getHeight()
        );
        this.textField.addKeyListener(this);

        this.subjectBox.setBounds(
            SUBJECT_FIELD.getPositionX(),
            SUBJECT_FIELD.getPositionY(),
            SUBJECT_FIELD.getWidth(),
            SUBJECT_FIELD.getHeight()
        );
        this.subjectBox.setFocusable(false);

        final JButton confirmButton = new JButton("Bestätigen");
        confirmButton.setBounds(
            CONFIRM_BUTTON.getPositionX(),
            CONFIRM_BUTTON.getPositionY(),
            CONFIRM_BUTTON.getWidth(),
            CONFIRM_BUTTON.getHeight()
        );
        confirmButton.setFocusable(false);
        confirmButton.setOpaque(true);
        confirmButton.setBackground(Color.DARK_GRAY);
        confirmButton.setForeground(Color.WHITE);
        confirmButton.addActionListener(this);

        super.add(textField);
        super.add(subjectBox);
        super.add(confirmButton);

        // realize draw object
        super.draw();
    }
    //</editor-fold>


    /**
     * Führt die Aktion aus, um die Auswahl zu bestätigen. Dies geschieht entweder über die Enter-Taste, oder über den
     * entsprechenden Button.
     */
    private void doAction() {
        final String name = this.textField.getText().strip();
        final String subject = (String) this.subjectBox.getSelectedItem();

        // check if name is empty
        if (name.equalsIgnoreCase("")) return;

        // close current gui
        this.close();

        // open buggy gui
        assert subject != null;
        final BuggyGui buggyGui = new BuggyGui(name, subject);

        buggyGui.open();
    }

    //<editor-fold desc="implementation">
    @Override
    public void draw(@NotNull final Graphics g) {
        // draw heading
        g.setFont(HEADING_FONT.deriveFont(HEADING_ATTRIBUTES));

        final int headingWidth = g.getFontMetrics().stringWidth(super.getTitle());
        final int x = (super.getWidth() / 2) - (headingWidth / 2);

        g.drawString(TITLE, x, HEADING_MARGIN_TOP);

        // draw name field text
        g.setFont(DEFAULT_FONT);

        g.drawString("Name:", NAME_FIELD_TEXT.getPositionX(), NAME_FIELD_TEXT.getPositionY());
        g.drawString("Fach:", SUBJECT_FIELD_TEXT.getPositionX(), SUBJECT_FIELD_TEXT.getPositionY());
    }

    @Override
    public void actionPerformed(@NotNull final ActionEvent actionEvent) {
        doAction();
    }

    @Override
    public void keyTyped(@NotNull final KeyEvent keyEvent) {

    }

    @Override
    public void keyPressed(@NotNull final KeyEvent keyEvent) {
        // check if enter is pressed
        if (keyEvent.getKeyCode() != KeyEvent.VK_ENTER) return;

        doAction();
    }

    @Override
    public void keyReleased(@NotNull final KeyEvent keyEvent) {

    }
    //</editor-fold>
}
