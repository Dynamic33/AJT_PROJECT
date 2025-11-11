package com.birthdaytracker.servlet;

import com.birthdaytracker.dao.FriendDAO;
import com.birthdaytracker.model.Friend;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;

public class AddFriendServlet extends HttpServlet {
    private FriendDAO friendDAO;

    public void init() {
        friendDAO = new FriendDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String birthday = request.getParameter("birthday");

        Friend friend = new Friend(0, name, email, birthday);
        friendDAO.insertFriend(friend);
        response.sendRedirect("list");
    }
}

