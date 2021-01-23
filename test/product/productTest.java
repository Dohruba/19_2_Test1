package product;

import org.junit.Assert;
import org.junit.Test;

public class productTest {


    private final int MAX_NUM = Integer.MAX_VALUE;

    @Test
    public void makeProductTest() throws Exception {
        Product testProduct = new ProductImpl("Test", 555);

        Assert.assertEquals(testProduct.getName(), "Test");
        Assert.assertEquals(testProduct.getPrice(), 555);
    }

    @Test(expected = Exception.class)
    public void badMakeDoubleProductTest() throws Exception{
        /*Product testProduct = new ProductImpl("Test", 555);
        Product testProduct2 = new ProductImpl("Test", 555);*/
        ProductImpl.Einkaufsliste.add(new ProductImpl("Test",555));
        ProductImpl.Einkaufsliste.add(new ProductImpl("Test",555));

    }

    @Test
    public void randMakeTest() throws Exception {
        Product randProduct = new ProductImpl("MaxNum", MAX_NUM);

        Assert.assertEquals(randProduct.getName(), "MaxNum");
        Assert.assertEquals(randProduct.getPrice(), MAX_NUM);
    }


}
