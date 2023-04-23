package com.city.manager;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;


/**
 * @version v1.0
 * @ClassName: NoticeTest
 * @Description: TODO(一句话描述该类的功能)
 * @Author: CitySpring
 */
@SpringBootTest
public class NoticeTest {

    @Test
    public void parseDate(){
        String s1 = " ";
        String s2 = "2023-03-26 22:40:04";

        int a1 = s1.charAt(0);
        int a2 = s2.charAt(10);

        System.out.println(a1);
        System.out.println(a2);

        System.out.println(LocalDateTime.parse("2023-03-26T22:40:04"));
    }

}
