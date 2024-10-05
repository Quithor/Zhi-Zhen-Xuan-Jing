package top.yanquithor.hhqg.item;

import net.minecraft.world.item.Item;

/// 此乃调养方子所需的药材的父类
public abstract class YaoCai extends Item {
    
    /// 此乃药性，阴、寒、凉、温、补等中医概念中的药性
    private String yaoxing;
    /// 此乃药材的品阶，低阶药材练不出高阶丹、药
    private int level;
    
    public YaoCai(Properties properties, String yaoxing, int level) {
        super(properties);
        this.yaoxing = yaoxing;
        this.level = level;
    }
    
    public String getYaoxing() {
        return yaoxing;
    }
    
    protected static String drugProperty(int index) {
        return switch (index){
            case 0 -> "阴";
            case 1 -> "阳";
            case 2 -> "寒";
            case 3 -> "温";
            case 4 -> "燥";
            case 5 -> "败";
            default -> "";
        };
    }
    
    public int getLevel() {
        return level;
    }
}
