package top.yanquithor.hhqg.command;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import top.yanquithor.hhqg.command.subcommand.HelpCommand;
import top.yanquithor.hhqg.command.subcommand.StageCommand;
import top.yanquithor.hhqg.command.subcommand.Subcommand;

import java.util.*;

public class HHQGCommand {
    
    private static final Map<String, Subcommand> SUBCOMMANDS = new HashMap<>();
    
    static {
        SUBCOMMANDS.put("help", new HelpCommand());
        SUBCOMMANDS.put("stage", new StageCommand());
    }
    
    public static void register(CommandDispatcher<CommandSourceStack> dispatcher) {
        dispatcher.register(Commands.literal("hhqg")
            .then(Commands.argument("subcommand",StringArgumentType.word())
                .suggests((context, builder) -> {
                    SUBCOMMANDS.keySet().forEach(key -> builder.suggest(key.toString()));
                    return builder.buildFuture();
                })
                .executes(context -> {
                    String subcommand = StringArgumentType.getString(context, "subcommand");
                    return SUBCOMMANDS.getOrDefault(subcommand, null).execute(context);
                })
            )
        );
    }
}
