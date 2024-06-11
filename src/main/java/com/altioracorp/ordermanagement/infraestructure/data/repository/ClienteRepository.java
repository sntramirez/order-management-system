package com.altioracorp.ordermanagement.infraestructure.data.repository;

import com.altioracorp.ordermanagement.infraestructure.data.entities.Cliente;
import com.altioracorp.ordermanagement.infraestructure.data.entities.QCliente;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "cliente", collectionResourceRel = "Clientes")
public interface ClienteRepository extends JpaRepository<Cliente, Long>,
        QuerydslPredicateExecutor<Cliente>, QuerydslBinderCustomizer<QCliente> {

    @Override
    default void customize(
            QuerydslBindings bindings, QCliente root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}
