package com.casestudymodule4.service.home;

import com.casestudymodule4.model.home.Home;
import com.casestudymodule4.model.home.order.HomeDay;
import com.casestudymodule4.model.home.order.Status;
import com.casestudymodule4.repository.home.IHomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class HomeServiceImpl implements IHomeService {
    @Autowired
    private IHomeRepository iHomeRepository;
    private HomeSpecification specification=new HomeSpecification();

    @Override
    public Iterable<Home> findAll() {
        return this.iHomeRepository.findAll();
    }

    @Override
    public Optional<Home> findById(Long id) {
        return this.iHomeRepository.findById(id);
    }

    @Override
    public Home save(Home home) {
        return this.iHomeRepository.save(home);
    }

    @Override
    public void remove(Long id) {
        this.iHomeRepository.deleteById(id);
    }

    @Override
    public List<Home> complexSearch(
            Optional<Integer> minNumberOfBathroom,
            Optional<Integer> maxNumberOfBathroom,
            Optional<Integer> minNumberOfBedroom,
            Optional<Integer> maxNumberOfBedroom,
            Optional<String> address,
            Optional<Double> priceMin,
            Optional<Double> priceMax,
            Optional<LocalDate> minDate,
            Optional<LocalDate> maxDate) {

        int minBath=minNumberOfBathroom.orElse(0);
        int maxBath=maxNumberOfBathroom.orElse(100);
        int minBed=minNumberOfBedroom.orElse(0);
        int maxBed=minNumberOfBedroom.orElse(100);
        String add=address.orElse("");
        Double minPrice=priceMin.orElse((double) 0);
        Double maxPrice=priceMax.orElse((double)100000000000000000L);

        var byBathroomNumber=specification.homeWithNumberOfBathroomBetween(minBath,maxBath);
        var byBedNumber=specification.homeWithNumberOfBedroomBetween(minBed,maxBed);
        var byAdd=specification.homeWithAddressLike(add);
        var byPrice=specification.homeWithPriceBetween(minPrice,maxPrice);

        List<Home> homes= iHomeRepository.findAll(byBathroomNumber.and(byBedNumber.and(byAdd.and(byPrice))));
        if(minDate.isEmpty()&&maxDate.isEmpty())return homes;
        List<Home> result=new ArrayList<>();
        IterateHome:for (Home home :
                homes) {
            Set<HomeDay> set=home.getOrderDay();
            for(HomeDay homeDay:set){
                if(minDate.isPresent()&&homeDay.getDay().isBefore(minDate.get()))continue IterateHome;
                else if(maxDate.isPresent()&&homeDay.getDay().isAfter(maxDate.get()))continue IterateHome;
                else if(homeDay.getStatus().getName()== Status.StatusType.FREE)continue IterateHome;
            }
            result.add(home);
        }
        return result;
    }
}
