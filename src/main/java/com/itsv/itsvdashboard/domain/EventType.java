package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;

/**
 * @Author yuduopeng
 * @date 2020/7/12
 * @time 4:08
 */
@Data
@Table(name = "t_event_type")
public class EventType {

    /**
     * id
     */
    @Column(name = "id")
    private Integer id;

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

    /**
     * 主事件类型
     */
    @Column(name = "m_event_type")
    private String masterEventType;

    /**
     * 子事件类型
     */
    @Column(name = "s_event_type")
    private String sonEventType;

    public EventType(Integer id, String eventClassificationLevel2, String eventClassificationLevel3, String masterEventType, String sonEventType) {
        this.id = id;
        this.eventClassificationLevel2 = eventClassificationLevel2;
        this.eventClassificationLevel3 = eventClassificationLevel3;
        this.masterEventType = masterEventType;
        this.sonEventType = sonEventType;
    }
}
