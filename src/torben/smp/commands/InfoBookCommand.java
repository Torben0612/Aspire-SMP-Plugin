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

public class InfoBookCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if (!commandSender.hasPermission("smp.user")) {
            Utilities.warnPlayer( commandSender, Main.getPhrase("no-permissions-message"));
            return true;
        }

        if(commandSender instanceof Player) {

            Player player = (Player) commandSender;

            ItemStack infobook = new ItemStack(Material.WRITTEN_BOOK);
            BookMeta meta = (BookMeta) infobook.getItemMeta();
            meta.setTitle(ChatColor.BLACK + "Information");
            meta.setAuthor("Auto Generated");
            meta.addPage(
                     ChatColor.BOLD + "CH1: Commands" +
                            "\n" + "/home /sethome /delhome" +
                            "\n" + "/warps /warp <WarpName>" +
                            "\n" + "/infobook /rulebook");

            meta.addPage(
                    ChatColor.BOLD + "CH2: Player Shops" +
                            "\n" + "You might be wondering, What are player shops?" +
                            "\n" + "Player Shops are shops that players  make" +
                            "\n" + "to buy and sell with other players" +
                            "\n" + "to start out use the command" +
                            "\n" + ChatColor.BLUE + "/shopkeeper give" + ChatColor.RESET + "This will give you a" +
                            "\n" + "shop keeper spawn egg. Next, place down a chest" +
                            "\n" + "that you will put the stock into right click the chest" +
                            "\n" + "and then where you want to put the npc" +
                            "\n" + "Follow this tutoial to finish it" +
                            "\n" + ChatColor.BLUE + "https://bit.ly/3h1bEZk"
                    );
            meta.addPage(
                    "CH3:" +
                            "\n\n" + "Trolololol theres no CH3:");
            infobook.setItemMeta(meta);

            player.getInventory().addItem(infobook);
            Utilities.informPlayer(commandSender, Main.getPhrase("give-info-book-message"));
        }
        return false;
    }
}
