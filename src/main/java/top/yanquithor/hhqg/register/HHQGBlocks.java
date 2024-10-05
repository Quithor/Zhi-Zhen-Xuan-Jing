package top.yanquithor.hhqg.register;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import top.yanquithor.hhqg.block.Grave;
import top.yanquithor.hhqg.block.StrawMat;

import static top.yanquithor.hhqg.HongHuangQianGu.MODID;

public class HHQGBlocks {
    
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister
            .create(ForgeRegistries.BLOCKS, MODID);
    
    public static final RegistryObject<Block> STRAW_MAT = BLOCKS
            .register("straw_mat", () ->
                new StrawMat(BlockBehaviour.Properties.of()
                    .mapColor(MapColor.GRASS)));
    
    public static final RegistryObject<Block> GRAVE = BLOCKS
            .register("grave", () ->
                    new Grave(BlockBehaviour.Properties
                            .copy(Blocks.BEDROCK)));
}
