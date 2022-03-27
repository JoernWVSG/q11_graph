public class Test {
    public static void main(String[] args) {
        Graph g = new Graph(12);
        g.knotenEinfuegen(new Ort("A"));
        g.knotenEinfuegen(new Ort("B"));
        g.knotenEinfuegen(new Ort("C"));
        g.knotenEinfuegen(new Ort("D"));
        g.knotenEinfuegen(new Ort("E"));
        g.knotenEinfuegen(new Ort("F"));
        g.knotenEinfuegen(new Ort("G"));
        g.knotenEinfuegen(new Ort("H"));
        g.knotenEinfuegen(new Ort("I"));
        g.knotenEinfuegen(new Ort("J"));
        g.knotenEinfuegen(new Ort("K"));
        g.ungerichteteKanteEinfuegen("A","B", 10);
        g.ungerichteteKanteEinfuegen("A","C", 20);
        g.ungerichteteKanteEinfuegen("B","D", 10);
        g.ungerichteteKanteEinfuegen("B","E", 20);
        g.ungerichteteKanteEinfuegen("C","F", 30);
        g.ungerichteteKanteEinfuegen("C","G", 10);
        g.ungerichteteKanteEinfuegen("D","H", 10);
        g.ungerichteteKanteEinfuegen("E","F", 10);
        g.ungerichteteKanteEinfuegen("F","G", 10);
        g.ungerichteteKanteEinfuegen("H","J", 10);
        g.ungerichteteKanteEinfuegen("F","J", 10);
        g.ungerichteteKanteEinfuegen("F","K", 10);
        g.dijkstraDurchfuehren("A");
        g.dijkstraPfadDrucken("K");
    }
}
