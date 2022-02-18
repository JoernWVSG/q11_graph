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
        g.ungerichteteKanteEinfuegen("B", "D");
        //g.kanteEinfuegen("E","A");
        g.adjazenzmatrixAusgeben();
        System.out.print("Maxtrix gewichtet: ");
        System.out.println(g.istUngerichtet()?"Ja":"Nein");
        g.knotenEntfernen("C");
        g.adjazenzmatrixAusgeben();
        g.knotenEntfernen("A");
        g.adjazenzmatrixAusgeben();
        g.knotenEntfernen("E");
        g.adjazenzmatrixAusgeben();
        g.knotenEinfuegen(new Ort("A"));
        g.adjazenzmatrixAusgeben();
    }
}
