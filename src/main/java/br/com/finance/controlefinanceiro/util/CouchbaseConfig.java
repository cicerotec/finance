package br.com.finance.controlefinanceiro.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.couchbase.config.AbstractCouchbaseConfiguration;
import org.springframework.data.couchbase.repository.config.EnableCouchbaseRepositories;

@Configuration
@EnableCouchbaseRepositories
public class CouchbaseConfig extends AbstractCouchbaseConfiguration {

    @Autowired
    private StorageUtil storageUtil;

    @Override
    public String getConnectionString() {
        return storageUtil.getHost();
    }

    @Override
    public String getUserName() {
        return storageUtil.getUsername();
    }

    @Override
    public String getPassword() {
        return storageUtil.getPassword();
    }

    @Override
    public String getBucketName() {
        return storageUtil.getBucket();
    }
}
