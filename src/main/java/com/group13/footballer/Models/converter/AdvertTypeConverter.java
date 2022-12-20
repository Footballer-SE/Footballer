package com.group13.footballer.Models.converter;

import com.group13.footballer.Models.AdvertType;
import com.group13.footballer.core.Exceptions.Constant.Constant;
import com.group13.footballer.core.Exceptions.WrongAdvertTypeException;
import org.springframework.stereotype.Component;

@Component
public class AdvertTypeConverter {

    public AdvertType convert(String advert){

        if (advert.equalsIgnoreCase("TEAM")){
            return AdvertType.TEAM;
        } else if (advert.equalsIgnoreCase("PLAYER")) {
            return AdvertType.PLAYER;
        } else if (advert.equalsIgnoreCase("OPPONENT")) {
            return AdvertType.OPPONENT;
        }else {
            throw new WrongAdvertTypeException(Constant.WRONG_ADVERT_TYPE);
        }
    }
}
