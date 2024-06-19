package dev.lone64.scorehub.config;

import dev.lone64.jcore.JConfig;
import dev.lone64.jcore.lib.file.FileFactory;
import dev.lone64.jcore.lib.string.ColorUtils;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.List;

public class BoardConfig extends JConfig {

    public BoardConfig() {
        super("boards.yml");
        FileFactory.createFile(getFile());
    }

    public String getTitle(final Player player) {
        return ColorUtils.gradient(PlaceholderAPI.setPlaceholders(player, getString("scoreboard-title", "<#d991ff:#9198ff>&l서버 이름")));
    }

    public List<String> getLines(final Player player) {
        return PlaceholderAPI.setPlaceholders(player, getList("scoreboard-lines", String.class)).stream().map(ColorUtils::gradient).toList();
    }

}