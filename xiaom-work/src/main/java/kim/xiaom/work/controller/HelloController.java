package kim.xiaom.work.controller;

import graphql.ExecutionResult;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

/**
 * Created by wnow20 on 23/12/2017.
 */
@RestController
public class HelloController {
    @GetMapping("")
    public String sayHello(HttpSession session) {
        UserProfile userProfile = (UserProfile) session.getAttribute("profile");
        return userProfile.getUsername();
    }

    @GetMapping("test-session")
    public String testSession(HttpSession session) {
        UserProfile userProfile = new UserProfile();
        userProfile.setUsername("wnow20");
        userProfile.setEmail("wnow20@gmail.com");
        session.setAttribute("profile", userProfile);
        return session.getId();
    }

    public class UserProfile {
        private String username;
        private String email;

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
