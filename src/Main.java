
public class Main {
    public static void main(String[] args) {
        // 객체 생성
        TodoService service = new TodoService();
        // 리스트 생성
        //service.addTodo("ID값 자동 부여 테스트2");

        // 리스트 삭제
        service.deleteTodo(1);

        // 리스트 수정
        service.editTodo(5, "테스트 3인데 잘못썼었네^^");

        // 수행 여부 체크
        service.isDone(2, true);
        service.isDone(3, true);

        // 전체 조회
        System.out.println("전체 조회 테스트");
        service.printAll();

        // 단건 조회
        // service.printOne(id);
    }
}