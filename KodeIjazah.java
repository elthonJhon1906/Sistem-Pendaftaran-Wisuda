import java.util.Random;
import java.time.LocalDate;

public class KodeIjazah {

    private static int nomorUrut = 1; 
    private static final Random random = new Random();

    public static String generateKodeIjazah(Prodi prodi) {
        int tahunLulus = LocalDate.now().getYear();  
        String nomorUrutFormatted = String.format("%05d", nomorUrut++); 
        int angkaRandom = random.nextInt(10); 

        String kodeProdiFormatted = prodi.getKodeProdiFormatted(); 
        String kodeIjazah = kodeProdiFormatted + tahunLulus + nomorUrutFormatted + angkaRandom;

        return kodeIjazah;
    }
}
