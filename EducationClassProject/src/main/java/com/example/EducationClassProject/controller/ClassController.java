package com.example.EducationClassProject.controller;

import com.example.EducationClassProject.apiPayload.BaseResponse;
import com.example.EducationClassProject.converter.ClassConverter;
import com.example.EducationClassProject.domain.Class;
import com.example.EducationClassProject.dto.classDTO.ClassRequestDTO;
import com.example.EducationClassProject.dto.classDTO.ClassResponseDTO;
import com.example.EducationClassProject.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
public class ClassController {

    private final ClassService classService;

    // class 생성
    @PostMapping("/api/v1/class/{userId}") // 추후에 jwt 적용시 수정 필요
    public BaseResponse<ClassResponseDTO.CreateClassResultDTO> createClass(@PathVariable UUID userId, @RequestBody ClassRequestDTO.CreateClassDTO createClassDTO) {
        Class classEntity = classService.createClass(createClassDTO, userId);
        return BaseResponse.onSuccess(ClassConverter.createClassResultDTO(classEntity));
    }

    // 유저 id로 class 찾기
    @GetMapping("/api/v1/class/{userId}")
    public BaseResponse<ClassResponseDTO.PreviewClassListResultDTO> findClassesByUser(@PathVariable UUID userId) {
        List<Class> classes = classService.findClassesByUserId(userId);
        return BaseResponse.onSuccess(ClassConverter.toPreviewClassList(classes));
    }

    // class 전체 조회
    @GetMapping("/api/v1/classes")
    public BaseResponse<ClassResponseDTO.PreviewClassListResultDTO> findAllClasses() {
        List<Class> classList = classService.findAllClasses();
        return BaseResponse.onSuccess(ClassConverter.toPreviewClassList(classList));
    }


}
