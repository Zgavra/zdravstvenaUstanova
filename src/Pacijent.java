
public class Pacijent{
	private String ime;
	private String prezime;
	private String jmbg;
	private String brojzdravstvenogkartona;
	private Doktor doktor;
	

	public Doktor getDoktor() {
		return doktor;
	}

	public void setDoktor(Doktor doktor) {
		this.doktor = doktor;
	}

	public Pacijent(String ime, String prezime, String jmbg, String brojzdravstvenogkartona ) {
		this.ime=ime;
		this.prezime=prezime;
		this.jmbg=jmbg;
		this.brojzdravstvenogkartona=brojzdravstvenogkartona;
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

	public String getJmbg() {
		return jmbg;
	}


	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}


	public String getBrojzdravstvenogkartona() {
		return brojzdravstvenogkartona;
	}


	public void setBrojzdravstvenogkartona(String brojzdravstvenogkartona) {
		this.brojzdravstvenogkartona = brojzdravstvenogkartona;
	}



}
