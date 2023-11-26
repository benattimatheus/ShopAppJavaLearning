/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package duke.choice;

import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerConfiguration;
import io.helidon.webserver.WebServer;
import java.net.InetAddress;
import java.net.UnknownHostException;

import java.util.Arrays;

/**
 *
 * @author Matheus
 */
public class ShopApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        double tax = 0.2;
        double total = 0;
  
        System.out.println("Welcome to Duke Choice Shop");
        
        Customer c1 = new Customer("Pinky", 9);
                        
        //c1.setName("Pinky");
        //c1.setSize("S");
        
        System.out.println("Min Price: " + Clothing.MIN_PRICE);
        
        Clothing item1 = new Clothing("Blue Jacket", 20.9, "M");
        Clothing item2 = new Clothing("Orange T-Shirt", 10.5, "S");
        Clothing item3 = new Clothing("Green Scarf", 5.0, "S");
        Clothing item4 = new Clothing("Blue T-Shirt", 10.5, "S");
        
        Clothing[] items = {item1, item2, item3, item4};
        
        try { 
            ItemList list = new ItemList(items);
            Routing routing = Routing.builder()
                    .get("/items", list).build();
            ServerConfiguration config = ServerConfiguration.builder()
                    .bindAddress(InetAddress.getLocalHost())
                    .port(8888).build();
            WebServer ws = WebServer.create(config, routing);
            ws.start();
        } catch(UnknownHostException ex){
            ex.printStackTrace();
        }
        //item1.setDescription(");
        //item1.setPrice();
        //item1.setSize();
        
        //item2.setDescription();
        //item2.setPrice();
        //item2.setSize();
        
        //items[2].setDescription();
        //items[2].setPrice();
        //items[2].setSize();
        
        //items[3].setDescription();
        //items[3].setPrice();
        //items[3].setSize();
              
//        System.out.println(item1.description + "," + item1.price + "," + item1.size);
//        System.out.println(item2.description + "," + item2.price + "," + item2.size);
        
        //total = (item1.price + item2.price * 2) * (1 + tax);
        //int measurement = 3;
 
        //c1.setSize(measurement);
        c1.addItems(items);
        

    System.out.println("Customer is " + c1.getName() + ", " + c1.getSize() + ", " + c1.getTotalClothingCost());
        for (Clothing item : c1.getItems()) {
            //System.out.println("Items: " + item.getDescription() + ", " + item.getSize() + ", " + item.getPrice());
          //  System.out.println(item.getDescription() + "," + item.getPrice() + "," + item.getSize() );
            System.out.println("Item " + item);
        }
        
        int average = 0;
        int count = 0;
        
        for (Clothing item : c1.getItems()){
            if (item.getSize().equals("L")){
                count++;
                average += item.getPrice();
            }
        }
        
        try{
            average = average / count;
            System.out.println("Average price " + average + ", Count " + count);
        } catch (ArithmeticException e){
            System.out.println("Don't divide by 0");
        }
        
        Arrays.sort(c1.getItems());
        for (Clothing item : c1.getItems()) {
            System.out.println("Item sorted " + item);
        }
    }

}
