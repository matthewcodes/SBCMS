package so.mwil.SBCMS.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Slide {

    @Id
    private String id;

    private String slideType;
    private String title;
    private String subtitle;
    private String url;
    private String imageUrl;
    private boolean internalLink;
}
