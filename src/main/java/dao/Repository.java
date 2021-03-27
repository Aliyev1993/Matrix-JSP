package dao;

import java.sql.*;

public class Repository {

    private  Connection connect;

    public Connection connection(String url,String name , String password) throws ClassNotFoundException, SQLException {

            Class.forName("com.mysql.cj.jdbc.Driver");

        connect= DriverManager.getConnection(url,name,password);
        return  connect;
    }

    public void selectById(int id) throws SQLException {
        PreparedStatement statement = connect.prepareStatement("select * from freshmarketform where id=?");
        statement.setInt(1,id);
       ResultSet result= statement.executeQuery();

       while (result.next()){
           System.out.println(result.getInt(1)+result.getString(2)+
                   result.getString(3)+result.getInt(4)+
                   result.getString(5)+result.getString(6));
       }
    }


    public void insert(String name, String lastName,int age , String email , String comment) throws SQLException {
        PreparedStatement statement = connect.prepareStatement("Insert INTO form (name,surName,age,email,message)" +
                " VALUES (?,?,?,?,?)");
        statement.setString(1,name);
        statement.setString(2,lastName);
        statement.setInt(3,age);
        statement.setString(4,email);
        statement.setString(5,comment);

        int insertedColumn=statement.executeUpdate();
        System.out.println(insertedColumn);
    }




    public void update(int id ,String name, String lastName,int age , String email , String comment) throws SQLException {
        PreparedStatement statement = connect.prepareStatement("update form fr set  fr.name=? , fr.surName=?," +
                "fr.age=?,fr.email=?,fr.message=?  where id=?");
        statement.setString(1,name);
        statement.setString(2,lastName);
        statement.setInt(3,age);
        statement.setString(4,email);
        statement.setString(5,comment);
        statement.setInt(6,id);

        int insertedColumn=statement.executeUpdate();
        System.out.println(insertedColumn);
    }


    public void closeConnection() throws SQLException {
        connect.close();

    }

}
