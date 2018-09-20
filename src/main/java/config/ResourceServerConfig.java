package config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {


    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId("resource-id");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .addFilterBefore(new CORSFilter(), ChannelProcessingFilter.class);


        http.authorizeRequests()
                .antMatchers("/**").hasRole("DOCTOR");
    }
}