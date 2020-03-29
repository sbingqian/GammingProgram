package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
public enum AttributeType {

    ATTACK("攻击", "ATTACK"),
    DEFENCE("防御", "DEFENCE"),
    DAMAGE("伤害", "DAMAGE"),
    AVOID("闪避", "AVOID"),
    CRITICAL("暴击", "CRITICAL"),


    ;


    @Getter
    private String name;

    @Getter
    private String code;

}
