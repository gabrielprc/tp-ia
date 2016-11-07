package main.java.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import main.java.model.constants.SymptomType;

@Entity
@Table(name = "symptoms")
public class Sypmtom extends BasicBean {
	
	private String name;
	private SymptomType type;
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "type")
	public SymptomType getType() {
		return type;
	}
	public void setType(SymptomType type) {
		this.type = type;
	}
	
}
