/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.BillDTO;
import Logic.LoginSampleException;
import Logic.OrderDTO;
import Logic.User;
import java.util.ArrayList;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author nille
 */
public class orderHistory extends Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        ArrayList<BillDTO> bills = FrontController.getHistory(user.getId());
        session.setAttribute("BillDTO", bills);
        return user.getRole() + "page";
    }
}
