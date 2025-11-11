package com.birthdaytracker.servlet;

import com.birthdaytracker.dao.FriendDAO;
import com.birthdaytracker.model.Friend;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.util.List;

public class ListFriendsServlet extends HttpServlet {
    private FriendDAO friendDAO;

    public void init() {
        friendDAO = new FriendDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Friend> list = friendDAO.listAllFriends();
        request.setAttribute("friendsList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listfriends.jsp");
        dispatcher.forward(request, response);
    }
}

