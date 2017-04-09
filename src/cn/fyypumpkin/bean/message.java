package cn.fyypumpkin.bean;

/**
 * 消息表对应的实体类
 * Created by fyy on 4/9/17.
 */
public class message  {
    private int id;
    private String command;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    private String description;
    private String content;


}
