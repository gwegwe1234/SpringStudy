package com.gwegwe.springboot;

import org.apache.catalina.LifecycleException;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
/*
위에 거는 아래 세개랑 같다.
@SpringBootConfiguration
@ComponentScan
@EnableAutoConfiguration

컴포넌트 스캔으로 빈을 등록하고, enable auto configuration으로 자동 설정 빈들을 또 등록해준다.

Spring-boot-autoconfigure 라이브러리에서
spring.factories 에 자동설정 관련된 값들이 설정돼있다
*/
public class Application {

  public static void main(String[] args) throws LifecycleException {
//    SpringApplication.run(Application.class, args);
    SpringApplication app = new SpringApplication(Application.class);
    app.addListeners(new SampleStartingListener());
    // WebApplicationType은 기본이 Servlet(mvc) 이다. Reactive 쓰고싶으면 타입을 바꿔준다.
    app.setWebApplicationType(WebApplicationType.SERVLET);
    app.setBannerMode(Mode.OFF);
    app.run(args);


    // 이런식으로 톰캣 설정을 해서 띄울수도 있다.
    // 근데 당연히 귀찮으니까 EnableAutoConfiguration에 있는 ServletWebServerFactoryAutoConfiguration 요기서 설정해준다.
    // DispatcherServletAutoConfiguration 에서 서블릿 만든거 등록해준다
//    Tomcat tomcat = new Tomcat();
//    tomcat.setPort(8080);
//
//    Context context = tomcat.addContext("/", "/");
//
//    HttpServlet httpServlet = new HttpServlet() {
//      @Override
//      protected void doGet(HttpServletRequest req, HttpServletResponse resp)
//          throws ServletException, IOException {
//        PrintWriter writer = resp.getWriter();
//        writer.println("<html><head><title>Hey, Tomcat</title></head><body>gdgd</body>");
//      }
//    };
//
//    String servletName = "Hello Servlet";
//    tomcat.addServlet("/", servletName, httpServlet);
//    context.addServletMappingDecoded("/hello", servletName);
//    tomcat.start();
//    tomcat.getServer().await();

  }

  /*
  이렇게 아래처럼 빈을 등록하면.. 먼저 컴포넌트 스캔으로 빈을 등록하고, 라이브러리에서 설정한 EnableAutoConfiguration에서 설정한게 더 나중에 설정해서
  이 아래에 설정한게 씹힌다.
  이걸 방지하려면 ConditionalOnMissingBean을 라이브러리에 설정해줘야한다.
  즉 라이브러리에서 다른곳에서 빈설정 안할때만 빈을 등록하도록 설정하는것
  근데 그냥 값만 바꾸고 싶을 수 도 있으니까 @ConfigurationProperties 을 사용해, 그냥 프로퍼티만 받아서 원하는 값 설정하게 해주면 된다.
   */

//  @Bean
//  public Holoman holoman() {
//    Holoman holoman = new Holoman();
//    holoman.setName("Gwegwe1234");
//    holoman.setHowLong(40);
//
//    return holoman;
//  }
}
