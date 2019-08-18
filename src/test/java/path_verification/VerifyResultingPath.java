package path_verification;

import exceptions.PathNotExistsException;
import model.Graph;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import service.algorithm.BreadthFirstSearch;
import service.input_reader.AbstractFindPathInputReader;
import service.input_reader.FileFindPathInputReader;

import java.io.File;
import java.io.IOException;

import static constants.Constants.FILE_WITH_TEST_DATA_1;
import static constants.Constants.FILE_WITH_TEST_DATA_2;
import static constants.Constants.FILE_WITH_TEST_DATA_FAIL;
import static org.junit.Assert.assertEquals;
import static service.StaticHelper.getThePath;

@RunWith(MockitoJUnitRunner.class)
public class VerifyResultingPath {

    private static final String EXPECTED_ANSWER_1 = "u,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,r,d,d,d,d,d,d,d,d,d,d,d";
    private static final String EXPECTED_ANSWER_2 = "r,r,r,d,d,d,r";

    @Test
    public void shouldReturnCorrectPathFromFirstTestData() throws IOException, PathNotExistsException {
        Graph graph = getGraphFromReader(FILE_WITH_TEST_DATA_1);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(getGraphFromReader(FILE_WITH_TEST_DATA_1));

        assertEquals(EXPECTED_ANSWER_1, getThePath(breadthFirstSearch.pathTo(graph.getFinishVertex())));
    }

    @Test
    public void shouldReturnCorrectPathFromSecondTestData() throws IOException, PathNotExistsException {
        Graph graph = getGraphFromReader(FILE_WITH_TEST_DATA_2);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);

        assertEquals(EXPECTED_ANSWER_2, getThePath(breadthFirstSearch.pathTo(graph.getFinishVertex())));
    }

    @Test(expected = PathNotExistsException.class)
    public void shouldThrowPathNotExistsException() throws IOException, PathNotExistsException {
        Graph graph = getGraphFromReader(FILE_WITH_TEST_DATA_FAIL);

        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch(graph);

        getThePath(breadthFirstSearch.pathTo(graph.getFinishVertex()));
    }

    private Graph getGraphFromReader(File fileWithTestData2) throws IOException {
        AbstractFindPathInputReader inputReader = new FileFindPathInputReader(fileWithTestData2);
        return inputReader.getGraph();
    }

}
