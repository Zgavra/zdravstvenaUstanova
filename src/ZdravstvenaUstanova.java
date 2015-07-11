import java.util.ArrayList;
import java.util.List;

public class ZdravstvenaUstanova {
	private List<Doktor> listaDoktora;
	private List<Pacijent> listaPacijenata;
	private List<Pregled> listaPregleda;

	public ZdravstvenaUstanova() {
		this.listaDoktora = new ArrayList<Doktor>();
		this.listaPacijenata = new ArrayList<Pacijent>();
		this.listaPregleda=new ArrayList<Pregled>();
	}
	
	
	
	public void DodajDoktora(Doktor doktor)
	{
		listaDoktora.add(doktor);
		
		Logger.Instance().Log("Kreiran doktor " + doktor.getIme());
	}
	public void DodajPacijenta(Pacijent pacijent)
	{
		listaPacijenata.add(pacijent);
		
		Logger.Instance().Log("Kreiran pacijent " + pacijent.getIme());
	}
	public void IzaberiDoktora(String imeDoktora, String imePacijenta){
		Doktor izabraniDoktor = NadjiDoktora(imeDoktora);		
		Pacijent izabraniPacijent = NadjiPacijenta(imePacijenta);
		
		if(izabraniDoktor == null || izabraniPacijent == null)
		{
			return;
		}
		
		izabraniPacijent.setDoktor(izabraniDoktor);
		
		Logger.Instance().Log(imePacijenta + " je izabrao " + imeDoktora + " za doktora");
	}
	
	public void ZakaziPregled(String imePacijenta, Pregled pregled)
	{
		Pacijent izabraniPacijent = NadjiPacijenta(imePacijenta);
		
		if(izabraniPacijent == null || izabraniPacijent.getDoktor() == null)
		{
			return;
		}

		pregled.setPacijent(izabraniPacijent);
		pregled.setPregledZakazao(izabraniPacijent.getDoktor());
		listaPregleda.add(pregled);
		
		Logger.Instance().Log(imePacijenta + " je zakazao pregled za " + pregled.getDatum());
	}
	
	public void ObaviPregled(int pregledId, String... param)
	{
		Pregled pregled = NadjiPregled(pregledId);
		
		if(pregled == null)
		{
			return;
		}
		
		if (pregled.getClass().equals(KrvniPritisak.class))
		{
			((KrvniPritisak)pregled).setGornjaVrednost(Integer.parseInt(param[0]));
			((KrvniPritisak)pregled).setDonjaVrednost(Integer.parseInt(param[1]));
			((KrvniPritisak)pregled).setPuls(Integer.parseInt(param[2]));
			
			Logger.Instance().Log("Pregled krvnog pritiska za pacijenta " + pregled.getPacijent().getIme()  + " je obavljen" );
		}
		else if (pregled.getClass().equals(NivoSecera.class))
		{
			((NivoSecera)pregled).setVrednost(Float.parseFloat(param[0]));
			((NivoSecera)pregled).setVremePoslednjegObroka(param[1]);
			
			Logger.Instance().Log("Pregled nivoa secera za pacijenta " + pregled.getPacijent().getIme()  + " je obavljen" );
		}
		else if (pregled.getClass().equals(NivoHolesterola.class))
		{
			((NivoHolesterola)pregled).setVrednost(Float.parseFloat(param[0]));
			((NivoHolesterola)pregled).setVremePoslednjegObroka(param[1]);
			
			Logger.Instance().Log("Pregled nivoa holesterola za pacijenta " + pregled.getPacijent().getIme()  + " je obavljen" );
		}
	}
	
	private Doktor NadjiDoktora(String imeDoktora)
	{
		for (Doktor doktor : listaDoktora)
		{
			if (doktor.getIme().equals(imeDoktora))
			{
				return doktor;
			}			
		}
		
		return null;
	}
	
	private Pacijent NadjiPacijenta(String imePacijenta)
	{
		for (Pacijent pacijent : listaPacijenata)
		{
			if (pacijent.getIme().equals(imePacijenta))
			{
				return pacijent;
			}			
		}
		
		return null;
	}
	
	private Pregled NadjiPregled(int pregledId)
	{
		for (Pregled pregled : listaPregleda)
		{
			if (pregled.getPregledId() == pregledId)
			{
				return pregled;
			}			
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		ZdravstvenaUstanova ustanova = new ZdravstvenaUstanova();
		ustanova.DodajDoktora(new Doktor("Milan", "Stojanovic", "neurolog") );
		ustanova.DodajPacijenta(new Pacijent("Dragan", "Draganovic", "0102989840003", "e234"));
		ustanova.IzaberiDoktora("Milan", "Dragan");
		ustanova.ZakaziPregled("Dragan", new NivoSecera("10.08.2015.", "10:00"));
		ustanova.ZakaziPregled("Dragan", new KrvniPritisak("12.08.2015.", "08:00"));
		ustanova.ObaviPregled(1, "5.0", "22:00");
		ustanova.ObaviPregled(1, "130", "80", "70");
	}
}

