package top.yanquithor.hhqg.ui;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.gui.components.Button;

public class IdentifyChooseScreen extends Screen {
    
    private static final ResourceLocation BACKGROUND_TEXTURE =
            new ResourceLocation("hhqg","textures/ui/idc.png");
    
    protected IdentifyChooseScreen(Component component) {
        super(Component.literal("修炼路线选择"));
    }
    
    @Override
    protected void init() {
        addRenderableWidget(new Button.Builder(
                Component.literal(""),
                button -> identifySet(0))
                .pos(super.width / 2 - 100, this.height / 4 + 0)
                .size(200,20)
                .build());
        addRenderableWidget(new Button.Builder(
                Component.literal(""),
                button -> identifySet(1))
                .pos(super.width / 2 - 100, this.height / 4 + 24)
                .size(200,20)
                .build());
        addRenderableWidget(new Button.Builder(
                Component.literal(""),
                button -> identifySet(2))
                .pos(super.width / 2 - 100, this.height / 4 + 48)
                .size(200,20)
                .build());
        addRenderableWidget(new Button.Builder(
                Component.literal(""),
                button -> identifySet(3))
                .pos(super.width / 2 - 100, this.height / 4 + 72)
                .size(200,20)
                .build());
    }
    
    /// 身份选择的方法
    /// @param direction 修炼方向，可选值为1->人类修士,2->鬼修,3->妖修,0->不开启修仙模式
    private void identifySet(int direction) {
        
        onClose();
    }
    
    @Override
    public boolean shouldCloseOnEsc() {
        return false;
        // 禁用ESC关闭此UI的功能
    }
}
