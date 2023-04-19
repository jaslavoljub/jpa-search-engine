package com.piinalpin.queryrequest.domain.common.query;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
public enum Operator {

    EQUAL ,
    NOT_EQUAL,
    GT,
    GTE,
    LT,
    LTE,
    LIKE,
    NOT_LIKE,
    IN ,
    NOT_IN ,
    BETWEEN;

    //public abstract <T> Predicate build(Root<T> root, CriteriaBuilder cb, FilterRequest request, Predicate predicate);

}
