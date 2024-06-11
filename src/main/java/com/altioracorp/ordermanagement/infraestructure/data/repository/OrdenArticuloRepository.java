package com.altioracorp.ordermanagement.infraestructure.data.repository;

import com.altioracorp.ordermanagement.infraestructure.data.entities.OrdenArticulo;
import com.altioracorp.ordermanagement.infraestructure.data.entities.QOrdenArticulo;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "ordenArticulo", collectionResourceRel = "ordenesArticulos")
public interface OrdenArticuloRepository extends JpaRepository<OrdenArticulo, Long>, QuerydslPredicateExecutor<OrdenArticulo>, QuerydslBinderCustomizer<QOrdenArticulo> {

    @Override
    default void customize(
            QuerydslBindings bindings, QOrdenArticulo root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}
