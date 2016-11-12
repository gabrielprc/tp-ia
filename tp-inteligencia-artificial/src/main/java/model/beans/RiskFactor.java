package main.java.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;

import main.java.model.constants.RiskFactorType;
import main.java.model.views.RiskFactorView;

@Entity
@Table(name = "risk_factors")
public class RiskFactor extends BasicBean {
	
	private String name;
	private RiskFactorType type;
	private Integer typeInt;
	
	public RiskFactor() {
		super();
	}
	
	public RiskFactor(String name, RiskFactorType type) {
		super();
		this.name = name;
		this.type = type;
		if (type != null) {
			
		}
	}
	
	public RiskFactor(Long id, String name, RiskFactorType type) {
		super(id);
		this.name = name;
		this.type = type;
		if (type != null) {
			
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
	public RiskFactorType getType() {
		return type;
	}
	public void setType(RiskFactorType type) {
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
		this.type = RiskFactorType.getByType(typeInt);
	}
	
	public RiskFactorView toView() {
		return new RiskFactorView(id, name, type, typeInt);
	}
	
	public static RiskFactor fromView(RiskFactorView view) {
		return new RiskFactor(view.getName(), view.getType());
	}
	
}
