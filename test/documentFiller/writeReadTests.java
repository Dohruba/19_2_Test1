package documentFiller;

import list.ListImpl;
import org.junit.Assert;
import org.junit.Test;
import product.Product;
import product.ProductImpl;

import java.util.ArrayList;

//https://github.com/Dohruba/18_1_Test1/tree/master/test/filing/filinfTest.java
public class writeReadTests {


    private ProductImpl getNewProduct(String name, int price) throws Exception {
        return new ProductImpl(name, price);
    }

    @Test
    public void writeReadTest() throws Exception {
        ProductImpl.Einkaufsliste.clear();
        ListImpl.setWholePrice(-1);

        Product apple = getNewProduct("Apple", 5);
        Product pear = getNewProduct("Pear", 6);
        Product far = getNewProduct("Far", 9);
        Product Mango = getNewProduct("Mango", 66);

        Writer testWriter = new FillerImpl();
        Reader testReader = new FillerImpl();

        testWriter.writeOnFile("Test.txt", false );
        Thread.sleep(2000);
        ProductImpl.Einkaufsliste.clear();
        //Empty the list, to be filled again. Like when restarting the program
        testReader.readFromFile("Test.txt");
        //Read fills the Einkaufsliste automatically with what it reads.
        Assert.assertEquals(ProductImpl.Einkaufsliste.size(),4);
        Assert.assertEquals(ProductImpl.Einkaufsliste.get(0).getName(),apple.getName());
    }
    @Test(expected = Exception.class)
    public void badReadTest() throws Exception {
        ProductImpl.Einkaufsliste.clear();

        Product apple = getNewProduct("Apple", 5);
        Product pear = getNewProduct("Pear", 6);
        Product far = getNewProduct("Far", 9);
        Product Mango = getNewProduct("Mango", 66);

        Writer testWriter = new FillerImpl();
        Reader testReader = new FillerImpl();
        ArrayList<Product> listBeforeRW = ProductImpl.Einkaufsliste;

        testWriter.writeOnFile("Test.txt", false );
        Thread.sleep(2000);
        testReader.readFromFile("Tests.txt");

    }
    @Test(expected = Exception.class)
    public void badWriteTest() throws Exception {
        ProductImpl.Einkaufsliste.clear();
        Product apple = getNewProduct("Apple", 5);
        Product pear = getNewProduct("Pear", 6);
        Product far = getNewProduct("Far", 9);
        Product Mango = getNewProduct("Mango", 66);

        Writer testWriter = new FillerImpl();
        Reader testReader = new FillerImpl();
        ArrayList<Product> listBeforeRW = ProductImpl.Einkaufsliste;

        testWriter.writeOnFile("TestNoFileFound.txt", false);


    }

    @Test(expected = Exception.class)
    public void randReadWriteTest() throws Exception {
        ProductImpl.Einkaufsliste.clear();
        Product apple = getNewProduct("Apple", 5);
        Writer testWriter = new FillerImpl();
        Reader testReader = new FillerImpl();
        ArrayList<Product> listBeforeRW = ProductImpl.Einkaufsliste;

        testWriter.writeOnFile("Test.txt",false );
        Thread.sleep(2000);
        testReader.readFromFile("Tests.txt");
    }



}
