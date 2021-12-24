/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;
import java.sql.*;

public class Transaksi  {

    public int idTransaksi, totalHarga, jmlhtiket;
    public Film film = new Film();
    public String hari;
    public Tiket tiket = new Tiket();
    

    public Transaksi() {
    }

    public Transaksi(Film film, String hari, int tiket) {

        this.film = film;
        this.hari = hari;
        this.jmlhtiket = tiket;
        

    }

    public int getIdTransaksi() {
        return idTransaksi;
    }

    public void setIdTransaksi(int idTransaksi) {
        this.idTransaksi = idTransaksi;
    }

    public int getTotalHarga() {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga) {
        this.totalHarga = totalHarga;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public String getHari() {
        return hari;
    }

    public void setHari(String hari) {
        this.hari = hari;
    }

    public Tiket getTiket() {
        return tiket;
    }

    public void setTiket(Tiket tiket) {
        this.tiket = tiket;
    }

    public int getJmlhtiket() {
        return jmlhtiket;
    }

    public void setJmlhtiket(int jmlhtiket) {
        this.jmlhtiket = jmlhtiket;
    }

    public Transaksi getById(int id) {
        Transaksi trnsks = new Transaksi();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "t.idtransaksi as idtransaksi,"
                + "t.totalharga as totalharga,"
                + "t.hari as hari,"
                + "t.jmlhtiket as jmlhtiket,"
                + "f.idfilm as idfilm,"
                + "f.judul as judul,"
                + "f.genre as genre,"
                + "f.sutradara as sutradara,"
                + "f.durasi as durasi,"
                + "r.idrating as idrating,"
                + "r.ratingfilm as ratingfilm"
                + " FROM transaksi t LEFT JOIN film f on t.idfilm = f.idfilm"
                + " LEFT JOIN rating r on f.idrating = r.idrating"
                + " WHERE t.idtransaksi = '" + id + "'");

        try {
            while (rs.next()) {
                trnsks = new Transaksi();
                trnsks.setIdTransaksi(rs.getInt("idtransaksi"));
                trnsks.getFilm().setIdFilm(rs.getInt("idfilm"));
                trnsks.getFilm().getRating().setIdRating(rs.getInt("idrating"));
                trnsks.getFilm().getRating().setRatingFilm(rs.getString("ratingfilm"));
                trnsks.getFilm().setJudul(rs.getString("judul"));
                trnsks.getFilm().setGenre(rs.getString("genre"));
                trnsks.getFilm().setSutradara(rs.getString("sutradara"));
                trnsks.getFilm().setDurasi(rs.getString("durasi"));
                trnsks.setHari(rs.getString("hari"));
                trnsks.setJmlhtiket(rs.getInt("jmlhtiket"));
                trnsks.setTotalHarga(rs.getInt("totalharga"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return trnsks;
    }

    public ArrayList<Transaksi> getAll() {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "t.idtransaksi as idtransaksi,"
                + "t.totalharga as totalharga,"
                + "t.hari as hari,"
                + "t.jmlhtiket as jmlhtiket,"
                + "f.idfilm as idfilm,"
                + "f.judul as judul,"
                + "f.genre as genre,"
                + "f.sutradara as sutradara,"
                + "f.durasi as durasi,"
                + "r.idrating as idrating,"
                + "r.ratingfilm as ratingfilm"
                + " FROM transaksi t LEFT JOIN film f on t.idfilm = f.idfilm"
                + " LEFT JOIN rating r on f.idrating = r.idrating");

        try {
            while (rs.next()) {
                Transaksi trnsks = new Transaksi();
                trnsks.setIdTransaksi(rs.getInt("idtransaksi"));
                trnsks.getFilm().setIdFilm(rs.getInt("idfilm"));
                trnsks.getFilm().getRating().setIdRating(rs.getInt("idrating"));
                trnsks.getFilm().getRating().setRatingFilm(rs.getString("ratingfilm"));
                trnsks.getFilm().setJudul(rs.getString("judul"));
                trnsks.getFilm().setGenre(rs.getString("genre"));
                trnsks.getFilm().setSutradara(rs.getString("sutradara"));
                trnsks.getFilm().setDurasi(rs.getString("durasi"));
                trnsks.setHari(rs.getString("hari"));
                trnsks.setJmlhtiket(rs.getInt("jmlhtiket"));
                trnsks.setTotalHarga(rs.getInt("totalharga"));

                ListTransaksi.add(trnsks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListTransaksi;
    }

    public ArrayList<Transaksi> search(String keyword) {
        ArrayList<Transaksi> ListTransaksi = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "t.idtransaksi as idtransaksi,"
                + "t.totalharga as totalharga,"
                + "t.hari as hari,"
                + "t.jmlhtiket as jmlhtiket,"
                + "f.idfilm as idfilm,"
                + "f.judul as judul,"
                + "f.genre as genre,"
                + "f.sutradara as sutradara,"
                + "f.durasi as durasi,"
                + "r.idrating as idrating,"
                + "r.ratingfilm as ratingfilm"
                + " FROM transaksi t LEFT JOIN film f on t.idfilm = f.idfilm"
                + " LEFT JOIN rating r on f.idrating = r.idrating"
                + " WHERE f.judul LIKE ' %" + keyword + "%'"
                + "OR t.hari LIKE '%" + keyword + "%'"
                + "OR t.jmlhtiket LIKE '%" + keyword + "%'"
                + "OR t.totalharga LIKE '%" + keyword + "%'");

        try {
            while (rs.next()) {
                Transaksi trnsks = new Transaksi();
                trnsks.setIdTransaksi(rs.getInt("idtransaksi"));
                trnsks.getFilm().setIdFilm(rs.getInt("idfilm"));
                trnsks.getFilm().getRating().setIdRating(rs.getInt("idrating"));
                trnsks.getFilm().getRating().setRatingFilm(rs.getString("ratingfilm"));
                trnsks.getFilm().setJudul(rs.getString("judul"));
                trnsks.getFilm().setGenre(rs.getString("genre"));
                trnsks.getFilm().setSutradara(rs.getString("sutradara"));
                trnsks.getFilm().setDurasi(rs.getString("durasi"));
                trnsks.setHari(rs.getString("hari"));
                trnsks.setJmlhtiket(rs.getInt("jmlhtiket"));
                trnsks.setTotalHarga(rs.getInt("totalharga"));

                ListTransaksi.add(trnsks);

                ListTransaksi.add(trnsks);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListTransaksi;

    }

    public void save() {
        if (getById(idTransaksi).getIdTransaksi() == 0) {
            String SQL = "INSERT INTO transaksi (idtransaksi,idfilm, hari, totalharga, jmlhtiket) VALUES("
                    + "     '" + this.idTransaksi + "', "
                    + "     '" + this.getFilm().getIdFilm() + "',  "
                    + "     '" + this.hari + "',  "
                    + "     '" + this.totalHarga + "',  "
                    + "     '" + this.jmlhtiket + "'  "
                    + "     )";
            this.idTransaksi = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE transaksi SET "
                    + "idfilm = '" + this.getFilm().getIdFilm() + "' "
                    + "hari = '" + this.hari + "',  "
                    + "totalharga = '" + this.totalHarga + "',  "
                    + "jmlhtiket = '" + this.jmlhtiket + "'  "
                    + "     WHERE idtransaksi = '" + this.idTransaksi + "'";
            DBHelper.executeQuery(SQL);
        }
        
        
    }

    public void delete() {
        String SQL = "DELETE FROM transaksi WHERE idtransaksi = '" + this.idTransaksi + "'";
        DBHelper.executeQuery(SQL);
    }
    
    
    public int totalHarga(){
        String weekday[] = {"Senin","Selasa","Rabu","Kamis"};
        if(hari.equalsIgnoreCase(weekday[0])||
           hari.equalsIgnoreCase(weekday[1])||
           hari.equalsIgnoreCase(weekday[2])||
           hari.equalsIgnoreCase(weekday[3])){
        return tiket.getHargaTiket()* jmlhtiket;
        }else{
        return (tiket.getHargaTiket()+5000)*jmlhtiket;
        } 
    }

}
