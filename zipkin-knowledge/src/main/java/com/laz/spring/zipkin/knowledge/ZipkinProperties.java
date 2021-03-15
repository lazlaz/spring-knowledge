package com.laz.spring.zipkin.knowledge;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.kristofa.brave.Brave;
import com.github.kristofa.brave.Brave.Builder;
import com.github.kristofa.brave.EmptySpanCollectorMetricsHandler;
import com.github.kristofa.brave.Sampler;
import com.github.kristofa.brave.SpanCollector;
import com.github.kristofa.brave.http.DefaultSpanNameProvider;
import com.github.kristofa.brave.http.HttpSpanCollector;
import com.github.kristofa.brave.http.HttpSpanCollector.Config;
import com.github.kristofa.brave.okhttp.BraveOkHttpRequestResponseInterceptor;
import com.github.kristofa.brave.servlet.BraveServletFilter;
import static com.github.kristofa.brave.http.HttpSpanCollector.Config;
import static com.github.kristofa.brave.http.HttpSpanCollector.create;
import lombok.Data;
import okhttp3.OkHttpClient;

@Data
@Configuration
@ConfigurationProperties(prefix = ZipkinProperties.ZIPKIN_PREFIX)
public class ZipkinProperties {
	 public static final String ZIPKIN_PREFIX = "zipkin";

	    /**
	     * 服务名称
	     */
	    private String serviceName;

	    /**
	     * zipkin地址
	     */
	    private String url;

	    /**
	     * 连接时间
	     */
	    private int connectTimeout;

	    /**
	     * 读取时间
	     */
	    private int readTimeout;

	    /**
	     * 每间隔多少秒执行一次Span信息上传
	     */
	    private int flushInterval;

	    /**
	     * 是否启动压缩
	     */
	    private boolean compressionEnabled;

	    /**
	     * @Description: span（一次请求信息或者一次链路调用）信息收集器
	     * @Param:
	     * @return: SpanCollector 控制器
	     * @Author: Mr.Yang
	     * @Date: 2018/7/3 0002
	     */
	    @Bean
	    public SpanCollector spanCollector() {
	        Config config = Config.builder()
	                // 默认false，span在transport之前是否会被gzipped
	                .compressionEnabled(compressionEnabled)
	                .connectTimeout(connectTimeout)
	                .flushInterval(flushInterval)
	                .readTimeout(readTimeout)
	                .build();
	        return HttpSpanCollector.create(url, config, new EmptySpanCollectorMetricsHandler());
	    }

	    /**
	     * @Description: 作为各调用链路，只需要负责将指定格式的数据发送给zipkin
	     * @Param:
	     * @return:
	     * @Author: Mr.Yang
	     * @Date: 2018/7/3 0002
	     */
	    @Bean
	    public Brave brave(SpanCollector spanCollector) {
	        //调用服务的名称
	        Builder builder = new Builder(serviceName);
	        builder.spanCollector(spanCollector);
	        //采集率
	        builder.traceSampler(Sampler.ALWAYS_SAMPLE);
	        return builder.build();
	    }


	    /**
	     * @Description: 设置server的（服务端收到请求和服务端完成处理，并将结果发送给客户端）过滤器
	     * @Param:
	     * @return: 过滤器
	     * @Author: Mr.Yang
	     * @Date: 2018/7/3 0002
	     */
	    @Bean
	    public BraveServletFilter braveServletFilter(Brave brave) {
	        BraveServletFilter filter = new BraveServletFilter(brave.serverRequestInterceptor(),
	                brave.serverResponseInterceptor(), new DefaultSpanNameProvider());
	        return filter;
	    }

	    /**
	     * @Description: 设置client的（发起请求和获取到服务端返回信息）拦截器
	     * @Param:
	     * @return: OkHttpClient 返回请求实例
	     * @Author: Mr.Yang
	     * @Date: 2018/7/3 0002
	     */
	    @Bean
	    public OkHttpClient okHttpClient(Brave brave) {
	        OkHttpClient httpClient = new OkHttpClient.Builder()
	                .addInterceptor(new BraveOkHttpRequestResponseInterceptor(
	                        brave.clientRequestInterceptor(),
	                        brave.clientResponseInterceptor(),
	                        new DefaultSpanNameProvider())).build();
	        return httpClient;
	    }
}
