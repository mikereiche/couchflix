package com.cb.fts.sample.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.couchbase.core.mapping.Field;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country {

    @Field("iso_3166_1")
    private String IsoCode;
    private String name;
}
