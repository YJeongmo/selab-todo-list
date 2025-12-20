
public class Main {
    public static void main(String[] args) {
        // 객체 생성
        TodoService service = new TodoService();
        // 리스트 생성과
        service.addTodo("자바 공부를 해봐요");

        // 리스트 삭제
        service.deleteTodo(1);

        // 리스트 수정
        service.editTodo(5, "해치웠나??");

        // 수행 여부 체크
        service.isDone(4, true);
        service.isDone(5, true);

        // 전체 조회
        System.out.println("전체 조회 테스트");
        service.printAll();

        // 단건 조회
        service.printOne(5);
    }
}