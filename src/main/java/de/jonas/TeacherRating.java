package de.jonas;

import de.jonas.teacherrating.gui.StartGui;
import org.jetbrains.annotations.NotNull;

/**
 * Die Haupt- und Main-Klasse der Anwendung, in welcher die gesamte Anwendung initialisiert und gestartet wird.
 */
@NotNull
public final class TeacherRating {

    //<editor-fold desc="setup and start">

    /**
     * Die Main-Methode, welche von der JRE sofort und als aller erstes, vor allen anderen Methoden aufgerufen wird.
     *
     * @param args Die Argumente, die von der JRE an diese Anwendung übergeben werden.
     */
    public static void main(final String[] args) {
        new StartGui().open();
    }
    //</editor-fold>

}
