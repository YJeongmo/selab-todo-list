public class TodoItem {

    // 리스트 id
    private int id;
    // 리스트 내용
    private String content;
    // 리스트 수행 여부
    private boolean isCompleted;

    // 생성자 - id, 내용, 수행 여부
    public TodoItem(int id, String content, boolean isCompleted){
        this.id = id;
        this.content = content;
        this.isCompleted = isCompleted;
    }

    // 파일 저장시 형식
    public String toFileFormat(){
        return id + " / " + content + " / " + isCompleted;
    }

    // Getter
    public int getId(){return id;}
    public String getContent(){return content;}
    public boolean isCompleted(){return isCompleted;}

    @Override // 김영한 중급-1 섹션1
    public String toString(){
        return "[" + (isCompleted ? "V" : "  ") + "] " + id + ". " + content;
    }

}
