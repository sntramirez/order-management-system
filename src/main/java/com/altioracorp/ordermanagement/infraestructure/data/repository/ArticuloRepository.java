package com.altioracorp.ordermanagement.infraestructure.data.repository;

import com.altioracorp.ordermanagement.infraestructure.data.entities.Articulo;
import com.altioracorp.ordermanagement.infraestructure.data.entities.QArticulo;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.binding.SingleValueBinding;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "articulo", collectionResourceRel = "articulos")
public interface ArticuloRepository extends JpaRepository<Articulo, Long>,
        QuerydslPredicateExecutor<Articulo>, QuerydslBinderCustomizer<QArticulo> {

    @Override
    default void customize(
            QuerydslBindings bindings, QArticulo root) {
        bindings.bind(String.class)
                .first((SingleValueBinding<StringPath, String>) StringExpression::containsIgnoreCase);
    }

}
