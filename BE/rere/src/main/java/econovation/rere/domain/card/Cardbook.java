package econovation.rere.domain.card;

import lombok.Data;

import java.util.Date;

@Data
public class Cardbook {
    private final Long id;
    private final String cardbookName;
    private final String writer;
    private final Date createDate;
    private final Date updateDate;
    private final int scrapCnt;
    private final String filePath;

}
