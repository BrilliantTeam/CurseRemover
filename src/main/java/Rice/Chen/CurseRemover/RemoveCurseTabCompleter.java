package Rice.Chen.CurseRemover;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveCurseTabCompleter implements TabCompleter {
    private final List<String> options = Arrays.asList("binding", "vanishing", "綁定詛咒", "消失詛咒");

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completions = new ArrayList<>();
        
        if (args.length == 1) {
            String partialArg = args[0].toLowerCase();
            for (String option : options) {
                if (option.toLowerCase().startsWith(partialArg)) {
                    completions.add(option);
                }
            }
        }
        
        return completions;
    }
}