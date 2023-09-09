package com.example3.service;

import com.example3.model.Avatar;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Collection;

public interface AvatarService {
    Avatar uploadAvatar(Long studentId, MultipartFile file) throws IOException;
    Avatar getAvatarById(Long avatarId);
    Collection<Avatar>  getAllAvatar(Integer page, Integer size);
}