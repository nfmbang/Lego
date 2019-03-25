package Logic;

import Data.Controller;
import Data.DataException;
import java.util.Map;
import java.util.ArrayList;

/**
 * LogicFace is the controller fro the logic layer. Manages interactions between
 * logic -> data and logic -> presentation
 *
 * @author Niels
 */
public class LogicFacade {

    static Controller dataController = new Controller();

    public static User login(String email, String password) throws LoginSampleException {
        return dataController.login(email, password);
    }

    public static User createUser(String email, String password) throws LoginSampleException {
        User user = new User(email, password, "customer");
        dataController.createUser(user);
        return user;
    }

    public static void addOrder(OrderDTO order) throws DataException {
        dataController.addOrder(order);
    }

    public static OrderDTO getOrder(int orderId) throws DataException {
        return dataController.getOrder(orderId);
    }

    public static Map<String, Integer> calculateBill(OrderDTO order) {
        return Bill.calculateBill(order);
    }

    public static void addBill(BillDTO bill) throws DataException {
        dataController.addBill(bill);
    }

    public static ArrayList<BillDTO> getHistory(int customerId) throws DataException {
        return dataController.getBills(customerId);
    }

}
