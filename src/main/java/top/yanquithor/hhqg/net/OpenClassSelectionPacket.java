package top.yanquithor.hhqg.net;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class OpenClassSelectionPacket {
    
    public OpenClassSelectionPacket() {    }
    
    public OpenClassSelectionPacket(FriendlyByteBuf buf) {
        // TODO: 对数据进行解码处理
    }
    
    public void toBytes(FriendlyByteBuf buf) {
        // TODO: 对数据进行编码
    }
    
    public void handle(Supplier<NetworkEvent.Context> contextSupplier) {
        NetworkEvent.Context context = contextSupplier.get();
        context.enqueueWork(() -> {
            //
        });
        context.setPacketHandled(true);
    }
}
