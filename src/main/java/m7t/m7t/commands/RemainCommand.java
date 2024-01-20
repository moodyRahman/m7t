package m7t.m7t.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import m7t.m7t.db.Db;

public class RemainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        String subcommand = args[0];

        switch (subcommand) {
            case "remain":
                int t = Db.getRemainingTime();
                sender.sendMessage(Integer.toString(t) + " minutes remaining");
                break;

            case "add":
                Db.increment(60);
                break;

        }

        return true;
    }

}
