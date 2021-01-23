package list;

import java.io.IOException;
import java.util.ArrayList;

public interface List {

    /**
     * Takes the last product from the list
     * @throws Exception If Product list is already empty
     * @param productName
     */
    void remove(String productName)throws Exception;

    /**
     * Outputs all the products on the list
     * @throws IOException If list is empty
     * @param listToPrint
     * @return A copy of what has been outputted for testing
     */
    String[] print(ArrayList listToPrint) throws IOException;

}
