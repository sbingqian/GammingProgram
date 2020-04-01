package util;

import common.CommonConstant;
import enums.EffectType;

import java.math.BigDecimal;

/**
 * @author admin
 */
public class CalculateUtil {

    /**
     * 处理增减益效果
     * @param baseValue
     * @param effectType
     * @param effectValue
     * @return
     */
    public static BigDecimal calEffect(BigDecimal baseValue, EffectType effectType, BigDecimal effectValue) {
        if (EffectType.BUFF_VALUE.getCode().equals(effectType.getCode())) {
            return  baseValue.add(effectValue);
        }

        if (EffectType.DE_BUFF_VALUE.getCode().equals(effectType.getCode())) {
            return  baseValue.subtract(effectValue);
        }

        if (EffectType.BUFF_PERCENT.getCode().equals(effectType.getCode())) {
            return  CommonConstant.BD_HUNDRED.add(effectValue).divide(CommonConstant.BD_HUNDRED).multiply(baseValue);
        }

        if (EffectType.DE_BUFF_PERCENT.getCode().equals(effectType.getCode())) {
            return  CommonConstant.BD_HUNDRED.subtract(effectValue).divide(CommonConstant.BD_HUNDRED).multiply(baseValue);
        }
        return null;
    }


    /**
     * 处理伤害
     *
     * @param attackVal
     * @param defenceVal
     * @return
     */
    public static BigDecimal calDamage(BigDecimal attackVal, BigDecimal defenceVal) {
        BigDecimal effectValue = CommonConstant.BD_HUNDRED.multiply(getDamageReduce(defenceVal));
        BigDecimal finalDamage = CommonConstant.BD_HUNDRED.subtract(effectValue).divide(CommonConstant.BD_HUNDRED).multiply(attackVal);
        return finalDamage;
    }


    /**
     * 获取伤害减少
     * @return
     */
    private static BigDecimal getDamageReduce(BigDecimal defenceVal){
        BigDecimal val1 = CommonConstant.VAL_0052.multiply(defenceVal);
        BigDecimal val2 = CommonConstant.VAL_0048.multiply(defenceVal).add(CommonConstant.VAL_09);
        return val1.divide(val2, 2,2);
    }



    /**
     * 处理概率
     *
     * @param percentVal
     * @param min
     * @param max
     * @return
     */
    public static boolean calProbability(BigDecimal percentVal, Integer min, Integer max) {
        int range = max - min;
        double rand = Math.random();
        double finalRand = min + Math.round(rand * range);
        BigDecimal bd_finalRand = new BigDecimal(finalRand).multiply(CommonConstant.BD_HUNDRED);
        BigDecimal bd_userProcessVal = percentVal.multiply(CommonConstant.BD_HUNDRED);
        return (bd_userProcessVal.intValue() - bd_finalRand.intValue()) > 0;
    }


    /**
     * 处理百分比数值
     *
     * @param baseVal
     * @return
     */
    public static BigDecimal calPercent(BigDecimal baseVal, BigDecimal percentVal) {
        return percentVal.multiply(baseVal).divide(CommonConstant.BD_HUNDRED);
    }




    public static void main(String[] args){
//        BigDecimal bdBaseValue = new BigDecimal("10");
//        BigDecimal bdEffectValue = new BigDecimal("3.12");
////        System.out.println(CommonConstant.HUNDRED.add(bdEffectValue).divide(CommonConstant.HUNDRED).multiply(bdBaseValue));
////        System.out.println(CommonConstant.HUNDRED.subtract(bdEffectValue).divide(CommonConstant.HUNDRED).multiply(bdBaseValue));
//
//        System.out.println(calProbability(bdEffectValue, CommonConstant.BD_ZERO.intValue(), CommonConstant.BD_HUNDRED.intValue()));
//        System.out.println(calPercent(bdBaseValue, bdEffectValue));

        BigDecimal defence = new BigDecimal("2");
        BigDecimal attack = new BigDecimal("100");

        System.out.println(getDamageReduce(defence));
        System.out.println(calDamage(attack, defence));

    }
}
