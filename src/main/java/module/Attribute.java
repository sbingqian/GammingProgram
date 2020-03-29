package module;

import enums.AttributeType;
import lombok.Data;

/**
 * @author admin
 */
@Data
public class Attribute {

    /**
     * 属性类型
     */
    private AttributeType attribute;

    /**
     * 是否正向收益
     */
    private Boolean positive;

    /**
     * 数值
     */
    private Long value;


}
