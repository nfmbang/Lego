/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * For calculating the BOM.
 *
 * @author nille
 */
public class Bill {

    public Map<String, Integer> calculateBill(OrderDTO order) {
        Map<String, Integer> bill = new HashMap();
        String[] bricks = order.getBricks();

        return bill;
    }

}
