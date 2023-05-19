package com.systemdesign.PrototypeDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class BookShop implements Cloneable{
	private String bookShopName;
	private List<Book> books;
	public BookShop() {
		books = new ArrayList<>();
	}
	public String getBookShopName() {
		return bookShopName;
	}
	public void setBookShopName(String bookShopName) {
		this.bookShopName = bookShopName;
	}
	public List<Book> getBooks() {
		return books;
	}
	public void setBooks(List<Book> books) {
		this.books = books;
	}
	public void loadData() {
		//Actual real code will load the data from DB but we are have it local in this example
		for(int i=1;i<=10;i++) {
			Book book = new Book();
			book.setBookId(i);
			book.setBookName("Book"+i);
			books.add(book);
		}
	}
	@Override
	protected BookShop clone() throws CloneNotSupportedException {
		BookShop bs = new BookShop();
		bs.setBooks(new ArrayList<>());
		for(Book b: this.getBooks()) {
			bs.getBooks().add(b);
		}
		return bs;
	}
	@Override
	public String toString() {
		return "BookShop [bookShopName=" + bookShopName + ", books=" + books + "]";
	}
}
