public class Kante {

    private Knoten ziel;
    private int gewicht;

    public Kante(Knoten ziel, int gewicht) {
        this.ziel  = ziel;
        this.gewicht = gewicht;
    }

    public Knoten zielGeben() {
        return this.ziel;
    }

    public void zielSetzen(Knoten ziel) {
        this.ziel = ziel;
    }

    public int gewichtGeben() {
        return this.gewicht;
    }

    public void gewichtSetzen(int gewicht) {
        this.gewicht = gewicht;
    }
}
