package com.example.tutospring.service;

import com.example.tutospring.model.Stage;

import java.util.List;

public interface StageService {
    List<Stage> getAllStages();
    void saveStage(Stage stage);
    void deleteStage(Long id);
    Stage getStageById(Long id);
    void updateStage(Long id, Stage stage);
}
