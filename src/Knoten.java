public class Knoten {

    private Datenelement daten;
    private boolean besucht;

    /**
     *
     * @param daten Datenelement des neuen Knotens
     */
    public Knoten(Datenelement daten) {
        this.daten = daten;
    }

    /**
     * Getter daten
     * @return Referenz auf Datenelement
     */
    public Datenelement datenGeben() {
        return this.daten;
    }

    /**
     * Setter daten
     * @param daten Referenz auf Datenelement
     */
    public void datenSetzen(Datenelement daten) {
        this.daten = daten;
    }

    /**
     * Getter besucht
     * @return Wert von besucht
     */
    public boolean besuchtGeben() {
        return this.besucht;
    }

    /**
     * Setter besucht
     * @param besucht Setze auf besucht
     */
    public void besuchtSetzen(boolean besucht) {
        this.besucht = besucht;
    }
}
