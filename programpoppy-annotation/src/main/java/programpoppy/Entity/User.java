package programpoppy.Entity;

import lombok.Data;
import programpoppy.annotation.AutoIdempotent;

@Data
public class User {
    /**
     * 姓名
     * */
    private String name;

    /**
     * 性别 man or women
     * 根据你之前提供的 ParamConstraintValidated 验证器类，这个注解的主要作用是确保一个字段的值存在于 paramValues 属性所定义的列表中。
     * 举个例子，假设你有一个类中的字段，你希望它的值只能是 "A", "B", 或 "C"。你可以这样使用这个注解：
     * */
    @AutoIdempotent(paramValues = {"man", "woman"})
    private String sex;
}
