package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;

import java.util.List;

public interface ObatService{
    void addObat(ObatModel obat);

    void deleteObat(ObatModel obat);

    ObatModel getObatById(Long id);

    ObatModel updateObat(ObatModel obatModel);
}