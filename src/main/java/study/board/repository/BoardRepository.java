package study.board.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import study.board.entity.Board;


/**
 * JPA 를 extend 한 클래스 만들고 저장할 객체와 프라이머리키 값을 넣는다.
 * <저장할 오브젝트, 프라이머리 키>
 */
public interface BoardRepository extends JpaRepository<Board, Integer> {

    Page<Board> findByTitleContaining(String search, Pageable pageable);
}
