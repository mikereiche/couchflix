package com.cb.fts.sample.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Language {

    @Field("iso_639_1")
    private String IsoCode;
    private String name;
}
