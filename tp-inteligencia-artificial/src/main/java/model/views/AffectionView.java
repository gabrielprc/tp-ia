package main.java.model.views;

import main.java.model.constants.AffectionType;

public class AffectionView extends BasicView {

	private AffectionType type;
	private String name;
	
	public AffectionView(AffectionType type, String name) {
		super();
		this.type = type;
		this.name = name;
	}
	
	public AffectionView(Long id, AffectionType type, String name) {
		super(id);
		this.type = type;
		this.name = name;
	}
	
	
	public AffectionType getType() {
		return type;
	}
	public void setType(AffectionType type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
