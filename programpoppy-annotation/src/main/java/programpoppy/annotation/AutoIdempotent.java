package programpoppy.annotation;

import javax.validation.Constraint;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
/*
* 这是一个自定义验证注解
*
* */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
/*
* Bean Validation 的核心部分，它告诉验证框架当这个注解被应用于一个字段时应该使用哪个类 (ParamConstraintValidated) 来进行验证
* */
@Constraint(validatedBy = ParamConstraintValidated.class)
public @interface AutoIdempotent {
    boolean required() default true;
    /**
     * 合法的参数值
     **/
    String[] paramValues();
    /**
     * 提示信息
     **/
    String message() default "参数不为指定值";
    Class<?>[] groups() default {};
}
