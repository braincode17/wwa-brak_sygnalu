package pl.allegro.braincode.integration.allegro;

public class PageToken {
    private String next;
    private String previous;

    public PageToken() {
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }
}
