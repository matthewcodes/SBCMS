package so.mwil.SBCMS.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;
import so.mwil.SBCMS.model.Slide;

public interface SlideRepository extends ReactiveMongoRepository<Slide, Integer> {
    Mono<Slide> findById(String id);
}
