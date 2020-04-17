package kg.megacom.demoauction.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class LotExistException extends RuntimeException {
    public LotExistException(String name){
        super("Lot с названием " + name + " cуществует");
    }
}
