public class Graph {

    private Knoten[] knotenliste;
    private int[][] adjazenzmatrix;
    private int maxAnzahl;
    private int anzahl;

    /**
     * Konstruktor
     * @param maxAnzahl maximale Anzahl der Knoten im Graph
     */
    public Graph(int maxAnzahl) {
        this.maxAnzahl = maxAnzahl;
        this.anzahl = 0;
        this.knotenliste = new Knoten[maxAnzahl];
        this.adjazenzmatrix = new int[maxAnzahl][maxAnzahl];
        for (int z=0; z<maxAnzahl; z=z+1) {
            for (int s=0; s<maxAnzahl; s=s+1) {
                adjazenzmatrix[z][s] = 0;  // eigentlich unnoetig, da int-Werte ohnehin auf 0 initialisiert
            }
        }
    }

}
