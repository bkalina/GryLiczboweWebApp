package pl.javamylove.gryliczbowewebapp;

import static pl.javamylove.gryliczbowewebapp.GryliczbowewebappUI.navigator;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LoginView extends VerticalLayout implements View {

	public LoginView() {
		setSizeFull();

		FormLayout form = new FormLayout();
		form.addStyleName("outlined");
		form.setSpacing(true);
		form.setWidth(15.0f, Unit.PERCENTAGE);

		final TextField login = new TextField("Login");
		login.setWidth(100.0f, Unit.PERCENTAGE);
		form.addComponent(login);

		final PasswordField password = new PasswordField("Hasło");
		password.setWidth(100.0f, Unit.PERCENTAGE);

		form.addComponent(password);

		Button button = new Button("Zaloguj", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				if (login.getValue().equals("demo")
						& password.getValue().equals("demo")) {
					navigator.navigateTo(GryliczbowewebappUI.MAINVIEW);
				}
				else{
					Notification.show("Błędny login lub hasło", Type.WARNING_MESSAGE);
				}
			}
		});
		form.addComponent(button);
		addComponent(form);
		setComponentAlignment(form, Alignment.MIDDLE_CENTER);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		
	}

}
