/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.OrderDTO;
import Logic.LoginSampleException;
import Logic.User;

/**
 *
 * @author nille
 */
public class Controller {

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

}
