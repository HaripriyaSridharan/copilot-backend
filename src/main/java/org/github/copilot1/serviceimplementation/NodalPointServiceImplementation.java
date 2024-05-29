package org.github.copilot1.serviceimplementation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.github.copilot1.models.NodalPoint;
import org.github.copilot1.repo.NodalPointRepository;
import org.github.copilot1.services.NodalPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NodalPointServiceImplementation implements NodalPointService {

    @Autowired
    private NodalPointRepository nodalPointRepository;
    public void loadNodes(){
        List<NodalPoint> nodalPoints = readFromLocal("src/main/resources/nodes.csv");
        save(nodalPoints);
    }

    public void save(List<NodalPoint> nodalPoints) {
        try {
            nodalPointRepository.saveAll(nodalPoints);
        } catch (Exception ex) {
            throw new RuntimeException("Failed to store CSV data: " + ex.getMessage());
        }
    }

    public List<NodalPoint> readFromLocal(String filePath) {
        List<NodalPoint> nodalPoints = new ArrayList<>();
        String line = "";
        String csvSplitBy = ",";

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] data = line.split(csvSplitBy);
                NodalPoint nodalPoint = new NodalPoint();
                nodalPoint.setNode(data[0]);
                nodalPoint.setDistance(Double.parseDouble(data[1]));
                nodalPoints.add(nodalPoint);
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to read CSV data: " + e.getMessage());
        }

        return nodalPoints;
    }
    public List<String> getNodalPoints() {
        return nodalPointRepository.findAll().stream()
                .map(NodalPoint::getNode)
                .collect(Collectors.toList());
    }
}

