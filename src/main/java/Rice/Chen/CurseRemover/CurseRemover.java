package Rice.Chen.CurseRemover;

import org.bukkit.plugin.java.JavaPlugin;

public class CurseRemover extends JavaPlugin {
    @Override
    public void onEnable() {
        this.getCommand("removecurse").setExecutor(new RemoveCurseCommand());
        this.getCommand("removecurse").setTabCompleter(new RemoveCurseTabCompleter());
        getLogger().info("CurseRemover 插件已啟用！");
    }

    @Override
    public void onDisable() {
        getLogger().info("CurseRemover 插件已停用！");
    }
}