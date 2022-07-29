package lifeilong;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteSQL {
    public static void main(String[] args) {
        Connection conn=null;
        Statement stat=null;
        String sql="delete  from user where id=3";
        try {
           conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/day14","root","root");
            stat=conn.createStatement();
            int counnt= stat.executeUpdate(sql);
            if(counnt>0){
                System.out.println("删除成功");
            }else {
                System.out.println("删除失败");
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
