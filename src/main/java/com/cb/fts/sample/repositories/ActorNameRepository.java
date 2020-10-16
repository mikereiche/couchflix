package com.cb.fts.sample.repositories;


import com.cb.fts.sample.entities.ActorName;
import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.repository.PagingAndSortingRepository;

@N1qlPrimaryIndexed
public interface ActorNameRepository extends PagingAndSortingRepository<ActorName, String> {
}
