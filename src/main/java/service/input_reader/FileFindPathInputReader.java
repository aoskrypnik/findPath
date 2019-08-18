package service.input_reader;

import model.Graph;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileFindPathInputReader extends AbstractFindPathInputReader {

    private File file;

    public FileFindPathInputReader(File file) {
        this.file = file;
    }

    @Override
    public Graph getGraph() throws IOException {
        Graph graph = new Graph();
        FileReader fileReader = new FileReader(file);

        int width = getWidth();

        int c;
        while ((c = fileReader.read()) != -1) {
            char character = (char) c;
            addVertex(graph, character, width);
        }
        return graph;
    }

    private int getWidth() throws IOException {
        FileReader fr = new FileReader(file.getAbsoluteFile());
        BufferedReader bufferedReader = new BufferedReader(fr);
        String line = bufferedReader.readLine();
        return line.length();
    }

}
