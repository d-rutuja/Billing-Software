package Billing_Software;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ShoppingBill   
{  
    public static void main(String args[])   
        {  
            // variables  
            String id = null;  
            String productName = null;  
            int quantity = 0;  
            double price = 0.0;  
            double totalPrice = 0.0;  
            double overAllPrice = 0.0;  
            double cgst, sgst, subtotal=0.0, discount=0.0;  
            char choice = '\0';  
            System.out.println("\t\t\t\t\t\t\t   Star Bazaar");  
            System.out.println("\t\t\t\t\t\t Ground Floor, Phoenix Marketcity");  
            System.out.println("\t\t\t\t\t\t     Viman Nagar, Pune 411014");  
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t     Contact: (+91) 8084586669");  
            System.out.println("\t\t\t\t\t\t\t\t\t\t\t\t     Email: info@starbazaar.com");
            //format of date and time  
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");    
            Date date = new Date();    
            Calendar calendar = Calendar.getInstance();  
            String[] days = new String[] { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };  
            //prints current date and time  
            System.out.println("Date: "+formatter.format(date)+"  "+days[calendar.get(Calendar.DAY_OF_WEEK) - 1]);  
            Scanner sc = new Scanner(System.in);  
            System.out.print("Enter Customer Name: ");  
            String customername=sc.nextLine();  
            //create Scanner class object  
            //creating an ArrayList to store the product  
            List<Product> product = new ArrayList<Product>();  
            do   
                {  
                    // read input values  
                    System.out.println("Enter the product details: ");  
                    System.out.print("Product ID: ");  
                    id = sc.nextLine();  
                    System.out.print("Product Name: ");  
                    productName = sc.nextLine();  
                    System.out.print("Quantity: ");  
                    quantity = sc.nextInt();  
                    System.out.print("Price (per unit): ");  
                    price = sc.nextDouble();  
                    //calculate total price for a particular product  
                    totalPrice = price * quantity;  
                    //calculates overall price  
                    overAllPrice = overAllPrice + totalPrice;  
                    //creates Product class object and add it to the List  
                    product.add( new Product(id, productName, quantity, price, totalPrice) );  
                    // ask for continue shopping?  
                    System.out.print("Want to add more items? (Y or N): ");  
                    //reads a character Y or N  
                    choice = sc.next().charAt(0);  
                    //read remaining characters, don't store (no use)  
                    sc.nextLine();  
                }   
            while (choice == 'y' || choice == 'Y');  
            //display all product with its properties  
            Product.displayFormat();  
            for (Product p : product)   
            {  
                p.display();  
            }  
            //price calculation  
            System.out.println("\n\t\t\t\t\t\t\t\t\t\tTotal Amount (Rs.) " +overAllPrice);  
            //calculating discount  
            discount = overAllPrice*5/100;  
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t    Discount (Rs.) " +discount);  
            //total amount after discount  
            subtotal = overAllPrice-discount;   
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t          Subtotal "+subtotal);  
            //calculating tax  
            sgst=overAllPrice*12/100;  
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t          SGST (%) "+sgst);  
            cgst=overAllPrice*12/100;  
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t          CGST (%) "+cgst);  
            //calculating amount to be paid by buyer  
            System.out.println("\n\t\t\t\t\t\t\t\t\t\t     Invoice Total " +(subtotal+cgst+sgst));  
            System.out.println("\t\t\t\t----------------Thank You for Shopping!!-----------------");  
            System.out.println("\t\t\t\t                     Visit Again");  
            // close Scanner  
            sc.close();  
        }     
}  
