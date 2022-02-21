package torben.smp.events.block;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import torben.smp.helpers.ActionSound;
import torben.smp.helpers.Utilities;

public class BlockClick implements Listener {

    @EventHandler
    public void onBlockClick(PlayerInteractEvent event) {
        Utilities.playSound(ActionSound.ERROR, event.getPlayer());

    }

}