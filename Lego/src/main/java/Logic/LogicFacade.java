package Logic;

import Data.Controller;
import Data.DataException;
import Domain.OrderDTO;

/**
 * The purpose of LogicFacade is to...
 *
 * @author kasper
 */
public class LogicFacade {

    static Controller dataController = new Controller();

    public static User login(String email, String password) throws LoginSampleException {
        return dataController.login(email, password);
    }

    public User createUser(String email, String password) throws LoginSampleException {
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
}
