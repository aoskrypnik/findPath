package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<Vertex, List<Vertex>> adjacentVertices;
    private List<Vertex> vertices;
    private Vertex startVertex;
    private Vertex finishVertex;

    public Graph() {
        Vertex.setFreeId(0);
        adjacentVertices = new HashMap<>();
        vertices = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {
        adjacentVertices.put(vertex, new ArrayList<>());
        vertices.add(vertex);
    }

    public void addEdge(Vertex vertex1, Vertex vertex2) {
        adjacentVertices.get(vertex1).add(vertex2);
        adjacentVertices.get(vertex2).add(vertex1);
    }

    public int getNumberOfVertices() {
        return vertices.size();
    }

    public List<Vertex> getAdjacentVertices(int id) {
        return adjacentVertices.get(vertices.get(id));
    }

    public List<Vertex> getVertices() {
        return vertices;
    }

    public Vertex getStartVertex() {
        return startVertex;
    }

    public void setStartVertex(Vertex startVertex) {
        this.startVertex = startVertex;
    }

    public Vertex getFinishVertex() {
        return finishVertex;
    }

    public void setFinishVertex(Vertex finishVertex) {
        this.finishVertex = finishVertex;
    }

}
