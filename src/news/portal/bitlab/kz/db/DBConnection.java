package news.portal.bitlab.kz.db;

import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class DBConnection {
    private static Connection connection;
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:8889/news_portal","root","root");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void createUser(User user){

        try {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO users (email, password, full_name, role_id) VALUES (?, ?, ?, ?)");
            statement.setString(1, user.getEmail());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getFullName());
            statement.setInt(4, user.getRole_id());
            statement.executeUpdate();
            System.out.println("user created");
        } catch (SQLException e) {
            System.out.println("error");
        }
    }
    public static User getUser(String email, String password){
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users WHERE email = ? and password = ? LIMIT 1");
            preparedStatement.setString(1,email);
            preparedStatement.setString(2,password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                user.setFullName(resultSet.getString("full_name"));
                user.setRole_id(resultSet.getInt("role_id"));
            }
            preparedStatement.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }

        return user;
    }

    public static ArrayList<News> getNews(){
        ArrayList<News> newsArrayList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM news");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                News news = new News();
                news.setId(resultSet.getLong("id"));
                news.setPost_date(resultSet.getString("post_date"));
                news.setCategory_id(resultSet.getLong("category_id"));
                news.setTitle(resultSet.getString("title"));
                news.setContent(resultSet.getString("content"));
                newsArrayList.add(news);
            }
            preparedStatement.close();
        }catch (Exception exception){
            exception.printStackTrace();
        }

        return newsArrayList;
    }

    public static void deleteNews(Long id){
        try {
            PreparedStatement preparedStatement = connection
                    .prepareStatement(
                            "DELETE FROM news WHERE id = ?");
            preparedStatement.setLong(1,id);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
