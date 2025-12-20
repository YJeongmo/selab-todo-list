
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;

import java.util.ArrayList;
import java.util.List;

public class TodoService {
    private final String FILE_NAME = "todolist.txt";

    //  파일의 내용을 한 줄씩 객체로 리스트에 저장
    private List<TodoItem> loadAll() {
        List<TodoItem> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                // 한 줄씩 객체로 변경 후 리스트에 추가
                list.add(TodoItem.fromFileFormat(line));
            }
        } catch (IOException e) {
            // 파일이 없으면 빈 리스트
        }
        return list;
    }


    // ID 자동 부여
    private int getNextId() {
        List<TodoItem> list = loadAll();

        // 빈 리스트 -> 1번 부여
        if (list.isEmpty()) return 1;
        // 리스트의 마지막 항목 + 1 부여
        return list.get(list.size() - 1).getId() + 1;
    }


    // 리스트 생성
    public void addTodo(String content) {

        // id를 직접 입력하는것이 아닌 자동부여 필요
        int nextId = getNextId();

        TodoItem newItem = new TodoItem(nextId, content, false);

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

        List<TodoItem> list = loadAll();

        // ID가 일치하는 리스트 삭제
        boolean removed = list.removeIf(item -> item.getId() == id);

        if (removed) {
            // 지운 데이터를 제외한 전체 데이터 덮어쓰기
            saveAll(list);
            System.out.println(id + "번 리스트 삭제 완료");
        } else {
            System.out.println("해당 ID의 리스트를 찾을 수 없습니다.");
        }
    }


    // 지운 데이터를 제외한 리스트를 파일에 덮어쓰기
    private void saveAll(List<TodoItem> list) {

        try (FileWriter fw = new FileWriter(FILE_NAME, false)) {
            for (TodoItem item : list) {
                fw.write(item.toFileFormat() + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // 리스트 수정
    public void editTodo(int id, String newContent) {

        List<TodoItem> list = loadAll();
        boolean isUpdated = false;

        for (TodoItem item : list) {
            if (item.getId() == id) {
                // 해당 id의 리스트 내용 변경
                item.setContent(newContent);
                isUpdated = true;
                break;
            }
        }

        if (isUpdated) {
            saveAll(list);
            System.out.println(id + "번 리스트 내용 수정 완료");
        } else {
            System.out.println("해당 ID의 리스트를 찾을 수 없습니다");
        }
    }


    // 수행 여부 체크
    public void isDone(int id, boolean isCompleted) {

        List<TodoItem> list = loadAll();
        boolean isUpdated = false;

        for (TodoItem item : list) {
            if (item.getId() == id) {
                // 해당 id의 리스트 상태 벼경
                item.setCompleted(isCompleted);
                isUpdated = true;
                break;
            }
        }

        if (isUpdated) {
            saveAll(list);
            System.out.println(id + "번 리스트 상태 수정 완료");
        } else {
            System.out.println("해당 ID의 리스트를 찾을 수 없습니다");
        }
    }


    // 전체 조회
    public void printAll() {
        List<TodoItem> list = loadAll();
        if (list.isEmpty()) {
            System.out.println("목록이 비어있습니다.");
            return;
        }
        for (TodoItem item : list) {
            System.out.println(item);
        }
    }


    // 단건 조회
    public void printOne(int id) {
        // 임시생성. 해당 id값의 데이터 출력
    }
}