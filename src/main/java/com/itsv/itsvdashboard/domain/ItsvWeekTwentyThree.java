package com.itsv.itsvdashboard.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @Author yuduopeng
 * @date 2020/6/6
 * @time 22:28
 */
@Table(name = "T_ITSV_23")
@Data
public class ItsvWeekTwentyThree implements Serializable, Cloneable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private String id;

    @Column(name = "RECEPTION")
    private String reception;

    @Column(name = "ASSIGNED_COMPANY")
    private String assignedCompany;

    @Column(name = "ASSIGNED_LEVEL_1_DEPARTMENT")
    private String assignedLevel1Department;

    @Column(name = "ASSIGNED_LEVEL_2_DEPARTMENT")
    private String assignedLevel2Department;

    @Column(name = "ASSIGNED_LEVEL_3_DEPARTMENT")
    private String assignedLevel3Department;

    @Column(name = "ASSIGNED_PERSON")
    private String assignedPerson;

    @Column(name = "AUTO_ASSIGN")
    private String autoAssign;

    @Column(name = "CUSTOMER")
    private String customer;

    @Column(name = "CUSTOMER_ERP")
    private String customerErp;

    @Column(name = "CUSTOMER_EMAIL")
    private String customerEmail;

    @Column(name = "CUSTOMER_POSITION")
    private String customerPosition;

    @Column(name = "CUSTOMER_WORK_CITY")
    private String customerWorkCity;

    @Column(name = "CUSTOMER_WORKPLACE")
    private String customerWorkplace;

    @Column(name = "CUSTOMER_RANK")
    private String customerRank;

    @Column(name = "CUSTOMER_GRADE")
    private String customerGrade;

    @Column(name = "CUSTOMER_DEPARTMENT")
    private String customerDepartment;

    @Column(name = "CUSTOMER_COMPANY")
    private String customerCompany;

    @Column(name = "CUSTOMER_LEVEL_1_DEPARTMENT")
    private String customerLevel1Department;

    @Column(name = "CUSTOMER_LEVEL_2_DEPARTMENT")
    private String customerLevel2Department;

    @Column(name = "CUSTOMER_LEVEL_3_DEPARTMENT")
    private String customerLevel3Department;

    @Column(name = "INFLUENCE_DEGREE")
    private String influenceDegree;

    @Column(name = "URGENCY")
    private String urgency;

    @Column(name = "PRIORITY")
    private String priority;

    @Column(name = "EVENT_TITLE")
    private String eventTitle;

    @Column(name = "DETAILED_DESCRIPTION")
    private String detailedDescription;

    @Column(name = "STATE")
    private String state;

    @Column(name = "SOLUTION")
    private String solution;

    @Column(name = "SYSTEM_CLASSIFICATION_LEVEL_1")
    private String systemClassificationLevel1;

    @Column(name = "SYSTEM_CLASSIFICATION_LEVEL_2")
    private String systemClassificationLevel2;

    @Column(name = "SYSTEM_CLASSIFICATION_LEVEL_3")
    private String systemClassificationLevel3;

    @Column(name = "REPORT_SOURCE")
    private String reportSource;

    @Column(name = "IS_EVALUATE_CLEARANCE")
    private String isEvaluateClearance;

    @Column(name = "EVALUATE")
    private String evaluate;

    @Column(name = "ATTITUDE_SCORE")
    private Integer attitudeScore;

    @Column(name = "TIMELINESS_SCORE")
    private Integer timelinessScore;

    @Column(name = "SATISFACTION_SCORE")
    private Integer satisfactionScore;

    @Column(name = "IS_REOPEN")
    private String isReopen;

    @Column(name = "NUMBER_OF_REOPENS")
    private Integer numberOfReopens;

    @Column(name = "REOPEN_LOG")
    private String reopenLog;

    @Column(name = "SUBMISSION_DATE")
    private Date submissionDate;

    @Column(name = "RESPONSE_DATE")
    private Date responseDate;

    @Column(name = "RESOLUTION_DATE")
    private Date resolutionDate;

    @Column(name = "CLOSING_DATE")
    private Date closingDate;

    @Column(name = "DURATION_OF_DOCUMENT_CREATION_MINUTES")
    private String durationOfDocumentCreationMinutes;

    @Column(name = "RESPONSE_TIME_HOURS")
    private Float responseTimeHours;

    @Column(name = "SOLUTION_TIME_HOURS")
    private Float solutionTimeHours;

    @Column(name = "EVENT_CLASSIFICATION_LEVEL_1")
    private String eventClassificationLevel1;

    @Column(name = "EVENT_CLASSIFICATION_LEVEL_2")
    private String eventClassificationLevel2;

    @Column(name = "EVENT_CLASSIFICATION_LEVEL_3")
    private String eventClassificationLevel3;

    @Column(name = "OPERATION_CLASSIFICATION_LEVEL_1")
    private String operationClassificationLevel1;

    @Column(name = "OPERATION_CLASSIFICATION_LEVEL_2")
    private String operationClassificationLevel2;

    @Column(name = "OPERATION_CLASSIFICATION_LEVEL_3")
    private String operationClassificationLevel3;

    @Column(name = "REPORT_TIME")
    private String reportTime;

    @Column(name = "SUBMISSION_TIME")
    private Date submissionTime;

    @Column(name = "RESPONSE_TIME")
    private Date responseTime;

    @Column(name = "RESOLUTION_TIME")
    private Date resolutionTime;

    @Column(name = "CLOSING_DATE1")
    private Date closingDate1;

    @Column(name = "AUTHOR_NAME")
    private String authorName;

    @Column(name = "FIRST_SERVICE_DESK")
    private String firstServiceDesk;

    @Column(name = "FIRST_PROCESSING_GROUP")
    private String firstProcessingGroup;

    @Column(name = "FIRST_HANDLER")
    private String firstHandler;

    @Column(name = "FIRST_TRANSFER_TIME")
    private String firstTransferTime;

    @Column(name = "TRANSFER_TIMES")
    private Integer transferTimes;

    @Column(name = "LAST_ASSIGNED_TIME")
    private String lastAssignedTime;

    @Column(name = "ENTER_PENDING_TIME")
    private String enterPendingTime;

    @Column(name = "RELEASE_PENDING_TIME")
    private String releasePendingTime;

    @Column(name = "RESOLVE_TIMEOUT")
    private String resolveTimeout;

    @Column(name = "IS_RELATED_QUESTION")
    private String isRelatedQuestion;

    @Column(name = "QUESTION_NO")
    private String questionNo;


}
