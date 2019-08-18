package service.algorithm;

import exceptions.PathNotExistsException;
import model.Graph;
import model.Vertex;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import static constants.Constants.EXCEPTION_MESSAGE;
import static constants.Constants.MAXIMUM;
import static java.util.Collections.reverse;

public class BreadthFirstSearch {

    private boolean[] marked;
    private int[] previousEdgeTo;
    private int[] distanceTo;

    public BreadthFirstSearch(Graph graph) {
        int size = graph.getNumberOfVertices();
        marked = new boolean[size];
        previousEdgeTo = new int[size];
        distanceTo = new int[size];
        performBreadthFirstSearch(graph, graph.getStartVertex());
    }

    public List<Integer> pathTo(Vertex finish) throws PathNotExistsException {
        List<Integer> path = new ArrayList<>();
        int vertexId = finish.getId();

        if (!marked[vertexId]) {
            throw new PathNotExistsException(EXCEPTION_MESSAGE);
        }

        int currentId;
        for (currentId = vertexId; distanceTo[currentId] != 0; currentId = previousEdgeTo[currentId]) {
            path.add(currentId);
        }
        path.add(currentId);

        reverse(path);

        return path;
    }

    private void performBreadthFirstSearch(Graph graph, Vertex start) {
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < graph.getNumberOfVertices(); i++) {
            distanceTo[i] = MAXIMUM;
        }

        distanceTo[start.getId()] = 0;
        marked[start.getId()] = true;
        queue.add(start.getId());

        while (!queue.isEmpty()) {
            int id = queue.poll();
            for (Vertex w : graph.getAdjacentVertices(id)) {
                int wId = w.getId();
                if (!marked[wId]) {
                    previousEdgeTo[wId] = id;
                    distanceTo[wId] = distanceTo[id] + 1;
                    marked[wId] = true;
                    queue.add(wId);
                }
            }
        }
    }

}
