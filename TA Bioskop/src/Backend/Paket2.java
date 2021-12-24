/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backend;

/**
 *
 * @author PC-HP
 */
public class Paket2 extends Menu{
    private boolean cocaCola = false;
    private boolean popCorn = false;
    private int harga=0;
    

    @Override
    public int totalHarga() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Popcorn() {
        popCorn = true;
        harga += 12000;
    }

    @Override
    public void cocaCola() {
        cocaCola = true;
        harga += 32000;
    }
}
