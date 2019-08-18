package service.input_reader;

import model.Graph;
import model.Vertex;

import java.io.IOException;
import java.util.List;

import static constants.Constants.DIESE_SYMBOL;
import static constants.Constants.NEXT_LINE_SYMBOL;
import static service.StaticHelper.initCornerVertex;

public abstract class AbstractFindPathInputReader {

    public abstract Graph getGraph() throws IOException;

    protected void addEdges(Graph graph, Vertex vertex, int width) {
        List<Vertex> vertices = graph.getVertices();

        Vertex leftNeighbourVertex = vertices.get(vertex.getId() - 1);
        if (vertex.getId() % width != 0 && leftNeighbourVertex.getValue() != DIESE_SYMBOL) {
            graph.addEdge(vertex, leftNeighbourVertex);
        }

        if (vertex.getId() >= width) {
            Vertex upNeighbourVertex = vertices.get(vertex.getId() - width);
            if (upNeighbourVertex.getValue() != DIESE_SYMBOL) {
                graph.addEdge(vertex, (vertices.get(vertex.getId() - width)));
            }
        }
    }

    protected void addVertex(Graph graph, char character, int width) {
        if (character == NEXT_LINE_SYMBOL)
            return;
        Vertex vertex = createVertex(character);
        graph.addVertex(vertex);
        callInitCornerVertex(graph, character, vertex);
        if (character != DIESE_SYMBOL && vertex.getId() != 0) {
            addEdges(graph, vertex, width);
        }
    }

    protected void callInitCornerVertex(Graph graph, char character, Vertex vertex) {
        initCornerVertex(graph, character, vertex);
    }

    protected Vertex createVertex(char character) {
        return new Vertex(character);
    }

}
