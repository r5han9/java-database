import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;


public class Database {

    private Statement stmt;
    public Database() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java_db", "root", ""
            );
            this.stmt = conn.createStatement();
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e);
        }
    }

    public ResultSet get(String sql) throws SQLException {
        try {
            ResultSet result = this.stmt.executeQuery(sql);

            return result;
        } catch (SQLException e){
            throw e;
        }
    }

    public void create(HashMap<String, String> data) throws SQLException {
        String nis = data.get("nis");
        String nama = data.get("nama");
        String tglLahir = data.get("tglLahir");
        String alamat = data.get("alamat");
        String namaOrtu = data.get("namaOrtu");


        String sql = String.format("INSERT INTO siswa(nis, nama, tglLahir, alamat, namaOrtu) VALUES ('%s', '%s', '%s', '%s', '%s')", nis, nama, tglLahir, alamat, namaOrtu);

        try {
            this.stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void update(int id, HashMap<String, String> data) throws SQLException {
        String nis = data.get("nis");
        String nama = data.get("nama");
        String tglLahir = data.get("tglLahir");
        String alamat = data.get("alamat");
        String namaOrtu = data.get("namaOrtu");


        String sql = String.format("UPDATE siswa SET nis = '%s', nama = '%s', tglLahir = '%s', alamat = '%s', namaOrtu = '%s' WHERE id = %d", nis, nama, tglLahir, alamat, namaOrtu, id);

        try {
            this.stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw e;
        }
    }

    public void delete(int id) throws SQLException{
        String sql = String.format("DELETE FROM siswa WHERE id = %d", id);

        try {
            this.stmt.executeUpdate(sql);
        } catch (SQLException e) {
            throw e;
        }
    }

}
