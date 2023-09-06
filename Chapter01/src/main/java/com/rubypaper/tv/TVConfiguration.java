package com.rubypaper.tv;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// XML 파일을 대체하는 환경 설정 클래스
@Configuration
@ComponentScan(basePackages = {"com.rubypaper.tv", "com.test"})
public class TVConfiguration {

}
