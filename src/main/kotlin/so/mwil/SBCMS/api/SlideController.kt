package so.mwil.SBCMS.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import so.mwil.SBCMS.data.Slide
import so.mwil.SBCMS.data.SlideService

@RestController
class SlideController() {

    @Autowired
    lateinit var slideService: SlideService


    @GetMapping("/slides")
    fun getSlides() = slideService.getAll()


    @PostMapping("/slides")
    fun addSlide(@RequestBody slide: Slide) = slideService.add(slide)


    @PutMapping("/slides")
    fun updateSlide(@RequestBody slide: Slide) = slideService.update(slide)


    @DeleteMapping("/slides")
    fun deleteSlide(@RequestBody slide: Slide) = slideService.delete(slide)
}