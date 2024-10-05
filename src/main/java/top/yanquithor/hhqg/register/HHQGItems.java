package top.yanquithor.hhqg.register;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.yanquithor.hhqg.item.guaxiang.Gua;

import static top.yanquithor.hhqg.HongHuangQianGu.MODID;

public class HHQGItems {
    
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,MODID);
    
    public static final RegistryObject<Item> STRAW_MAT_ITEM =
        ITEMS.register("straw_mat" ,
            () -> new BlockItem(
                HHQGBlocks.STRAW_MAT.get(),
                new Item.Properties()));
    
    public static final RegistryObject<Item> QIAN_GUA = ITEMS.register("qian", ()-> Gua.QIAN);
    public static final RegistryObject<Item> DUI_GUA = ITEMS.register("dui", ()-> Gua.DUI);
    public static final RegistryObject<Item> LI_GUA = ITEMS.register("li", ()-> Gua.LI);
    public static final RegistryObject<Item> ZHEN_GUA = ITEMS.register("zhen", ()-> Gua.ZHEN);
    public static final RegistryObject<Item> XUN_GUA = ITEMS.register("xun", ()-> Gua.XUN);
    public static final RegistryObject<Item> KAN_GUA = ITEMS.register("kan", ()-> Gua.KAN);
    public static final RegistryObject<Item> GEN_GUA = ITEMS.register("gen", ()-> Gua.GEN);
    public static final RegistryObject<Item> KUN_GUA = ITEMS.register("kun", ()-> Gua.KUN);
    public static final RegistryObject<Item> YIN_YANG_YV = ITEMS.register("yinyangyv", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> HOU_TIAN_BA_GUA_TU = ITEMS.register("htbgt", () ->new Item(new Item.Properties()));
}
