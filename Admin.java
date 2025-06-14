public class Admin extends User {
    private String nama;
    private String idPegawai;
    private String email;
    private String noTelepon;
    
    public Admin(
        String username, 
        String password,
        String nama,
        String idPegawai,
        String email,
        String noTelepon
    ){
        super(username, password, Role.ADMIN);
        this.nama = nama;
        this.idPegawai = idPegawai;
        this.email = email;
        this.noTelepon = noTelepon;
    }
    
    public String getNama(){
        return nama;
    }
}
