/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

//import java.sql.Date;
import java.util.Date;

/**
 *
 * @author nille
 */
public class OrderDTO {

    private int height, width, length, customerNo, orderId;
    private Date date;
    // private final String[] desiredBricks;

    public OrderDTO(int customerNo, int length, int width, int height) {
        this.customerNo = customerNo;
        this.height = height;
        this.width = width;
        this.length = length;
        date = new Date();
        //this.desiredBricks = desiredBricks;
    }

    public int getCustomerNo() {
        return customerNo;
    }

    public void setCustomerNo(int customerNo) {
        this.customerNo = customerNo;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
