package main.java.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.persistence.Transient;

import main.java.model.constants.SymptomType;
import main.java.model.views.SymptomView;

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
	
	public Symptom(Long id, String name, SymptomType type) {
		super(id);
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
	
	public SymptomView toView() {
		return new SymptomView(id, name, type, typeInt);
	}
	
	public static Symptom fromView(SymptomView view) {
		return new Symptom(view.getName(), view.getType());
	}
	
}
