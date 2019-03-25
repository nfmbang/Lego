/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author nille
 */
public class BillDTO {

    private Map<String, Integer> bill = new HashMap<>();
    private int billId;
    private OrderDTO order;

    public BillDTO(OrderDTO order) {
        this.order = order;
    }

    public void calcBill() {
        bill = LogicFacade.calculateBill(order);
    }

    public Map<String, Integer> getBill() {
        return bill;
    }

    public void setBill(Map<String, Integer> bill) {
        this.bill = bill;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public void setA(int a) {
        bill.put("2x4", a);
    }

    public void setB(int b) {
        bill.put("2x2", b);
    }

    public void setC(int c) {
        bill.put("2x1", c);
    }

    public int getA() {
        return bill.get("2x4");
    }

    public int getB() {
        return bill.get("2x2");
    }

    public int getC() {
        return bill.get("2x1");
    }
}
