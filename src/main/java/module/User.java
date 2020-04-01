package module;

import enums.Profession;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.ArrayList;
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
     * 闪避概率
     */
    private BigDecimal avoid;

    /**
     * 生命值
     */
    private BigDecimal health;

    /**
     * 暴击概率
     */
    private BigDecimal criticalPercent;

    /**
     * 暴击伤害
     */
    private BigDecimal criticalDamagePercent;


    /**
     * 伤害加深
     */
    private BigDecimal damageIncrPercent;

    /**
     * 装备列表
     */
    private List<Equipment> equipmentList;

    /**
     * 职业
     */
    private Profession profession;


    public List<Equipment> getEquipmentList() {
        if (equipmentList == null){
            equipmentList = new ArrayList<>();
        }
        return equipmentList;
    }


}
