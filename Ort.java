public class Ort implements Datenelement {
    private String name;

    /**
     *
     * @param name Name des Orts
     */
    public Ort(String name) {
        this.name = name;
    }
    /**
     * Liefert Schluesselwert des Datenelements
     * @return        Schluesselwert
     */
    @Override
    public String schluesselGeben() {
        return this.name;
    }
    /**
     * Liefert Information zum Datenelements (z. B. fuer Druckausgabe)
     * @return        Information
     */
    @Override
    public String infoGeben() {
        return this.name;
    }
    /**
     * Vergleicht Datenelement mit Vergleichselement (VE)
     * @return        -1, wenn < VE, +1, wenn > VE, 0, wenn == VE
     */
    @Override
    public int vergleiche(Datenelement daten) {
        return this.name.compareTo(daten.schluesselGeben());
    }
    /**
     * Vergleicht Datenelement mit Vergleichselement (VE)
     * @return        -1, wenn < VE, +1, wenn > VE, 0, wenn == VE
     */
    @Override
    public int vergleiche(String schluessel) {
        return this.name.compareTo(schluessel);
    }

}
