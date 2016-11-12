package main.java.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import main.java.model.constants.SymptomType;

@Entity
@Table(name = "symptoms")
public class Symptom extends BasicBean {
	
	private String name;
	private SymptomType type;
	private Integer typeInt;
	
	public Symptom() {
		super();
	}
	
	public Symptom(String name, SymptomType type) {
		super();
		this.name = name;
		this.type = type;
		if (type != null) {
			this.setTypeInt(type.type);
		}
	}
	
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Transient
	public SymptomType getType() {
		return type;
	}
	public void setType(SymptomType type) {
		this.type = type;
		if (type != null) {
			this.typeInt = type.type;
		}
	}

	@Column(name = "type")
	public Integer getTypeInt() {
		return typeInt;
	}

	public void setTypeInt(Integer typeInt) {
		this.typeInt = typeInt;
		this.type = SymptomType.getByType(typeInt);
	}
	
}
