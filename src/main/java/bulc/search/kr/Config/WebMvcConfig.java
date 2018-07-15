package bulc.search.kr.Config;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

public class WebMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new BookInterceptor())
                .addPathPatterns("/*")
                .excludePathPatterns("/login/**");
    }
}
