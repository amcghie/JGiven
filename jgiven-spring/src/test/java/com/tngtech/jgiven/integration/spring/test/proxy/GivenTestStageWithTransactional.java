package com.tngtech.jgiven.integration.spring.test.proxy;

import com.tngtech.jgiven.annotation.ProvidedScenarioState;
import com.tngtech.jgiven.integration.spring.JGivenStage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@JGivenStage
@Transactional
public class GivenTestStageWithTransactional {

    @Autowired
    private HelloWorldService helloWorldService;

    @ProvidedScenarioState
    private MessageToTheWorld message;

    public void should_say_hello() {
        assertThat(helloWorldService).isNotNull();

        message = helloWorldService.sayHello();
    }

}