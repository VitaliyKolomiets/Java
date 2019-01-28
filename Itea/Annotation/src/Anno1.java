import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value = RetentionPolicy.CLASS)

public @interface Anno1 {
    String str() default "my srting default";
    int value();
}
