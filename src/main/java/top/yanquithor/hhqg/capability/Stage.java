package top.yanquithor.hhqg.capability;

import net.minecraft.nbt.CompoundTag;

/**
 * 这个类是对玩家修炼阶段的设定实现
 */
public class Stage {
    
    /// 这个是玩家的修练等级码
    private int level;
    /// 这是玩家的在当前阶段的修炼点数
    private int point;
    /// 灵气
    private int lingqi;
    /// 这是玩家修为的细分修为如：筑基<b>前</b>、<b>中</b>、<b>后</b>期
    private int levelLevel;
    /// 这个是玩家修炼等级
    private String[] levelValue = {"练气","筑基","结丹","元婴","化神","合体","大乘","金仙","大罗金仙"};
    private final int[] points = {100,200,500,800,1000,2000,5000,8000,10000};
    
    public Stage() {
        level = 0;
        point = 0;
    }
    public Stage(int level, int point) {
        this.level = level;
        this.point = point;
    }
    
    public Stage setLevel(int level) {
        if (level < 14 && level >0)
            this.level = level;
        return this;
    }
    public Stage setPoint(int point) {
        if (point < points[level] && point > 0)
            this.point = point;
        return this;
    }
    public Stage setLingqi(int lingqi) {
        if (lingqi < points[level] && lingqi > 0)
            this.lingqi = lingqi;
        return this;
    }
    public Stage setLeveLevel(int leveLevel) {
        if (level == 0)
            if (leveLevel < 10 && leveLevel >= 0)
                this.levelLevel = leveLevel;
            else return this;
        else if (level == 1)
            if (leveLevel < 3 && leveLevel >= 0)
                this.levelLevel = leveLevel;
            else return this;
        else
            if (leveLevel < 4 && leveLevel >= 0)
                this.levelLevel = leveLevel;
        return this;
    }
    
    public int getLevelCode() {
        return level;
    }
    public String getLevel() {
        return levelValue[level];
    }
    public String getLevelLevel() {
        return switch (level){
            case 0 -> switch (levelLevel) {
                case 0 -> "一层";
                case 1 -> "二层";
                case 2 -> "三层";
                case 3 -> "四层";
                case 4 -> "五层";
                case 5 -> "六层";
                case 6 -> "七层";
                case 7 -> "八层";
                case 8 -> "九层";
                case 9 -> "十层";
                default -> "ERROR";
            };
            case 1 -> switch (levelLevel) {
                case 0 -> "初期";
                case 1 -> "中期";
                case 2 -> "后期";
                default -> "ERROR";
            };
            default -> switch (levelLevel) {
                case 0 -> "初期";
                case 1 -> "中期";
                case 2 -> "后期";
                case 3 -> "末期";
                default -> "ERROR";
            };
        };
    }
    public int getPoint() {
        return point;
    }
    public int getLingqi() {
        return lingqi;
    }
    public int getLevelLevelCode() {
        return levelLevel;
    }
    
    public int addPoint() {
        if (point < points[level])
            point += level;
        return point;
    }
    public int addLevel() {
        if (level < 13)
            level ++;
        point = 0;
        return level;
    }
    public int addLingqi(int point) {
        if ((point + lingqi) > points[level] || (point + lingqi) < 0)
            return lingqi;
        else lingqi += point;
        return lingqi;
    }
    
    public void saveNBTData(CompoundTag compoundTag) {
        compoundTag.putInt("xiuwei",level);     /// 将修为添加到玩家的NBT中
        compoundTag.putInt("xiuweidian",point); /// 将修为点数添加到玩家的NBT中
        compoundTag.putInt("lingqi",lingqi);    /// 将玩家的灵气添加到NBT中
    }
    public void loadNBTData(CompoundTag compoundTag) {
        level = compoundTag.getInt("xiuwei");
        point = compoundTag.getInt("xiuweidian");
        lingqi = compoundTag.getInt("lingqi");
    }
    
    @Override
    public String toString() {
        return String.format("""
                ================玩家面板展示================
                """);
    }
}
