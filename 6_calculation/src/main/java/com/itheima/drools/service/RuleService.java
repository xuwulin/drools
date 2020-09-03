package com.itheima.drools.service;

import com.itheima.drools.entity.Calculation;
import org.kie.api.KieBase;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RuleService {
    @Autowired
    private KieBase kieBase;

    /**
     * 调用Drools规则引擎实现个人所得税计算
     * @param calculation
     * @return
     */
    public Calculation calculate(Calculation calculation){
        KieSession session = kieBase.newKieSession();
        session.insert(calculation);
        session.fireAllRules();
        session.dispose();
        return calculation;
    }
}
