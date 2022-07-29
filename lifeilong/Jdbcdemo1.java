package lifeilong;

import java.sql.*;

public class Jdbcdemo1 {
    public static void main(String[] args) {
        Statement stmt=null;
        Connection conn=null;
        try  {
            //定义sql
            String sql="insert into user values (null,'李飞龙 ',123456)" ;
            //获取连接对象
             conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/day14","root","root");
            //获取执行sql的对象，Statement
             stmt= conn.createStatement();
             //执行sql
            int count= stmt.executeUpdate(sql);
            //处理结果
            System.out.println(count);
            if(count>0){
                System.out.println("添加成功");
            }else {
                System.out.println("添加失败");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(stmt!=null){
                try {
                    stmt.close();
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
        }

    }

}
