CREATE TABLE MEMBER
(
    USER_ID                 VARCHAR2(20)                  PRIMARY KEY ,
    PASSWORD                VARCHAR2(20)                  NOT NULL,
    EMAIL                   VARCHAR2(50)                  NOT NULL  UNIQUE ,
    NAME                    VARCHAR2(20)                  NOT NULL,
    ROLE                    VARCHAR2(20) DEFAULT '회원',
    PROFILE_IMAGE           VARCHAR2(50) DEFAULT 'DEFAULTImage.jpg',
    LAST_LOGIN_DATE         DATE,
    REG_DATE                DATE                          NOT NULL,
    PROJECT_WITHDRAWAL_DATE DATE,
    REPORT_CNT              NUMBER       DEFAULT 0,
    SELF_INTRO              VARCHAR2(200),
    MEMBER_STATUS           VARCHAR2(20) DEFAULT 'NORMAL' NOT NULL,
    REVIEW_TOTAL_SCORE      NUMBER       DEFAULT 0,
    LINK                    VARCHAR2(500),
    PROJECT_HISTORY         VARCHAR2(100),
    PROJECT_NO              NUMBER
);
COMMENT ON COLUMN MEMBER.ROLE IS '회원 / 관리자 / 커뮤니티관리자';
COMMENT ON COLUMN MEMBER.MEMBER_STATUS IS 'NORMAL/DORMANT/BLACK/WITHDRAWAL/PROJECT_WITHDRAWAL/BLACK_WITHDRAWAL';

CREATE TABLE PROJECT
(
    PROJECT_NO              NUMBER           PRIMARY KEY,
    USER_ID                 VARCHAR2(20)     NOT NULL REFERENCES MEMBER (USER_ID),
    PROJECT_NAME            VARCHAR2(30)     NOT NULL,
    PROGRESS_CLASSIFICATION NUMBER           NOT NULL,
    PROJECT_CATEGORY        NUMBER           NOT NULL,
    PRE_START_DATE          DATE             NOT NULL,
    PRE_PERIOD              NUMBER           NOT NULL,
    MEETING_METHOD          NUMBER           NOT NULL,
    MEETING_LOCATION        VARCHAR2(50),
    APPLICATION_DEADLINE    DATE             NOT NULL,
    END_DATE                DATE,
    PROJECT_DETAIL          VARCHAR2(500)    NOT NULL,
    REG_DATE                DATE             NOT NULL,
    PROJECT_STATUS          NUMBER DEFAULT 1 NOT NULL,
    PROJECT_VIEW_CNT        NUMBER DEFAULT 0 NOT NULL,
    APPLICANT_QUESTION_A    VARCHAR2(100),
    APPLICANT_QUESTION_B    VARCHAR2(100),
    APPLICANT_QUESTION_C    VARCHAR2(100)

);

COMMENT ON COLUMN PROJECT.PROGRESS_CLASSIFICATION is '1 : 신규 프로젝트 / 2 : 기존 프로젝트';
COMMENT ON COLUMN PROJECT.PROJECT_CATEGORY is '1 : 개발 / 2 : 기획 / 3 : 디자인';
COMMENT ON COLUMN PROJECT.MEETING_METHOD is '1 : 대면 / 2 : 비대면';
COMMENT ON COLUMN PROJECT.PROJECT_STATUS is '1 : 모집중 / 2 : 모집완료 / 3 : 종료';

ALTER TABLE MEMBER ADD FOREIGN KEY (PROJECT_NO) REFERENCES PROJECT (PROJECT_NO);


CREATE TABLE APPLICANT
(
    APPLICANT_NO       NUMBER                    PRIMARY KEY ,
    USER_ID            VARCHAR2(20)     NOT NULL REFERENCES MEMBER(USER_ID),
    PROJECT_NO         NUMBER           NOT NULL REFERENCES PROJECT(PROJECT_NO),
    APPLICANT_STATUS   NUMBER DEFAULT 1 NOT NULL,
    APPLICANT_ANSWER_A VARCHAR2(100),
    APPLICANT_ANSWER_B VARCHAR2(100),
    APPLICANT_ANSWER_C VARCHAR2(100),
    INTRO_TO_MEMBER    VARCHAR2(100)
);

COMMENT ON COLUMN APPLICANT.APPLICANT_STATUS IS '1 : 정보검토중 / 2 : 신청승인 / 3 : 신청거절 / 4 : 참가안함';


CREATE TABLE GRADE
(
    GRADE      VARCHAR2(20) PRIMARY KEY,
    LOW_SCORE  NUMBER       NOT NULL,
    HIGH_SCORE NUMBER       NOT NULL
);


CREATE TABLE POST
(
    POST_NO      NUMBER                    PRIMARY KEY,
    USER_ID      VARCHAR2(20)     NOT NULL REFERENCES MEMBER(USER_ID),
    POST_NAME    VARCHAR2(50)     NOT NULL,
    POST_CONTENT VARCHAR2(500)    NOT NULL,
    REG_DATE     DATE             NOT NULL,
    VIEW_CNT     NUMBER DEFAULT 0 NOT NULL
);

CREATE TABLE REPLY
(
    REPLY_NO      NUMBER                 PRIMARY KEY,
    POST_NO       NUMBER                 REFERENCES POST(POST_NO),
    PROJECT_NO    NUMBER                 REFERENCES PROJECT(PROJECT_NO),
    USER_ID       VARCHAR2(20)  NOT NULL REFERENCES MEMBER(USER_ID),
    REPLY_CONTENT VARCHAR2(500) NOT NULL,
    REG_DATE      DATE          NOT NULL
);


