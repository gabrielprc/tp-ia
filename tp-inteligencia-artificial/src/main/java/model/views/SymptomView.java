package main.java.model.views;

import main.java.model.constants.SymptomType;

public class SymptomView extends BasicView {

	private String name;
	private SymptomType type;
	private Integer typeInt;
	
	public SymptomView(String name, SymptomType type, Integer typeInt) {
		super();
		this.name = name;
		this.type = type;
		this.typeInt = typeInt;
	}
	
	public SymptomView(Long id, String name, SymptomType type, Integer typeInt) {
		super(id);
		this.name = name;
		this.type = type;
		this.typeInt = typeInt;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public SymptomType getType() {
		return type;
	}
	public void setType(SymptomType type) {
		this.type = type;
	}
	public Integer getTypeInt() {
		return typeInt;
	}
	public void setTypeInt(Integer typeInt) {
		this.typeInt = typeInt;
	}
	
}
