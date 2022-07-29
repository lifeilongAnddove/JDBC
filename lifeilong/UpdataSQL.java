package lifeilong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdataSQL {
    public static void main(String[] args) {
        System.out.println("hello lifeilong");
        Statement stat=null;
        Connection conn=null;
        String sql ="update user set username='张三' where id=1";
        try {
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/day14" ,"root","root");
            stat = conn.createStatement();
            int count=stat.executeUpdate(sql);
            if(count>0){
                System.out.println("修改成功");
            }else {
                System.out.println("修改失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
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
            }
        }
    }
}
