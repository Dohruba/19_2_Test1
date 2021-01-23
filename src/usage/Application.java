package usage;

import documentFiller.FillerImpl;
import documentFiller.Reader;
import list.List;
import list.ListImpl;
import product.Product;
import product.ProductImpl;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) throws Exception {


        PrefillList();
        Greeting();
        WaitForInput();

    }

    private static void Greeting(){
        String greeting = "Welcome to your awesome Product List.\n" +
                "The last time you opend it, the whole cost was: " + ListImpl.getWholePrice() +
                "\nTo see the products, write \"print\". \n" +
                "To remove a product, write \"remove\" and the name of the product.\n" +
                "To add a product, just write its name and its price, like this: " +
                "Name 55\n" +
                "Have fun.\n>";
        System.out.print(greeting);
    }

    private static void PrefillList() throws Exception {
        Reader listReader = new FillerImpl();
        listReader.readFromFile("Einkaufsliste.txt");
    }

    private static void WaitForInput() throws Exception {
        List theList = new ListImpl();
        Scanner scanner = new Scanner(System.in);
        String read;
        String[] productInfo;
        Product addedProduct;

        while (true){
            if (scanner.hasNextLine()){
                read = scanner.nextLine();
                productInfo = read.split(" ");
                switch (productInfo.length){
                    case 1: //Command
                        if (productInfo[0].equals("print")) {
                            try {
                                theList.print(ProductImpl.Einkaufsliste);
                            }catch (Exception ex){
                                System.out.println("List is empty");
                            }
                        } else {
                            System.out.println("\n");
                        }
                        break;
                    case 2: //Product or Remove
                        if (productInfo[0].equals("remove")) {
                            try {
                                theList.remove(productInfo[1]);
                            }catch (Exception ex){
                                System.out.println("Exception caught");
                            }
                        } else {
                            int x=0;
                            try {
                                x = Integer.parseInt(productInfo[1]);
                            }catch (NumberFormatException nex){
                                System.out.println("Error.");
                                break;
                            }
                            try {
                                addedProduct = new ProductImpl(productInfo[0], x);
                            }catch (Exception ex){
                                System.out.println(ex);
                            }
                        }
                        break;
                    default: //Error
                        System.out.println("Max two arguments. Min one.");
                        break;
                }
                //Print gesamt + >
                ListImpl.PrintWholePrice();

            }

        }
    }


}
