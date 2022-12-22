package com.devsuperior.dslearnbds.components.config;

import com.devsuperior.dslearnbds.components.jwtTokenEnhancer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenEnhancerChain;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

import java.util.Arrays;

@Configuration
@EnableAuthorizationServer // anotação que indica que esta classe é a authorization server
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    @Value("${security.oauth2.client.client-id}")
    private String clientId;

    @Value("${security.oauth2.client.client-secret}")
    private String clientSecret;

    @Value("${jwt.duration}")
    private Integer jwtDuration;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private JwtAccessTokenConverter accessTokenConverter;

    @Autowired
    private JwtTokenStore tokenStore;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtTokenEnhancer tokenEnhancer;

    @Autowired
    private UserDetailsService userDetailsService;

    /**
     * Configurar a segurança do Servidor de Autorização, em termos práticos o
     * endpoint /oauth/token.
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()");
    }

    /**
     * define como será a autenticação da aplicação e quais são os dados do
     * cliente(Cliente, a aplicação que solicita os dados)
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                // nome da aplicação
                .withClient(clientId)
                // senha da aplicação
                .secret(passwordEncoder.encode(clientSecret))
                // scopo, como vai ser o acesso
                .scopes("read", "write")
                // como será feito o acesso de login
                .authorizedGrantTypes("password", "refresh_token")
                // tempo para expirar o token
                .accessTokenValiditySeconds(jwtDuration)
                // para refresh token
                .refreshTokenValiditySeconds(jwtDuration);
    }

    /**
     * configura o tratamento de segurança para liberação dos endpoints a aplicação
     * que ta solicitando via chave
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {

        /** Configuração para colocar dados adicionais no token */
        // instanciando o "melhorador" do token
        TokenEnhancerChain chain = new TokenEnhancerChain();
        // adicionando as "melhorias" em formato de lista, passando o conversor do token
        // e as melhorias
        chain.setTokenEnhancers(Arrays.asList(accessTokenConverter, tokenEnhancer));

        endpoints
                .authenticationManager(authenticationManager)
                .tokenStore(tokenStore) // processar o token
                .accessTokenConverter(accessTokenConverter)
                // dados adicionais
                .tokenEnhancer(chain)
                // para refresh token
                .userDetailsService(userDetailsService);
    }
}
