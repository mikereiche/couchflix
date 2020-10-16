package com.cb.fts.sample.service;

import com.cb.fts.sample.entities.vo.Result;

public interface MovieService {

    Result searchQuery(String query, String genres);

}
