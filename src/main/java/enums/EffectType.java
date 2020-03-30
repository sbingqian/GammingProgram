package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author admin
 */

@AllArgsConstructor
public enum EffectType {

    BUFF_PERCENT("百分比增益", "BUFF_PERCENT", 1),
    DE_BUFF_PERCENT("百分比减益", "DE_BUFF_PERCENT", 2),
    BUFF_VALUE("数值增益", "BUFF_VALUE", 3),
    DE_BUFF_VALUE("数值减益", "DE_BUFF_VALUE", 4),

    ;


    @Getter
    private String name;

    @Getter
    private String code;

    @Getter
    private int sort;

}
