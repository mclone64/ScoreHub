package dev.lone64.scorehub.scoreboard;

import dev.lone64.jcore.lib.fastboard.FastBoard;
import dev.lone64.scorehub.ScoreHub;
import dev.lone64.scorehub.config.BoardConfig;
import org.bukkit.entity.Player;

public class ScoreboardManager {

    public void create(final Player p) {
        if (ScoreHub.getInstance().getBoards().get(p) != null)
            return;
        ScoreHub.getInstance().getBoards().put(p, new FastBoard(p));
    }

    public void delete(final Player p) {
        if (ScoreHub.getInstance().getBoards().get(p) == null)
            return;
        ScoreHub.getInstance().getBoards().remove(p);
    }

    public void update(final FastBoard board) {
        board.updateTitle(new BoardConfig().getTitle(board.getPlayer()));
        board.updateLines(new BoardConfig().getLines(board.getPlayer()));
    }

}