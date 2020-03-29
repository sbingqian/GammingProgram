package handler;

import module.Equipment;
import module.User;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class BattleHandler {



    public void battle(User userOne, User userTwo){
        //  获取攻击排序
        processUserAttr(userOne);
        processUserAttr(userOne);

        List<User> fightSeqList = fightSeq(userOne, userTwo);
        Long speedDiff = fightSeqList.get(0).getSpeed() - fightSeqList.get(1).getSpeed();
        while(userOne.getHealth() > 0 && userTwo.getHealth() > 0) {

            fight(fightSeqList.get(0), fightSeqList.get(1), 0L);

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


    private void fight(User userOne, User userTwo, Long speedDiff){

        // 是否被闪避



        // 获取攻击力
        Long attack = userOne.getAttack();

        // 本次攻击是否暴击 是的情况 重新计算攻击力
        if(isHitRange(userOne.getCritical())) {
            attack = attack;
        }

        // 获取对方防御力
        Long defence = userTwo.getDefence();

        // 计算伤害值
        Long totalDamage = 1L;

        // 计算伤害加成


        // 扣除生命值


    }


    private void processUserAttr(User user){
        List<Equipment> equipmentList = user.getEquipmentList();
        for (Equipment equipment : equipmentList){




        }
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
