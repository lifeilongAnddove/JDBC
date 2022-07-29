package lifeilong;

import util.JDBCutil;

import java.sql.*;
import java.util.Scanner;
public class Login {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        Boolean lg = new Login().login(username, password);
        if (lg == true) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }
    }

    Connection conn;
    ResultSet rs;
    Statement stat;

    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        } else {
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day14", "root", "root");
                String sql = "select * from user where username = '" + username + "' and password = '" + password + "' ";

                stat = conn.createStatement();
                rs = stat.executeQuery(sql);
                if (rs.next()) {
                    return true;
                } else {
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                if (conn != null) {
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }


                if (rs != null) {
                    try {
                        rs.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                }


            }
            return false;
        }
    }

}