public class Test {
    public static void main(String[] args) {
        Graph g = new Graph(5);
        g.knotenEinfuegen(new Ort("A"));
        g.knotenEinfuegen(new Ort("B"));
        g.knotenEinfuegen(new Ort("C"));
        g.knotenEinfuegen(new Ort("D"));
        g.knotenEinfuegen(new Ort("E"));
        g.ungerichteteKanteEinfuegen("A", "B");
        g.ungerichteteKanteEinfuegen("A", "C");
        g.ungerichteteKanteEinfuegen("A", "D");
        g.ungerichteteKanteEinfuegen("C", "D");
        g.ungerichteteKanteEinfuegen("D", "E");
        g.adjazenzmatrixAusgeben();
    }
}
