package com.example.EducationClassProject.service.serviceImpl;

import com.example.EducationClassProject.converter.UserConverter;
import com.example.EducationClassProject.domain.User;
import com.example.EducationClassProject.dto.userDTO.UserRequestDTO;
import com.example.EducationClassProject.dto.userDTO.UserResponseDTO;
import com.example.EducationClassProject.repository.UserRepository;
import com.example.EducationClassProject.service.UserCommandService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    // 유저 회원가입
    @Override
    @Transactional
    public UserResponseDTO.JoinResultDTO joinUser(UserRequestDTO.JoinDTO joinDTO) {
        User user = UserConverter.toUser(joinDTO, passwordEncoder);
        userRepository.save(user);
        user.updateUserPoint(500); // 회원가입시 500 포인트 증정
        return new UserResponseDTO.JoinResultDTO(user.getId(), user.getCreateAt());
    }
}
