package documentFiller;

import product.Product;
import product.ProductImpl;

import java.io.*;
import java.nio.charset.StandardCharsets;

//https://github.com/Dohruba/18_1_Test1/tree/master/src/filing
public class FillerImpl implements Writer,Reader{


    @Override
    public void readFromFile(String filename) throws Exception {

        String readString;
        String[] productInfo;
        String productName;
        int price;

        FileInputStream fis = new FileInputStream(filename);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        do {
            readString = br.readLine();
            String temp = readString;
            //System.out.println("ReadSomething");
            if (temp == null)break;

            productInfo = temp.split(" ");
            productName = productInfo[0];
            price = Integer.parseInt(productInfo[1]);

            Product readProduct = new ProductImpl(productName, price);

        }while (!readString.isBlank());
    }

    @Override
    public void writeOnFile(String filename, boolean append) throws IOException {


        FileOutputStream fos = new FileOutputStream(filename);
        //if (!append) {
            for (int i = 0; i < ProductImpl.Einkaufsliste.size(); i++) {
                String toAdd = ProductImpl.Einkaufsliste.get(i).getName() + " " + ProductImpl.Einkaufsliste.get(i).getPrice() +"\n";
                byte[] productBytes = (toAdd.getBytes(StandardCharsets.UTF_8));

                fos.write(productBytes);
            }
       /* }else{
            String toWrite = ProductImpl.Einkaufsliste.get(ProductImpl.Einkaufsliste.size()-1).toString();
            byte[] productBytes = toWrite.getBytes(StandardCharsets.UTF_8);
            fos.write(productBytes, true);
        }*/

        fos.close();
    }
}
