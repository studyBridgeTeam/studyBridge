package com.green.studybridge.acaClass.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AcaClassClassWeekDays {
    @Schema(title = "수업 PK", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long classId;
    @Schema(title = "요일 PK", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private long dayId;
}
