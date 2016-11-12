package main.java.model.dao;

public class DaoQuery {

	public final Long id;
	public final String name;
	public final Integer type;
	
	private DaoQuery(Long id, String name, Integer type) {
		super();
		this.id = id;
		this.name = name;
		this.type = type;
	}
	
	public static class Builder {
		private Long id;
		private String name;
		private Integer type;
		
		private Builder() {
			super();
		}
		
		public Builder id(Long id) {
			this.id = id;
			return this;
		}
		
		public Builder name(String name) {
			this.name = name;
			return this;
		}
		
		public Builder type(Integer type) {
			this.type = type;
			return this;
		}
		
		public DaoQuery build() {
			return new DaoQuery(this.id, this.name, this.type);
		}
	}
	
	
}
