package so.mwil.SBCMS.data

/**
 * Created by Matthew Wilson on 18/08/2018.
 * 3EN Cloud Ltd.
 */

interface SlideService {
    fun getAll(): Array<Slide>
    fun add(slide: Slide)
    fun update(slide: Slide)
    fun delete(slide: Slide)
}
