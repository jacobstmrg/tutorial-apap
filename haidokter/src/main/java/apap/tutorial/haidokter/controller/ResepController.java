package apap.tutorial.haidokter.controller;

import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.service.ResepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ResepController {
    @Autowired
    private ResepService resepService;

    // routing url
    @RequestMapping("/resep/add")
    public String addResep(
            //request parameter yang ingin dibawa
            @RequestParam(value = "noResep", required = true) String noResep,
            @RequestParam(value = "namaDokter", required = true) String namaDokter,
            @RequestParam(value = "namaPasien", required = true) String namaPasien,
            @RequestParam(value = "catatan", required = true) String catatan,
            Model model

                ){
    // membuat objek ResepModel
        ResepModel resep = new ResepModel(noResep, namaDokter, namaPasien, catatan);

    // memanggil service addResep
        resepService.addResep(resep);

        model.addAttribute("nomorResep", noResep);

        return "add-resep";
    }
    @RequestMapping("/resep/viewall")
    public String listResep(Model model){
        List<ResepModel> listResep = resepService.getResepList();

        model.addAttribute("listResep", listResep);

        return "viewall-resep";
    }

    @RequestMapping("/resep/view")
    public String detailResep(
            @RequestParam(value = "noResep") String noResep,
            Model model){
        ResepModel resep = resepService.getResepByNomorResep(noResep);

        model.addAttribute("resep", resep);

        return "view-resep";
    }

    @RequestMapping("/resep/view/no-resep/{noResep}")
    public String detailResepDenganPathVariable(
        @PathVariable(value = "noResep") String noResep,
        Model model){
            ResepModel resep = resepService.getResepByNomorResep(noResep);
            model.addAttribute("resep", resep);
            return "view-resep";
    }

    @RequestMapping("/resep/update/no-resep/{noResep}/catatan/{catatan}")
    public String updateCatatan(
        @PathVariable(value = "noResep") String noResep,
        @PathVariable(value = "catatan") String catatan,
        Model model){
            ResepModel resep = resepService.getResepByNomorResep(noResep);
            resep.setCatatan(catatan);
            model.addAttribute("nomorResep", noResep);
            return "update-catatan";
    }

    @RequestMapping("/resep/delete/no-resep/{noResep}")
    public String deleteResep(
        @PathVariable(value = "noResep") String noResep,
        Model model){
            ResepModel resep = resepService.getResepByNomorResep(noResep);
            resepService.getResepList().remove(resep);
            model.addAttribute("nomorResep", noResep);
            return "delete-resep";
    }
}