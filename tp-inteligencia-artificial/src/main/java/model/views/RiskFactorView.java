package main.java.model.views;

import main.java.model.constants.RiskFactorType;

public class RiskFactorView extends BasicView {

	private String name;
	private RiskFactorType type;
	private Integer typeInt;
	
	public RiskFactorView(String name, RiskFactorType type, Integer typeInt) {
		super();
		this.name = name;
		this.type = type;
		this.typeInt = typeInt;
	}
	
	public RiskFactorView(Long id, String name, RiskFactorType type, Integer typeInt) {
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
	public RiskFactorType getType() {
		return type;
	}
	public void setType(RiskFactorType type) {
		this.type = type;
	}
	public Integer getTypeInt() {
		return typeInt;
	}
	public void setTypeInt(Integer typeInt) {
		this.typeInt = typeInt;
	}
	
}
