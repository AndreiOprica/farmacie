import java.util.HashMap;

public class Farmacie {

    public int cod;
    public String nume;
    public String adresa;
    public Oras oras;
    public String telefon;
    public HashMap<Integer, Medicament> stoc = new HashMap<>();

    public Farmacie(int cod, String nume, String adresa, Oras oras, String telefon){
        this.cod = cod;
        this.nume = nume;
        this.adresa = adresa;
        this.oras = oras;
        this.telefon = telefon;
    }

    public void addMedicament(Medicament medicament, int nrProduse){
        stoc.put(nrProduse, medicament);
    }
}
