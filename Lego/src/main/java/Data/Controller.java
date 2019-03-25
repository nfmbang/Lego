/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.BillDTO;
import Logic.OrderDTO;
import Logic.LoginSampleException;
import Logic.User;
import java.util.ArrayList;
import java.util.Map;

/**
 * Controller fro the database layer. Handles communication between the data
 * layer and the logic layer.
 *
 * @author nille
 */
public class Controller {

    /**
     * Passes information the the user mapper about the login attempt.
     *
     * @param email
     * @param password
     * @return
     * @throws LoginSampleException
     */
    public User login(String email, String password) throws LoginSampleException {
        User user = UserMapper.login(email, password);
        return user;
    }

    public void createUser(User user) throws LoginSampleException {
        UserMapper.createUser(user);
    }

    public OrderDTO getOrder(int orderId) throws DataException {
        return DataMapper.getOrder(orderId);
    }

    public void addOrder(OrderDTO order) throws DataException {
        DataMapper.addOrder(order);
    }

    public void addBill(BillDTO bill) throws DataException {
        DataMapper.addBill(bill);
    }

    public ArrayList<BillDTO> getBills(int customerId) throws DataException {
        return DataMapper.getBills(customerId);
    }

}
