package com.vaadin.tutorial.tache;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.tutorial.addressbook.backend.Tache;
import com.vaadin.tutorial.addressbook.backend.TacheService;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

/* User Interface written in Java.
 *
 * Define the user interface shown on the Vaadin generated web page by extending the UI class.
 * By default, a new UI instance is automatically created when the page is loaded. To reuse
 * the same instance, add @PreserveOnRefresh.
 */
@Title("Gestion des taches")
@Theme("taksguitheme")
public class TacheUI extends UI {

	/* Hundreds of widgets.
	 * Vaadin's user interface components are just Java objects that encapsulate
	 * and handle cross-browser support and client-server communication. The
	 * default Vaadin components are in the com.vaadin.ui package and there
	 * are over 500 more in vaadin.com/directory.
     */
    TextField filter = new TextField();
    Grid tachelist = new Grid();
    Button newTacheButton = new Button("Nouvelle tache");

    // ContactForm is an example of a custom component class
    TacheForm tacheForm = new TacheForm();

    // ContactService is a in-memory mock DAO that mimics
    // a real-world datasource. Typically implemented for
    // example as EJB or Spring Data based service.
    TacheService service = TacheService.getInstance();


    /* The "Main method".
     *
     * This is the entry point method executed to initialize and configure
     * the visible user interface. Executed on every browser reload because
     * a new instance is created for each web page loaded.
     */
    @Override
    protected void init(VaadinRequest request) {
        configureComponents();
        buildLayout();
    }


    private void configureComponents() {
         /* Synchronous event handling.
         *
         * Receive user interaction events on the server-side. This allows you
         * to synchronously handle those events. Vaadin automatically sends
         * only the needed changes to the web page without loading a new page.
         */
    	newTacheButton.addClickListener(e -> tacheForm.edit(new Tache()));

        filter.setInputPrompt("Filtrer les tâches...");
        filter.addTextChangeListener(e -> refreshContacts(e.getText()));

        tachelist.setContainerDataSource(new BeanItemContainer<>(Tache.class));
        tachelist.setColumnOrder("label", "datePrevu");
//        tachelist.removeColumn("id");
//        tachelist.removeColumn("birthDate");
//        tachelist.removeColumn("phone");
        tachelist.setSelectionMode(Grid.SelectionMode.SINGLE);
        tachelist.addSelectionListener(e
                -> tacheForm.edit((Tache) tachelist.getSelectedRow()));
        refreshTaches();
    }

    /* Robust layouts.
     *
     * Layouts are components that contain other components.
     * HorizontalLayout contains TextField and Button. It is wrapped
     * with a Grid into VerticalLayout for the left side of the screen.
     * Allow user to resize the components with a SplitPanel.
     *
     * In addition to programmatically building layout in Java,
     * you may also choose to setup layout declaratively
     * with Vaadin Designer, CSS and HTML.
     */
    private void buildLayout() {
        HorizontalLayout actions = new HorizontalLayout(filter, newTacheButton);
        actions.setWidth("100%");
        filter.setWidth("100%");
        actions.setExpandRatio(filter, 1);

        VerticalLayout left = new VerticalLayout(actions, tachelist);
        left.setSizeFull();
        tachelist.setSizeFull();
        left.setExpandRatio(tachelist, 1);

        HorizontalLayout mainLayout = new HorizontalLayout(left, tacheForm);
        mainLayout.setSizeFull();
        mainLayout.setExpandRatio(left, 1);

        // Split and allow resizing
        setContent(mainLayout);
    }

    /* Choose the design patterns you like.
     *
     * It is good practice to have separate data access methods that
     * handle the back-end access and/or the user interface updates.
     * You can further split your code into classes to easier maintenance.
     * With Vaadin you can follow MVC, MVP or any other design pattern
     * you choose.
     */
    void refreshTaches() {
        refreshContacts(filter.getValue());
    }

    private void refreshContacts(String stringFilter) {
        tachelist.setContainerDataSource(new BeanItemContainer<>(
                Tache.class, service.findAll(stringFilter)));
       tacheForm.setVisible(false);
    }




    /*  Deployed as a Servlet or Portlet.
     *
     *  You can specify additional servlet parameters like the URI and UI
     *  class name and turn on production mode when you have finished developing the application.
     */
    @WebServlet(urlPatterns = "/*")
    @VaadinServletConfiguration(ui = TacheUI.class, productionMode = false)
    public static class MyUIServlet extends VaadinServlet {
    }
}


