package com.casestudymodule4.service.hometype;

import com.casestudymodule4.model.home.type.HomeType;
import com.casestudymodule4.service.IGeneralService;

import java.util.Optional;

public interface IHomeTypeService extends IGeneralService<HomeType> {
    HomeType findByName(HomeType.TypeName homeType);
}
