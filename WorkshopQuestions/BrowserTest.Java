interface NavigationManager {
    void visit(String url);
    void back();
    void forward();
    void currentPage();
}

class DesktopBrowserNavigation implements NavigationManager {
    private Stack<String> backStack = new Stack<>();
    private Stack<String> forwardStack = new Stack<>();
    private String currentUrl = "Home";

    @Override
    public void visit(String url) {
        backStack.push(currentUrl);
        currentUrl = url;
        forwardStack.clear();
    }

    @Override
    public void back() {
        if (!backStack.isEmpty()) {
            forwardStack.push(currentUrl);
            currentUrl = backStack.pop();
        } else {
            System.out.println("No pages in back history.");
        }
    }

    @Override
    public void forward() {
        if (!forwardStack.isEmpty()) {
            backStack.push(currentUrl);
            currentUrl = forwardStack.pop();
        } else {
            System.out.println("No pages in forward history.");
        }
    }

    @Override
    public void currentPage() {
        System.out.println("Current Page: " + currentUrl);
    }
}

public class BrowserTest {
    public static void main(String[] args) {
        NavigationManager browser = new DesktopBrowserNavigation();

        browser.visit("google.com");
        browser.visit("youtube.com");
        browser.visit("github.com");
        browser.currentPage(); // github.com

        browser.back();
        browser.currentPage(); // youtube.com

        browser.back();
        browser.currentPage(); // google.com

        browser.forward();
        browser.currentPage(); // youtube.com
    }
}
