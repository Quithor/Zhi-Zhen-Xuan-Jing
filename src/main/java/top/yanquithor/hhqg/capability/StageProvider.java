package top.yanquithor.hhqg.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class StageProvider implements ICapabilityProvider, INBTSerializable {
    
    private Stage stage;
    public static final Capability<Stage> PLAY_XIAN_STAGE_CAPABILITY = CapabilityManager.get(new CapabilityToken<Stage>() {});
    private final LazyOptional<Stage> lazyOptional = LazyOptional.of(() -> this.stage);
    
    public StageProvider() {
        stage = new Stage();
    }
    public StageProvider(Stage stage) {
        this.stage = stage;
    }
    
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction direction) {
        return getCapability(capability);
    }
    
    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        return cap == PLAY_XIAN_STAGE_CAPABILITY ? lazyOptional.cast() : LazyOptional.empty();
    }
    
    @Override
    public Tag serializeNBT() {
        CompoundTag tag = new CompoundTag();
        stage.saveNBTData(tag);
        return tag;
    }
    
    @Override
    public void deserializeNBT(Tag tag) {
        stage.loadNBTData((CompoundTag) tag);
    }
}
