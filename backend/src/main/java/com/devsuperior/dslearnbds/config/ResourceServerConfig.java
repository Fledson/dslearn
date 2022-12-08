package com.devsuperior.dslearnbds.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableResourceServer // anotação que processa a configuração para que essa classe implemente as
// funções do resourcer server
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

    @Autowired
    private Environment env; // ambiente de execução da aplicação

    @Autowired
    private JwtTokenStore tokenStore;

    /* STRINGS COM AS REGRAS */
    // endpoints publicos (h2-console libera acesso ao h2)
    private static final String[] PUBLIC = { "/oauth/token", "/h2-console/**" };


    /**
     * Recebe o token da aplicação
     * deixa ele capaz de identificar o token e trabalhar com ele
     */
    @Override
    public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
        resources.tokenStore(tokenStore);
    }

    /**
     * Configuração das rotas - Configura as regras de acessos para os endpoints com
     * segurança ou sem
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {

        // h2
        if (Arrays.asList(env.getActiveProfiles()).contains("test")) {
            http.headers().frameOptions().disable();
        }

        http.authorizeRequests()
                // liberando as rotas publicas
                .antMatchers(PUBLIC).permitAll()
                // qualquer outra rota tem que tá logado
                .anyRequest().authenticated();
    }
}
