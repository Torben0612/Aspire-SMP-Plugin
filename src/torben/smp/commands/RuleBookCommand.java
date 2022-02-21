package torben.smp.commands;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BookMeta;
import torben.smp.Main;
import torben.smp.helpers.Utilities;

public class RuleBookCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {


        if (!commandSender.hasPermission("template.user")) {
            Utilities.warnPlayer(commandSender, Main.getPhrase("no-permissions-message"));
            return true;
        }
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;

            ItemStack rulebook = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta meta = (BookMeta) rulebook.getItemMeta();
            meta.setTitle(ChatColor.DARK_GREEN + "Aspire SMP Rules");
            meta.setAuthor(ChatColor.RED + "Auto Generated");
            meta.addPage(
                    ChatColor.BOLD + "SMP Rule Book" +
                            "\n" + "These Rules were set in place" +
                            "\n" + "by " + ChatColor.RED + ChatColor.BOLD + "Andrew " + ChatColor.RESET + "and " + ChatColor.RED + ChatColor.BOLD + "Torben" +
                            "\n" + "Sorry about having to say this but no pvp" +
                            "\n" + "1: No Greifing See Page 2 for details" +
                            "\n" + "2: No Hacking See page 3 for details" +
                            "\n" + "If you find someone brakeing these rules" +
                            "\n" + "DM CMDRTorbenator#3508 on Discord or" +
                            "\n" + "open a report a player ticket on the" +
                            "\n" + "Report player Channel TheAspireSMP Discord server" +
                            "\n" + "Discord Server Link: https://discord.gg/zcFwHeJBA5");
            meta.addPage(
                    "Rule 1: No Greifing " +
                            "\n\n" + "When you see someone else or someone greifed" +
                            "\n" + "your build please dm me on discord" +
                            "\n" + ChatColor.GOLD + ChatColor.BOLD + "CMDRTorbenator#3508" + ChatColor.RESET + "or go to the website" +
                            "\n" + ChatColor.BLUE + ChatColor.UNDERLINE + "www.theaspiresmp.tk");
            rulebook.setItemMeta(meta);
            player.getInventory().addItem(rulebook);
            Utilities.informPlayer(commandSender, Main.getPhrase("give-rule-book-message"));
        }
        return false;
    }
}
