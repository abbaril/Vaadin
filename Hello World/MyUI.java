package Vaadin;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.Page;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.server.VaadinSession;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.*;

import java.util.Locale;

/**
 * This UI is the application entry point. A UI may either represent a browser window 
 * (or tab) or some part of a html page where a Vaadin application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be 
 * overridden to add component to the user interface and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {




    @Override
    protected void init(VaadinRequest vaadinRequest) {
        UI.getCurrent().setLocale(new Locale("en")); //set Ui locale to english, more like a HTML lang.
        Page.getCurrent().setTitle("Home page"); //Page title
        VaadinSession.getCurrent().setAttribute("My session", "Hello"); //Current session


        VerticalLayout layout = new VerticalLayout();

        Button button  = new Button("Hello"); // Button
        button.addClickListener(e-> {
            layout.addComponent(new Label("Hello World")); // display content
        });

        layout.addComponent(button); // add Button component
        setContent(layout);




    }







    @WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}
