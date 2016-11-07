package main.java.model.constants;

public enum AffectionType {
	DENTAL(1, "Dental"),
	PERIODONTAL(2, "Periodontal"),
	TEMPOROMANDIBULAR(3, "Temporomandibular");
	
	private int type;
	private String label;
	
	private AffectionType(int type, String label) {
		this.type = type;
		this.label = label;
	}
}
