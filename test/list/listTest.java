package list;

import org.junit.Assert;
import org.junit.Test;
import product.Product;
import product.ProductImpl;

import java.io.IOException;

public class listTest {


    private ProductImpl getNewProduct(String name, int price) throws Exception {
       return new ProductImpl(name, price);
    }

    @Test
    public void goodPrintTest() throws Exception {
        ProductImpl.Einkaufsliste.clear();
        Product one = getNewProduct("A",1);
        Product two = getNewProduct("B",3);
        Product three = getNewProduct("C",2);

        List testList = new ListImpl();
        String[] printedStuff = testList.print(ProductImpl.Einkaufsliste);

        Assert.assertTrue(ProductImpl.Einkaufsliste.size() == 3);
        Assert.assertEquals(printedStuff[0], "A 1");
        Assert.assertEquals(printedStuff[2], "C 2");

    }
    @Test//Only One product
    public void randPrintTest() throws Exception {
        ProductImpl.Einkaufsliste.clear();
        Product one = getNewProduct("D",20);
        List testList = new ListImpl();
        String[] printedStuff = testList.print(ProductImpl.Einkaufsliste);
        Assert.assertEquals(printedStuff[0], "D 20");
    }
    @Test(expected = Exception.class) //ListEmpty
    public void badPrintTest() throws IOException {
        ProductImpl.Einkaufsliste.clear();

        List testList = new ListImpl();
        String[] printedStuff = testList.print(ProductImpl.Einkaufsliste);
    }

    @Test
    public void goodRemoveTest() throws Exception {
        ProductImpl.Einkaufsliste.clear();
        Product one = getNewProduct("A",1);
        Product two = getNewProduct("B",3);
        Product three = getNewProduct("C",2);

        List testList = new ListImpl();
        testList.remove("A");


        Assert.assertTrue(ProductImpl.Einkaufsliste.size() == 2);
        Assert.assertEquals(ProductImpl.Einkaufsliste.get(0).getName(), "B");
        Assert.assertEquals(ProductImpl.Einkaufsliste.get(0).getPrice(), 3);
    }
    @Test
    public void randRemoveTest() throws Exception {
        ProductImpl.Einkaufsliste.clear();
        Product one = getNewProduct("A",1);
        List testList = new ListImpl();
        testList.remove("A");
        Assert.assertTrue(ProductImpl.Einkaufsliste.isEmpty());

    }
    @Test(expected = Exception.class) //Empty
    public void badRemoveTest() throws Exception {
        ProductImpl.Einkaufsliste.clear();
        List testList = new ListImpl();
        testList.remove("A");
    }

}
