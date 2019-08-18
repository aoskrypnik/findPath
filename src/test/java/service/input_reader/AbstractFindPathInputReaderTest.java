package service.input_reader;

import model.Graph;
import model.Vertex;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import static constants.Constants.DIESE_SYMBOL;
import static constants.Constants.NEXT_LINE_SYMBOL;
import static constants.Constants.START_SYMBOL;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyChar;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AbstractFindPathInputReaderTest {

    private static final int WIDTH = 5;
    private static final int ID = 20;

    @Spy
    private AbstractFindPathInputReader testInstance = new StdInFindPathInputReader();
    @Mock
    private Graph graph;
    @Mock
    private Vertex vertex;

    @Before
    public void setUp() {
        doReturn(vertex).when(testInstance).createVertex(anyChar());
    }

    @Test
    public void shouldNotAddVertexWhenCharacterIsNextLineSymbol() {
        testInstance.addVertex(graph, NEXT_LINE_SYMBOL, WIDTH);

        verify(graph, never()).addVertex(any());
    }

    @Test
    public void shouldAddVertexWhenCharacterIsNotLineSymbol() {
        testInstance.addVertex(graph, DIESE_SYMBOL, WIDTH);

        InOrder orderVerifier = inOrder(testInstance, graph);
        orderVerifier.verify(testInstance).createVertex(DIESE_SYMBOL);
        orderVerifier.verify(graph).addVertex(vertex);
        orderVerifier.verify(testInstance).callInitCornerVertex(graph, DIESE_SYMBOL, vertex);
    }

    @Test
    public void shouldNotMakeConnectionsWhenCharacterIsDieseSymbol() {
        testInstance.addVertex(graph, DIESE_SYMBOL, WIDTH);

        verify(testInstance, never()).addEdges(any(), any(), anyInt());
    }

    @Test
    public void shouldNotMakeConnectionsWhenVertexIdEqualsZero() {
        when(vertex.getId()).thenReturn(0);

        testInstance.addVertex(graph, START_SYMBOL, WIDTH);

        verify(testInstance, never()).addEdges(any(), any(), anyInt());
    }

    @Test
    public void shouldMakeConnections() {
        when(vertex.getId()).thenReturn(ID);
        doNothing().when(testInstance).addEdges(any(), any(), anyInt());

        testInstance.addVertex(graph, START_SYMBOL, WIDTH);

        verify(testInstance).addEdges(graph, vertex, WIDTH);
    }

}
