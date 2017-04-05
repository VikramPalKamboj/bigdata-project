package protectedarea.bigdata.repository;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import protectedarea.bigdata.model.Protected;

@Repository
public class ProtectedSearchRepository {

	@Autowired
	MongoTemplate mongoTemplate;
	
	public Collection<Protected> searchProtected(String text) {
		return mongoTemplate.find(Query.query(new Criteria()
						.orOperator(Criteria.where("NAME").regex(text, "i"),
								    Criteria.where("ISO3").regex(text, "i"),
									Criteria.where("STATUS").regex(text, "i"), 
									Criteria.where("OWN_TYPE").regex(text, "i"),
									Criteria.where("DESIG_TYPE").regex(text, "i"),
									Criteria.where("GOV_TYPE").regex(text, "i"),
									Criteria.where("NO_TK_AREA").regex(text, "i"),
									Criteria.where("field29").regex(text, "i"),
									Criteria.where("field30").regex(text, "i"))
						), Protected.class);
	}
	
}
