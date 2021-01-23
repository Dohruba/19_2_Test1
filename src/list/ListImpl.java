package list;

import documentFiller.FillerImpl;
import documentFiller.Writer;
import product.ProductImpl;

import java.io.IOException;
import java.util.ArrayList;

public class ListImpl implements List {
    private static int wholePrice;
    private Writer writer;

    public static int getWholePrice() {
        return wholePrice;
    }

    public static void setWholePrice(int price) {

        if (price >= 0) {wholePrice += price;}
        else {
            wholePrice=0;
        }

    }
    public static void PrintWholePrice(){
        System.out.print("Gesamt: " + wholePrice + "\n>");
    }




    @Override
    public void remove(String productName) throws Exception {

        writer = new FillerImpl();
        for (int i = 0; i < ProductImpl.Einkaufsliste.size(); i++){
            if (ProductImpl.Einkaufsliste.get(i).getName().equals(productName)){
                wholePrice -= ProductImpl.Einkaufsliste.get(i).getPrice();
                ProductImpl.Einkaufsliste.remove(i);
                writer.writeOnFile("Einkaufsliste.txt", false);
                break;
            }

        }
        System.out.println("No product with that name.");
    }

    @Override
    public String[] print(ArrayList listToPrint) throws IOException {
        if (ProductImpl.Einkaufsliste.size() == 0) throw new IOException("List Empty");
        String[] toReturn = new String[ProductImpl.Einkaufsliste.size()];
        for (int i = 0; i< ProductImpl.Einkaufsliste.size(); i++){
            System.out.println(ProductImpl.Einkaufsliste.get(i).toString());
            toReturn[i] = ProductImpl.Einkaufsliste.get(i).toString();
        }

        return toReturn;
    }
}
