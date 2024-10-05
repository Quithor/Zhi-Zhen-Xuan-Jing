package top.yanquithor.hhqg.item;
import net.minecraft.world.item.Item;

/// 这个是法宝等物品的父类
public abstract class QiYong extends Item {
    
    private byte typeCode;
    private final String[] types = {""};
    /// 法宝属性代值
    private byte shuxingCode;
    private final String[] shuxing = {""};
    
    public QiYong(Properties properties) {
		super(properties);
    }
    public QiYong(Properties properties, byte type, byte shuxing) {
		super(properties);
        typeCode = type;
        shuxingCode = shuxing;
    }
    
    public String getType() {
        return types[typeCode];
    }
    public String getShuxing() {
        return shuxing[shuxingCode];
    }
    public byte getTypeCode() {
        return typeCode;
    }
    public byte getShuxingCode() {
        return shuxingCode;
    }
    
    public QiYong setType(byte code) {
        typeCode = code;
        return this;
    }
    public QiYong setShuxing(byte code) {
        shuxingCode = code;
        return this;
    }
}
