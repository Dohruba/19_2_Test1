package product;

import documentFiller.FillerImpl;
import documentFiller.Writer;
import list.ListImpl;

import java.io.IOException;
import java.util.ArrayList;

public class ProductImpl implements Product{

    private String productName;
    private int price;
    private Writer productWriter = new FillerImpl();

    public static ArrayList<Product> Einkaufsliste = new ArrayList<>();

    public ProductImpl(String name, int price) throws Exception{
        this.productName = name;
        this.price = price;
        for (int i = 0; i < Einkaufsliste.size(); i++){
            if (Einkaufsliste.get(i).getName().equals(this.productName)) throw new Exception("Exception: doppelte Eingabe" + "Gesamt: " + ListImpl.getWholePrice() + "\n>");
        }
        Einkaufsliste.add(this);
        ListImpl.setWholePrice(price);

        productWriter.writeOnFile("Einkaufsliste.txt",true);
    }


    @Override
    public String getName() throws IOException {
        return this.productName;
    }

    @Override
    public int getPrice() throws IOException {
        return this.price;
    }

    @Override
    public String toString(){
        return new String(this.productName + " " + this.price);
    }
}
