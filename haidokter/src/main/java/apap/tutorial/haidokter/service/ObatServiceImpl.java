package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.repository.ObatDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ObatServiceImpl implements ObatService {
    @Autowired
    ObatDb obatDb;

    @Override
    public void addObat(ObatModel obat){
        obatDb.save(obat);
    }

    @Override
    public void deleteObat(ObatModel obat){
        obatDb.delete(obat);
    }

    @Override
    public ObatModel getObatById(Long id){
        return obatDb.findById(id).get();
    }

    @Override
    public ObatModel updateObat(ObatModel obatModel){
        obatDb.save(obatModel);

        return obatModel;
    }
    @Override
    public List<ObatModel> getObatByNamaDanBentuk(String nama, Integer bentuk) {
        return obatDb.findObatByNamaDanBentuk(nama, bentuk);
    }
}