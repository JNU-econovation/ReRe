package econovation.rere.domain.card;

import lombok.Data;

import java.util.Date;

@Data
public class Theme {
    private final Long id;
    private final Long cardbookId;
    private final String themeName;
    private final Date createDate;
    private final Date updateDate;

}
