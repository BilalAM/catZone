package com.bilal.catZone.services;


import com.bilal.catZone.models.Cat;
import com.bilal.catZone.models.Role;
import com.bilal.catZone.repos.CatRepository;
import com.bilal.catZone.models.Owner;
import com.bilal.catZone.repos.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class OwnerService implements UserDetailsService {

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CatRepository catRepository;


    public void addOwner(Owner owner) {
        ownerRepository.save(owner);
    }

    public void addAllOwners(Iterable<Owner> owners) {
        ownerRepository.saveAll(owners);
    }

    public void deleteOwner(int id) {
        ownerRepository.deleteById(id);
    }

    public List<Owner> getAllOwners() {
        return ownerRepository.findAll();

    }

    public Owner getOwner(int id) {
        return ownerRepository.findById(id).get();
    }

    public Owner updateOwner(Owner newOwner) {
        return ownerRepository.save(newOwner);
    }

    public List<Cat> getAllCatsOf(String ownerName) {
        return ownerRepository.findByOwnerName(ownerName).getCats();
    }

    public Owner getByOwnerEmail(String email) {
        return ownerRepository.findByOwnerEmail(email);
    }

    // increase the furDensity of all the cats belonging to those owners that have names starting with * and persist that furDensity
    // a "possible" business logic


    public void increaseFurDensity() {
        for (Owner owner : ownerRepository.findByOwnerNameContainingIgnoreCase("A")) {
            for (Cat cat : owner.getCats()) {
                double newFurdensity = ((20.0 / 100.0) * cat.getFurDensity()) + cat.getFurDensity();
                cat.setFurDensity(newFurdensity);
                catRepository.save(cat);
            }
        }

    }

    @Transactional
    public void deleteOwnerCat(String catName) {
        Owner owner = ownerRepository.findByCatsCatName(catName);
        owner.getCats().remove(catRepository.findByCatName(catName));
        ownerRepository.save(owner);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Owner anOwner = getByOwnerEmail(username);
        if (anOwner == null) {
            throw new UsernameNotFoundException(username);
        } else {
            Role role = anOwner.getRole();
            return new OwnerDetailsImpl(anOwner,role);
        }
    }


}

