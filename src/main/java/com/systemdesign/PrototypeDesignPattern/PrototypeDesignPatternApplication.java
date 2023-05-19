package com.systemdesign.PrototypeDesignPattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrototypeDesignPatternApplication {

	public static void main(String[] args) throws CloneNotSupportedException {
		SpringApplication.run(PrototypeDesignPatternApplication.class, args);
		BookShop bs1 = new BookShop();
		bs1.setBookShopName("Universal");
		bs1.loadData();
		BookShop bs2 = bs1.clone();
		bs2.setBookShopName("Vishal");
	    bs1.getBooks().remove(0);
		System.out.println(bs1);
		System.out.println(bs2);
	}
}