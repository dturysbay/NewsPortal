package news.portal.bitlab.kz.db;
import java.sql.*;
import java.sql.PreparedStatement;
import java.time.LocalDateTime;
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
        } catch (SQLException e) {
            e.printStackTrace();
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

    public static User getUserById(Long id){
        User user = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "SELECT * FROM users WHERE id = ? LIMIT 1"
            );
            preparedStatement.setLong(1,id);
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
        }catch (Exception e){
            e.printStackTrace();
        }
        return user;
    }

    public static void updateUserInfo(User user){
        try{
           PreparedStatement preparedStatement = connection.prepareStatement(
                   "UPDATE users " +
                           "SET " +

                           "email = ?, " +
                           "password = ?, " +
                           "full_name = ?, " +
                           "role_id = ? " +
                           "WHERE id = ? "
           );
           preparedStatement.setString(1,user.getEmail());
           preparedStatement.setString(2,user.getPassword());
           preparedStatement.setString(3,user.getFullName());
           preparedStatement.setLong(4,user.getRole_id());
           preparedStatement.setLong(5,user.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
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

    public static ArrayList<Comment> getComments(){
        ArrayList<Comment> commentArrayList = new ArrayList<>();

        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM comments");
            ResultSet resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Comment comment = new Comment();
                comment.setId(resultSet.getLong("id"));
                comment.setComment(resultSet.getString("comment"));
                comment.setPost_date(resultSet.getString("post_date"));
                comment.setUser_id(resultSet.getLong("user_id"));
                comment.setNews_id(resultSet.getLong("news_id"));
                commentArrayList.add(comment);
            }
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return commentArrayList;
    }

    public static ArrayList<User> getUsers(){
        ArrayList<User> userArrayList = new ArrayList<>();
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setFullName(resultSet.getString("full_name"));
                userArrayList.add(user);
            }
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        return userArrayList;
    }

    public static News getNewsById(Long id){
        News news = null;
        try{
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM news WHERE id = ? LIMIT 1");
            preparedStatement.setLong(1,id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                news = new News();
                news.setId(resultSet.getLong("id"));
                news.setPost_date(resultSet.getString("post_date"));
                news.setCategory_id(resultSet.getLong("category_id"));
                news.setTitle(resultSet.getString("title"));
                news.setContent(resultSet.getString("content"));
            }
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return news;
    }

    public static void updateNews(News news){
        try{
            PreparedStatement preparedStatement = connection
                    .prepareStatement("UPDATE news " +
                            "SET " +
                            "post_date = CURRENT_TIMESTAMP,"+
                            "title = ?," +
                            "content = ?," +
                            "category_id = 1"+
                            " WHERE id = ?");

            preparedStatement.setString(1,news.getTitle());
            preparedStatement.setString(2,news.getContent());
            preparedStatement.setLong(3, news.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void addNews(News news){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO news(post_date,category_id,title,content) " +
                            "VALUES (?,?,?,?)"
            );
            preparedStatement.setTimestamp(1,Timestamp.valueOf(LocalDateTime.now()));
            preparedStatement.setInt(2,1);
            preparedStatement.setString(3,news.getTitle());
            preparedStatement.setString(4,news.getContent());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
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

    public static void addComment(Comment comment){
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO comments (comment,post_date,user_id,news_id) " +
                            "VALUES (?,CURRENT_TIMESTAMP,?,?)"
            );

            preparedStatement.setString(1,comment.getComment());
            preparedStatement.setLong(2,comment.getUser_id());
            preparedStatement.setLong(3,comment.getNews_id());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
