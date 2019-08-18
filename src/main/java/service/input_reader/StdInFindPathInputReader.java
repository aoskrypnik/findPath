package service.input_reader;

import model.Graph;

import java.util.Scanner;

public class StdInFindPathInputReader extends AbstractFindPathInputReader {

    @Override
    public Graph getGraph() {
        StringBuilder stringBuilder = new StringBuilder();
        Scanner scanner = new Scanner(System.in);

        String current = scanner.nextLine();
        int width = current.length();

        stringBuilder.append(current);
        while (scanner.hasNextLine()) {
            stringBuilder.append(scanner.nextLine());
        }

        Graph graph = new Graph();
        for (int i = 0; i < stringBuilder.length(); i++) {
            char character = stringBuilder.charAt(i);
            addVertex(graph, character, width);
        }

        return graph;
    }

}
