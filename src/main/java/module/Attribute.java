package module;

import enums.AttributeType;
import enums.EffectType;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author admin
 */
@Data
public class Attribute {

    /**
     * 属性类型
     */
    private AttributeType attributeType;

    /**
     * 是否正向收益
     */
    private EffectType effectType;

    /**
     * 数值
     */
    private BigDecimal value;


}
