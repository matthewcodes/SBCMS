package so.mwil.SBCMS.controller;

import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import so.mwil.SBCMS.model.Slide;
import so.mwil.SBCMS.repository.SlideRepository;

@RestController
@RequestMapping("/api")
public class SlideController {

    private final SlideRepository slideRepository;

    public SlideController(SlideRepository slideRepository) {
        this.slideRepository = slideRepository;
    }

    @GetMapping("/slide")
    public Flux<Slide> getAllSlides() {
        return this.slideRepository.findAll();
    }

    @PostMapping("/slide")
    public Mono<Slide> createSlide(@RequestBody Slide slide) {
        return this.slideRepository.insert(slide);
    }

    @PutMapping("/slide/{id}")
    public Mono<Slide> updateSlide(@RequestBody Slide slide, @RequestParam("id") String id) {

        Mono<Slide> existingSlideMono = this.slideRepository.findById(id);

        return existingSlideMono.flatMap(existingSlide -> {
           existingSlide.setImageUrl(slide.getImageUrl());
           existingSlide.setInternalLink(slide.isInternalLink());
           existingSlide.setSlideType(slide.getSlideType());
           existingSlide.setSubtitle(slide.getSubtitle());
           existingSlide.setTitle(slide.getTitle());
           existingSlide.setUrl(slide.getUrl());

           return this.slideRepository.save(existingSlide);
        });

    }

    @DeleteMapping("/slide/{id}")
    public Mono<Void> deleteSlide(@RequestParam("id") String id) {
        Mono<Slide> existingSlideMono = this.slideRepository.findById(id);
        return existingSlideMono.flatMap(this.slideRepository::delete);
    }

}
