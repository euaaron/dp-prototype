public class BugException implements Cloneable {
    private final int id;
    private String message;

    public BugException(String message) {
        super();
        this.id = (int) (Math.random() * 10);
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void throwException() {
        throw new RuntimeException(message);
    }

    @Override
    public BugException clone() throws CloneNotSupportedException {
        return (BugException) super.clone();
    }

    @Override
    public String toString() {
        return "Bug [id=" + id + ", message=" + message + "]";
    }
}