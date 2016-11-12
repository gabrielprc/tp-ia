package main.java.model.views;

public abstract class BasicView {

	protected Long id;
	
	protected BasicView() {
		super();
	}

	protected BasicView(Long id) {
		super();
		this.id = id;
	}

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
}
