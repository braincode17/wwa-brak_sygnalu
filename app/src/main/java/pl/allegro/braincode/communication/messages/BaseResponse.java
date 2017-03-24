package pl.allegro.braincode.communication.messages;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BaseResponse {
    protected Boolean success;
    protected String message;
}
