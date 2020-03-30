package util;

import enums.EffectType;

import java.math.BigDecimal;

/**
 * @author admin
 */
public class CalculateUtil {

    public static BigDecimal HUNDRED = new BigDecimal(100);
    public static BigDecimal ZERO = new BigDecimal(0);


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
            return  HUNDRED.add(effectValue).divide(HUNDRED).multiply(baseValue);
        }

        if (EffectType.DE_BUFF_PERCENT.getCode().equals(effectType.getCode())) {
            return  HUNDRED.subtract(effectValue).divide(HUNDRED).multiply(baseValue);
        }
        return new BigDecimal(0);
    }






    public static void main(String[] args){
        Long baseValue = 10L;
        Long effectValue = 3L;
        BigDecimal bdBaseValue = new BigDecimal(baseValue);
        BigDecimal bdEffectValue = new BigDecimal(effectValue);

        BigDecimal hundred = new BigDecimal(100);


        System.out.println(hundred.add(bdEffectValue).divide(hundred).multiply(bdBaseValue));

        System.out.println(hundred.subtract(bdEffectValue).divide(hundred).multiply(bdBaseValue));
    }
}
