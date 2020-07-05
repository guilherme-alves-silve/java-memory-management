package br.com.guilhermealvessilveira.escapingreferences.exercise;

public class Main {

	public static void main(String[] args) {

		final var bookCollection = new BookCollection();
		
		//get price of book called Tom Jones in EUR
		System.out.println(bookCollection.findBookByName("Tom Jones").getPrice().convert("EUR"));

		bookCollection.printAllBooks();

		final BookReadOnly book = bookCollection.findBookByName("Gulliver's Travels");
		final Book modifiedBook = ((Book) book).withPrice(150d);

		System.out.println(modifiedBook + ": " + modifiedBook.getPrice().convert("EUR"));

		bookCollection.printAllBooks();

		//Not modified because, withPrice return a new object
		final var sameBook = bookCollection.findBookByName("Gulliver's Travels");
		System.out.println(sameBook + ": " + sameBook.getPrice().convert("EUR"));

		//java.lang.UnsupportedOperationException because getRates in immutable
		//sameBook.getPrice().getRates().put("EUR", 0d);
	}
}
