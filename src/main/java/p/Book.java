/*
 * CREATE TABLE book( id IDENTITY, title VARCHAR(64) NOT NULL, publisher
 * VARCHAR(64), price INT NOT NULL )
 */

package p;

import java.util.List;

public class Book {
	int id;
	String title;
	String publisher;
	int price;
	List<Ordering> orderings;

	public Book() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public List<Ordering> getOrderings() {
		return orderings;
	}

	public void setOrderings(List<Ordering> orderings) {
		this.orderings = orderings;
	}
}
