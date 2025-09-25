package DailyPractice;

import java.util.Scanner;
import java.util.*;



public class BuyGifts {
	
	static class Item{
	    String name;
	    int price;
	    int quantity;
	    
	    public Item(String name,int price,int quantity){
	        this.name = name;
	        this.price = price;
	        this.quantity = quantity;
	    }
	    
	}

    public static void main(String[] args) {

        //Scanner sc = new Scanner(System.in);
        int noOfChildren = 5;
        String giftStockAvailibility = "Chocolate:30:3,IceCream:15:2";
        int tot = 0;
        
        //Write your logic here
        String[] arr = giftStockAvailibility.split(",");
        List<Item> list = new ArrayList<>();
        for(String item : arr){
            String[] parts = item.split(":");
            String name  = parts[0];
            int price = Integer.parseInt(parts[1]);
            int quantity = Integer.parseInt(parts[2]);
            list.add(new Item(name,price,quantity));
            
        }
        if(list.size() > 1) {
        	Item item1 = list.get(0);
        	Item item2 = list.get(1);
        	
        	int choPrice = item1.price;
        	int icePrice = item2.price;
        	
        	int choQuantity = item1.quantity;
        	int iceQuantity = item2.quantity;
        	
        	if(choQuantity >= noOfChildren) {
        		System.out.println(choPrice * noOfChildren);
        	}else if(iceQuantity >= noOfChildren) {
        		System.out.println(icePrice * noOfChildren);
        	}else {
        		System.out.println(tot);
        	}
        }
    }

}

