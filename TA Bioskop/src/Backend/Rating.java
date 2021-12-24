/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

import java.util.ArrayList;
import java.sql.*;

public class Rating {

    public int idRating;
    public String ratingFilm;

    public Rating(int idRating, String ratingFilm) {
        this.idRating = idRating;
        this.ratingFilm = ratingFilm;
    }

    public Rating() {
    }

    public int getIdRating() {
        return idRating;
    }

    public void setIdRating(int idRating) {
        this.idRating = idRating;
    }

    public String getRatingFilm() {
        return ratingFilm;
    }

    public void setRatingFilm(String ratingFilm) {
        this.ratingFilm = ratingFilm;
    }

    public Rating getById(int id) {
        Rating rat = new Rating();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Rating "
                + " WHERE idRating = '" + id + "'");

        try {
            while (rs.next()) {
                rat = new Rating();
                rat.setIdRating(rs.getInt("idrating"));
                rat.setRatingFilm(rs.getString("ratingfilm"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return rat;
    }

    public ArrayList<Rating> getAll() {
        ArrayList<Rating> ListRating = new ArrayList();

        ResultSet rs = DBHelper.selectQuery("SELECT * FROM Rating");

        try {
            while (rs.next()) {
                Rating rat = new Rating();
                rat.setIdRating(rs.getInt("idRating"));
                rat.setRatingFilm(rs.getString("ratingfilm"));

                ListRating.add(rat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListRating;
    }

    public ArrayList<Rating> search(String keyword) {
        ArrayList<Rating> ListRating = new ArrayList();

        String sql = "SELECT * FROM Rating WHERE "
                + "     ratingfilm LIKE '%" + keyword + "%'";

        ResultSet rs = DBHelper.selectQuery(sql);

        try {
            while (rs.next()) {
                Rating rat = new Rating();
                rat.setIdRating(rs.getInt("idRating"));
                rat.setRatingFilm(rs.getString("ratingfilm"));

                ListRating.add(rat);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ListRating;

    }

    public void save() {
        if (getById(idRating).getIdRating() == 0) {
            String SQL = "INSERT INTO Rating (idrating, ratingfilm) VALUES("
                    + "     '" + this.idRating + "', "
                    + "     '" + this.ratingFilm + "' "
                    + "     )";
            this.idRating = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE Rating SET "
                    + "     ratingfilm = '" + this.ratingFilm + "' "
                    + "     WHERE idRating = '" + this.idRating + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM Rating WHERE idRating = '" + this.idRating + "'";
        DBHelper.executeQuery(SQL);
    }
    public String toString(){
    return ratingFilm;
    }
}
