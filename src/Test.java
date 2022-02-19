public class Test {
    public static void main(String[] args) {
        Graph g = new Graph(4);
        g.knotenEinfuegen(new Ort("A"));
        g.knotenEinfuegen(new Ort("B"));
        g.knotenEinfuegen(new Ort("C"));
        g.knotenEinfuegen(new Ort("D"));
        g.kanteEinfuegen("A", "B");
        g.kanteEinfuegen("B", "B");
        g.kanteEinfuegen("B", "C");
        g.kanteEinfuegen("B", "D");
        g.kanteEinfuegen("C", "A");
        g.kanteEinfuegen("C", "B");
        g.adjazenzmatrixAusgeben();
        System.out.println("Kante von B nach C löschen:");
        g.kanteEntfernen("B", "C");
        g.adjazenzmatrixAusgeben();
        System.out.println("Kante von C nach B löschen:");
        g.kanteEntfernen("C", "B");
        g.adjazenzmatrixAusgeben();
        System.out.println("Kante von C nach C einfügen:");
        g.kanteEinfuegen("C", "C");
        g.adjazenzmatrixAusgeben();
        System.out.println("Knoten B löschen:");
        g.knotenEntfernen("B");
        g.adjazenzmatrixAusgeben();
        System.out.println("Knoten C löschen:");
        g.knotenEntfernen("C");
        g.adjazenzmatrixAusgeben();
    }
}
