
import java.io.FileWriter;
import java.io.IOException;
public class TodoService {
    // 리스트를 저장할 파일명
    private final String FILE_NAME = "todoList.txt";

    // 리스트 생성 매서드
    public void createTodo(int id, String content){
        // 객체 생성
        TodoItem newItem = new TodoItem(id, content, false);

        try (FileWriter writer = new FileWriter(FILE_NAME, true)){
            writer.write(newItem.toFileFormat() + "\n");
            System.out.println(newItem + " 저장 완료.");
        } catch (IOException e){
            System.out.println("저장 실패 " + e.getMessage());
        }

    }

}
