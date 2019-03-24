/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.DataException;
import Logic.LogicFacade;
import Logic.LoginSampleException;
import Logic.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import Domain.OrderDTO;

/**
 *
 * @author nille
 */
public class AddOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        try {
            HttpSession session = request.getSession();
            int lenght = Integer.parseInt(request.getParameter("length"));
            int width = Integer.parseInt(request.getParameter("width"));
            int height = Integer.parseInt(request.getParameter("height"));
            User user = (User) session.getAttribute("user");
            LogicFacade.addOrder(new OrderDTO(user.getId(), lenght, width, height));
            return user.getRole() + "page";
        } catch (DataException e) {
            throw new LoginSampleException(e.getMessage());
        }
    }
}
