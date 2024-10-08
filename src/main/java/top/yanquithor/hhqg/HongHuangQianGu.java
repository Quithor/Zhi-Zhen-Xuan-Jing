package top.yanquithor.hhqg;

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
import top.yanquithor.hhqg.capability.StageProvider;
import top.yanquithor.hhqg.net.HHQGNetworking;

import static top.yanquithor.hhqg.register.HHQGBlocks.BLOCKS;
import static top.yanquithor.hhqg.register.HHQGItems.ITEMS;
import static top.yanquithor.hhqg.register.HHQGCreateItemTables.CREATIVE_ITEM_TABLES;

/**
 * mod chinese name: 洪荒千古
 * mod english id: Hong Huang Qian Gu
 * type: 修仙
 * This is mod's main class.
 */
@Mod(HongHuangQianGu.MODID)
public class HongHuangQianGu {
    
    public static final String MODID = "hhqg";
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
    /**
     *                             _ooOoo_
     *                            o8888888o
     *                            88" . "88
     *                            (| -_- |)
     *                            O\  =  /O
     *                         ____/`---'\____
     *                       .'  \\|     |//  `.
     *                      /  \\|||  :  |||//  \
     *                     /  _||||| -:- |||||-  \
     *                     |   | \\\  -  /// |   |
     *                     | \_|  ''\---/''  |   |
     *                     \  .-\__  `-`  ___/-. /
     *                   ___`. .'  /--.--\  `. . __
     *                ."" '<  `.___\_<|>_/___.'  >'"".
     *               | | :  `- \`.;`\ _ /`;.`/ - ` : | |
     *               \  \ `-.   \_ __\ /__ _/   .-` /  /
     *          ======`-.____`-.___\_____/___.-`____.-'======
     *                             `=---='
     *          ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
     *                     佛祖保佑        永无BUG
     *            佛曰:
     *                   写字楼里写字间，写字间里程序员；
     *                   程序人员写程序，又拿程序换酒钱。
     *                   酒醒只在网上坐，酒醉还来网下眠；
     *                   酒醉酒醒日复日，网上网下年复年。
     *                   但愿老死电脑间，不愿鞠躬老板前；
     *                   奔驰宝马贵者趣，公交自行程序员。
     *                   别人笑我忒疯癫，我笑自己命太贱；
     *                   不见满街漂亮妹，哪个归得程序员？
     */
}
