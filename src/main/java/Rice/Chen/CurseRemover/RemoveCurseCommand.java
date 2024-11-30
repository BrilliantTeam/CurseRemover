package Rice.Chen.CurseRemover;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandExecutor;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RemoveCurseCommand implements CommandExecutor {
    private final String PREFIX = "§7｜§6系統§7｜§f飯娘：§7";

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(PREFIX + ChatColor.RED + "此指令只能由玩家使用！");
            return true;
        }

        Player player = (Player) sender;
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item == null || !item.hasItemMeta()) {
            player.sendMessage(PREFIX + ChatColor.RED + "您必須手持一個物品！");
            return true;
        }

        if (args.length != 1) {
            player.sendMessage(PREFIX + ChatColor.RED + "用法：/removecurse <binding|vanishing|綁定詛咒|消失詛咒>");
            return true;
        }

        ItemMeta meta = item.getItemMeta();
        String type = args[0].toLowerCase();

        switch (type) {
            case "binding":
            case "綁定詛咒":
                if (meta.hasEnchant(Enchantment.BINDING_CURSE)) {
                    meta.removeEnchant(Enchantment.BINDING_CURSE);
                    item.setItemMeta(meta);
                    player.sendMessage(PREFIX + ChatColor.GREEN + "已移除綁定詛咒！");
                } else {
                    player.sendMessage(PREFIX + ChatColor.RED + "此物品沒有綁定詛咒！");
                }
                break;

            case "vanishing":
            case "消失詛咒":
                if (meta.hasEnchant(Enchantment.VANISHING_CURSE)) {
                    meta.removeEnchant(Enchantment.VANISHING_CURSE);
                    item.setItemMeta(meta);
                    player.sendMessage(PREFIX + ChatColor.GREEN + "已移除消失詛咒！");
                } else {
                    player.sendMessage(PREFIX + ChatColor.RED + "此物品沒有消失詛咒！");
                }
                break;

            default:
                player.sendMessage(PREFIX + ChatColor.RED + "無效的詛咒類型！請使用 binding/vanishing 或 綁定詛咒/消失詛咒。");
                break;
        }

        return true;
    }
}