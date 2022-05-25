package br.com.finance.controlefinanceiro.repository.nativequery;

import br.com.finance.controlefinanceiro.core.document.ControleFinanceiro;
import br.com.finance.controlefinanceiro.util.HttpLoggingFilter;
import com.couchbase.client.java.Cluster;
import com.couchbase.client.java.query.QueryResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.couchbase.core.CouchbaseOperations;
import org.springframework.data.couchbase.repository.config.RepositoryOperationsMapping;

import java.util.List;

import static br.com.finance.controlefinanceiro.util.Constants.ALIAS_CONTROLE_FINANCEIRO_COMMONS;

public class ControleFinanceiroRepositoryNQCustomImpl implements ControleFinanceiroRepositoryNQCustom, InitializingBean {

    private static final Logger log = LoggerFactory.getLogger(ControleFinanceiroRepositoryNQCustomImpl.class);

    @Autowired
    private RepositoryOperationsMapping templateProvider;
    private CouchbaseOperations template;

    @Override
    public List<ControleFinanceiro> findControleFinanceiroByStatements(String statements) {
        Cluster cluster = template.getCouchbaseClientFactory().getCluster();

        QueryResult query = cluster
                .query("SELECT " + ALIAS_CONTROLE_FINANCEIRO_COMMONS + " FROM `financas`.gastos.testes " + statements );
        log.info("SELECT " + ALIAS_CONTROLE_FINANCEIRO_COMMONS + " FROM `financas`.gastos.testes " + statements);
        return query.rowsAs(ControleFinanceiro.class);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        template = templateProvider.resolve(ControleFinanceiroRepositoryNQ.class, ControleFinanceiro.class);
    }
}
