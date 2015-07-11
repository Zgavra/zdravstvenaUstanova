
public class NivoSecera extends Pregled {
	private Float vrednost;
	private String vremePoslednjegObroka;
	

	public NivoSecera(String datum, String vreme) {
		super(datum, vreme);
		// TODO Auto-generated constructor stub
	}


	public Float getVrednost() {
		return vrednost;
	}


	public void setVrednost(Float vrednost) {
		this.vrednost = vrednost;
	}


	public String getVremePoslednjegObroka() {
		return vremePoslednjegObroka;
	}


	public void setVremePoslednjegObroka(String vremePoslednjegObroka) {
		this.vremePoslednjegObroka = vremePoslednjegObroka;
	}

}
