/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package real.estate;


/**
 *
 * Class namely Property was created
 * Address, Price, and Landsize declared 
 */
public class Property {

    private double address;//post code
    private double price;
    private double landsize;

    /**
     *
     * A set method, setting the address to assign values
     * @param address
     */
    public void setAddress(double address) {
        this.address = address;
    }

    /**
     *
     * A get method, to provide access to the values that address holds and
     * @return address 
     */
    public double getAddress() {
        return address;
    }

    /**
     *A get method, to provide access to the values that address holds and  
     * @return price 
     */
    public double getPrice() {
        return price;
    }

    /**
     * A get method, to provide access to the values that Landsize holds and 
     * @return landsize 
     */
    public double getLandsize() {
        return landsize;
    }

    /**
     *A set method, setting the price to assign values
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     *A set method, setting the Landsize to assign values
     * @param landsize
     */
    public void setLandsize(double landsize) {
        this.landsize = landsize;
    }

}
