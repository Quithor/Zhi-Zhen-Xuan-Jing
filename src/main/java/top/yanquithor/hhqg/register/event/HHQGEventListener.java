package top.yanquithor.hhqg.register.event;

import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yanquithor.hhqg.capability.StageProvider;
import top.yanquithor.hhqg.command.HHQGCommand;

import static top.yanquithor.hhqg.HongHuangQianGu.MODID;

@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class HHQGEventListener {
    
    @SubscribeEvent
    public static void registerCommand(RegisterCommandsEvent event) {
        HHQGCommand.register(event.getDispatcher());
    }
    
    @SubscribeEvent
    public static void registerCapability(RegisterCapabilitiesEvent event) {
        event.register(StageProvider.class);
    }
    
}
