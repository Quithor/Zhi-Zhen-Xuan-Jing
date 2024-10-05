package top.yanquithor.hhqg.command.subcommand;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;

public class HelpCommand implements Subcommand {
    
    @Override
    public String getName() {
        return "help";
    }
    
    @Override
    public int execute(CommandContext<CommandSourceStack> context) {
        context.getSource().sendSystemMessage(Component.literal("""
                ==================洪荒千古指令系统介绍==================
                *   使用 /hhqg [option] <param>进行操作
                *   option是操作功能
                *   param是操作参数
                """));
        return 0;
    }
}
