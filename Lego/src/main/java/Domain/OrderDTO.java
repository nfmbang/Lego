/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

/**
 *
 * @author nille
 */
public class OrderDTO {

    private int height, width, length, customerNo;
    // private final String[] desiredBricks;

    public int getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }

    public OrderDTO(int length, int width, int height) {
        this.height = height;
        this.width = width;
        this.length = length;
        //this.desiredBricks = desiredBricks;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    /*   public String[] getBricks() {
        return desiredBricks;
    }
     */
}
