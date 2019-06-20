package com.amg.web.common.util;

import java.util.function.Consumer;

import com.amg.web.common.lambda.IConsumer;

import org.springframework.stereotype.Service;

/**
 * Printer
 */
@Service //객체타입 아니니까 기능을 하니까 Component는 new 어쩌구 할때 쓰는 것임 그니까 Repository도 Mapper만 쓰고 그래서 Service씀.
public class Printer implements IConsumer {

    @Override
    public void accept(Object o) {
        Consumer <String> c = System.out :: println;
        c.accept((String)o);
    }

    
}