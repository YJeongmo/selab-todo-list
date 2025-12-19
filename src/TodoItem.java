public class TodoItem {

    // 리스트 ID
    private int id;
    // 리스트 내용
    private String content;
    // 수행 여부
    private boolean isCompleted;

    // 생성자. ID, 내용, 수행 여부
    public TodoItem(int id, String content, boolean isCompleted) {
        this.id = id;
        this.content = content;
        this.isCompleted = isCompleted;
    }

    // 내용을 변경하는 메서드
    public void setContent(String content) {
        this.content = content;
    }

    // 완료 상태를 변경하는 메서드
    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    // 저장할 테이터 변환
    public String toFileFormat() {
        return id + "," + content + "," + isCompleted;
    }

    // ID 추출하는 매서드
    public static int getIdFromLine(String line) {
        String[] parts = line.split(",");
        return Integer.parseInt(parts[0]);
    }

    // Getter
    public int getId(){return id;}
    public String getContent(){return content;}
    public boolean isCompleted(){return isCompleted;}

    @Override
    public String toString() {
        return "[" + (isCompleted ? "V" : " ") + "] " + id + ". " + content;
    }
}