package apap.tutorial.haidokter.service;

import apap.tutorial.haidokter.repository.ResepDb;
import apap.tutorial.haidokter.rest.Setting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.transaction.Transactional;

@Service
@Transactional
public class APIRestServiceImpl implements APIRestService{
    private final WebClient webClient;

    public APIRestServiceImpl(WebClient.Builder webClientBuilder){
        this.webClient = webClientBuilder.baseUrl(Setting.hospitalUrl).build();
    }

    @Override
    public String getHospitalByState(String state) {
        return this.webClient.get().uri("?state=" + state).retrieve().bodyToMono(String.class).block();
    }
}