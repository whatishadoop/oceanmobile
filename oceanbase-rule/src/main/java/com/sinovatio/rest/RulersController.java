package com.sinovatio.rest;

import com.sinovatio.aop.log.Log;
import lombok.extern.slf4j.Slf4j;
import org.kie.api.KieBase;
import org.kie.api.builder.Message;
import org.kie.api.builder.Results;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName: RulersController
 * @Description: TODO
 * @Author JinLu
 * @Date 2019/5/14 16:49
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping("/api")
public class RulersController {

    @Log("测试规则")
    @GetMapping(value = "/testrule")
    public ResponseEntity getRule() {
        KieHelper kieHelper = new KieHelper();
        //方式一: 通过kiehelper加载classpath路径下的drl，可以加载多个规则，而不是覆盖
        //kieHelper.addResource(ResourceFactory.newClassPathResource("rules/test01.drl"), ResourceType.DRL);
        //方式二: 通过kiehelper加载直接加载drl内容,这里的内容可以存在数据库中，动态读取出来
		kieHelper.addContent("package com.rules\n" +
				"\n" +
				"rule \"chapter4\"\n" +
				"\n" +
				"when\n" +
				"\n" +
				"then\n" +
				"\n" +
				"System.out.println(\"Fire the default rules from database!\");\n" +
				"end",ResourceType.DRL);

		// 加入内容后需要进行校验处理
        Results verify = kieHelper.verify();
        boolean hasMessages = verify.hasMessages(Message.Level.WARNING, Message.Level.ERROR);
        if (hasMessages) {
            List<Message> messages = verify.getMessages(Message.Level.WARNING, Message.Level.ERROR);
            for (Message message : messages) {
                System.out.println("ERROR : " + message.getText());
            }

            throw new RuntimeException("verify has errors!");
        }

        KieBase kieBase = kieHelper.build();
        KieSession kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();

        // 若要添加新的规则，则需要重新添加，构建再执行，旧的规则仍旧存在，是增量添加
        kieHelper.addResource(ResourceFactory.newClassPathResource("rules/test02.drl"), ResourceType.DRL);
        kieBase = kieHelper.build();
        kieSession = kieBase.newKieSession();
        kieSession.fireAllRules();
        return new ResponseEntity(HttpStatus.OK);
    }
}
