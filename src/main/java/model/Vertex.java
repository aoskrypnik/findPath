package model;

public class Vertex {

    private static int freeId = 0;

    private int id;
    private char value;

    public Vertex(char value) {
        this.id = freeId++;
        this.value = value;
    }

    public char getValue() {
        return value;
    }

    public int getId() {
        return id;
    }

    static void setFreeId(int freeId) {
        Vertex.freeId = freeId;
    }

}
