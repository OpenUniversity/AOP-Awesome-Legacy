package awesome.platform.annotations;
import java.lang.annotation.*;

@Retention(RetentionPolicy.CLASS)
@Target(ElementType.METHOD)
public @interface AwSourceLines 
{
	int[] sourceLines();
}
