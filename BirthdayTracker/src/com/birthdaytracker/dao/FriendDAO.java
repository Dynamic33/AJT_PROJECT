package com.birthdaytracker.dao;

import java.sql.*;
import java.util.*;
import com.birthdaytracker.model.Friend;

public class FriendDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/birthdaydb";
    private String jdbcUsername = "root";
    private String jdbcPassword = "root123Ers@*";

    private static final String INSERT_FRIEND = "INSERT INTO friends (name, email, birthday) VALUES (?, ?, ?)";
    private static final String SELECT_ALL = "SELECT * FROM friends";
    private static final String DELETE_FRIEND = "DELETE FROM friends WHERE id=?";

    public FriendDAO() {}

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertFriend(Friend friend) {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(INSERT_FRIEND)) {
            ps.setString(1, friend.getName());
            ps.setString(2, friend.getEmail());
            ps.setString(3, friend.getBirthday());
            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Friend> listAllFriends() {
        List<Friend> friends = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_ALL)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                friends.add(new Friend(rs.getInt("id"), rs.getString("name"),
                        rs.getString("email"), rs.getString("birthday")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return friends;
    }

    public boolean deleteFriend(int id) {
        boolean rowDeleted = false;
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement(DELETE_FRIEND)) {
            ps.setInt(1, id);
            rowDeleted = ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rowDeleted;
    }
}