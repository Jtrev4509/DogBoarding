package controller;

import dao.DogDao;
import model.Dog;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class DogController {
    private DogDao dogDao;

    public DogController(DogDao dogDao) {
        this.dogDao = dogDao;
    }

//    @RequestMapping(path = "/dog", method = RequestMethod.GET)
//    List<Dog> listAllDogs(Dog dog){
//        
//    }
}
