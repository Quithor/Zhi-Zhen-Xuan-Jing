package top.yanquithor.hhqg.command.subcommand;

import com.mojang.brigadier.context.CommandContext;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.network.chat.Component;
import top.yanquithor.hhqg.capability.StageProvider;

public class StageCommand implements Subcommand {
    @Override
    public String getName() {
        return "stage";
    }
    
    @Override
    public int execute(CommandContext<CommandSourceStack> context) {
        getStage(context);
        return 1;
    }
    
    int getStage(CommandContext<CommandSourceStack> context) {
        context.getSource().getPlayer().getCapability(StageProvider.PLAY_XIAN_STAGE_CAPABILITY).ifPresent(stage ->
                context.getSource().sendSuccess(() -> Component.literal(String.format("""
                    当前修为：%d
                    当前修炼法门：%s
                    当前修炼点数：%d
                    灵根：%s""",
                    stage.getLevelCode(),
                    "一头二臂",
                    stage.getPoint(),
                    "雷")), false));
        return 1;
    }
}
