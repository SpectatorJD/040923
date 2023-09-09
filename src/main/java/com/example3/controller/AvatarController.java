package com.example3.controller;

import com.example3.model.Avatar;
import com.example3.service.AvatarService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collection;

@RestController
public class AvatarController {
    private final AvatarService avatarService;

    public AvatarController(AvatarService avatarService) {
        this.avatarService = avatarService;
    }
    @PostMapping(value = "/student/{studentId}/avatar", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Avatar uploadAvatar(@PathVariable("studentId") Long studentId, @RequestParam MultipartFile file) throws IOException{
        return avatarService.uploadAvatar(studentId, file);
    }
    @GetMapping("/avatar/{avatarId}/from-db")
    public ResponseEntity<byte[]> downloadFromDb (Long avatarId){
        Avatar avatar = avatarService.getAvatarById(avatarId);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.parseMediaType(avatar.getMediaType()));
        headers.setContentLength(avatar.getSize());
        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(avatar.getData());
    }
    @GetMapping("/avatar/{avatarId}/from-file")
    public void downloadFromFile (@PathVariable Long avatarId, HttpServletResponse response) throws IOException {
        Avatar avatar =  avatarService.getAvatarById(avatarId);
        Path avatarPath = Path.of(avatar.getPath());

        try  (
                InputStream is = Files.newInputStream(avatarPath);
                OutputStream os =   response.getOutputStream();

        ) {
            response.setStatus(HttpStatus.OK.value());
            response.setContentType(avatar.getMediaType());
            response.setContentLength(Math.toIntExact(avatar.getSize()));

            is.transferTo(os);
        }
    }
    @GetMapping(value = "/avatar", params = {"page", "size"})
    public Collection<Avatar> getAllAvatars (@RequestParam Integer page, @RequestParam Integer size){
        return avatarService.getAllAvatar(page, size);
    }
}
