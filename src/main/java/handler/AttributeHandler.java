package handler;

import enums.AttributeType;
import module.Attribute;
import module.Equipment;
import module.User;
import util.CalculateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AttributeHandler {

    /**
     * 处理用户属性
     * @param user
     */
    public void processUserAttr(User user){
        List<Equipment> equipmentList = user.getEquipmentList();
        List<Attribute> totalAttrList = new ArrayList<>();

        // 获取所有属性
        for (Equipment equipment : equipmentList){
            totalAttrList.addAll(equipment.getAttributeList());
        }

        // 属性排序
        totalAttrList.sort((attributeOne, attributeTwo) -> sortAttr(attributeOne, attributeTwo));


        // 开始计算属性内容
        for (Attribute attribute : totalAttrList){
            processAttrEffect(attribute, user);
        }

    }


    /**
     * 属性排序
     *
     * @param attributeOne
     * @param attributeTwo
     * @return
     */
    private int sortAttr(Attribute attributeOne, Attribute attributeTwo){
        int result = attributeOne.getAttributeType().getSort() - attributeTwo.getAttributeType().getSort();
        if (result==0) {
            return attributeOne.getEffectType().getSort() - attributeTwo.getEffectType().getSort();
        }
        return result;
    }


    /**
     * 处理用户属性
     * @param attribute
     * @param user
     */
    public void processAttrEffect(Attribute attribute, User user){
        // 处理攻击
        if(AttributeType.ATTACK.equals(attribute.getAttributeType())){
            BigDecimal newAttackVal = CalculateUtil.calEffect(user.getAttack(), attribute.getEffectType(), attribute.getValue());
            user.setAttack(newAttackVal);
        }

        // 处理防守
        if(AttributeType.DEFENCE.equals(attribute.getAttributeType())){
            BigDecimal newDefenceVal = CalculateUtil.calEffect(user.getDefence(), attribute.getEffectType(), attribute.getValue());
            user.setDefence(newDefenceVal);
        }

        // 处理速度
        if(AttributeType.SPEED.equals(attribute.getAttributeType())){
            BigDecimal newSpeedVal = CalculateUtil.calEffect(user.getSpeed(), attribute.getEffectType(), attribute.getValue());
            user.setSpeed(newSpeedVal);
        }

        // 处理闪避
        if(AttributeType.AVOID.equals(attribute.getAttributeType())){
            BigDecimal newAvoidVal = CalculateUtil.calEffect(user.getAvoid(), attribute.getEffectType(), attribute.getValue());
            user.setAvoid(newAvoidVal);
        }

        // 处理暴击
        if(AttributeType.CRITICAL.equals(attribute.getAttributeType())){
            BigDecimal newCriticalVal = CalculateUtil.calEffect(user.getCritical(), attribute.getEffectType(), attribute.getValue());
            user.setCritical(newCriticalVal);
        }

        // 处理生命
        if(AttributeType.HEALTH.equals(attribute.getAttributeType())){
            BigDecimal newCriticalVal = CalculateUtil.calEffect(user.getHealth(), attribute.getEffectType(), attribute.getValue());
            user.setHealth(newCriticalVal);
        }

        // 处理伤害加深
        if(AttributeType.DAMAGE.equals(attribute.getAttributeType())){
            BigDecimal newDamageVal = CalculateUtil.calEffect(user.getDamage(), attribute.getEffectType(), attribute.getValue());
            user.setDamage(newDamageVal);
        }
    }






}
