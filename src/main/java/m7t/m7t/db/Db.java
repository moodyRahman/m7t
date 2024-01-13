package m7t.m7t.db;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import java.sql.*;

public class Db {

    public static Connection conn;

    public Db(JavaPlugin server) {
        server.getLogger().info("booting up the sql db at " + server.getDataFolder().getAbsolutePath() + "/moody.db");
        String url = "jdbc:sqlite:" + server.getDataFolder().getAbsolutePath() + "/moody.db";

        try {
            Connection conn = DriverManager.getConnection(url);
            if (conn != null) {
                Db.conn = conn;
                Statement st = conn.createStatement();
                st.execute(
                        "CREATE TABLE IF NOT EXISTS time" +
                                "(time INT);");

                st.execute("SELECT time from time");
                ResultSet r = st.getResultSet();
                while (r.next()) {
                    ;
                }

                if (r.getRow() == 0) {
                    st.execute("insert into time (time) VALUES (-1);");
                }
                server.getLogger().info("finished initializing database");
            }
        } catch (SQLException e) {
            server.getLogger().warning("aw snap something wacky happened");
            server.getLogger().warning(e.getMessage());
        }
    }

    public ResultSet get_raw(String s) {
        try {
            Statement st = conn.createStatement();
            st.executeQuery(s);
            ResultSet r = st.getResultSet();
            return r;
        } catch (SQLException e) {
            Bukkit.getLogger().warning("bad query ran");
            return null;
        }
    }

    public static void increment() {
        try {
            Statement st = conn.createStatement();
            st.execute("UPDATE time SET time = time + 1");
        } catch (SQLException e) {
            Bukkit.getLogger().warning("failed increment in db");
        }
    }

    public static void decrement() {
        try {
            Statement st = conn.createStatement();
            st.execute("UPDATE time SET time = time - 1");
        } catch (SQLException e) {
            Bukkit.getLogger().warning("failed decrement in db");
            Bukkit.getLogger().warning(e.getMessage());

        }
    }
}
