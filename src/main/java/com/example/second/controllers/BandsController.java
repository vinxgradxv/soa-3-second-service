package com.example.second.controllers;

import com.example.second.clients.MainServerClientService;
import com.example.second.model.MusicBand;
import com.example.second.model.MusicGenre;
import com.example.second.model.Nomination;
import com.example.second.model.NominationResponse;
import com.example.second.services.NominationService;
import com.example.second.utils.StringToObjectUsingJackson;
import feign.FeignException;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.List;

@RestController()
@CrossOrigin("*")
public class BandsController {

    @Autowired
    private NominationService nominationService;

    @Autowired
    MainServerClientService client;

    @GetMapping(value = "/second/bands/get-by-genre/{genre}", produces = "application/xml")
    @SneakyThrows
    public List<MusicBand> getBandsByGenre(@PathVariable MusicGenre genre) {
        var responseFromMainService = client.get("/api/music-bands/all");
        var origBands = StringToObjectUsingJackson.convertStringToListOfObject(responseFromMainService);
        var res = new ArrayList<MusicBand>();
        for (var band : origBands) {
            if (band.getGenre().equals(genre)) {
                res.add(band);
            }
        }
        return res;
    }

    @PostMapping(value = "/second/band/{band-id}/nominate/{genre}", produces = "application/xml")
    public NominationResponse nominateBand(@PathVariable("band-id") Long bandId, @PathVariable("genre") MusicGenre genre) {

        try {
            var responseFromMainService = client.get("/api/music-bands/" + bandId);
        } catch (FeignException e) {
            return new NominationResponse("Не удалось найти данную группу: проверьте id или повторите позже");
        }
        nominationService.createNomination(Nomination.builder()
                        .bandId(bandId)
                        .genre(genre).build());
        return new NominationResponse("Группа успешно номинирована на премию");
    }
}
