package spring.conf;


import Chapter02_ANNO.MessageBeanImpl2;
import calc_ANNO.CalcAdd;
import calc_ANNO.CalcMul;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // 환경설정 파일로 취급해라
public class SpringConfiguration {

    // 빈 생성
//    @Bean
//    public MessageBeanImpl2 messageBeanImpl2() {
//        return new MessageBeanImpl2("사과");
//    }


    @Bean(name="messageBeanImpl2")
    public MessageBeanImpl2 getMessageBeanImpl2() {
        return new MessageBeanImpl2("사과");
    } // getMessageBeanImpl2


    @Bean
    public CalcAdd calcAdd() {
        return new CalcAdd(25, 36);
    }

    @Bean(name="calcMul")
    public CalcMul getCalcMul() {
        return new CalcMul();
    }


} // end class


/*
    메소드에서 return 되는 값을 스프링 빈으로 생성
    메소드명을 설정할 때는 반드시 빈의 id명으로 해야된다.
    메소드명을 설정할 때 자바처럼 getter를 사용하려면 @Bean(name 속성)을 사용한다.
 */