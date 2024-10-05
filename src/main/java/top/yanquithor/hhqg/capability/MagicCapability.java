package top.yanquithor.hhqg.capability;

/**
 * 这个类实现的是玩家的法术条，玩家在施法时消耗的法术就是这个东西
 */
public class MagicCapability {
    
    /** 玩家当前的法术余量 */
    private int mp;
    /** 玩家当前修练境界的法术最大值 */
    private int maxMp;
    
    /** 这个数组存放玩家每个修炼阶段的最大法术值，数组索引就是玩家的修炼等级 */
    private static final int[] mps = {
            100,
            200,
            500,
            1000,
            2000,
            5000,
            10000,
            20000,
            50000,
    };
    
}
