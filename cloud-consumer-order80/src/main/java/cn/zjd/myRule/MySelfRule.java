package cn.zjd.myRule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Configuration;

/**
 * @Description TODO
 * @Date 2020/3/20 11:14
 * @auther by Dong
 */
@Configuration
public class MySelfRule {

    public IRule myRule(){
        return new RandomRule();
    }
}
