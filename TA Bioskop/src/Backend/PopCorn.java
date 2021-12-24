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
public class PopCorn extends Menu{
    private boolean popcorn = false;
    private int harga;
    @Override
    public int totalHarga() {
        return this.harga*super.jumlah;
    }

    @Override
    public void Popcorn() {
        popcorn=true;
        harga =5000;
    }

    @Override
    public void cocaCola() {
       
    }
}
