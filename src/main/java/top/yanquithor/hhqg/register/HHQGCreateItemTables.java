package top.yanquithor.hhqg.register;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import static top.yanquithor.hhqg.HongHuangQianGu.MODID;

public class HHQGCreateItemTables {
    
    public static final DeferredRegister<CreativeModeTab> CREATIVE_ITEM_TABLES = DeferredRegister
            .create(Registries.CREATIVE_MODE_TAB,MODID);
    
    public static final RegistryObject<CreativeModeTab> ITEM_TABLE_DAN = CREATIVE_ITEM_TABLES
            .register("hhqg.ib.dan",() -> CreativeModeTab
                    .builder()
                    .title(Component.translatable("item_table_dan"))
                    .icon( () -> null)
                    .displayItems( (p, o) -> {
                        // o.accept(Items.item.get());
                    })
                    .build());
    
    public static final RegistryObject<CreativeModeTab> ITEM_TABLE_TOOL = CREATIVE_ITEM_TABLES
            .register("hhqg.ib.tool", () -> CreativeModeTab
                    .builder()
                    .title(Component.translatable("item_table_tool"))
                    .icon(() -> new ItemStack(HHQGItems.STRAW_MAT_ITEM.get()))
                    .displayItems( (p, o) -> {
                        o.accept(HHQGItems.STRAW_MAT_ITEM.get());
                    })
                    .build());
    
    public static final RegistryObject<CreativeModeTab> ITEM_TABLE_OTHER = CREATIVE_ITEM_TABLES
            .register("hhqg.ib.other", () -> CreativeModeTab
                    .builder()
                    .title(Component.translatable("item_table_other"))
                    .icon(() -> new ItemStack(HHQGItems.XUN_GUA.get()))
                    .displayItems( (parameters, output) ->{
                        output.accept(HHQGItems.QIAN_GUA.get());
                        output.accept(HHQGItems.DUI_GUA.get());
                        output.accept(HHQGItems.LI_GUA.get());
                        output.accept(HHQGItems.ZHEN_GUA.get());
                        output.accept(HHQGItems.XUN_GUA.get());
                        output.accept(HHQGItems.KAN_GUA.get());
                        output.accept(HHQGItems.GEN_GUA.get());
                        output.accept(HHQGItems.KUN_GUA.get());
                        output.accept(HHQGItems.YIN_YANG_YV.get());
                        output.accept(HHQGItems.HOU_TIAN_BA_GUA_TU.get());
                    })
                    .build());
}
