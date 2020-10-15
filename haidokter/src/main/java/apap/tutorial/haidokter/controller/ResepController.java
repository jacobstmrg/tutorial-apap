package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ObatService;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import apap.tutorial.haidokter.service.ResepService;

import java.util.List;

@Controller
public class ResepController {

    @Qualifier("resepServiceImpl")
    @Autowired
    private ResepService resepService;

    @Autowired
    private ObatService obatService;

    @GetMapping("/")
    private String home(){
        return "home";
    }

    @GetMapping("/resep/add")
    public String addResepFormPage(Model model){
        model.addAttribute("resep", new ResepModel());

        return "form-add-resep";
    }

    @PostMapping("/resep/add")
    public String addResepSubmit(
            @ModelAttribute ResepModel resep,
            Model model
    ){
        resepService.addResep(resep);
        model.addAttribute("nomorResep", resep.getNoResep());

        return "add-resep";
    }

    @GetMapping("/resep/change/{noResep}")
    private String changeResepFormPage(
            @PathVariable Long noResep,
            Model model){
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        model.addAttribute("resep", resep);

        return "form-update-resep";
    }

    @PostMapping("/resep/change")
    private String changeResepFormSubmit(
            @ModelAttribute ResepModel resep,
            Model model){
        ResepModel updatedResep = resepService.updateResep(resep);
        model.addAttribute("resep", updatedResep.getNoResep());

        return "update-resep";
    }

    @GetMapping("/resep/view")
    public String viewDetailResep(
            @RequestParam(value = "noResep") Long noResep,
            Model model
    ){
            ResepModel resep = resepService.getResepByNomorResep(noResep);
            List<ObatModel> listObat = resep.getListObat();

            model.addAttribute("resep", resep);
            model.addAttribute("listObat", listObat);

            return "view-resep";
    }
    @GetMapping("/resep/viewall")
    public String viewAll(
            Model model) {
        //Mendapatkan semua ResepModel
        List<ResepModel> listResep = resepService.getResepList();

        // Add variabel semua ResepModel ke 'listResep' untuk dirender pada thymeleaf
        model.addAttribute("listResep", listResep);

        //  Return view template yang ingin digunakan
        return "viewall-resep";
    }
    @PostMapping("/error")
    public String error(
            Model model){
        return "error";
    }
    @GetMapping("resep/delete/{noResep}")
    private String deleteResep(
            @PathVariable Long noResep,
            Model model){
        ResepModel resep = resepService.getResepByNomorResep(noResep);
        model.addAttribute("nomorResep", resep.getNoResep());
        if(resep.getListObat().isEmpty()){
            resepService.deleteResep(resep);

            return "delete-resep";
        }
        else{
            return "error-delete-resep";
        }
    }
}