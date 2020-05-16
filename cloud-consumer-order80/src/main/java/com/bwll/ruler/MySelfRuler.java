package com.bwll.ruler;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName MySelfRuler
 * @Description: TODO
 * @Author shukang
 * @Date 2020/5/13
 **/
@Configuration
public class MySelfRuler {
    @Bean
    public IRule myRuler(){
        return new RandomRule();
    }
}
