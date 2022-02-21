public class Graph {

    private final Knoten[] knotenliste;
    private final int[][] adjazenzmatrix;
    private final int maxAnzahl;
    private int anzahl;

    /**
     * Liefert Index eines Knotens mit angegebenene Schluessel zurueck
     * -1 falls Knoten nicht existiert
     *
     * @param schluessel Schluessel des Knotens
     * @return Index des Knotens
     */
    private int knotenIndexGeben(String schluessel) {
        for (int i = 0; i < this.anzahl; i++) {
            if (this.knotenliste[i].datenGeben().vergleiche(schluessel) == 0) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Konstruktor
     *
     * @param maxAnzahl maximale Anzahl der Knoten im Graph
     */
    public Graph(int maxAnzahl) {
        this.maxAnzahl = maxAnzahl;
        this.anzahl = 0;
        this.knotenliste = new Knoten[maxAnzahl];
        this.adjazenzmatrix = new int[maxAnzahl][maxAnzahl];
        for (int z = 0; z < maxAnzahl; z = z + 1) {
            for (int s = 0; s < maxAnzahl; s = s + 1) {
                adjazenzmatrix[z][s] = 0;  // eigentlich unnoetig, da int-Werte ohnehin auf 0 initialisiert
            }
        }
    }

    /**
     * Fuegt neuen Knoten in den Graphen ein
     *
     * @param daten neu einzufuegendes Datenelement
     */
    public void knotenEinfuegen(Datenelement daten) {
        if (this.anzahl < this.maxAnzahl) {
            this.knotenliste[this.anzahl] = new Knoten(daten);
            this.anzahl++;
        } else {
            System.out.println("Maximale Zahl an Knoten bereits eingefügt.");
        }
    }

    /**
     * Fuegt neue Kante ein
     *
     * @param von     Schluessel des Anfangsknotens
     * @param nach    Schluessel des Endknotens
     * @param gewicht Kantengewicht
     */
    public void kanteEinfuegen(String von, String nach, int gewicht) {
        int vonIndex = this.knotenIndexGeben(von);
        int nachIndex = this.knotenIndexGeben(nach);
        if (vonIndex >= 0 && nachIndex >= 0) {
            this.adjazenzmatrix[vonIndex][nachIndex] = gewicht;
        }
    }

    /**
     * Fuegt ungewichtete Kante ein
     *
     * @param von  Schluessel des Anfangsknotens
     * @param nach Schluessel des Endknotens
     */
    public void kanteEinfuegen(String von, String nach) {
        this.kanteEinfuegen(von, nach, 1);
    }

    /**
     * Fuegt ungerichtete Kante ein
     *
     * @param von     Schluessel des Anfangsknotens
     * @param nach    Schluessel des Endknotens
     * @param gewicht Kantengewicht
     */
    public void ungerichteteKanteEinfuegen(String von, String nach, int gewicht) {
        this.kanteEinfuegen(von, nach, gewicht);
        this.kanteEinfuegen(nach, von, gewicht);
    }

    /**
     * Fuegt ungewichtete ungerichtete Kante ein
     *
     * @param von  Schluessel des Anfangsknotens
     * @param nach Schluessel des Endknotens
     */
    public void ungerichteteKanteEinfuegen(String von, String nach) {
        this.ungerichteteKanteEinfuegen(von, nach, 1);
    }

    /**
     * Entfernt Kante aus Graph
     *
     * @param von  Schluessel des Anfangsknotens
     * @param nach Schluessel des Endknotens
     */
    public void kanteEntfernen(String von, String nach) {
        int vonIndex = this.knotenIndexGeben(von);
        int nachIndex = this.knotenIndexGeben(nach);
        if (vonIndex >= 0 && nachIndex >= 0) {
            this.adjazenzmatrix[vonIndex][nachIndex] = 0;
        }
    }

    /**
     * Entfernt ungerichtete Kante aus Graph
     *
     * @param von  Schlussel des Anfangsknotens
     * @param nach Schluessel des Endknotens
     */
    public void ungerichteteKanteEntfernen(String von, String nach) {
        this.kanteEntfernen(von, nach);
        this.kanteEntfernen(nach, von);
    }

    /**
     * Ausgabe der Knotenliste
     */
    public void knotenAusgeben() {
        for (int i = 0; i < this.anzahl; i++) {
            System.out.print("\t" + this.knotenliste[i].datenGeben().schluesselGeben());
        }
        System.out.println();
    }

    /**
     * Adjazenzmatrix ausgeben
     */
    public void adjazenzmatrixAusgeben() {
        this.knotenAusgeben();
        for (int i = 0; i < this.anzahl; i++) {
            System.out.print(this.knotenliste[i].datenGeben().schluesselGeben());
            for (int j = 0; j < this.anzahl; j++) {
                System.out.print("\t" + this.adjazenzmatrix[i][j]);
            }
            System.out.println();
        }
    }

    /**
     * Prueft, ob der Graph gerichtet ist
     * @return True, falls der Graph gerichtet ist
     */
    public boolean istUngerichtet() {
        for (int i=0; i<this.anzahl; i++) {
            for (int j=i+1; j<this.anzahl; j++) {
                if (this.adjazenzmatrix[i][j] != this.adjazenzmatrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * Entfernt Knoten mit angegebenen Schluessel
     * @param schluessel Schluessel des zu loeschenden Knotens
     */
    public void knotenEntfernen(String schluessel) {
        int knotenIndex = this.knotenIndexGeben(schluessel);
        if (knotenIndex >= 0) {
            // Spalten vorruecken
            for (int i=0; i<this.anzahl; i++) {
                for (int j=knotenIndex+1; j<this.anzahl; j++) {
                    this.adjazenzmatrix[i][j-1] = this.adjazenzmatrix[i][j];
                }
                this.adjazenzmatrix[i][this.anzahl-1] = 0;
            }
            // Zeilen hochruecken
            for (int i=0; i<this.anzahl; i++) {
                for (int j=knotenIndex+1; j<this.anzahl; j++) {
                    this.adjazenzmatrix[j-1][i] = this.adjazenzmatrix[j][i];
                }
                this.adjazenzmatrix[this.anzahl-1][i] = 0;
            }
            for (int i=knotenIndex+1; i<this.anzahl; i++) {
                this.knotenliste[i-1] = this.knotenliste[i];
            }
            this.knotenliste[this.anzahl-1] = null;
            this.anzahl--;
        }
    }

    /**
     * Fuehrt den Algorithmus der Tiefensuche im Graphen durch
     * @param start Schluessel des Startknotens fuer Tiefensuche
     */
    public void dfsStarten(String start) {
        int startIndex = this.knotenIndexGeben(start);
        if (startIndex >= 0) {
            for (int i=0; i<this.anzahl; i++) {
                this.knotenliste[i].besuchtSetzen(false);
            }
            System.out.print("Tiefensuche: ");
            this.dfs(startIndex);
            System.out.println();
        }
    }

    /**
     * Fuehrt rekursiv den Algorithmus der Tiefensuche im Graphen durch
     * @param index Index des aktiven Knotens
     */
    private void dfs(int index) {
        Knoten akn = this.knotenliste[index];
        akn.besuchtSetzen(true);
        System.out.print(akn.datenGeben().infoGeben() + " ");
        for (int i=0; i<this.anzahl; i++) {
            if (this.adjazenzmatrix[index][i] != 0 && this.knotenliste[i].besuchtGeben() == false) {
                this.dfs(i);
            }
        }
    }

}
