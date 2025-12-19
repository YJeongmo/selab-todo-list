
import java.io.FileWriter;
import java.io.IOException;

public class TodoService {
    private final String FILE_NAME = "todolist.txt";

    // 리스트 생성
    public void addTodo(int id, String content) {

        TodoItem newItem = new TodoItem(id, content, false);

        // 파일에 저장
        try (FileWriter fw = new FileWriter(FILE_NAME, true)) {
            // 파일에 저장할 형식으로 변환
            fw.write(newItem.toFileFormat() + "\n");
            System.out.println("리스트에 추가 :  " + newItem);
        } catch (IOException e) {
            System.out.println("오류 발생 : " + e.getMessage());
        }
    }

    // 리스트 삭제
    public void deleteTodo(int id) {
        // 임시생성. 파일읽기 -> 해당 id값의 데이터 삭제 -> 덮어쓰기
    }

    // 리스트 수정
    public void editTodo(int id, String newContent) {
        // 임시생성. 파일읽기 -> 해당 id값의 데이터 수정 -> 덮어쓰기
    }

    // 수행 여부 체크
    public void isDone(int id, boolean isCompleted) {
        // 임시생성. 해당 id값의 boolean 데이터값 변경
    }

    // 전체 조회
    public void printAll() {
        // 임시생성. txt파일 전체 출력
    }

    // 단건 조회
    public void printOne(int id) {
        // 임시생성. 해당 id값의 데이터 출력
    }
}