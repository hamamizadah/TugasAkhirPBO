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
public class CocaCola extends Menu{
    private boolean cocacola = false;
    private int harga;

    @Override
    public int totalHarga() {
        return this.harga*super.jumlah;
    }

    @Override
    public void Popcorn() {
       }

    @Override
    public void cocaCola() {
        cocacola = true;
        harga = 10000;
    }

    
    
    
}
