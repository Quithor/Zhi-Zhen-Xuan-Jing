package top.yanquithor.hhqg.net;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import static top.yanquithor.hhqg.HongHuangQianGu.MODID;

public class HHQGNetworking {
    
    private static final String PROTOCOL_VERSION = "1";
    public static final SimpleChannel INSTANCE = NetworkRegistry.newSimpleChannel(
            new ResourceLocation(MODID,"main"),
            () -> PROTOCOL_VERSION,
            PROTOCOL_VERSION::equals,
            PROTOCOL_VERSION::equals);
    
    public static void registerMessages() {
        int id = 0;
        INSTANCE.messageBuilder(OpenClassSelectionPacket.class, id++, NetworkDirection.PLAY_TO_CLIENT)
                .encoder(OpenClassSelectionPacket::toBytes)
                .decoder(OpenClassSelectionPacket::new)
                .consumerMainThread(OpenClassSelectionPacket::handle)
                .add();
        INSTANCE.messageBuilder(OpenClassSelectionPacket.class, id++, NetworkDirection.PLAY_TO_SERVER)
                .encoder(OpenClassSelectionPacket::toBytes)
                .decoder(OpenClassSelectionPacket::new)
                .consumerMainThread(OpenClassSelectionPacket::handle)
                .add();
    }
    
    public static void sendToClient(Object packet, ServerPlayer player) {
        INSTANCE.send(PacketDistributor.PLAYER.with(() -> player), packet);
    }
    
    public static void sendToServer(Object packet) {
        INSTANCE.sendToServer(packet);
    }
}
