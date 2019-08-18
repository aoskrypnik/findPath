package service;

import model.Graph;
import model.Vertex;

import java.util.List;

import static constants.Constants.COMMA;
import static constants.Constants.DOWN;
import static constants.Constants.FINISH_SYMBOL;
import static constants.Constants.LEFT;
import static constants.Constants.RIGHT;
import static constants.Constants.START_SYMBOL;
import static constants.Constants.UP;

public class StaticHelper {

    public static String getThePath(List<Integer> list) {
        StringBuilder path = new StringBuilder();
        for (int i = 1; i < list.size(); i++) {
            int difference = list.get(i) - list.get(i - 1);
            if (difference == 1) {
                path.append(RIGHT).append(COMMA);
            } else if (difference == -1) {
                path.append(LEFT).append(COMMA);
            } else if (difference > 1) {
                path.append(DOWN).append(COMMA);
            } else if (difference < -1) {
                path.append(UP).append(COMMA);
            }
        }
        return path.toString().substring(0, path.length() - 1);
    }

    public static void initCornerVertex(Graph graph, char character, Vertex vertex) {
        if (character == START_SYMBOL) {
            graph.setStartVertex(vertex);
        }
        if (character == FINISH_SYMBOL) {
            graph.setFinishVertex(vertex);
        }
    }

}
