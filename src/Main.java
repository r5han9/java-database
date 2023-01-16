import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        Main c = new Main();

        c.get();
    }

    private void get() {
        try{
            Database db = new Database();
            ResultSet result = db.get("SELECT * FROM siswa");
            while (result.next()) {
                String nis = result.getString("nis");
                String nama = result.getString("nama");
                String tglLahir = result.getString("tglLahir");
                String alamat = result.getString("alamat");
                String namaOrtu = result.getString("namaOrtu");

                System.out.println("NIS                     : " + nis);
                System.out.println("Nama                    : " + nama);
                System.out.println("Tanggal Lahir           : " + tglLahir);
                System.out.println("Alamat                  : " + alamat);
                System.out.println("Nama Orang Tua          : " + namaOrtu);
                System.out.println("----------------------------------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void create() {
        try{
            Database db = new Database();
            HashMap<String, String> data = new HashMap<String, String>();
            data.put("nama", "John Doe");
            data.put("nis", "02020");
            data.put("tglLahir", "2000-01-01");
            data.put("alamat", "Jl. Way");
            data.put("namaOrtu", "Jane Doe");

            db.create(data);

            this.get();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void update() {
        try{
            Database db = new Database();

            HashMap<String, String> data = new HashMap<String, String>();
            data.put("nama", "John Doe");
            data.put("nis", "02828");
            data.put("tglLahir", "2000-01-01");
            data.put("alamat", "Jl. Way");
            data.put("namaOrtu", "Jane Doe");

            db.update(3, data);

            this.get();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void delete() {
        try{
            Database db = new Database();

            db.delete(1);

            this.get();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}