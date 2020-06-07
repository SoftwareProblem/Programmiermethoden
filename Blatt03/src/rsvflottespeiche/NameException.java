package rsvflottespeiche;

/**
 * Wird von MitgliederVerwaltung#beitritt geworfen, wenn der Name ungültig ist
 */
class NameException extends IllegalArgumentException {
    public NameException() {
        super();
    }
}
