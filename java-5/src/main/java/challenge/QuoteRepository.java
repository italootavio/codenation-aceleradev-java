package challenge;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface QuoteRepository extends CrudRepository<Quote,Long> {

    @Query(value = "select scr.id, scr.actor, scr.detail from scripts scr order by RAND() limit 1", nativeQuery = true)
    Quote findRandomQuote();

    @Query(value = "select scr.id, scr.actor,scr.detail from scripts scr where scr.actor = :actor order by RAND() limit 1", nativeQuery = true)
    Quote findRandomQuotebyActor(@Param("actor") String actor);
}
