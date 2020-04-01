import enums.AttributeType;
import enums.EffectType;
import enums.Profession;
import handler.BattleHandler;
import module.Attribute;
import module.Equipment;
import module.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author admin
 */
public class MainClass {

    public static void main(String[] args){
        User sbq = assembleUser("sbq");
        User agl = assembleUser("agl");

        Attribute attribute1 = new Attribute();
        attribute1.setAttributeType(AttributeType.ATTACK);
        attribute1.setEffectType(EffectType.BUFF_VALUE);
        attribute1.setValue(new BigDecimal(60));

        Equipment tulongdao = new Equipment();
        tulongdao.setName("攻击之爪");
        tulongdao.getAttributeList().add(attribute1);


        Attribute attribute2 = new Attribute();
        attribute2.setAttributeType(AttributeType.DEFENCE);
        attribute2.setEffectType(EffectType.BUFF_VALUE);
        attribute2.setValue(new BigDecimal(60));

        Equipment suozijia = new Equipment();
        suozijia.setName("锁子甲");
        suozijia.getAttributeList().add(attribute2);


        agl.getEquipmentList().add(tulongdao);
        sbq.getEquipmentList().add(suozijia);


        BattleHandler battleHandler = new BattleHandler();
        battleHandler.battle(sbq, agl);

    }



    public static User assembleUser(String name){
        User u1 = new User();
        u1.setName(name);
        u1.setAttack(new BigDecimal(20));
        u1.setDefence(new BigDecimal(0));
        u1.setSpeed(new BigDecimal(10));
        u1.setAvoid(new BigDecimal(10));
        u1.setHealth(new BigDecimal(100));
        u1.setCriticalPercent(new BigDecimal(10));
        u1.setCriticalDamagePercent(new BigDecimal(150));
        u1.setDamageIncrPercent(new BigDecimal(100));
        return u1;
    }


}
