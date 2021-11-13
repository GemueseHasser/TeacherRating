package de.jonas.teacherrating.object;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Range;

/**
 * Eine {@link ObjectLocation} ist eine Position eines Objekts, welche sowohl eine X- als auch eine Y-Koordinate
 * besitzt. Zudem kann in diesem Objekt die Breite und die Höhe gespeichert werden.
 */
@Getter
@NotNull
@RequiredArgsConstructor
public final class ObjectLocation {

    //<editor-fold desc="LOCAL FIELDS">
    /** Die X-Position des Objekts. */
    private final int positionX;
    /** Die Y-Position des Objekts. */
    private final int positionY;
    /** Die Breite des Objekts. */
    private int width;
    /** Die Höhe des Objekts. */
    private int height;
    //</editor-fold>


    //<editor-fold desc="CONSTRUCTORS">

    /**
     * Erzeugt eine neue und vollständig unabhängige {@link ObjectLocation}. Diese {@link ObjectLocation} wird nicht
     * über {@link RequiredArgsConstructor} erstellt, denn bei dieser Instanziierung werden alle Parameter, also die X-
     * und Y-Koordinate und sowohl Breite als auch Höhe angegeben.
     *
     * @param positionX Die X-Koordinate der {@link ObjectLocation}.
     * @param positionY Die Y-Koordinate der {@link ObjectLocation}.
     * @param width     Die Breite der {@link ObjectLocation}.
     * @param height    Die Höhe der {@link ObjectLocation}.
     */
    public ObjectLocation(
        @Range(from = 0, to = Integer.MAX_VALUE) final int positionX,
        @Range(from = 0, to = Integer.MAX_VALUE) final int positionY,
        @Range(from = 0, to = Integer.MAX_VALUE) final int width,
        @Range(from = 0, to = Integer.MAX_VALUE) final int height
    ) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;
    }
    //</editor-fold>

}
