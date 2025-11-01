package com.capstone.samadhi.record.dto;

import com.capstone.samadhi.record.entity.Record;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public record RecordResponse(
        @Schema(description = "레코드 ID", example = "1")
        Long id,

        @Schema(description = "레코드 생성 날짜/시간 (ISO-8601)", example = "2025-11-01T15:00:00")
        String dateTime,

        // Duration은 예시를 넣어도 복잡하게 표시될 수 있습니다.
        @Schema(description = "총 운동 시간 (ISO-8601 Duration)", example = "PT30M")
        long workingout_time,

        @Schema(description = "유튜브 영상 URL", example = "https://www.youtube.com/watch?v=example")
        String youtube_url,

        @Schema(description = "총 평균 점수", example = "92")
        int total_score,

        @Schema(description = "자세별 타임라인 목록")
        List<TimeLineResponse> timelines
) {

    public static RecordResponse from(Record record) {

        List<TimeLineResponse> timelines = record.getTimeLineList().stream()
                .map(TimeLineResponse::from) // TimeLineResponse의 정적 메소드 사용
                .collect(Collectors.toList());

        return new RecordResponse(
                record.getId(),
                record.getCreatedAt().toString(),
                record.getWorkingout_time().toSeconds(),
                record.getYoutube_url(),
                record.getTotal_score(),
                timelines
        );
    }
}