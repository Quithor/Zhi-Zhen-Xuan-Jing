package top.yanquithor.zzxj.register.event;

import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yanquithor.zzxj.capability.StageProvider;
import top.yanquithor.zzxj.command.HHQGCommand;

import static top.yanquithor.zzxj.HongHuangQianGu.MODID;

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
