package com.lkl.studygroup.dto.response;

import com.lkl.studygroup.model.enums.GroupRole;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;
@Getter
@Setter
public class GetListGroupResponse {
    UUID groupId;
    String groupName;
    GroupRole groupRole;
    public GetListGroupResponse(UUID groupId, String groupName, GroupRole groupRole) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupRole = groupRole;
    }
}
