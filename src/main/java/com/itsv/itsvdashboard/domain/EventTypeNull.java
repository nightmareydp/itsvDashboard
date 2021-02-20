package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author yuduopeng
 * @date 2021/2/9
 * @time 9:56
 */
@Data
@Table(name = "t_event_type_null")
public class EventTypeNull {

    /**
     * id
     */
    @Column(name = "id")
    private String id;

    /**
     * 事件分类层二
     */
    @Column(name = "event_classification_level_2")
    private String eventClassificationLevel2;

    /**
     * 事件分类层三
     */
    @Column(name = "event_classification_level_3")
    private String eventClassificationLevel3;


    public EventTypeNull(String id, String eventClassificationLevel2, String eventClassificationLevel3) {
        this.id = id;
        this.eventClassificationLevel2 = eventClassificationLevel2;
        this.eventClassificationLevel3 = eventClassificationLevel3;
    }
}
