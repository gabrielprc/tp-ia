package main.java.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import main.java.model.constants.AffectionType;
import main.java.model.views.AffectionView;

@Entity
@Table(name = "affections")
public class Affection extends BasicBean {
	
	private AffectionType type;
	private Integer typeInt;
	private String name;

	
	public Affection() {
		super();
	}
	
	public Affection(AffectionType type, String name) {
		super();
		this.type = type;
		if (type != null) {
			this.typeInt = type.type;
		}
		this.name = name;
	}
	
	public Affection(Long id, AffectionType type, String name) {
		super(id);
		this.type = type;
		if (type != null) {
			this.typeInt = type.type;
		}
		this.name = name;
	}
	
	
	@Transient
	public AffectionType getType() {
		return type;
	}
	public void setType(AffectionType type) {
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
		this.type = AffectionType.getByType(typeInt);
	}
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public AffectionView toView() {
		return new AffectionView(id, type, name);
	}
	
	public static Affection fromView(AffectionView view) {
		return new Affection(view.getType(), view.getName());
	}
	
}
