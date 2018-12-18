package com.resonator.server.ambd.ambdservice.controllers;

import com.google.gson.Gson;
import com.google.gson.internal.LinkedTreeMap;
import com.google.gson.reflect.TypeToken;
import com.resonator.server.ambd.ambdservice.dao.entities.*;
import com.resonator.server.ambd.ambdservice.dao.repositories.AmbdRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class AmbdController {
    private final AmbdRepository ambdRepository;

    AmbdController(AmbdRepository ambdRepository) {
        this.ambdRepository = ambdRepository;
    }

    @PostMapping("/save")
    public ResponseEntity<String> addAmbd(@RequestBody String jsonString) {
        Map<String, Object> retMap = new Gson().fromJson(
                jsonString, new TypeToken<HashMap<String, Object>>() {}.getType()
        );

        LinkedTreeMap<String, Object> metaEntityMap = (LinkedTreeMap<String, Object>) retMap.get("meta");
        LinkedTreeMap<String, Object> triggersMap = (LinkedTreeMap<String, Object>) retMap.get("triggers");
        LinkedTreeMap<String, Object> statesMap = (LinkedTreeMap<String, Object>) retMap.get("states");
        LinkedTreeMap<String, Object> transitionsMap = (LinkedTreeMap<String, Object>) retMap.get("transitions");
        LinkedTreeMap<String, Object> pipelinesMap = (LinkedTreeMap<String, Object>) retMap.get("pipeline");
        LinkedTreeMap<String, Object> streamMap = (LinkedTreeMap<String, Object>) retMap.get("stream");

        MetaEntity metaEntity = new MetaEntity(metaEntityMap.get("name").toString(),metaEntityMap.get("author").toString());
        ArrayList<TriggerEnum> triggers = new ArrayList<>();
        for (String key: triggersMap.keySet()){
            triggers.add(TriggerEnum.valueOf(triggersMap.get(key).toString().toUpperCase()));
        }

        ArrayList<String> states = new ArrayList<>();
        for (String key: statesMap.keySet()){
            states.add(statesMap.get(key).toString());
        }

        ArrayList<String> transitions = new ArrayList<>();
        for (String key: transitionsMap.keySet()){
            transitions.add(transitionsMap.get(key).toString());
        }

        List<PipelineEntity> pipelines = new ArrayList<>();
        for (String key: pipelinesMap.keySet()){
            transitions.add(pipelinesMap.get(key).toString());
        }

        List<StreamEntity> streams = new ArrayList<>();
        for (String key: streamMap.keySet()){
            transitions.add(streamMap.get(key).toString());
        }

        ambdRepository.save(new AmbdEntity(metaEntity,triggers,states,transitions,pipelines,streams));
        return ResponseEntity.ok(".ambd file data was saved!");
    }

    @PostMapping("/load")
    public ResponseEntity<Object> loadAmbd(@RequestParam("name") String name,@RequestParam("author") String author) {
        AmbdEntity ambdEntity = ambdRepository.findByNameAndAuthor(name,author);
        return ResponseEntity.ok(ambdEntity.toString());
    }

}
