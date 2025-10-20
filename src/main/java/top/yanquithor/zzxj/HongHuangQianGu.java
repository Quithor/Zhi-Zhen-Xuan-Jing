package top.yanquithor.zzxj;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;
import top.yanquithor.zzxj.capability.StageProvider;
import top.yanquithor.zzxj.net.HHQGNetworking;

import static top.yanquithor.zzxj.register.HHQGBlocks.BLOCKS;
import static top.yanquithor.zzxj.register.HHQGItems.ITEMS;
import static top.yanquithor.zzxj.register.HHQGCreateItemTables.CREATIVE_ITEM_TABLES;

/**
 * mod chinese name: 洪荒千古
 * mod english id: Zhi Zhen Xuan Jing
 * type: 修仙
 * This is mod's main class.
 */
@Mod(HongHuangQianGu.MODID)
public class HongHuangQianGu {
    
    public static final String MODID = "zzxj";
    public static final Logger LOGGER = LogUtils.getLogger();
    
    public HongHuangQianGu(FMLJavaModLoadingContext context) {
        LOGGER.info("Hong Huang Qian Gu mod is initializing...");
        IEventBus bus = context.getModEventBus();
        BLOCKS.register(bus);
        ITEMS.register(bus);
        CREATIVE_ITEM_TABLES.register(bus);
        MinecraftForge.EVENT_BUS.addGenericListener(Entity.class, this::attachCapability);
        HHQGNetworking.registerMessages();
        LOGGER.info("Hong Huang Qian Gu mod initialize finish");
    }
    
    public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player player)
            if (!player.getCapability(StageProvider.PLAY_XIAN_STAGE_CAPABILITY).isPresent())
                event.addCapability(new ResourceLocation(MODID, "xianstage"), new StageProvider());
    }
}
