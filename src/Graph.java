import java.util.ArrayList;
import java.util.HashMap;

public class Graph {

    private final ArrayList<Knoten> knotenliste;
    private final HashMap<Knoten,ArrayList<Kante>> adjazenzliste;

    /**
     * Liefert Index eines Knotens mit angegebenene Schluessel zurueck
     * -1 falls Knoten nicht existiert
     *
     * @param schluessel Schluessel des Knotens
     * @return Index des Knotens
     */
    private int knotenIndexGeben(String schluessel) {
        for (Knoten k : this.knotenliste) {
            if (k.datenGeben().vergleiche(schluessel) == 0) {
                return this.knotenliste.indexOf(k);
            }
        }
        return -1;
    }

    /**
     * Konstruktor
     *
     */
    public Graph() {
        this.knotenliste = new ArrayList<>();
        this.adjazenzliste = new HashMap<>();
    }

    /**
     * Fuegt neuen Knoten in den Graphen ein
     *
     * @param daten neu einzufuegendes Datenelement
     */
    public void knotenEinfuegen(Datenelement daten) {
        Knoten k = new Knoten(daten);
        this.knotenliste.add(k);
        this.adjazenzliste.put(k, new ArrayList<>());
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
            Kante kante = this.kanteFinden(this.knotenliste.get(vonIndex), this.knotenliste.get(nachIndex));
            if (kante != null) {
                kante.gewichtSetzen(gewicht);
            } else {
                this.adjazenzliste.get(this.knotenliste.get(vonIndex)).add(new Kante(this.knotenliste.get(nachIndex), gewicht));
            }
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
            Kante kante = this.kanteFinden(this.knotenliste.get(vonIndex), this.knotenliste.get(nachIndex));
            if (kante != null) {
                this.adjazenzliste.get(this.knotenliste.get(vonIndex)).remove(kante);
            }
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

    public Kante kanteFinden(Knoten von, Knoten nach) {
        ArrayList<Kante> kanten = this.adjazenzliste.get(von);
        for (Kante kante : kanten) {
            if (kante.zielGeben().equals(nach)) {
                return kante;
            }
        }
        return null;
    }

    /**
     * Ausgabe der Knotenliste
     */
    public void knotenAusgeben() {
        for (Knoten knoten : this.knotenliste) {
            System.out.print("\t" + knoten.datenGeben().schluesselGeben());
        }
        System.out.println();
    }

    /**
     * Adjazenzmatrix ausgeben
     */
    public void adjazenzmatrixAusgeben() {
        this.knotenAusgeben();
        for (int i = 0; i < this.knotenliste.size(); i++) {
            Knoten von = this.knotenliste.get(i);
            System.out.print(von.datenGeben().schluesselGeben());
            for (Knoten knoten : this.knotenliste) {
                if (this.kanteFinden(von, knoten) != null) {
                    System.out.print("\t" + this.kanteFinden(von, knoten).gewichtGeben());
                } else {
                    System.out.print("\t" + 0);
                }
            }
            System.out.println();
        }
    }

    /**
     * Prueft, ob der Graph gerichtet ist
     * @return True, falls der Graph gerichtet ist
     */
    public boolean istUngerichtet() {
        /*
        for (int i = 0; i < this.knotenliste.size(); i++) {
            for (int j = i + 1; j < this.knotenliste.size(); j++) {
                if (this.adjazenzmatrix[i][j] != this.adjazenzmatrix[j][i]) {
                    return false;
                }
            }
        }

         */
        return true;
    }

    /**
     * Entfernt Knoten mit angegebenen Schluessel
     * @param schluessel Schluessel des zu loeschenden Knotens
     */
    public void knotenEntfernen(String schluessel) {
        int knotenIndex = this.knotenIndexGeben(schluessel);
        if (knotenIndex >= 0) {
            Knoten kloesch = this.knotenliste.get(knotenIndex);
            // Kanten mit kloesch als Start loeschen
            this.adjazenzliste.remove(kloesch);
            // Kanten mit k als Ziel loeschen
            for (Knoten k : this.adjazenzliste.keySet()) {
                Kante kante = this.kanteFinden(k,kloesch);
                if (kante != null) {
                    this.adjazenzliste.get(k).remove(kante);
                }
            }
            // Knoten loeschen
            this.knotenliste.remove(kloesch);
        }
    }

    /**
     * Fuehrt den Algorithmus der Tiefensuche im Graphen durch
     * @param start Schluessel des Startknotens fuer Tiefensuche
     */
    public void dfsStarten(String start) {
        int startIndex = this.knotenIndexGeben(start);
        if (startIndex >= 0) {
            for (Knoten knoten : this.knotenliste) {
                knoten.besuchtSetzen(false);
            }
            System.out.print("Tiefensuche: ");
            this.dfs(this.knotenliste.get(startIndex));
            System.out.println();
        }
    }

    /**
     * Fuehrt rekursiv den Algorithmus der Tiefensuche im Graphen durch
     * @param akn Referenz auf aktiven Knotens
     */
    private void dfs(Knoten akn) {
        akn.besuchtSetzen(true);
        System.out.print(akn.datenGeben().infoGeben() + " ");
        for (Knoten k : this.knotenliste) {
            Kante kante = this.kanteFinden(akn, k);
            if (!k.besuchtGeben() && kante != null) {
                this.dfs(k);
            }
        }
    }

}
