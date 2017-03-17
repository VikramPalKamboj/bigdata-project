package protectedarea.bigdata.repository;

import org.springframework.data.repository.CrudRepository;

import protectedarea.bigdata.model.Protected;

public interface ProtectedMongoRepository extends CrudRepository<Protected, String>{}