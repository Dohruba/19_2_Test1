package documentFiller;

import java.io.IOException;

//https://github.com/Dohruba/18_1_Test1/tree/master/src/filing
public interface Writer {

    /**
     * Writes on the file every time there is a new Product.
     * @param filename
     * @param append If true, only a new line will be added.
     *               when removing a Product, it will be false and the whole list will be rewritten
     * @throws IOException
     */
    void writeOnFile(String filename, boolean append) throws IOException;

}
