package module;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @author admin
 */
@Data
@ToString
public class Equipment {

    /**
     * 装备名称
     */
    private String name;

    /**
     * 装备类型
     */
    private Integer type;

    /**
     * 装备位置
     */
    private Integer position;

    /**
     * 属性
     */
    private List<Attribute> attributeList;




}
