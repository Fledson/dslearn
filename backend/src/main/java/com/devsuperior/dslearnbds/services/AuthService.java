package com.devsuperior.dslearnbds.services;

import com.devsuperior.dslearnbds.entities.User;
import com.devsuperior.dslearnbds.repositories.UserRepository;
import com.devsuperior.dslearnbds.services.exceptions.ForbiddenException;
import com.devsuperior.dslearnbds.services.exceptions.UnauthorizedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Classe para controle de autenticação a nivel de serviço
 */
@Service
public class AuthService {

    @Autowired
    private UserRepository repository;

    /**
     * Função que busca o usuario logado na aplicação
     * @return retorna o usuario logado ou se ele não for reconhecido retorna UnauthorizedException("Invalid user")
     */
    @Transactional(readOnly = true)
    public User authenticated() {
        // pegando o usuario logado reconhecido pelo spring security
        String username = SecurityContextHolder.getContext().getAuthentication().getName();

        // retornando o usuario logado
        return repository.findByEmail(username)
                            .orElseThrow( () ->  new UnauthorizedException("Invalid user"));
    }

    /**
     * Verifica se o usuario passado é o mesmo logado na aplicação ou é um admin
     * se não for lança uma exceção ForbiddenException("Access denied");
     * @param id usuario que sera verificado
     */
    public void validateSelfOrAdmin(Long id)  {
        // buscando o usuario autenticado
        User user = authenticated();

        /*
            Verificação se o usuario passado não é igual ao usuario autenticado
            e se o usuario logado não é admin.
        */
        if (!user.getId().equals(id) && !user.hasHole("ROLE_ADMIN") ) {
            throw new ForbiddenException("Access denied");
        }

    }
}
