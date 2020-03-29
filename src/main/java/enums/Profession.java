package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;


/**
 * @author admin
 */

@AllArgsConstructor
public enum Profession {

    ROOKIE("新手", "ROOKIE"),
    THIEF("盗贼", "THIEF"),
    WARRIOR("战士", "WARRIOR"),
    MAGIC("法师", "MAGIC"),







            ;


    @Getter
    private String name;

    @Getter
    private String code;


}
