package org.example.w22.todo;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class TodoVO {
    private Integer tno;
    private String title;
    private String writer;
    private Timestamp regdate;
    private Timestamp moddate;
    private boolean delFlag;
}
