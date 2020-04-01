package handler;

import common.CommonConstant;
import module.User;
import util.CalculateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @author admin
 */
public class BattleHandler {

    private AttributeHandler attributeHandler = new AttributeHandler();


    public void battle(User userOne, User userTwo){

        // 获取用户最终属性
        attributeHandler.processUserAttr(userOne);
        attributeHandler.processUserAttr(userTwo);

        //  获取攻击排序
        List<User> fightSeqList = fightSeq(userOne, userTwo);
        BigDecimal speedDiff = fightSeqList.get(0).getSpeed().subtract(fightSeqList.get(1).getSpeed());

        while(userOne.getHealth().compareTo(CommonConstant.BD_ZERO) > 0 && userTwo.getHealth().compareTo(CommonConstant.BD_ZERO) > 0) {

            fight(fightSeqList.get(0), fightSeqList.get(1), null);

            if(fightSeqList.get(1).getHealth().compareTo(CommonConstant.BD_ZERO) > 0) {
                fight(fightSeqList.get(1), fightSeqList.get(0), speedDiff);
            }

        }

        System.out.println();

    }

    /**
     * 获取战斗顺序
     * @param userOne
     * @param userTwo
     * @return
     */
    private List<User> fightSeq(User userOne, User userTwo){
        List<User> seqList = new ArrayList<User>();
        seqList.add(userOne);
        seqList.add(userTwo);
        seqList.sort(Comparator.comparing(User::getSpeed));
        return seqList;
    }

    /**
     * 战斗
     *
     * @param userOne
     * @param userTwo
     * @param speedDiff
     */
    private void fight(User userOne, User userTwo, BigDecimal speedDiff){

        // 是否被闪避
        if(speedDiff != null) {
            CalculateUtil.calPercent(userTwo.getAvoid(), speedDiff);
        }
        if (CalculateUtil.calProbability(userTwo.getAvoid(), CommonConstant.INT_ZERO, CommonConstant.INT_HUNDRED)) {
            System.out.println(userTwo.getName() + " 闪避了 " + userOne.getName() + "的攻击");
            return;
        }

        // 获取攻击力
        BigDecimal attack = userOne.getAttack();
        boolean isCritical = false;
        // 本次攻击是否暴击 是的情况 重新计算攻击力
        if (CalculateUtil.calProbability(userOne.getCriticalPercent(), CommonConstant.INT_ZERO, CommonConstant.INT_HUNDRED)) {
            attack = CalculateUtil.calPercent(attack, userOne.getCriticalDamagePercent());
            isCritical = true;
        }

        // 计算伤害值
        BigDecimal totalDamage = CalculateUtil.calDamage(attack, userTwo.getDefence());

        // 计算伤害加成
        totalDamage = CalculateUtil.calPercent(totalDamage, userOne.getDamageIncrPercent());
        String desc = "";
        if (isCritical) {
            desc = " 会心一击了 ";
        } else {
            desc = " 攻击了 ";
        }
        System.out.println(userOne.getName() + desc + userTwo.getName() + "造成 " + totalDamage + " 点伤害");

        // 扣除生命值
        BigDecimal userTwoHealth = userTwo.getHealth().subtract(totalDamage);
        System.out.println(userTwo.getName() + " 剩余 " + userTwoHealth + " 点生命");

        if (userTwoHealth.compareTo(CommonConstant.BD_ZERO) <= 0){
            System.out.println(userTwo.getName() + " GG ");
            userTwo.setHealth(CommonConstant.BD_ZERO);
        } else {
            userTwo.setHealth(userTwoHealth);
        }

    }

}
