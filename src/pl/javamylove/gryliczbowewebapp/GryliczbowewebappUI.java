package pl.javamylove.gryliczbowewebapp;

import com.vaadin.annotations.Theme;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("gryliczbowewebapp")
public class GryliczbowewebappUI extends UI {

	static Navigator navigator;
	protected static final String MAINVIEW = "main";

	@Override
	protected void init(VaadinRequest request) {

		getPage().setTitle("Gry Liczbowe - WebApp");

		// Create a navigator to control the views
		navigator = new Navigator(this, this);

		// Create and register the views
		navigator.addView("", new LoginView());
		navigator.addView(MAINVIEW, new MainView());

	}

}