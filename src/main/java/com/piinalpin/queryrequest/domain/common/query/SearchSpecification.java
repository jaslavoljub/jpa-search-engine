package com.piinalpin.queryrequest.domain.common.query;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
public class SearchSpecification<T> implements Specification<T> {

    private final SearchRequest searchRequest;

    public SearchSpecification(SearchRequest searchRequest) {
        this.searchRequest = searchRequest;
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        // Apply filters
        Predicate filterPredicate = getFilterPredicate(root, cb);
        if (filterPredicate != null) {
            query.where(filterPredicate);
        }

        // Apply sorts
        getSortOrders(root, cb).forEach(query::orderBy);

        return query.getRestriction();
    }

    private Predicate getFilterPredicate(Root<T> root, CriteriaBuilder cb) {
        if (searchRequest.getFilters().isEmpty()) {
            return null;
        }

        Predicate[] predicates = searchRequest.getFilters().stream()
                .map(filter -> buildPredicate(filter, root, cb))
                .filter(Objects::nonNull)
                .toArray(Predicate[]::new);

        return cb.and(predicates);
    }

    private Predicate buildPredicate(FilterRequest filter, Root<T> root, CriteriaBuilder cb) {
        Path<Object> path = getPath(root, filter.getKey());
        if (path == null) {
            return null;
        }

        Object value = parseValue(filter.getFieldType(), filter.getValue());
        Object valueTo = parseValue(filter.getFieldType(), filter.getValueTo());
        Object[] values = filter.getValues().stream()
                .map(v -> parseValue(filter.getFieldType(), v))
                .toArray();

        switch (filter.getOperator()) {
            case EQUAL:
                return cb.equal(path, value);
            case NOT_EQUAL:
                return cb.notEqual(path, value);
            case GREATER_THAN:
                if (path.getJavaType().isAssignableFrom(Integer.class)) {
                    return cb.greaterThan(path.as(Integer.class), Integer.parseInt(value.toString()));
                } else if (path.getJavaType().isAssignableFrom(Long.class)) {
                    return cb.greaterThan(path.as(Long.class), Long.parseLong(value.toString()));
                } else if (path.getJavaType().isAssignableFrom(Double.class)) {
                    return cb.greaterThan(path.as(Double.class), Double.valueOf(value.toString()));
                } else if (path.getJavaType().isAssignableFrom(LocalDate.class)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    return cb.greaterThan(path.as(LocalDate.class), LocalDate.parse(value.toString(),formatter));
                } else {
                    throw new UnsupportedOperationException("Unsupported field type for GT operator: " + path.getJavaType());
                }
            case GREATER_OR_EQUAL_TO:
                if (path.getJavaType().isAssignableFrom(Integer.class)) {
                    return cb.greaterThanOrEqualTo(path.as(Integer.class), Integer.parseInt(value.toString()));
                } else if (path.getJavaType().isAssignableFrom(Long.class)) {
                    return cb.greaterThanOrEqualTo(path.as(Long.class), Long.parseLong(value.toString()));
                } else if (path.getJavaType().isAssignableFrom(Double.class)) {
                    return cb.greaterThanOrEqualTo(path.as(Double.class), Double.valueOf(value.toString()));
                } else if (path.getJavaType().isAssignableFrom(LocalDate.class)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    return cb.greaterThanOrEqualTo(path.as(LocalDate.class), LocalDate.parse(value.toString(),formatter));
                } else {
                    throw new UnsupportedOperationException("Unsupported field type for GT operator: " + path.getJavaType());
                }
            case LESS_THAN:
                if (path.getJavaType().isAssignableFrom(Integer.class)) {
                    return cb.lessThan(path.as(Integer.class), Integer.parseInt(value.toString()));
                } else if (path.getJavaType().isAssignableFrom(Long.class)) {
                    return cb.lessThan(path.as(Long.class), Long.parseLong(value.toString()));
                } else if (path.getJavaType().isAssignableFrom(Double.class)) {
                    return cb.lessThan(path.as(Double.class), Double.valueOf(value.toString()));
                } else if (path.getJavaType().isAssignableFrom(LocalDate.class)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    return cb.lessThan(path.as(LocalDate.class), LocalDate.parse(value.toString(),formatter));
                } else {
                    throw new UnsupportedOperationException("Unsupported field type for GT operator: " + path.getJavaType());
                }
            case LESS_OR_EQUAL_TO:
                if (path.getJavaType().isAssignableFrom(Integer.class)) {
                    return cb.lessThanOrEqualTo(path.as(Integer.class), Integer.parseInt(value.toString()));
                } else if (path.getJavaType().isAssignableFrom(Long.class)) {
                    return cb.lessThanOrEqualTo(path.as(Long.class), Long.parseLong(value.toString()));
                } else if (path.getJavaType().isAssignableFrom(Double.class)) {
                    return cb.lessThanOrEqualTo(path.as(Double.class), Double.valueOf(value.toString()));
                } else if (path.getJavaType().isAssignableFrom(LocalDate.class)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    return cb.lessThanOrEqualTo(path.as(LocalDate.class), LocalDate.parse(value.toString(),formatter));
                } else {
                    throw new UnsupportedOperationException("Unsupported field type for GT operator: " + path.getJavaType());
                }
            case BETWEEN:
                if (path.getJavaType().isAssignableFrom(Integer.class)) {
                    return cb.between(path.as(Integer.class), Integer.parseInt(value.toString()), Integer.parseInt(valueTo.toString()));
                } else if (path.getJavaType().isAssignableFrom(Long.class)) {
                    return cb.between(path.as(Long.class), Long.parseLong(value.toString()), Long.parseLong(valueTo.toString()));
                } else if (path.getJavaType().isAssignableFrom(Double.class)) {
                    return cb.between(path.as(Double.class), Double.valueOf(value.toString()), Double.valueOf(valueTo.toString()));
                } else if (path.getJavaType().isAssignableFrom(LocalDate.class)) {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
                    return cb.between(path.as(LocalDate.class), LocalDate.parse(value.toString(),formatter), LocalDate.parse(valueTo.toString(),formatter));
                } else {
                    throw new UnsupportedOperationException("Unsupported field type for BETWEEN operator: " + path.getJavaType());
                }
            case IN:
                return path.in(values);
            case NOT_IN:
                return cb.not(path.in(values));
            case STARTS_WITH:
                return cb.like(cb.lower(path.as(String.class)), filter.getValue().toString().toLowerCase() + "%");
            case END_WITH:
                return cb.like(cb.lower(path.as(String.class)), "%" + filter.getValue().toString().toLowerCase());
            case LIKE:
                return cb.like(cb.lower(path.as(String.class)), "%" + filter.getValue().toString().toLowerCase() + "%");
            case NOT_LIKE:
                return cb.notLike(cb.lower(path.as(String.class)), "%" + filter.getValue().toString().toLowerCase() + "%");
            default:
                return null;
        }
    }

    private Path<Object> getPath(Root<T> root, String key) {
        if (key.contains(".")) {
            String[] parts = key.split("\\.");
            Join<Object, Object> join = root.join(parts[0], JoinType.LEFT);
            for (int i = 1; i < parts.length - 1; i++) {
                join = join.join(parts[i], JoinType.LEFT);
            }
            return join.get(parts[parts.length - 1]);
        } else {
            return root.get(key);
        }
    }

    private List<Order> getSortOrders(Root<T> root, CriteriaBuilder cb) {
        return searchRequest.getSorts().stream()
                .map(sort -> sort.getDirection().build(root, cb, sort))
                .collect(Collectors.toList());
    }

    private Object parseValue(FieldType fieldType, Object value) {
        if (value == null) {
            return null;
        }
        return fieldType.parse(value.toString());
    }

    public static Pageable getPageable(Integer page, Integer size) {
        return PageRequest.of(Objects.requireNonNullElse(page, 0), Objects.requireNonNullElse(size, 100));
    }

}
