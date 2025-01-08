package ui.utils;

import com.microsoft.playwright.*;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PlaywrightUIUtils {
    private final Page page;

    /**
     * Constructor to initialize the utility with a Playwright Page instance.
     *
     * @param page Playwright Page instance.
     */
    public PlaywrightUIUtils(Page page) {
        if (page == null) {
            throw new IllegalArgumentException("Page instance cannot be null.");
        }
        this.page = page;
    }

    /**
     * Hover over an element.
     *
     * @param selector locator of the element to hover over.
     */
    public void hover(String selector) {
        try {
            page.hover(selector);
            System.out.println("Hovered over element: " + selector);
        } catch (Exception e) {
            System.err.println("Failed to hover over element: " + selector);
            e.printStackTrace();
        }
    }

    /**
     * Double-click an element.
     *
     * @param selector Locator of the element to double-click.
     */
    public void doubleClick(String selector) {
        try {
            page.dblclick(selector);
            System.out.println("Double-clicked element: " + selector);
        } catch (Exception e) {
            System.err.println("Failed to double-click element: " + selector);
            e.printStackTrace();
        }
    }

    /**
     * Wait for an element to be visible.
     *
     * @param selector Locator of the element to wait for.
     * @param timeout  Maximum wait time in milliseconds.
     */
    public void waitForVisible(String selector, int timeout) {
        try {
            page.waitForSelector(selector, new Page.WaitForSelectorOptions().setTimeout(timeout));
            System.out.println("Element is visible: " + selector);
        } catch (Exception e) {
            System.err.println("Failed to wait for visibility of element: " + selector);
            e.printStackTrace();
        }
    }

    /**
     * Take a screenshot of the page or an element.
     */
    public void takeScreenshot() {
        try {
            Path path = Paths.get("screenshot");
            page.screenshot(new Page.ScreenshotOptions().setPath(path));
            System.out.println("Screenshot saved to: " + path);
        } catch (Exception e) {
            System.err.println("Failed to take screenshot.");
            e.printStackTrace();
        }
    }


    /**
     * Switch to a frame by index.
     *
     * @param index Index of the frame to switch to.
     */
    public Frame switchToFrameUsingIndex(int index) {
        try {
            Frame frame = page.frames().get(index);
            if (frame != null) {
                System.out.println("Switched to frame at index: " + index);
            } else {
                throw new IllegalArgumentException("No frame found at index: " + index);
            }
            return frame;
        } catch (Exception e) {
            System.err.println("Failed to switch to frame at index: " + index);
            e.printStackTrace();
            return null;
        }
    }

    public Frame switchToFrameUsingName(String nameOrId) {
        try {
            Frame frame = page.frame(nameOrId);
            if (frame != null) {
                System.out.println("Switched to frame with name or ID: " + nameOrId);
            } else {
                throw new IllegalArgumentException("No frame found with name or ID: " + nameOrId);
            }
            return frame;
        } catch (Exception e) {
            System.err.println("Failed to switch to frame with name or ID: " + nameOrId);
            e.printStackTrace();
            return null;
        }
    }


    /**
     * Switch to a frame directly using an iframe element.
     *
     * @param iframeSelector CSS or XPath selector for the iframe element.
     */
    public void switchToFrameUsingElement(String iframeSelector) {
        try {
            ElementHandle iframeElement = page.locator(iframeSelector).elementHandle();
            if (iframeElement != null) {
                Frame frame = iframeElement.contentFrame();
                if (frame != null) {
                    page.setContent(frame.content()); // Optionally switch context by using the frame's content.
                    System.out.println("Switched to frame using iframe element: " + iframeSelector);
                } else {
                    throw new IllegalArgumentException("No frame found for the iframe element: " + iframeSelector);
                }
            } else {
                throw new IllegalArgumentException("No iframe element found for selector: " + iframeSelector);
            }
        } catch (Exception e) {
            System.err.println("Failed to switch to frame using iframe element: " + iframeSelector);
            e.printStackTrace();
        }
    }

    /**
     * Preform Key action
     *
     * @param key The key to press.
     */
    public void holdKey(String key) {
        try {
            page.keyboard().press(key);
            System.out.println("Held key down: " + key);
        } catch (Exception e) {
            System.err.println("Failed to hold key down: " + key);
            e.printStackTrace();
        }
    }


    /**
     * Accept a JavaScript alert or confirmation dialog.
     */
    public void acceptAlert() {
        try {
            page.onDialog(dialog -> {
                System.out.println("Dialog message: " + dialog.message());
                dialog.accept(); // Accept the dialog
            });
            System.out.println("Accepted the alert/confirmation dialog.");
        } catch (Exception e) {
            System.err.println("Failed to accept the alert/confirmation dialog.");
            e.printStackTrace();
        }
    }

    /**
     * Dismiss a JavaScript confirmation dialog.
     */
    public void dismissAlert() {
        try {
            page.onDialog(dialog -> {
                System.out.println("Dialog message: " + dialog.message());
                dialog.dismiss(); // Dismiss the dialog
            });
            System.out.println("Dismissed the alert/confirmation dialog.");
        } catch (Exception e) {
            System.err.println("Failed to dismiss the alert/confirmation dialog.");
            e.printStackTrace();
        }
    }


    /**
     * Accept a JavaScript prompt and provide input.
     *
     * @param input The text to enter into the prompt.
     */
    public void acceptPromptWithInput(String input) {
        try {
            page.onDialog(dialog -> {
                System.out.println("Dialog message: " + dialog.message());
                dialog.accept(input); // Accept the prompt with input
            });
            System.out.println("Accepted the prompt with input: " + input);
        } catch (Exception e) {
            System.err.println("Failed to accept the prompt with input: " + input);
            e.printStackTrace();
        }
    }


}
