package rsvflottespeiche;

/**
 * Aufzählung der zu betrachtenden Radsportarten
 */
enum SportArt {
    /**
     * Spezialist für Langstrecken (Eintages-Rennen, mit und ohne Team)
     */
    Marathon,

    /**
     * Spezialist für Zeitfahren (kürzere, aber extrem schnelle Rennen: Alleine gegen die Uhr)
     */
    Zeitfahren,

    /**
     * Spezialist für die Frühjahrsklassiker (Eintages-Rennen mit Team)
     */
    Klassiker,

    /**
     * Spezialist für die großen Landesrundfahrten (Mehrtages-Rennen mit Team)
     */
    Rundfahrt,

    /**
     * Einzelkämpfer, muss neben Radfahren noch Laufen und Schwimmen
     */
    Triathlon,

    /**
     * Fährt immer im Kreis ...
     */
    Bahn
}
