import java.util.Random;

public class Prodi {
    private int kodeProdi;
    private String namaProdi;

    public Prodi(String namaProdi) {
        this.namaProdi = namaProdi;
        this.kodeProdi = generateRandomKodeProdi();
    }

    private int generateRandomKodeProdi() {
        Random random = new Random();
        return 10000 + random.nextInt(90000); 
    }

    public String getNamaProdi() {
        return namaProdi;
    }

    public int getKodeProdi() {
        return kodeProdi;
    }

    public String getKodeProdiFormatted() {
        return String.format("%05d", kodeProdi);
    }
}
