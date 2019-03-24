/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.awt.BorderLayout;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * For calculating the BOM.
 *
 * @author nille
 */
public class Bill {

    /**
     * Calculates a BoM based on an order.
     *
     * @param order
     * @return Bill of Materials
     */
    public Map<String, Integer> calculateBill(OrderDTO order) {
        Map<String, Integer> bill = new HashMap();
        // String[] bricks = order.getBricks();

        int width = order.getWidth() - 4; // -4 because of brick width.
        int length = order.getLength();
        int height = order.getHeight() * 2; // *2 because of maffs

        if (width < 0) {
            width = 0;
        }

        bill.put("2x4", (int) ((length / 4 + (width) / 4)) * height);
        bill.put("2x2", (int) (((length % 4) / 2 + ((width) % 4) / 2)) * height);
        bill.put("2x1", (int) (((length % 2) + ((width) % 2))) * height);

        return bill;
    }

    /*public static void main(String[] args) {
        OrderDTO order = new OrderDTO(1, 2, 1);
        Map<String, Integer> b = new Bill().calculateBill(order);

        for (Map.Entry<String, Integer> e : b.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
    }*/
}
