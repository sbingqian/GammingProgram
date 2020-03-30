package module;

import enums.Profession;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author admin
 */
@Data
@ToString
public class User {

    /**
     * 昵称
     */
    private String name;

    /**
     * 性别
     */
    private boolean gender;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 攻击值
     */
    private BigDecimal attack;

    /**
     * 防御值
     */
    private BigDecimal defence;

    /**
     * 速度值
     */
    private BigDecimal speed;

    /**
     * 闪避值
     */
    private BigDecimal avoid;

    /**
     * 暴击值
     */
    private BigDecimal critical;

    /**
     * 生命值
     */
    private BigDecimal health;

    /**
     * 伤害加深
     */
    private BigDecimal damage;

    /**
     * 装备列表
     */
    private List<Equipment> equipmentList;

    /**
     * 职业
     */
    private Profession profession;

}
