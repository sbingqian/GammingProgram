package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import module.User;


/**
 * @author shenbingqian
 */

@AllArgsConstructor
public enum AttributeType {

    ATTACK("攻击", "ATTACK", 1),
    DEFENCE("防御", "DEFENCE", 2),
    SPEED("速度", "SPEED", 3),
    DAMAGE("伤害", "DAMAGE", 4),
    AVOID("闪避", "AVOID", 5),
    CRITICAL("暴击", "CRITICAL" ,6),
    HEALTH("生命", "HEALTH", 7),

    ;

    @Getter
    private String name;

    @Getter
    private String code;

    @Getter
    private int sort;


    /**
     *
     * @param attributeType
     * @return
     */
    public boolean equals(AttributeType attributeType) {
        return this.getCode().equals(attributeType.getCode());
    }

}
