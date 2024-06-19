package dev.lone64.scorehub;

import dev.lone64.jcore.JPlugin;
import dev.lone64.jcore.lib.fastboard.FastBoard;
import dev.lone64.jcore.lib.runnable.JRunnable;
import dev.lone64.scorehub.config.BoardConfig;
import dev.lone64.scorehub.listener.ScoreHubPlayerListener;
import dev.lone64.scorehub.scoreboard.ScoreboardManager;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public final class ScoreHub extends JPlugin {

    @Getter private static ScoreHub instance;

    @Getter private Map<Player, FastBoard> boards;

    @Override
    protected void load() {
        instance = this;

        /*------| maps |------*/
        this.boards = new HashMap<>();
    }

    @Override
    protected void enable() {
        /*------| configs |------*/
        new BoardConfig();

        /*------| listeners |------*/
        register(new ScoreHubPlayerListener());

        /*------| tasks |------*/
        new JRunnable() {
            @Override
            protected void running() {
                boards.values().forEach(board -> new ScoreboardManager().update(board));
            }
        }.start(20L);

        /*------| loads |------*/
        Bukkit.getOnlinePlayers().forEach(p -> new ScoreboardManager().create(p));
    }

}