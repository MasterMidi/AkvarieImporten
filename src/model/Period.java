package model;

import java.time.LocalDate;

public class Period<T> {
	private int id;
	private T object;
	private LocalDate startDate;
	private LocalDate endDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Period(T object, LocalDate startDate) {
		super();
		this.object = object;
		this.startDate = startDate;
	}
	public Period(T object, LocalDate startDate, LocalDate endDate) {
		this(object, startDate);
		this.endDate = endDate;
	}

	public T getObject() {
		return object;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

}
