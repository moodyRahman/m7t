package m7t.m7t.db;

import org.bukkit.plugin.java.JavaPlugin;
import java.sql.*;

public class Db {

    Connection conn;

    public Db(JavaPlugin server) {
        server.getLogger().info("booting up the sql db at " + server.getDataFolder().getAbsolutePath() + "/moody.db");
        String url = "jdbc:sqlite:" + server.getDataFolder().getAbsolutePath() + "/moody.db";

        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                this.conn = conn;
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

    public String get_raw(String s) {
        try {
            Statement st = conn.createStatement();
            st.executeQuery(s);
            ResultSet r = st.getResultSet();
            while (r.next()) {

            }
        } catch (SQLException e) {

        }
        return "";
    }

    public void increment() {
        try {
            Statement st = conn.createStatement();
            st.executeQuery("UPDATE time SET time = time + 1");
        } catch (SQLException e) {

        }
    }
}
