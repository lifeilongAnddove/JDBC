package lifeilong;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
public class Login2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.next();
        System.out.println("请输入密码");
        String password = sc.next();
        Boolean lg = new Login2().login(username, password);

        if (lg == true) {
            System.out.println("登陆成功");
        } else {
            System.out.println("登陆失败");
        }
    }
    Connection conn=null;
    ResultSet rs=null;
   PreparedStatement ps=null;
    public boolean login(String username, String password) {
        if (username == null || password == null) {
            return false;
        }
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day14", "root", "root");
                String sql = "select * from user where username = ? and password = ?";
                ps = conn.prepareStatement(sql);
                ps.setString(1, username);
                ps.setString(2, password);
                rs = ps.executeQuery();
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

                if (ps != null) {
                    try {
                        ps.close();
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

