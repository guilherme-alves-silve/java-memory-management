package br.com.guilhermealvessilveira.escapingreferences.exercise;

public class Book implements BookReadOnly {

	private final int id;
	private final String title;
	private final String author;
	private final Price price;

	public Book(
			final int id,
			final String title,
			final String author,
			final Double price
	) {
		this.id = id;
		this.title = title;
		this.author = author;
		this.price = new Price(price);
	}

	public Book(final Book other) {
		this.id = other.id;
		this.title = other.title;
		this.author = other.author;
		this.price = other.price;
	}

	@Override
	public int getId() {
		return id;
	}

	@Override
	public String getTitle() {
		return title;
	}

	@Override
	public String getAuthor() {
		return author;
	}

	@Override
	public Price getPrice() {
		return this.price;
	}

	public Book withPrice(final Double newPrice) {
		return new Book(this.id, this.title, this.author, newPrice);
	}
	
	public String toString() {
		return title + " by " + author;
	}


	
}
