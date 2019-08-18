import exceptions.PathNotExistsException;
import model.Graph;
import service.algorithm.BreadthFirstSearch;
import service.input_reader.AbstractFindPathInputReader;
import service.input_reader.FileFindPathInputReader;
import service.input_reader.StdInFindPathInputReader;

import java.io.IOException;

import static constants.Constants.FILE_WITH_TEST_DATA_1;
import static constants.Constants.FILE_WITH_TEST_DATA_2;
import static constants.Constants.FILE_WITH_TEST_DATA_FAIL;
import static service.StaticHelper.getThePath;

public class Run {

    public static void main(String[] args) throws IOException, PathNotExistsException {
        runWith(new FileFindPathInputReader(FILE_WITH_TEST_DATA_1));
//        runWith(new FileFindPathInputReader(FILE_WITH_TEST_DATA_2));
//        runWith(new FileFindPathInputReader(FILE_WITH_TEST_DATA_FAIL));
//        runWith(new StdInFindPathInputReader());
    }

    private static void runWith(AbstractFindPathInputReader inputReader) throws IOException, PathNotExistsException {
        Graph graph = inputReader.getGraph();
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);
        System.out.println(getThePath(breadthFirstSearch.pathTo(graph.getFinishVertex())));
    }
}
