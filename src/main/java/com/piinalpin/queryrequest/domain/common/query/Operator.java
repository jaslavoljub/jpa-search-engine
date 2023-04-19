package com.piinalpin.queryrequest.domain.common.query;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum Operator {
    EQUAL ,
    NOT_EQUAL,
    GT,
    GTE,
    LT,
    LTE,
    LIKE,
    BEGIN_WITH,
    END_WITH,
    NOT_LIKE,
    IN ,
    NOT_IN ,
    BETWEEN;

    //public abstract <T> Predicate build(Root<T> root, CriteriaBuilder cb, FilterRequest request, Predicate predicate);

}
