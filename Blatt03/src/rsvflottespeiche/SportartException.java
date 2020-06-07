package rsvflottespeiche;

/**
 * Wird von MitgliederVerwaltung#beitritt geworfen, wenn die Sportart ungültig ist
 * <p>
 * Differenzierung in der Message:
 * - <code>throw new SportartException("Sportart: Triathlon");</code> (falls als Sportart Triathlon angegeben wurde)
 * - <code>throw new SportartException("Sportart: Bahn");</code> (falls als Sportart Bahn angegeben wurde)
 * - <code>throw new SportartException();</code> (sonstige ungültige Sportarten)
 */
class SportartException extends IllegalArgumentException {
    public SportartException(String s) {
        super(s);
    }

    public SportartException() {
        super();
    }
}
