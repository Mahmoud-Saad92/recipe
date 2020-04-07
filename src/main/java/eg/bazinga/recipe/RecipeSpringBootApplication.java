package eg.bazinga.recipe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class RecipeSpringBootApplication {

    public static void main(String[] args) {
        SpringApplication.run(RecipeSpringBootApplication.class, args);
    }

}
