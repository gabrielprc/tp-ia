package main.java.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import main.java.model.constants.AffectionType;

@Entity
@Table(name = "affections")
public class Affection extends BasicBean {
	
	private AffectionType type;
	private String name;
	
	
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "type")
	public AffectionType getType() {
		return type;
	}
	public void setType(AffectionType type) {
		this.type = type;
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
