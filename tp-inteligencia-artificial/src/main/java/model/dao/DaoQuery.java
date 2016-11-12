package main.java.model.dao;

import java.util.ArrayList;
import java.util.List;

public class DaoQuery {

	public final List<Long> ids;
	public final List<String> names;
	public final List<Integer> types;
	
	private DaoQuery(List<Long> ids, List<String> names, List<Integer> types) {
		super();
		this.ids = ids;
		this.names = names;
		this.types = types;
	}
	
	public static class Builder {
		private List<Long> ids;
		private List<String> names;
		private List<Integer> types;
		
		public Builder() {
			super();
			this.ids = new ArrayList<Long>();
			this.names = new ArrayList<String>();
			this.types = new ArrayList<Integer>();
		}
		
		public Builder id(Long id) {
			this.ids.add(id);
			return this;
		}
		
		public Builder name(String name) {
			this.names.add(name);
			return this;
		}
		
		public Builder type(Integer type) {
			this.types.add(type);
			return this;
		}
		
		public DaoQuery build() {
			return new DaoQuery(this.ids, this.names, this.types);
		}
	}
	
	
}
