public class Test {
    public static void main(String[] args) {
        Graph g = new Graph(20);
        g.knotenEinfuegen(new Ort("A"));
        g.knotenEinfuegen(new Ort("F"));
        g.knotenEinfuegen(new Ort("FD"));
        g.knotenEinfuegen(new Ort("HO"));
        g.knotenEinfuegen(new Ort("KA"));
        g.knotenEinfuegen(new Ort("LI"));
        g.knotenEinfuegen(new Ort("M"));
        g.knotenEinfuegen(new Ort("N"));
        g.knotenEinfuegen(new Ort("PA"));
        g.knotenEinfuegen(new Ort("R"));
        g.knotenEinfuegen(new Ort("RO"));
        g.knotenEinfuegen(new Ort("S"));
        g.knotenEinfuegen(new Ort("UL"));
        g.knotenEinfuegen(new Ort("WÜ"));
        g.ungerichteteKanteEinfuegen("RO","M");
        g.ungerichteteKanteEinfuegen("M","A");
        g.ungerichteteKanteEinfuegen("A","UL");
        g.ungerichteteKanteEinfuegen("UL","LI");
        g.ungerichteteKanteEinfuegen("UL","S");
        g.ungerichteteKanteEinfuegen("S","KA");
        g.ungerichteteKanteEinfuegen("KA","F");
        g.ungerichteteKanteEinfuegen("F","WÜ");
        g.ungerichteteKanteEinfuegen("WÜ","S");
        g.ungerichteteKanteEinfuegen("WÜ","UL");
        g.ungerichteteKanteEinfuegen("WÜ","FD");
        g.ungerichteteKanteEinfuegen("WÜ","N");
        g.ungerichteteKanteEinfuegen("N","M");
        g.ungerichteteKanteEinfuegen("N","HO");
        g.ungerichteteKanteEinfuegen("N","R");
        g.ungerichteteKanteEinfuegen("R","M");
        g.ungerichteteKanteEinfuegen("R","PA");
        g.ungerichteteKanteEinfuegen("WÜ","HO");
        g.ungerichteteKanteEinfuegen("R","HO");
        g.adjazenzmatrixAusgeben();
        g.dfsStarten("M");
        g.dfsIterativ("M");
    }
}
