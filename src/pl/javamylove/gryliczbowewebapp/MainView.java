package pl.javamylove.gryliczbowewebapp;

import static pl.javamylove.gryliczbowewebapp.GryliczbowewebappUI.navigator;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class MainView extends VerticalLayout implements View {
	Panel panel;

	// Menu navigation button listener
	class ButtonListener implements Button.ClickListener {

		String menuitem;

		public ButtonListener(String menuitem) {
			this.menuitem = menuitem;
		}

		@Override
		public void buttonClick(ClickEvent event) {
			navigator.navigateTo(GryliczbowewebappUI.MAINVIEW + "/" + menuitem);
		}
	}

	public MainView() {
		setSizeFull();

		HorizontalLayout hLayout = new HorizontalLayout();
		hLayout.setSizeFull();

		// Menu po lewej stronie
		Panel menu = new Panel("Lista gier");
		menu.setHeight("100%");
		menu.setWidth(null);
		VerticalLayout menuContent = new VerticalLayout();
		menuContent.addComponent(new Button("Jeden numerek",
				new ButtonListener("jeden")));
		menuContent.addComponent(new Button("Standard", new ButtonListener(
				"standard")));
		menuContent
				.addComponent(new Button("Maxi", new ButtonListener("maxi")));
		menuContent.setWidth(null);
		menuContent.setMargin(true);
		menu.setContent(menuContent);
		hLayout.addComponent(menu);

		// Panel po prawej stronie
		panel = new Panel("Panel");
		panel.setSizeFull();
		hLayout.addComponent(panel);
		hLayout.setExpandRatio(panel, 1.0f);

		addComponent(hLayout);
		setExpandRatio(hLayout, 1.0f);

		// Wylogowanie
		Button logout = new Button("Wyloguj", new Button.ClickListener() {
			@Override
			public void buttonClick(ClickEvent event) {
				navigator.navigateTo("");
			}
		});
		addComponent(logout);
	}

	@Override
	public void enter(ViewChangeEvent event) {
		VerticalLayout panelContent = new VerticalLayout();
		panelContent.setSizeFull();
		panelContent.setMargin(true);
		panel.setContent(panelContent); // Also clears

		if (event.getParameters() == null || event.getParameters().isEmpty()) {
			panelContent.addComponent(new Label("Wybierz grę."));
			return;
		}

		Label watching = new Label("Wybrana gra " + event.getParameters());
		watching.setSizeUndefined();
		panelContent.addComponent(watching);
		panelContent.setComponentAlignment(watching, Alignment.MIDDLE_CENTER);

		Label back = new Label("Wybrana gra " + event.getParameters());
		back.setSizeUndefined();
		panelContent.addComponent(back);
		panelContent.setComponentAlignment(back, Alignment.MIDDLE_CENTER);
	}

}
