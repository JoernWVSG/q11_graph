public class Graph {

    private Knoten[] knotenliste;
    private int[][] adjazenzmatrix;
    private int maxAnzahl;
    private int anzahl;

    /**
     * Liefert Index eines Knotens mit angegebenene Schluessel zurueck
     * -1 falls Knoten nicht existiert
     * @param schluessel
     * @return Index des Knotens
     */
    private int knotenIndexGeben(String schluessel) {
        for (int i=0; i<this.anzahl; i++) {
            if (this.knotenliste[i].datenGeben().vergleiche(schluessel) == 0) {
                return i;
            }
        }
        return -1;
    }

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

    /**
     * Fuegt neuen Knoten in den Graphen ein
     * @param daten
     */
    public void einfuegen(Datenelement daten) {
        if (this.anzahl < this.maxAnzahl) {
            this.knotenliste[this.anzahl] = new Knoten(daten);
            this.anzahl++;
        } else {
            System.out.println("Maximale Zahl an Knoten bereits eingefügt.");
        }
    }

    /**
     * Fuegt neue Kante ein
     * @param von Schluessel des Anfangsknotens
     * @param nach Schluessel des Endknotens
     * @param gewicht Kantengewicht
     */
    public void kanteEinfuegen(String von, String nach, int gewicht) {
        int vonIndex = this.knotenIndexGeben(von);
        int nachIndex = this.knotenIndexGeben(nach);
        if (vonIndex == 0 && nachIndex == 0) {
            this.adjazenzmatrix[vonIndex][nachIndex] = gewicht;
        }
    }

    /**
     * Fuegt ungewichtete Kante ein
     * @param von Schluessel des Anfangsknotens
     * @param nach Schluessel des Endknotens
     */
    public void kanteEinfuegen(String von, String nach) {
        this.kanteEinfuegen(von, nach, 1);
    }

    /**
     * Fuegt ungerichtete Kante ein
     * @param von Schluessel des Anfangsknotens
     * @param nach Schluessel des Endknotens
     * @param gewicht Kantengewicht
     */
    public void ungerichteteKanteEinfuegen(String von, String nach, int gewicht) {
        this.kanteEinfuegen(von, nach, gewicht);
        this.kanteEinfuegen(nach, von, gewicht);
    }

    /**
     * Fuegt ungewichtete ungerichtete Kante ein
     * @param von Schluessel des Anfangsknotens
     * @param nach Schluessel des Endknotens
     */
    public void ungerichteteKanteEinfuegen(String von, String nach) {
        this.ungerichteteKanteEinfuegen(von, nach, 1);
    }

}
