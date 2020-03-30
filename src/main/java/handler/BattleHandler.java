package handler;

import module.User;
import util.CalculateUtil;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BattleHandler {

    private AttributeHandler attributeHandler = new AttributeHandler();


    public void battle(User userOne, User userTwo){

        // 获取用户最终属性
        attributeHandler.processUserAttr(userOne);
        attributeHandler.processUserAttr(userTwo);

        //  获取攻击排序
        List<User> fightSeqList = fightSeq(userOne, userTwo);
        BigDecimal speedDiff = fightSeqList.get(0).getSpeed().subtract(fightSeqList.get(1).getSpeed());
        while(userOne.getHealth().compareTo(CalculateUtil.ZERO) > 0 && userTwo.getHealth().compareTo(CalculateUtil.ZERO) > 0) {

            fight(fightSeqList.get(0), fightSeqList.get(1), null);

            fight(fightSeqList.get(1), fightSeqList.get(0), speedDiff);
        }

    }


    private List<User> fightSeq(User userOne, User userTwo){
        List<User> seqList = new ArrayList<User>();
        seqList.add(userOne);
        seqList.add(userTwo);
        seqList.sort(Comparator.comparing(User::getSpeed));
        return seqList;
    }


    private void fight(User userOne, User userTwo, BigDecimal speedDiff){

        // 是否被闪避


        // 获取攻击力
        BigDecimal attack = userOne.getAttack();

        // 本次攻击是否暴击 是的情况 重新计算攻击力
        if(isHitRange(userOne.getCritical().longValue())) {
            attack = attack;
        }

        // 获取对方防御力
        Long defence = userTwo.getDefence().longValue();

        // 计算伤害值
        Long totalDamage = 1L;

        // 计算伤害加成


        // 扣除生命值


    }





    /**
     * 处理收益
     */
    private void processBenefit(Long baseValue){

    }


    private boolean isHitRange(Long speedDiff){
        long randomNum = randomnum(1, 1000);
        return randomNum > speedDiff;
    }




    /**
     * 获取2个值之间的随机数
     *
     * @param smin
     * @param smax
     * @return
     */
    private static long randomnum(int smin, int smax) {
        int range = smax - smin;
        double rand = Math.random();
        return smin + Math.round(rand * range);
    }

}
