public class BerkasPendaftaran {
    String formulirPendaftaranWisuda;
    String formulirBiodataMahasiswa;
    String formulirPermohonanBebasPustaka;
    String formulirBebasLaboratorium;
    String formulirSuratIkutSertaWisuda;
    String formulirDokumenWisuda;
    String formulirPenyerahanKaryaIlmiah;
    StatusPendaftaran status = StatusPendaftaran.DIPROSES;
    private Admin adminPenanggungJawab; 
   
    public BerkasPendaftaran(
        String formulirPendaftaranWisuda,
        String formulirBiodataMahasiswa,
        String formulirPermohonanBebasPustaka,
        String formulirBebasLaboratorium,
        String formulirSuratIkutSertaWisuda,
        String formulirDokumenWisuda,
        String formulirPenyerahanKaryaIlmiah
    ){
        this.formulirPendaftaranWisuda = formulirPendaftaranWisuda;
        this.formulirBiodataMahasiswa = formulirBiodataMahasiswa;
        this.formulirPermohonanBebasPustaka = formulirPermohonanBebasPustaka;
        this.formulirBebasLaboratorium = formulirBebasLaboratorium;
        this.formulirSuratIkutSertaWisuda = formulirSuratIkutSertaWisuda;
        this.formulirDokumenWisuda = formulirDokumenWisuda;
        this.formulirPenyerahanKaryaIlmiah = formulirPenyerahanKaryaIlmiah;
    }
   
    public void displayBerkasPendaftaran(String namaMahasiswa){
        System.out.println("Berkas Pendaftaran Wisuda " + namaMahasiswa);
        System.out.println("Formulir Pendaftaran Wisuda : " + formulirPendaftaranWisuda);
        System.out.println("Formulir Biodata Mahasiswa : " + formulirBiodataMahasiswa);
        System.out.println("Formulir Permohonan Bebas Pustaka : " + formulirPermohonanBebasPustaka);
        System.out.println("Formulir Bebas Laboratorium : " + formulirBebasLaboratorium);
        System.out.println("Formulir Surat Ikut Serta Wisuda : " + formulirSuratIkutSertaWisuda);
        System.out.println("Formulir Dokumen Wisuda : " + formulirDokumenWisuda);
        System.out.println("Formulir Penyerahan Karya Ilmiah : " + formulirPenyerahanKaryaIlmiah);
        System.out.println("Status: " + this.status);
        if (adminPenanggungJawab != null) {
            System.out.println("Status diubah oleh: " + this.adminPenanggungJawab.getUsername());
        }
    }
    
    public void updateStatus(Admin adm, StatusPendaftaran status) {
        this.adminPenanggungJawab = adm;
        this.status= status;
    }
    
    public StatusPendaftaran getStatus() {
        return this.status;
    }
}
