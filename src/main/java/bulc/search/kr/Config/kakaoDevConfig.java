package bulc.search.kr.Config;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import feign.Client;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.httpclient.ApacheHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

public class kakaoDevConfig {

    private final Gson gson;


    @Value("${kakao.key:}")
    private String apiKey;


    @Autowired
    public kakaoDevConfig() {
        /* 이름 정책을 변경하기 위해 빌더 이용*/
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);

        this.gson = gsonBuilder.create();
    }


    @Bean
    public Client client() {

        final HttpClientBuilder builder = HttpClientBuilder.create()
                .setMaxConnPerRoute(300)
                .setMaxConnTotal(300)
                .addInterceptorFirst((HttpRequestInterceptor) (request, context) -> {
                    /*개발자 키 삽입*/
                    request.addHeader("Authorization", apiKey);
                });

        builder.disableContentCompression();

        return new ApacheHttpClient(builder.build());
    }

    @Bean
    public Decoder decoder() {
        return new GsonDecoder(gson);
    }

    @Bean
    public Encoder encoder() {
        return new GsonEncoder(gson);
    }
}
