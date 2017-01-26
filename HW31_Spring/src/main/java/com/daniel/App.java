package com.daniel;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.daniel.classes.Customer;
import com.daniel.classes.CustomersManual;
import com.daniel.classes.SellersSheet;


public class App 
{
    public static void main( String[] args )
    {
    	AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
    	
        CustomersManual cm = new CustomersManual();
        cm.searchCustomerCash("30");
        for(Customer k : cm.getSet()) {
        	System.out.println(k.getName());
        }
        
        SellersSheet zs = (SellersSheet) context.getBean("sellersSheet");
        zs.updateBalance();
       System.out.println(zs.biggestBalance());
       zs.sortDescending();
        
     System.out.println(zs.toString());
        
        }
}
