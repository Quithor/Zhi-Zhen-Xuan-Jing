package top.yanquithor.hhqg.net;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ClassSelectionPacket {
    
    private final String selectClass;
    
    public ClassSelectionPacket(String selectClass) {
        this.selectClass = selectClass;
    }
    
    public ClassSelectionPacket(FriendlyByteBuf buf) {
        this.selectClass = buf.readUtf();
    }
    
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUtf(selectClass);
    }
    
    public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            ServerPlayer sender = context.getSender();
            if (sender != null) {
                sender.getPersistentData().put("",null);
                applyClassEffects(sender,selectClass);
            }
        });
        context.setPacketHandled(true);
    }
    
    private void applyClassEffects(ServerPlayer player, String playerClass) {
        // TODO: 应用玩家的修炼路线
    }
}
