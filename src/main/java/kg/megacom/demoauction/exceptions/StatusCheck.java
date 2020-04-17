package kg.megacom.demoauction.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.PAYMENT_REQUIRED)
public class StatusCheck extends RuntimeException{
    public StatusCheck(String message){
        super("Status is " + message);

    }
}
