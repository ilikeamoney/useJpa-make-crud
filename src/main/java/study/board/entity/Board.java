package study.board.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @Entity 라고 사용하면 속성 정보 데이터 베이스 주소에서 클래스 명과 같은
 * 테이블명을 찾고 관련해서 맵필을 해준다.
 * @Id = PK
 * @GeneratedValue(strategy = GenerationType.IDENTITY) (어떤 종류의 SQL문을 사용하는지 확인
 */

@Entity
@Data
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private String filepath;
    private String filename;
}
