package com.piinalpin.queryrequest.domain.common.query;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Operator {
    EQUAL,
    NOT_EQUAL,
    LIKE,
    NOT_LIKE,
    STARTS_WITH,
    END_WITH,
    IN,
    NOT_IN,
    GREATER_THAN,
    GREATER_OR_EQUAL_TO,
    LESS_THAN,
    LESS_OR_EQUAL_TO,
    BETWEEN;

    //public abstract <T> Predicate build(Root<T> root, CriteriaBuilder cb, FilterRequest request, Predicate predicate);

}
