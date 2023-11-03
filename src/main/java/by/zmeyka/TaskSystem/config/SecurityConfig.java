package by.zmeyka.TaskSystem.config;

import by.zmeyka.TaskSystem.Service.UserDetailService;
import by.zmeyka.TaskSystem.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private UserDetailService userDetailService;

    protected void configureGlobal(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailService);

    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{
        httpSecurity.//csrf(csrf->csrf.disable()).
                authorizeRequests()
               .requestMatchers("/user/show").hasRole("ADMIN")
//                .requestMatchers("/auth/welcome").authenticated()
                .requestMatchers( "/auth/login","/error").permitAll()
                .requestMatchers( "/user/registrate").permitAll()
                .anyRequest().authenticated()
                .and()
                        .formLogin(form->form.loginPage("/auth/login")
                                .loginProcessingUrl("/proc")
                                .defaultSuccessUrl("/auth/welcome", true)
                                .failureUrl("/auth/login?error"))
                        .logout(logout->logout.logoutUrl("/logout").logoutSuccessUrl("/auth/login"));

        return httpSecurity.build();
    }



    //шифрование пароля с помощью BCrypt
    @Bean
    public static PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }




}
