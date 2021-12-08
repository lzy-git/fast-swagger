package top.openyuan.swagger;

import org.springframework.context.annotation.Import;
import top.openyuan.swagger.config.SwaggerConfig;

import java.lang.annotation.*;

/**
 * 开启快速接口文档
 *
 * @author liangzhengyuan
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import({SwaggerConfig.class})
public @interface EnableFastSwagger {

}
