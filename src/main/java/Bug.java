public class Bug implements Cloneable {
    private int id;
    private String message;

    public Bug(String message) {
        super();
        this.id = (int) (Math.random() * 10);
        this.message = "Atenção! " + message;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = "Atenção! " + message;
    }

    public void throwException() {
        throw new RuntimeException(message);
    }

    @Override
    public Bug clone() throws CloneNotSupportedException {
        return (Bug) super.clone();
    }

    @Override
    public String toString() {
        return "{\n  \"Bug\": {\n    \"id\": " + getId() + ",    \n    \"message\": \"" + getMessage() + "\"\n  }\n}";
    }
}