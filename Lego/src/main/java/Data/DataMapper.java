/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import Logic.BillDTO;
import Logic.OrderDTO;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author nille
 */
class DataMapper {

    /**
     * Adds an order to the database
     *
     * @param order
     * @throws DataException
     */
    static void addOrder(OrderDTO order) throws DataException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO orders (customerId, length, height, width, date) VALUES (?, ?, ?, ?, CURDATE())";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getCustomerNo());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getHeight());
            ps.setInt(4, order.getWidth());
            //            ps.setDate(5, (Date) order.getDate());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            order.setOrderId(id);

            BillDTO tempB = new BillDTO(order);
            tempB.calcBill();
            addBill(tempB);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage());
        }
    }

    /**
     * fetches an order from the database.
     *
     * @param orderId
     * @return
     * @throws DataException
     */
    static OrderDTO getOrder(int orderId) throws DataException {
        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders "
                    + "WHERE orderId=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int customerNo = rs.getInt("customerId");
                int length = rs.getInt("length");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                Date date = rs.getDate("date");

                OrderDTO order = new OrderDTO(customerNo, length, width, height);
                order.setOrderId(orderId);
                order.setDate(date);
                return order;
            } else {
                throw new DataException("Could not find order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new DataException(ex.getMessage());
        }
    }

    /**
     * Adds a new bill to the database.
     *
     * @param bill
     * @throws DataException
     */
    static void addBill(BillDTO bill) throws DataException {
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO bills (orderId, 2x4, 2x2, 1x2) VALUES (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);

            ps.setInt(1, bill.getOrder().getOrderId());
            ps.setInt(2, bill.getA());
            ps.setInt(3, (bill.getB()));
            ps.setInt(4, bill.getC());
            ps.executeUpdate();

        } catch (SQLException | ClassNotFoundException ex) {
            throw new DataException(ex.getMessage());
        }
    }

    /**
     * Fetches all orders by that customer.
     *
     * @param customerId
     * @return ArrayList of Orders
     * @throws DataException
     */
    ArrayList<OrderDTO> getOrders(int customerId) throws DataException {
        ArrayList<OrderDTO> history = new ArrayList<>();
        int customerNo, length, width, height, orderId;
        Date date;

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT * FROM orders "
                    + "WHERE customerId=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                OrderDTO order;
                customerNo = rs.getInt("customerId");
                length = rs.getInt("length");
                width = rs.getInt("width");
                height = rs.getInt("height");
                date = rs.getDate("date");
                orderId = rs.getInt("orderId");
                order = new OrderDTO(customerNo, length, width, height);
                order.setOrderId(orderId);
                order.setDate(date);
                history.add(order);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new DataException(ex.getMessage());
        }
        return history;
    }

    /**
     * Returns all bills connected to orders by the customer.
     *
     * @param customerId
     * @return
     * @throws DataException
     */
    static ArrayList<BillDTO> getBills(int customerId) throws DataException {

        ArrayList<BillDTO> bills = new ArrayList<>();

        try {
            Connection con = Connector.connection();
            String SQL = "SELECT bills.* FROM orders join bills "
                    + "on orders.orderId=bills.orderId "
                    + "WHERE customerId=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setInt(1, customerId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BillDTO bill = new BillDTO(null);
                bill.setBillId(rs.getInt("billId"));
                bill.setA(rs.getInt("2x4"));
                bill.setB(rs.getInt("2x2"));
                bill.setC(rs.getInt("1x2"));
                bill.setOrder(getOrder(rs.getInt("orderId")));
                bills.add(bill);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new DataException(ex.getMessage());
        }
        return bills;
    }

}
