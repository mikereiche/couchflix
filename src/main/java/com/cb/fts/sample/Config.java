package com.cb.fts.sample;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.core.convert.CouchbaseCustomConversions;
import org.springframework.data.couchbase.core.convert.MappingCouchbaseConverter;
import org.springframework.data.couchbase.core.mapping.CouchbaseMappingContext;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories
public class Config extends AbstractCouchbaseConfiguration {
	String bucketname = "movies";
	String username = "Administrator";
	String password = "password";
	String connectionString = "127.0.0.1";

	@Override public String getConnectionString() {
		return connectionString;
	}

	@Override public String getUserName() {
		return username;
	}

	@Override public String getPassword() {
		return password;
	}

	@Override public String getBucketName() {
		return bucketname;
	}

}
