package es.cresdev.apps.microservices.repository;

import es.cresdev.apps.microservices.model.user.User;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends ElasticsearchRepository<User, String> {

    User findByEmail(String email);

}
