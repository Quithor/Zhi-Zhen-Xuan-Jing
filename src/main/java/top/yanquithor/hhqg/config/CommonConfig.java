package top.yanquithor.hhqg.config;

import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.registries.ForgeRegistries;

public class CommonConfig {
    
    private static ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();
    
    private static boolean allow(Object obj) {
        return ForgeRegistries.BLOCKS.containsKey(new ResourceLocation(obj.toString()));
    }
    
    public static final ForgeConfigSpec SPEC = BUILDER.build();
}
