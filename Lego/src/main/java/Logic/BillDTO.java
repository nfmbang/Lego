/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Logic;

import java.util.Map;

/**
 *
 * @author nille
 */
public class BillDTO {

    private Map<String, Integer> bill;
    private int billId;
    private OrderDTO order;

    public BillDTO(OrderDTO order) {
        this.bill = LogicFacade.calculateBill(order);
        this.order = order;
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

}
