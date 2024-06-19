package dev.lone64.scorehub.listener;

import dev.lone64.scorehub.scoreboard.ScoreboardManager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class ScoreHubPlayerListener implements Listener {

    @EventHandler
    public void onJoin(final PlayerJoinEvent e) {
        new ScoreboardManager().create(e.getPlayer());
    }

    @EventHandler
    public void onQuit(final PlayerQuitEvent e) {
        new ScoreboardManager().delete(e.getPlayer());
    }

}