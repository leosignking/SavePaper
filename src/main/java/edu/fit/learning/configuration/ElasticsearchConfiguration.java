package edu.fit.learning.configuration;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.common.transport.TransportAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

import javax.annotation.Resource;

/**
 * Created by virus on 03/14/16.
 */

@Configuration
@EnableElasticsearchRepositories(basePackages = "edu.fit.learning.repository")
public class ElasticsearchConfiguration {

    @Bean
    public Client client() {
        Settings settings = ImmutableSettings.settingsBuilder()
                .loadFromClasspath("elasticsearch.yml")
                .replacePropertyPlaceholders().build();

        TransportClient client = new TransportClient(settings);
        TransportAddress address = new InetSocketTransportAddress("localhost", 9300);
        client.addTransportAddress(address);
        return client;
    }

    @Bean
    public ElasticsearchOperations elasticsearchTemplate() {
        return new ElasticsearchTemplate(client());
    }

}
