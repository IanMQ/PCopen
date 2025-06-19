package pe.upc.pc2logistipro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class Pc2LogistiProApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pc2LogistiProApplication.class, args);
    }

}
