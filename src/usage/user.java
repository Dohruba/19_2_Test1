package usage;

import java.io.IOException;

public interface user {

    /**
     * Depending on what the user puts in, three things can happen:
     * 1. Something #: new product is added
     * 2. remove Something: product with that name is removed
     * 3. print(): Prints the list
     * @throws IOException
     */
    void introduceCommand() throws IOException;
}
