package io.swagger;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("io.swagger.model")
@ComponentScan(basePackages = { "io.swagger", "io.swagger.api", "io.swagger.configuration",
    "io.swagger.service"})
@EnableJpaRepositories("io.swagger.repository")
public class Swagger2SpringBoot implements CommandLineRunner {

    @Override
    public void run(String... arg0) throws Exception {
        if (arg0.length > 0 && arg0[0].equals("exitcode")) {
            throw new ExitException();
        }
    }

    public static void main(String[] args) throws Exception {
        new SpringApplication(Swagger2SpringBoot.class).run(args);
    }

//    @Configuration
//    static class CustomDateConfig extends WebMvcConfigurerAdapter {
//        @Override
//        public void addFormatters(FormatterRegistry registry) {
//            registry.addConverter(new LocalDateConverter("yyyy-MM-dd"));
//            registry.addConverter(new LocalDateTimeConverter("yyyy-MM-dd'T'HH:mm:ss"));
//        }
//    }

    class ExitException extends RuntimeException implements ExitCodeGenerator {
        private static final long serialVersionUID = 1L;

        @Override
        public int getExitCode() {
            return 10;
        }

    }
}
