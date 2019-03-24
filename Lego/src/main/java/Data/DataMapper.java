/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Domain.OrderDTO;
import Logic.LoginSampleException;
import Logic.User;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author nille
 */
class DataMapper {

    static void addOrder(OrderDTO order) throws DataException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (customerId, length, height, width, date) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getCustomerNo());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getHeight());
            ps.setInt(4, order.getWidth());
            ps.setDate(5, (Date) order.getDate());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setOrderId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage());
        }
    }

    static OrderDTO getOrder(int orderId) throws DataException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders "
                    + "WHERE id=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int customerNo = rs.getInt("customerId");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");

                OrderDTO order = new OrderDTO(customerNo, length, width, height);
                order.setOrderId(orderId);
                return order;
            } else {
                throw new DataException("Could not find order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new DataException(ex.getMessage());
        }
    }

}
