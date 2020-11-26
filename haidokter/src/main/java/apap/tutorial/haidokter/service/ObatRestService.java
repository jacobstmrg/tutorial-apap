package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.model.ObatModel;
import apap.tutorial.haidokter.model.ResepModel;
import apap.tutorial.haidokter.rest.ResepDetail;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ObatRestService {
    ObatModel createObat(ObatModel obat);

    List<ObatModel> retrieveListObat();

    ObatModel getObatByIdObat(Long idObat);

    ObatModel changeObat(Long idObat, ObatModel obatUpdate);

    void deleteObat(Long idObat);

//    Mono<String> getStatus(Long noResp);
//
//    Mono<ResepDetail> postStatus();
}