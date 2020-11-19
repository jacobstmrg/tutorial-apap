package apap.tutorial.haidokter.restcontroller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ObatRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
public class ObatRestController {

    @Autowired
    private ObatRestService obatRestService;

    @PostMapping(value="/obat")
    private String createObat(@Valid @RequestBody ObatModel obat, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()){
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Request body has invalid type or missing field"
            );
        }
        else{
            obatRestService.createObat(obat);
            return "Add obat sucess!";
        }
    }

    @DeleteMapping(value="/obat/{idObat}")
    private String deleteObat(@PathVariable("idObat") Long idObat){
        try{
            obatRestService.deleteObat(idObat);
            return "Obat has been deleted!";
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Obat with id " + String.valueOf(idObat) + " not found!"
            );
        }
    }

    @GetMapping(value = "/obat/{idObat}")
    private ObatModel retrieveObat(@PathVariable(value = "idObat") Long idObat){
        try {
            return obatRestService.getObatByIdObat(idObat);
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Obat with id " + String.valueOf(idObat)+ " not found!"
            );
        }
    }

    @PutMapping(value = "/obat/{idObat}")
    private String updateObat(@PathVariable(value = "idObat") Long idObat, @RequestBody ObatModel obat){
        try {
            obatRestService.changeObat(idObat, obat);
            return "Update obat sucess!";
        } catch (NoSuchElementException e){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Obat with id " + String.valueOf(idObat) + " not found!"
            );
        }
    }

    @GetMapping(value = "/obat-all")
    private List<ObatModel> retrieveListObat() {
        return obatRestService.retrieveListObat();
    }
}