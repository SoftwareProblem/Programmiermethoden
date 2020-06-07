package rsvflottespeiche;

/**
 * Wird von MitgliederVerwaltung#beitritt geworfen, wenn das Alter ungültig ist
 */
class AlterException extends IllegalArgumentException {
    public AlterException() {
        super();
    }
}
