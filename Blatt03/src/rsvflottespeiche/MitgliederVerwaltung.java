package rsvflottespeiche;

/**
 * Mitgliederverwaltung des RSV Flotte Speiche
 */
public class MitgliederVerwaltung {

    /**
     * Über diese Methode tritt ein neues Mitglied dem Verein bei.
     *
     * @param name  Nachname des neuen Mitglieds. Darf nicht leer sein und muss mit einem Großbuchstaben beginnen.
     * @param alter Alter des neuen Mitglieds in Jahren. Aus versicherungstechnischen Gründen können nur Personen
     *              zwischen 20 und 60 Jahren (jeweils inklusive) Mitglied werden.
     * @param typ   Spezialisierung des neuen Mitglieds. Da der Verein nicht über ein Schwimmbecken und auch nicht
     *              über eine Bahn verfügt, werden Beitrittswünsche mit den Spezialisierungen `Triathlon` und `Bahn`
     *              zurückgewiesen. D.h. es werden nur Mitglieder aufgenommen, die entweder `Marathon`-, `Zeitfahren`-,
     *              `Klassiker`- oder `Rundfahrt`-Spezialisten sind.
     * @return String, der aus dem ersten Buchstaben des Namens, den beiden Ziffern des Alters und dem ersten
     * Buchstaben der Sportart gebildet wird.
     * @throws IllegalArgumentException Wird geworfen, falls die Argumente (entsprechend dem ersten ungültigen
     *                                  Parameter, von links nach rechts) nicht der Spezifikation gehorchen:
     *                                  <code>throw new NameException();</code> falls der Name nicht gültig ist,
     *                                  <code>throw new AlterException();</code> falls das Alter nicht gültig ist,
     *                                  <code>throw new SportartException("Sportart: Triathlon");</code> falls als Sportart Triathlon angegeben wurde,
     *                                  <code>throw new SportartException("Sportart: Bahn");</code> falls als Sportart Bahn angegeben wurde,
     *                                  <code>throw new SportartException();</code> falls die Sportart sonst nicht gültig ist.
     */
    public String beitritt(String name, int alter, SportArt typ) throws IllegalArgumentException {
        String mitgliedsnummer = "";
        // Konkrete Implementierung der Methode unbekannt; Verhalten siehe Aufgabe/JavaDoc
        return mitgliedsnummer;
    }

}
