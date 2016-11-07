package main.java.model.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import main.java.model.constants.RiskFactorType;

@Entity
@Table(name = "risk_factors")
public class RiskFactor extends BasicBean {
	
	private String name;
	private RiskFactorType type;
	
	@Column(name = "name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Enumerated(EnumType.ORDINAL)
	@Column(name = "type")
	public RiskFactorType getType() {
		return type;
	}
	public void setType(RiskFactorType type) {
		this.type = type;
	}
	
}
