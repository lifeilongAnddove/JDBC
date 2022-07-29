package util;

import example.Close;

import java.sql.*;
import java.util.ArrayList;

public class Utillianxi {
    public static void main(String[] args) {
        Utillianxi cls=   new Utillianxi();
        cls.findfull();

    }
    public  void  findfull(){

        Connection conn=null;
        Statement stat=null;
        ResultSet rs=null;

        try {
            String sql="select * from user";
           /* conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/day14","root","root");*/
            conn =  JDBCutil.getConnection();
            stat= conn.createStatement();
            rs=stat.executeQuery(sql);

            while (rs.next()){
                int a=  rs.getInt("id");
                String b=  rs.getString("username");
                String c= rs.getString("password");
                ArrayList list=new ArrayList();
                list.add(a);
                list.add(b);
                list.add(c);
                System.out.println(list);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCutil.close(rs, stat, conn);
        }

    }
}

