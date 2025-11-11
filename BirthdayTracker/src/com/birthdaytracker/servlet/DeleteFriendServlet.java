package com.birthdaytracker.servlet;

import com.birthdaytracker.dao.FriendDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class DeleteFriendServlet extends HttpServlet {
    private FriendDAO friendDAO;

    public void init() {
        friendDAO = new FriendDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        friendDAO.deleteFriend(id);
        response.sendRedirect("list");
    }
}

