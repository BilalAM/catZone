package com.bilal.catZone.Seeders;

import com.bilal.catZone.models_embedded.CatImage;
import com.bilal.catZone.models_embedded.OwnerImage;
import com.bilal.catZone.repos.CatCharacteristicsRepository;
import com.bilal.catZone.repos.CatRepository;
import com.bilal.catZone.repos.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Seeder {

    @Autowired
    private OwnerBuilder ownerFactory;

    @Autowired
    private CatBuilder catBuilder;


    @Autowired
    private OwnerCatsBuilder ownerCatsBuilder;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private CatRepository catRepository;

    private void seedCatCharacteristicsData(CatCharacteristicsRepository repository) {

    }

    public void seedCatData() {
        CatImage bhoori = new CatImage("cat_pictures/bhoori.jpg");
        CatImage chico = new CatImage("cat_pictures/chico.jpg");
        CatImage fluffer = new CatImage("cat_pictures/fluffer.jpg");
        CatImage rina = new CatImage("cat_pictures/rina.jpg");
        CatImage vincelot = new CatImage("cat_pictures/vincelot.jpg");
        CatImage whiskers = new CatImage("cat_pictures/whiskers.jpg");
        CatImage william = new CatImage("cat_pictures/william.jpg");
        CatImage woofer = new CatImage("cat_pictures/woofer.jpg");
        CatImage bobo = new CatImage("cat_pictures/bobo.jpg");
        CatImage coco = new CatImage("cat_pictures/coco.jpg");
        CatImage lion = new CatImage("cat_pictures/lion.jpeg");
        CatImage roger = new CatImage("cat_pictures/roger.jpg");


        catBuilder.createCat("RINA", 10.5,rina)
                .createCat("WILLIAM", 10.5,william)
                .createCat("CHICO BABA", 50.7,chico)
                .createCat("BHOORI", 89.0,bhoori)
                .createCat("BOBO", 5.0,bobo)
                .createCat("WOFFER", 45.5,woofer)
                .createCat("VINCELOT", 16.6,vincelot)
                .createCat("COCO", 99.0,coco)
                .createCat("LION", 88.4,lion)
                .createCat("ROGER", 10.5,roger)
                .createCat("FLUFFER", 55.0,fluffer)
                .createCat("WHISKERS", 77.21,whiskers);
    }

    public void seedOwnerData() {

        OwnerImage bilalImage = new OwnerImage("owner_pictures/owner1.jpg");
        OwnerImage owner2Image = new OwnerImage("owner_pictures/owner2.jpg");
        OwnerImage owner3Image = new OwnerImage("owner_pictures/owner3.jpg");
        OwnerImage owner4Image = new OwnerImage("owner_pictures/owner4.jpg");
        OwnerImage owner5Image = new OwnerImage("owner_pictures/owner5.jpg");
        OwnerImage owner6Image = new OwnerImage("owner_pictures/owner6.jpg");
        OwnerImage owner7Image = new OwnerImage("owner_pictures/owner7.jpg");

        ownerFactory.ownerCreator("BILAL",bilalImage).ownerCreator("IBRAHIM",owner2Image).ownerCreator("SAIF",owner3Image).ownerCreator("RAJAA",owner4Image).ownerCreator("FATIMA",owner5Image)
                .ownerCreator("HUDA",owner6Image).ownerCreator("ALI",owner7Image);
    }

    public void seedOwnerCatsData() {
        ownerCatsBuilder
                .builderOwnerCats(ownerRepository.findByOwnerName("BILAL"), catRepository.findByCatName("BHOORI"), catRepository.findByCatName("BOBO"), catRepository.findByCatName("COCO"))
                .builderOwnerCats(ownerRepository.findByOwnerName("RAJAA"), catRepository.findByCatName("WOFFER"), catRepository.findByCatName("VINCELOT"))
                .builderOwnerCats(ownerRepository.findByOwnerName("ALI"), catRepository.findByCatName("ROGER"))
                .builderOwnerCats(ownerRepository.findByOwnerName("IBRAHIM"), catRepository.findByCatName("FLUFFER"))
                .builderOwnerCats(ownerRepository.findByOwnerName("FATIMA"), catRepository.findByCatName("LION"), catRepository.findByCatName("WHISKERS"))
                .builderOwnerCats(ownerRepository.findByOwnerName("SAIF"), catRepository.findByCatName("WILLIAM"))
                .builderOwnerCats(ownerRepository.findByOwnerName("HUDA"), catRepository.findByCatName("RINA"))
        ;
    }
}
