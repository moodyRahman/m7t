package m7t.m7t.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import m7t.m7t.db.Db;

public class RemainCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (args.length == 0) {
            return false;
        }

        String subcommand = args[0];

        switch (subcommand) {
            case "remain":
                int t = Db.getRemainingTime();
                sender.sendMessage(Integer.toString(t) + " minutes remaining");
                break;

            case "add":
                if (args.length == 2) {
                    if (args[1].matches("-?\\d+")) {
                        Db.increment(Integer.parseInt(args[1]));
                        sender.sendMessage(Integer.toString(Db.getRemainingTime()) + " minutes remaining");
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
                break;
        }

        return true;
    }

}
