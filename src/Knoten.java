public class Knoten {

    private Datenelement daten;

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
}
