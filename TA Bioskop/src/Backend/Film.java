/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;
import java.sql.*;

public class Film  {

    public int idFilm;
    public String judul, genre, sutradara, durasi, keterangan;
    public Rating rating = new Rating();

    public Film() {
    }

    public Film(int idFilm, String judul, String genre, String sutradara, String durasi, Rating rating, String keterangan) {

        this.idFilm = idFilm;
        this.judul = judul;
        this.genre = genre;
        this.sutradara = sutradara;
        this.durasi = durasi;
        this.rating = rating;
        this.keterangan = keterangan;
    }

    public int getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(int idFilm) {
        this.idFilm = idFilm;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    
    public String masukGedung(String gedung) {
        return "\n Masuk ke gedung " + gedung;
    }

    
    public String jadwalTayang(String jadwal) {
        String gedung = "";
        if (jadwal.equalsIgnoreCase("13.00 WIB")) {
            gedung += masukGedung("Teater 1");
        } else if (jadwal.equalsIgnoreCase("14.35 WIB")) {
            gedung += masukGedung("Teater 1");
        } else if (jadwal.equalsIgnoreCase("16.15 WIB")) {
            gedung += masukGedung("Teater 1");
        } else if (jadwal.equalsIgnoreCase("14.00 WIB")) {
            gedung += masukGedung("Teater 2");
        } else if (jadwal.equalsIgnoreCase("15.55 WIB")) {
            gedung += masukGedung("Teater 2");
        } else if (jadwal.equalsIgnoreCase("17.25 WIB")) {
            gedung += masukGedung("Teater 2");
        } else if (jadwal.equalsIgnoreCase("15.00 WIB")) {
            gedung += masukGedung("Teater 3");
        } else if (jadwal.equalsIgnoreCase("16.30 WIB")) {
            gedung += masukGedung("Teater 3");
        } else if (jadwal.equalsIgnoreCase("18.00 WIB")) {
            gedung += masukGedung("Teater 3");
        }

        return "Jadwal Tayang " + jadwal + gedung;
    }

    public Film getById(int id) {
        Film flm = new Film();
        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "f.idfilm as idfilm,"
                + "f.judul as judul,"
                + "f.genre as genre,"
                + "f.sutradara as sutradara,"
                + "f.durasi as durasi,"
                + "f.keterangan as keterangan,"
                + "r.idrating as idrating,"
                + "r.ratingfilm as ratingfilm"
                + " FROM film f LEFT JOIN rating r on f.idrating = r.idrating "
                + " WHERE f.idfilm = '" + id + "'");

        try {
            while (rs.next()) {
                flm = new Film();
                flm.setIdFilm(rs.getInt("idfilm"));
                flm.getRating().setIdRating(rs.getInt("idrating"));
                flm.getRating().setRatingFilm(rs.getString("ratingfilm"));
                flm.setJudul(rs.getString("judul"));
                flm.setGenre(rs.getString("genre"));
                flm.setSutradara(rs.getString("sutradara"));
                flm.setDurasi(rs.getString("durasi"));
                flm.setKeterangan(rs.getString("keterangan"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flm;
    }

    public ArrayList<Film> getAll() {
        ArrayList<Film> ListFilm = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "f.idfilm as idfilm,"
                + "f.judul as judul,"
                + "f.genre as genre,"
                + "f.sutradara as sutradara,"
                + "f.durasi as durasi,"
                + "f.keterangan as keterangan,"
                + "r.idrating as idrating,"
                + "r.ratingfilm as ratingfilm"
                + " FROM film f LEFT JOIN rating r on f.idrating = r.idrating ");

        try {
            while (rs.next()) {
                Film flm = new Film();
                flm.setIdFilm(rs.getInt("idfilm"));
                flm.getRating().setIdRating(rs.getInt("idrating"));
                flm.getRating().setRatingFilm(rs.getString("ratingfilm"));
                flm.setJudul(rs.getString("judul"));
                flm.setGenre(rs.getString("genre"));
                flm.setSutradara(rs.getString("sutradara"));
                flm.setDurasi(rs.getString("durasi"));
                flm.setKeterangan(rs.getString("keterangan"));

                ListFilm.add(flm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListFilm;
    }

    public ArrayList<Film> search(String keyword) {
        ArrayList<Film> ListFilm = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT "
                + "f.idfilm as idfilm,"
                + "f.judul as judul,"
                + "f.genre as genre,"
                + "f.sutradara as sutradara,"
                + "f.durasi as durasi,"
                + "f.keterangan as keterangan,"
                + "r.idrating as idrating,"
                + "r.ratingfilm as ratingfilm"
                + " FROM film f LEFT JOIN rating r on f.idrating = r.idrating "
                + " WHERE f.judul LIKE ' %" + keyword + "%'"
                + "OR f.genre LIKE '%" + keyword + "%'"
                + "OR f.sutradara LIKE '%" + keyword + "%'");

        try {
            while (rs.next()) {
                Film flm = new Film();
                flm.setIdFilm(rs.getInt("idfilm"));
                flm.getRating().setIdRating(rs.getInt("idrating"));
                flm.getRating().setRatingFilm(rs.getString("ratingfilm"));
                flm.setJudul(rs.getString("judul"));
                flm.setGenre(rs.getString("genre"));
                flm.setSutradara(rs.getString("sutradara"));
                flm.setDurasi(rs.getString("durasi"));
                flm.setKeterangan(rs.getString("keterangan"));

                ListFilm.add(flm);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListFilm;

    }

    public void save() {
        if (getById(idFilm).getIdFilm() == 0) {
            String SQL = "INSERT INTO Film (idFilm, idrating, judul, genre, sutradara, durasi, keterangan) VALUES("
                    + "     '" + this.idFilm + "', "
                    + "     '" + this.getRating().getIdRating() + "',  "
                    + "     '" + this.judul + "',  "
                    + "     '" + this.genre + "',  "
                    + "     '" + this.sutradara + "',  "
                    + "     '" + this.durasi + "',  "
                    + "     '" + this.keterangan + "'  "
                    + "     )";
            this.idFilm = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE Film SET "
                    + "idrating = '" + this.getRating().getIdRating() + "', "
                    + "judul = '" + this.judul + "',  "
                    + "genre = '" + this.genre + "',  "
                    + "sutradara = '" + this.sutradara + "',  "
                    + "durasi = '" + this.durasi + "',  "
                    + "keterangan = '" + this.keterangan + "'  "
                    + "     WHERE idfilm = '" + this.idFilm + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM Film WHERE idfilm = '" + this.idFilm + "'";
        DBHelper.executeQuery(SQL);
    }
    public String toString(){
    return judul + keterangan;}
}
