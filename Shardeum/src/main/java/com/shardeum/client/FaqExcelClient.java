package com.shardeum.client;

import com.shardeum.dto.SearchByMessageResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class FaqExcelClient {

    private final RestTemplate restTemplate;

    public String getExcelData() {
        return restTemplate.getForObject("https://docs.google.com/spreadsheets/d/e/2PACX-1vQ5aKjJg_GttGdTFiCqq21qko" +
                "YWmE7CPwf2jjpT0wbxDokatkKFI1VpRx6WaERPyqCEJiGfTVisWX62/pub?gid=0&single=true&output=csv", String.class);
    }

    public SearchByMessageResponse getAnswerByText(String message){
        return restTemplate.getForObject("https://asia-south1-lively-marking-346111.cloudfunctions.net" +
                "/shardeumBotSearch?key=Mirv3IzakWBPT2Gs&q=" + message, SearchByMessageResponse.class);
    }
}