CREATE TABLE REPORT
(
    REPORT_NO        NUMBER                PRIMARY KEY ,
    REPORTER_USER_ID VARCHAR2(20) NOT NULL REFERENCES MEMBER(USER_ID),
    TARGET_USER_ID   VARCHAR2(20) NOT NULL REFERENCES MEMBER(USER_ID),
    REPORT_TARGET    NUMBER       NOT NULL,
    REPORT_TYPE      NUMBER       NOT NULL,
    POST_NO          NUMBER       NOT NULL REFERENCES POST(POST_NO),
    REPLY_NO         NUMBER                REFERENCES REPLY(REPLY_NO),
    REPORT_DATE      DATE         NOT NULL
);

COMMENT ON COLUMN REPORT.REPORT_TARGET IS '1: 게시물 / 2: 댓글';
COMMENT ON COLUMN REPORT.REPORT_TYPE IS '1: 음란 / 2:욕설 / 3:홍보';



CREATE TABLE PORTFOLIO
(
    PORTFOLIO_NO            NUMBER                 PRIMARY KEY ,
    USER_ID                 VARCHAR2(20)  NOT NULL REFERENCES MEMBER(USER_ID),
    PROJECT_NO              NUMBER        NOT NULL REFERENCES PROJECT(PROJECT_NO),
    PORT_PROJECT_START_DATE DATE          NOT NULL,
    PORT_PROJECT_END_DATE   DATE          NOT NULL,
    PORT_DESCRIPTION        VARCHAR2(500) NOT NULL,
    PORT_THUMBNAIL_IMAGE    VARCHAR2(50)
);


CREATE TABLE REVIEW
(
    REVIEW_NO      NUMBER                PRIMARY KEY ,
    USER_ID        VARCHAR2(20) NOT NULL REFERENCES MEMBER(USER_ID),
    PROJECT_NO     NUMBER       NOT NULL REFERENCES PROJECT(PROJECT_NO),
    REVIEW_GRADE   NUMBER       NOT NULL,
    REVIEW_COMMENT VARCHAR2(20) NOT NULL
);



CREATE TABLE NOTIFICATION
(
    NOTI_NO      NUMBER                    PRIMARY KEY ,
    USER_ID      VARCHAR2(20)     NOT NULL REFERENCES MEMBER(USER_ID),
    PROJECT_NO   NUMBER                    REFERENCES PROJECT(PROJECT_NO),
    APPLICANT_NO NUMBER                    REFERENCES APPLICANT(APPLICANT_NO),
    POST_NO      NUMBER                    REFERENCES POST(POST_NO),
    NOTI_STATUS  NUMBER DEFAULT 2 NOT NULL
);

COMMENT ON COLUMN NOTIFICATION.NOTI_STATUS IS '1 : 확인 / 2 : 미확인';


CREATE TABLE BOOKMARK
(
    BOOKMARK_NO NUMBER                PRIMARY KEY ,
    USER_ID     VARCHAR2(20) NOT NULL REFERENCES MEMBER(USER_ID),
    POST_NO     NUMBER                REFERENCES POST(POST_NO),
    PROJECT_NO  NUMBER                REFERENCES PROJECT(PROJECT_NO)
);


CREATE TABLE FILES
(
    FILE_NO       NUMBER        PRIMARY KEY,
    UPLOAD_FILE_A VARCHAR2(50),
    UPLOAD_FILE_B VARCHAR2(50),
    UPLOAD_FILE_C VARCHAR2(50),
    UPLOAD_FILE_D VARCHAR2(50),
    POST_NO       NUMBER        REFERENCES POST(POST_NO),
    PROJECT_NO    NUMBER        REFERENCES PROJECT(PROJECT_NO),
    PORTFOLIO_NO  NUMBER        REFERENCES PORTFOLIO(PORTFOLIO_NO)
);



CREATE TABLE HASHTAG
(
    HASHTAG_NO NUMBER       PRIMARY KEY ,
    HASHTAG    VARCHAR2(20) NOT NULL
);



CREATE TABLE SKILL_HASHTAG
(
    SKILL_HASHTAG_NO NUMBER          PRIMARY KEY ,
    HASHTAG_NO       NUMBER NOT NULL REFERENCES HASHTAG(HASHTAG_NO),
    USER_ID          VARCHAR2(20)    REFERENCES MEMBER(USER_ID),
    PROJECT_NO       NUMBER          REFERENCES PROJECT(PROJECT_NO),
    PORTFOLIO_NO     NUMBER          REFERENCES PORTFOLIO(PORTFOLIO_NO)
);



CREATE TABLE TODO
(
    TODO_NO      NUMBER                    PRIMARY KEY ,
    PROJECT_NO   NUMBER           NOT NULL REFERENCES PROJECT(PROJECT_NO),
    USER_ID      VARCHAR2(20)     NOT NULL REFERENCES MEMBER(USER_ID),
    TODO_CONTENT VARCHAR2(50)     NOT NULL,
    TODO_STATUS  NUMBER DEFAULT 2 NOT NULL
);

COMMENT ON COLUMN TODO.TODO_STATUS IS '1 : 완료 / 2 : 미완료';







