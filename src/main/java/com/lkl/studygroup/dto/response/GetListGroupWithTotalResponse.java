package com.lkl.studygroup.dto.response;

import lombok.Data;
import java.util.List;

@Data
public class GetListGroupWithTotalResponse {
    List<GetListGroupResponse> groups;
    long totalGroups;

    public GetListGroupWithTotalResponse(List<GetListGroupResponse> groups, long totalGroups) {
        this.groups = groups;
        this.totalGroups = totalGroups;
    }
}
