package main.java.model.constants;

public enum Probability {
	UNKNOWN(0, "Sin información"),
	LOW(1, "Baja"),
	MEDIUM(2, "Media"),
	HIGH(3, "Alta"),
	VERY_HIGH(4, "Muy alta");
	
	private int probability;
	private String label;
	
	private Probability(int probability, String label) {
		this.probability = probability;
		this.label = label;
	}

	public static Probability getByLabel(String label) {
		for (Probability probability : Probability.values()) {
			if (probability.label.equalsIgnoreCase(label)) {
				return probability;
			}
		}
		return UNKNOWN;
	}

	public String getLabel() {
		return this.label;
	}
}
