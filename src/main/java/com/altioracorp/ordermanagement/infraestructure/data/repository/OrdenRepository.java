package com.altioracorp.ordermanagement.infraestructure.data.repository;

import com.altioracorp.ordermanagement.infraestructure.data.entities.Orden;
import com.altioracorp.ordermanagement.infraestructure.data.entities.QOrden;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource(path = "orden", collectionResourceRel = "ordenes")
public interface OrdenRepository extends JpaRepository<Orden, Long>, QuerydslPredicateExecutor<Orden>, QuerydslBinderCustomizer<QOrden> {

    @Override
    default void customize(
            QuerydslBindings bindings, QOrden root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }
}
