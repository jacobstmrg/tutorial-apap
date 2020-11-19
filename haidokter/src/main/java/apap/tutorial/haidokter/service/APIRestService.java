package apap.tutorial.haidokter.service;

import reactor.core.publisher.Mono;

public interface APIRestService {
    public String getHospitalByState(String state);
}