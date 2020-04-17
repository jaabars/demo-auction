package kg.megacom.demoauction.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Date;

@ResponseStatus(code = HttpStatus.CONFLICT)
public class DateCheckLot extends RuntimeException {
public DateCheckLot(Date date){
    super("Аукцион закончился");
}
}
