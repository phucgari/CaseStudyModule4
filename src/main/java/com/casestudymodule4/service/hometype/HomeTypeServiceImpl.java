package com.casestudymodule4.service.hometype;

import com.casestudymodule4.model.home.type.HomeType;
import com.casestudymodule4.repository.home.IHomeTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HomeTypeServiceImpl implements IHomeTypeService {
    @Autowired
    private IHomeTypeRepository iHomeTypeRepository;

    @Override
    public Iterable<HomeType> findAll() {
        return iHomeTypeRepository.findAll();
    }

    @Override
    public Optional<HomeType> findById(Long id) {
        return iHomeTypeRepository.findById(id);
    }

    @Override
    public HomeType save(HomeType homeType) {
        return iHomeTypeRepository.save(homeType);
    }

    @Override
    public void remove(Long id) {
        iHomeTypeRepository.deleteById(id);
    }

    @Override
    public Optional<HomeType> findByName(String name) {
        switch (name) {
            case "villa":
                return iHomeTypeRepository.findByName(HomeType.TypeName.SingleRoom);
            case "apartment":
                return iHomeTypeRepository.findByName(HomeType.TypeName.DoubleRoom);
            case "motel":
                return iHomeTypeRepository.findByName(HomeType.TypeName.PresidentRoom);
                case "vip":
                return iHomeTypeRepository.findByName(HomeType.TypeName.VIPRoom);
            case "luxury":
                return iHomeTypeRepository.findByName(HomeType.TypeName.LuxuryRoom);
        }
        throw new RuntimeException("invalid hometype");
    }
}
