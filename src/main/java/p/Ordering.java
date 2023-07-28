/*
CREATE TABLE ordering(
		id IDENTITY,
		customerId BIGINT NOT NULL REFERENCES customer(id),
		bookId BIGINT NOT NULL REFERENCES book(id),
		sellingPrice INT NOT NULL,
		orderingDate DATE
)
*/

package p;

import java.util.Date;

public class Ordering {
    int id;
    int customerId;
    int bookId;
    int sellingPrice;
    Date orderingDate;
    Customer customer;
    Book book;
    
	public Ordering() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public int getSellingPrice() {
		return sellingPrice;
	}

	public void setSellingPrice(int sellingPrice) {
		this.sellingPrice = sellingPrice;
	}

	public Date getOrderingDate() {
		return orderingDate;
	}

	public void setOrderingDate(Date orderingDate) {
		this.orderingDate = orderingDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}

