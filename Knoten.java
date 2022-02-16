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
     * Liefert Referenz auf Datenelement zurueck
     * @return Referenz auf Datenelement
     */
    public Datenelement datenGeben() {
        return this.daten;
    }
}
