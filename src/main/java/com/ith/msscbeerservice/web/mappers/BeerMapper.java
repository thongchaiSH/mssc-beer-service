package com.ith.msscbeerservice.web.mappers;

import com.ith.msscbeerservice.domain.Beer;
import com.ith.msscbeerservice.web.model.BeerDto;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class})
public interface BeerMapper {
    BeerDto beerToBeerDto(Beer beer);
    Beer beerDtoToBeer(BeerDto beerDto);
}
