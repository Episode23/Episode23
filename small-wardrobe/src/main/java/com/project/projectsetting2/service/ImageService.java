package com.project.projectsetting2.service;

import com.project.projectsetting2.entity.Image;
import com.project.projectsetting2.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class ImageService {

    private final ImageRepository imageRepository;

    private final String path = "image" + File.separator;

    private final String absolutePath = new File("./image").getAbsolutePath() + File.separator;

    public List<Image> saveImages(MultipartFile[] multipartFiles) throws IOException {
        List<Image> images = new ArrayList<>();

        if (multipartFiles != null) {
            File file = new File(path);

            if (!file.exists()) {
                if (!file.mkdir()) {
                    log.info("file was not successful");
                }
            }

            for (MultipartFile multipartFile : multipartFiles) {
                log.info("fileName: {}", multipartFile.getOriginalFilename());

                String fileExtension;
                String contentType = multipartFile.getContentType();

                if (ObjectUtils.isEmpty(contentType)) {
                    break;
                } else {
                    if(contentType.contains("image/jpeg")) {
                        fileExtension = ".jpg";
                    } else if(contentType.contains("image/png")) {
                        fileExtension = ".png";
                    } else {
                        break;
                    }
                }

                String fileSaveName = UUID.randomUUID() + "_" + multipartFile.getOriginalFilename() + fileExtension;
                Image image = Image.builder()
                        .name(fileSaveName)
                        .link("http://localhost:8080/" + path + fileSaveName + File.separator)
//                        .link("http://localhost:8080/" + path + fileSaveName + File.separator)
                        .build();

                images.add(image);
                imageRepository.save(image);

                file = new File(absolutePath + File.separator + fileSaveName);

                multipartFile.transferTo(file);
            }
        } else {
            log.info("MultipartFiles Not Found");
        }

        return images;
    }

}
