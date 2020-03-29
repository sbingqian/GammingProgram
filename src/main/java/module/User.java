package module;

import enums.Profession;
import lombok.Data;
import lombok.ToString;

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
    private Long attack;

    /**
     * 防御值
     */
    private Long defence;

    /**
     * 速度值
     */
    private Long speed;

    /**
     * 闪避值
     */
    private Long avoid;

    /**
     * 暴击值
     */
    private Long critical;

    /**
     * 生命值
     */
    private Long health;

    /**
     * 装备列表
     */
    private List<Equipment> equipmentList;

    /**
     * 职业
     */
    private Profession profession;

}
