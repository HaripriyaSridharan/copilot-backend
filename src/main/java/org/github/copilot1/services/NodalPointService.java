package org.github.copilot1.services;

import java.util.List;
import org.github.copilot1.models.NodalPoint;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface NodalPointService {
    public void save(List<NodalPoint> nodalPoints);
    public List<NodalPoint> readFromLocal(String filePath);
    public List<String> getNodalPoints();
    public void loadNodes();
}
