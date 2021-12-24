/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend;
import Backend.*;

public class Test {
    public static void main(String[] args) {
        Rating rat1 = new Rating(1, "SU (Semua Umur)");
        Rating rat2 = new Rating(2, "13+ (Remaja)");
        Rating rat3 = new Rating(3, "17+ (Dewasa)");
        
//        rat1.save();
//        rat2.save();
//        rat3.save();
        
        Film flm1 = new Film(1, "Shang-Chi the Legend of the The Rings(2021) ", "Action, Adventure, Fantasy", "Destin Daniel Cretton", "132 Menit", rat2,"");
        flm1.setKeterangan(flm1.jadwalTayang("13.00 WIB"));
         Film flm2 = new Film(2, "Shang-Chi the Legend of the The Rings(2021) ", "Action, Adventure, Fantasy", "Destin Daniel Cretton", "132 Menit", rat2,"");
        flm2.setKeterangan(flm2.jadwalTayang("14.00 WIB"));
     
         Film flm3 = new Film(3, "Shang-Chi the Legend of the The Rings(2021) ", "Action, Adventure, Fantasy", "Destin Daniel Cretton", "132 Menit", rat2,"");
        flm3.setKeterangan(flm3.jadwalTayang("14.35 WIB"));
        
        flm1.save();
        flm2.save();
        flm3.save();
        
    
        
//        Transaksi trnsks  = new Transaksi(flm1,"Senin" , 2, 0);
//        trnsks.setTotalHarga(trnsks.totalHarga());
//        trnsks.save();
       
        
    }
 
}
