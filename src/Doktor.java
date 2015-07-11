public class Doktor{
	private String ime;
	private String prezime;
	private String specijalnost;
	
	public Doktor(String ime, String prezime, String specijalnost){
		this.ime=ime;
		this.prezime=prezime;
		this.specijalnost=specijalnost;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getSpecijalnost() {
		return specijalnost;
	}

	public void setSpecijalnost(String specijalnost) {
		this.specijalnost = specijalnost;
	}

}
