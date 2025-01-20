package com.example.tutospring.service;

import com.example.tutospring.model.Stage;
import com.example.tutospring.repository.StageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StageServiceImpl implements StageService {

    @Autowired
    private StageRepository stageRepository;

    @Override
    public List<Stage> getAllStages() {
        return stageRepository.findAll();
    }

    @Override
    public void saveStage(Stage stage) {
        stageRepository.save(stage);
    }

    @Override
    public void deleteStage(Long id) {
        stageRepository.deleteById(id);
    }

    @Override
    public Stage getStageById(Long id) {
        Optional<Stage> stage = stageRepository.findById(id);
        return stage.orElse(null);
    }

    @Override
    public void updateStage(Long id, Stage stageDetails) {
        Stage stage = stageRepository.findById(id).orElseThrow();
        stage.setTitle(stageDetails.getTitle());
        stage.setDescription(stageDetails.getDescription());
        stage.setStartDate(stageDetails.getStartDate());
        stage.setEndDate(stageDetails.getEndDate());
        stage.setCompany(stageDetails.getCompany());
        stage.setStudent(stageDetails.getStudent());
        stageRepository.save(stage);
    }
}
