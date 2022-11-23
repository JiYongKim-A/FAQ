package FAQ.faqcenter.config.session;

import lombok.*;

@AllArgsConstructor
@Data @Getter @Setter
public class SessionForm {

    private String loginId;

    private String nickname;

}
