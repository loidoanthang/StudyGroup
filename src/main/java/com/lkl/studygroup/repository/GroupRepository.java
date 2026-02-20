package com.lkl.studygroup.repository;

import com.lkl.studygroup.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

public interface GroupRepository extends JpaRepository<Group, UUID>, GroupRepositoryCustom {
    Group findGroupById(UUID id);

    boolean isGroupNameExist(String groupName);

    java.util.List<Group> findAllByIsPublicTrue();

    @Modifying
    @Transactional
    @Query("DELETE FROM Group g WHERE g.createdBy = :createdBy")
    void deleteByCreatedBy(@Param("createdBy") UUID createdBy);
}
