package com.lkl.studygroup.dto.response;
import com.lkl.studygroup.model.enums.GroupRole;
import lombok.Data;

import java.util.UUID;
@Data
public class GetMemberResponse {
    UUID userId;
    String firstName;
    String lastName;
    GroupRole groupRole;
    String email;
    public GetMemberResponse(UUID userId, String firstName, String lastName, String email, GroupRole groupRole) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.groupRole = groupRole;
    }
}
