package example;

import jdk.nashorn.internal.objects.annotations.Where;

import java.sql.*;
import java.util.ArrayList;

public class Close {
    public static void main(String[] args) {
        Close  cls=   new Close();
        cls.findfull();

    }
   public  void  findfull(){

       Connection conn=null;
       Statement stat=null;
       ResultSet rs=null;
       try {
           String sql="select * from user";
           conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/day14","root","root");
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
           if(rs!=null){
               try {
                   rs.close();
               } catch (SQLException e) {
                   e.printStackTrace();
               }
           }
       }

   }
}
