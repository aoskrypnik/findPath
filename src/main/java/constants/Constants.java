package constants;

import java.io.File;

public interface Constants {

    String PATH_TO_TEST_DATA_1 = "src/main/resources/testData1";
    String PATH_TO_TEST_DATA_2 = "src/main/resources/testData2";
    String PATH_TO_TEST_DATA_FAIL = "src/main/resources/testDataFail";

    String EXCEPTION_MESSAGE = "Unfortunately, there is no path from the maze";

    File FILE_WITH_TEST_DATA_1 = new File(PATH_TO_TEST_DATA_1);
    File FILE_WITH_TEST_DATA_2 = new File(PATH_TO_TEST_DATA_2);
    File FILE_WITH_TEST_DATA_FAIL = new File(PATH_TO_TEST_DATA_FAIL);

    Character DIESE_SYMBOL = '#';
    Character START_SYMBOL = 'S';
    Character FINISH_SYMBOL = 'X';
    Character NEXT_LINE_SYMBOL = '\n';
    Character COMMA = ',';
    Character UP = 'u';
    Character DOWN = 'd';
    Character LEFT = 'l';
    Character RIGHT = 'r';

    Integer MAXIMUM = Integer.MAX_VALUE;

}
