package lifeilong;

import java.sql.*;

public class SelectSQL {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stat=null;
        ResultSet resu=null;

        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/day14" ,"root","root");
            String sql="Select * from user";
            stat=conn.createStatement();
            resu=stat.executeQuery(sql);
         while ( resu.next()){
              int id=resu.getInt(1);
              String name=resu.getString("username");
              String password=resu.getString("password");
              System.out.println("学号为："+id+"的"+name+"同学密码是"+password);
          }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stat!=null){
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                System.out.println();

            }
        }
    }
}
