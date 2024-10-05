package top.yanquithor.hhqg.item.guaxiang;

import net.minecraft.world.item.Item;

public class Gua extends Item {
    
    private final boolean first;
    private final boolean second;
    private final boolean third;
    
    /// 将构造方法私有化，禁止外部方法创建对象
    private Gua(int first, int second, int third) {
        super(new Item.Properties());
        this.first = first == 1;
        this.second = second == 1;
        this.third = third == 1;
    }
    
    public static final Gua QIAN = new Gua(1,1,1);
    public static final Gua DUI = new Gua(0,1,1);
    public static final Gua LI = new Gua(1,0,1);
    public static final Gua ZHEN = new Gua(0,0,1);
    public static final Gua XUN = new Gua(1,1,0);
    public static final Gua KAN = new Gua(0,1,0);
    public static final Gua GEN = new Gua(1,0,0);
    public static final Gua KUN = new Gua(0,0,0);
    
    /// 这个方法根据爻的阴阳来获取对应的卦象
    public static Gua getGua(int f, int s, int t) {
        return switch (f * 4 + s * 2 + t){
            case 7 -> QIAN;         /// 乾，阳
            case 3 -> DUI;          /// 兑，阴
            case 5 -> LI;           /// 离，阴
            case 1 -> ZHEN;         /// 震，阳
            case 6 -> XUN;          /// 巽，阴
            case 4 -> KAN;          /// 坎，阳
            case 2 -> GEN;          /// 艮，阳
            case 0 -> KUN;          /// 坤，阴
            default -> null;
        };
    }
    
    /// 在比较的时候，只要卦象相同，就是同一个对象
    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Gua gua)) return false;
        
        return first == gua.first && second == gua.second && third == gua.third;
    }
    
    @Override
    public int hashCode() {
        int result = Boolean.hashCode(first);
        result = 31 * result + Boolean.hashCode(second);
        result = 31 * result + Boolean.hashCode(third);
        return result;
    }
}