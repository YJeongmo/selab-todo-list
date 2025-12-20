import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TodoService service = new TodoService();
        Scanner sc = new Scanner(System.in);
        boolean run = true;

        while (run) {
            System.out.println("\n----- TodoList 프로그램 -----");
            System.out.println("1. 생성 | 2. 삭제 | 3. 수정 | 4. 체크 | 5. 전체조회 | 6. 단건조회 | 7. 종료");
            System.out.print("선택 : ");

            int menu = sc.nextInt();
            sc.nextLine(); // 숫자 입력 후 남은 엔터값을 제거하기 위한 필수 코드

            switch (menu) {
                case 1: // 리스트 추가
                    System.out.print("할 일 내용: ");
                    String content = sc.nextLine();
                    service.addTodo(content);
                    break;
                case 2: // 리스트 삭제
                    System.out.print("삭제할 ID: ");
                    int deleteId = sc.nextInt();
                    service.deleteTodo(deleteId);
                    break;
                case 3: // 리스트 수정
                    System.out.print("수정할 ID: ");
                    int editId = sc.nextInt();
                    sc.nextLine(); // 엔터 제거
                    System.out.print("새로운 내용: ");
                    String newContent = sc.nextLine();
                    service.editTodo(editId, newContent);
                    break;
                case 4: // 완료 상태 변경
                    System.out.print("체크할 ID: ");
                    int doneId = sc.nextInt();
                    System.out.print("완료 여부 (true/false): ");
                    boolean isDone = sc.nextBoolean();
                    service.isDone(doneId, isDone);
                    break;
                case 5: // 전체 조회
                    service.printAll();
                    break;
                case 6: // 단건 조회
                    System.out.print("조회할 ID: ");
                    int searchId = sc.nextInt();
                    service.printOne(searchId);
                    break;
                case 7: // 종료
                    run = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다.");
            }
        }
        sc.close();
    }
}