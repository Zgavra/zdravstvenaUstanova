
public abstract class Pregled {
	protected static int pregledId = 0;
	protected String datum;
	protected String vreme;
	protected Pacijent pacijent;
	protected Doktor pregledZakazao;
	
	public Pregled()
	{
		pregledId++;
	}
	
	public Pregled(String datum, String vreme) {
		this();
		this.datum = datum;
		this.vreme = vreme;
	}
	public String getDatum() {
		return datum;
	}
	public void setDatum(String datum) {
		this.datum = datum;
	}
	public String getVreme() {
		return vreme;
	}
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}

	public Doktor getPregledZakazao() {
		return pregledZakazao;
	}

	public void setPregledZakazao(Doktor pregledZakazao) {
		this.pregledZakazao = pregledZakazao;
	}

	public static int getPregledId() {
		return pregledId;
	}

	public Pacijent getPacijent() {
		return pacijent;
	}

	public void setPacijent(Pacijent pacijent) {
		this.pacijent = pacijent;
	}
	
	
	

}
