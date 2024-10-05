package top.yanquithor.hhqg.command.subcommand;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;

public interface Subcommand {
    
    String getName();
    
    int execute(CommandContext<CommandSourceStack> context);
}
