package study.board.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import study.board.entity.Board;
import study.board.repository.BoardRepository;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 *  @Autowired 로 Repository 의존관계를 자동으로 주입 받는다.
 */

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    // 글작성
    public void write(Board board, MultipartFile file) throws IOException {

        // 현재 경로가 나온다.
        // 저장할 파일경로
        String projectPath = System.getProperty("user.dir") + "/src/main/resources/static/files";

        UUID uuid = UUID.randomUUID();

        String fileName = uuid + "_" + file.getOriginalFilename();

        // 파일 경로와 이름
        File saveFile = new File(projectPath, fileName);

        // 파일 저장
        file.transferTo(saveFile);

        board.setFilepath("/files/" + fileName);
        board.setFilename(fileName);

        boardRepository.save(board);
    }

    public Page<Board> boardSearchList(String searchKeyWord, Pageable pageable) {
        return boardRepository.findByTitleContaining(searchKeyWord, pageable);
    }

    // 게시글 리스트 처리
    // 파라미터로 Pageable 을 받으면
    // 리턴 값으로 List<T> 에서 Page<T> 로 바뀐다.
    public Page<Board> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);
    }

    public Board boardView(Integer id) {
        return boardRepository.findById(id).get();
    }

    public void boardDelete(Integer id) {
        boardRepository.deleteById(id);
    }
}
