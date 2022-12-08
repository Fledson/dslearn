package com.devsuperior.dslearnbds.components;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe para adicionar informações no meu token jwt
 * para ser executado na geração do token precisa injetar e usar no AuthorizationServer
 */
@Component
public class jwtTokenEnhancer implements TokenEnhancer {

    @Autowired
    private UserRepository userRepository;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {

        /** Bucando o ususario por email para colocar nas informações adicionais*/
        User user = userRepository.findByEmail(oAuth2Authentication.getName()).get();

        /** instanciando o map */
        Map<String, Object> map = new HashMap();

        /** Colocando as informações que desejo adicionar ao map*/
        map.put("userId", user.getId());
        map.put("userName", user.getName());

        /** Instanciando o token (para acessar o metodo setAdditionalInformation precisa converter para DefaultOAuth2AccessToken)
         *  DefaultOAuth2AccessToken é uma especialização do OAuth2AccessToken
         * */
        DefaultOAuth2AccessToken token = (DefaultOAuth2AccessToken) oAuth2AccessToken;

        /** Colocando as informações adicionais no token */
        token.setAdditionalInformation(map);

        return oAuth2AccessToken;
    }
}
