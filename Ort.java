public class Ort implements Datenelement {
    private String name;
    /**
     * Liefert Schluesselwert des Datenelements
     * @return        Schluesselwert
     */
    public String schluesselGeben() {
        return this.name;
    }
    /**
     * Liefert Information zum Datenelements (z. B. fuer Druckausgabe)
     * @return        Information
     */
    public String infoGeben();
    /**
     * Vergleicht Datenelement mit Vergleichselement (VE)
     * @return        -1, wenn < VE, +1, wenn > VE, 0, wenn == VE
     */
    public int vergleiche(Datenelement daten);
    /**
     * Vergleicht Datenelement mit Vergleichselement (VE)
     * @return        -1, wenn < VE, +1, wenn > VE, 0, wenn == VE
     */
    public int vergleiche(String schluessel);

}
