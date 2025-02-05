package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ObatService;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ObatController {
    @Qualifier("resepServiceImpl")
    @Autowired
    ResepService resepService;

    @Autowired
    ObatService obatService;

    @GetMapping("/obat/add/{noResep}")
    private String addResepFormPage(
            @PathVariable Long noResep,
            Model model
    ){
        ObatModel obat = new ObatModel();
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        obat.setResepModel(resep);
        model.addAttribute("obat", obat);

        return "form-add-obat";
    }
    @GetMapping({"/obat/add-multiple/{noResep}"})
    private String addMultipleObatFormPage(@PathVariable Long noResep, Model model) {
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        ArrayList<ObatModel> temp_obat = new ArrayList<ObatModel>();
        temp_obat.add(new ObatModel());
        resep.setListObat(temp_obat);
        model.addAttribute("resep", resep);
        return "form-add-multiple-obat";
    }

    @PostMapping(value = "/obat/add-multiple", params = {"save"})
    private String submitMultipleObat(@ModelAttribute ResepModel resep, Model model) {
        for (ObatModel obat : resep.getListObat()) {
            obat.setResepModel(resep);
            obatService.addObat(obat);
        }
        int jumlah = resep.getListObat().size();
        model.addAttribute("jumlah", jumlah);
        model.addAttribute("noResep", resep.getNoResep());

        return "add-multiple-obat";
    }

    @PostMapping(value="/obat/add-multiple", params = {"addrow"})
    private String addRowMultipleObat(@ModelAttribute ResepModel resep, Model model){
        if(resep.getListObat() == null || resep.getListObat().size() == 0){
            resep.setListObat(new ArrayList<ObatModel>());
        }
        resep.getListObat().add(new ObatModel());
        model.addAttribute("resep", resep);
        return "form-add-multiple-obat";
    }

    @PostMapping(value = "/obat/add-multiple", params = {"deleterow"})
    private String deleteRowMultipleObat(
            @ModelAttribute ResepModel resep,
            final HttpServletRequest req,
            Model model) {
        int rowId = Integer.valueOf(req.getParameter("deleterow"));
        resep.getListObat().remove(rowId);
        model.addAttribute("resep", resep);
        return "form-add-multiple-obat";
    }


    @PostMapping("/obat/add")
    private String addObatSubmit(
            @ModelAttribute ObatModel obat,
            Model model
    ){
        obatService.addObat(obat);
        model.addAttribute("id", obat.getId());

        return "add-obat";
    }

//    @GetMapping("/obat/delete/{id}")
//    private String deleteObat(
//            @PathVariable Long id,
//            Model model
//    ){
//        ObatModel obat = obatService.getObatById(id);
//        obatService.deleteObat(obat);
//
//        model.addAttribute("id", obat.getId());
//
//        return "delete-obat";
//    }

    @PostMapping(value="/obat/delete")
    public String deleteMenuFormSubmit(@ModelAttribute ResepModel resep, Model model){
        model.addAttribute("obatCount", resep.getListObat().size());
        for(ObatModel obat : resep.getListObat()){
            obatService.deleteObatById(obat.getId());
        }
        return "delete-obat";
    }

    @GetMapping("obat/change/{id}")
    private String changeObatFormPage(
            @PathVariable Long id,
            Model model
    ){
        ObatModel obat = obatService.getObatById(id);
        model.addAttribute("obat", obat);

        return "form-update-obat";
    }

    @PostMapping("/obat/change")
    private String changeObatFormSubmit(
            @ModelAttribute ObatModel obat,
            Model model){
        ObatModel updatedObat = obatService.updateObat(obat);
        model.addAttribute("id", updatedObat.getId());

        return "update-obat";
    }
}