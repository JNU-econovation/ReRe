package econovation.rere.domain.card;

import lombok.Data;

import java.util.Date;

@Data
public class Card {
    private final Long id;
    private final Long themeId;
    private final String content;
    private final String answer;
    private final Date createDate;
    private final Date updateDate;

}
