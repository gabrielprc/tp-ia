package main.java.model.constants;

public enum RiskFactorType {
	DISEASE(1, "Enfermedad"),
	HABIT(2, "Habito");
	
	public final int type;
	public final String label;
	
	private RiskFactorType(int type, String label) {
		this.type = type;
		this.label = label;
	}
	
	public static RiskFactorType getByType(Integer type) {
		if (type != null) {
			for (RiskFactorType r : values()) {
				if (r.type == type.intValue()) {
					return r;
				}
			}
		}
		return null;
	}
}
