package top.yanquithor.hhqg.register.event;

import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import top.yanquithor.hhqg.capability.StageProvider;
import top.yanquithor.hhqg.net.HHQGNetworking;
import top.yanquithor.hhqg.net.OpenClassSelectionPacket;

@Mod.EventBusSubscriber
public class PlayerHandler {
    
    /// 玩家进入地图/服务器触发当前方法
    @SubscribeEvent
    public static void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof ServerPlayer serverPlayer) {
            if (isFirstJoin(serverPlayer)) {
                HHQGNetworking.sendToClient(new OpenClassSelectionPacket(), serverPlayer);
            }
        }
    }
    
    public static boolean isFirstJoin(Player player) {
        boolean isFirst;
        isFirst = player.getCapability(StageProvider.PLAY_XIAN_STAGE_CAPABILITY).isPresent();
        return isFirst;
    }
    
}
