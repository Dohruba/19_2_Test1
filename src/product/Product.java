package product;

import java.io.IOException;

public interface Product {

    /**
     *
     * @return the name of the product
     * @throws IOException When there is nothing to return
     */
    String getName() throws IOException;

    /**
     *
     * @return How much it costs
     * @throws IOException  When there is nothing to return
     */
    int getPrice() throws IOException;

    @Override
    public String toString();
}
