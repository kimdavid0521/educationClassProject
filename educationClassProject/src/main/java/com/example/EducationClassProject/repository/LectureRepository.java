package com.example.EducationClassProject.repository;

import com.example.EducationClassProject.domain.Lecture;
import com.example.EducationClassProject.repository.customRepository.LectureRepositoryCustom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long>, LectureRepositoryCustom {

//    //특정 유저 id를 통해 클래스 조회하기 (단순성과 성능 최적화를 위해 매핑 엔티티에서 조회화기보단 class 엔티티에서 userId로 조회하였습니다.)
//    @Query("SELECT ul.aLecture FROM UserLecture ul WHERE ul.user.id = :userId")
//    Page<Lecture> findLecturesByUserId(UUID userId, Pageable pageable);

    // 자신이 생성한 강의만 조회
    Page<Lecture> findByOwnerId(UUID ownerId, Pageable pageable);

    // 강의 목록 전체 조회 페이지 네이션
    Page<Lecture> findAll(Pageable pageable);
}
