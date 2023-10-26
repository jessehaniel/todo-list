package tech.ada.java.todolist.system.repository;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

@RequiredArgsConstructor
public class MySpecification<T> implements Specification<T> {

    private final transient List<SearchCriteria<T>> params;

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return this.params.stream()
            .map(it -> this.getPredicate(root, criteriaBuilder, it))
            .reduce(criteriaBuilder::and)
            .orElse(null);
    }

    private Predicate getPredicate(Root<T> root, CriteriaBuilder criteriaBuilder, SearchCriteria<T> criteria) {
        if (criteria.operacao().equalsIgnoreCase(">")) {
            return criteriaBuilder.greaterThanOrEqualTo(
                root.get(criteria.chave()), criteria.valor().toString());
        } else if (criteria.operacao().equalsIgnoreCase("<")) {
            return criteriaBuilder.lessThanOrEqualTo(
                root.get(criteria.chave()), criteria.valor().toString());
        } else if (criteria.operacao().equalsIgnoreCase(":")) {
            if (root.get(criteria.chave()).getJavaType() == String.class) {
                return criteriaBuilder.like(
                    root.get(criteria.chave()), "%" + criteria.valor() + "%");
            } else {
                return criteriaBuilder.equal(root.get(criteria.chave()), criteria.valor());
            }
        }
        return null;
    }
}
