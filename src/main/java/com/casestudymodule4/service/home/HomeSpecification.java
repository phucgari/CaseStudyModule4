package com.casestudymodule4.service.home;

import com.casestudymodule4.model.home.Home;
import org.springframework.data.jpa.domain.Specification;

public class HomeSpecification {
    public Specification<Home> homeWithNumberOfBathroomBetween(int minNumberOfBathroom, int maxNumberOfBathroom){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("numberOfBathroom"),minNumberOfBathroom,maxNumberOfBathroom));
    }
    public Specification<Home> homeWithNumberOfBedroomBetween(int minNumberOfBedroom,int maxNumberOfBedroom){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("numberOfBedroom"),minNumberOfBedroom,maxNumberOfBedroom));
    }
    public Specification<Home> homeWithAddressLike(String address){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("address"),"%"+address+"%"));
    }
    public Specification<Home> homeWithPriceBetween(Double minPrice,Double maxPrice){
        return ((root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("price"),minPrice,maxPrice));
    }
}
