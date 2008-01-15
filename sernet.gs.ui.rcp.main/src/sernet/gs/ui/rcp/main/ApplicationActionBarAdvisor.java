package sernet.gs.ui.rcp.main;

import org.eclipse.core.runtime.IExtension;
import org.eclipse.jface.action.IContributionItem;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.action.ToolBarContributionItem;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchActionConstants;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ContributionItemFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.ui.internal.WorkbenchPlugin;
import org.eclipse.ui.internal.cheatsheets.actions.CheatSheetCategoryBasedSelectionAction;
import org.eclipse.ui.internal.registry.ActionSetRegistry;
import org.eclipse.ui.internal.registry.IActionSetDescriptor;

import sernet.gs.ui.rcp.main.actions.OpenViewAction;
import sernet.gs.ui.rcp.main.actions.ShowBulkEditAction;
import sernet.gs.ui.rcp.main.actions.ShowCheatSheetAction;
import sernet.gs.ui.rcp.main.actions.ShowExportWizardAction;
import sernet.gs.ui.rcp.main.actions.ShowKonsolidatorAction;
import sernet.gs.ui.rcp.main.bsi.views.AuditView;
import sernet.gs.ui.rcp.main.bsi.views.BSIMassnahmenView;
import sernet.gs.ui.rcp.main.bsi.views.BrowserView;
import sernet.gs.ui.rcp.main.bsi.views.BsiModelView;
import sernet.gs.ui.rcp.main.bsi.views.DSModelView;
import sernet.gs.ui.rcp.main.bsi.views.TodoView;
import sernet.gs.ui.rcp.main.bsi.views.actions.BSIModelViewCloseDBAction;
import sernet.gs.ui.rcp.main.bsi.views.actions.BSIModelViewOpenDBAction;
import sernet.gs.ui.rcp.main.preferences.ShowPreferencesAction;

/**
 * An action bar advisor is responsible for creating, adding, and disposing of
 * the actions added to a workbench window. Each window will be populated with
 * new actions.
 * 
 * @author koderman@sernet.de
 */
public class ApplicationActionBarAdvisor extends ActionBarAdvisor {

	// Actions - important to allocate these only in makeActions, and then use
	// them
	// in the fill methods. This ensures that the actions aren't recreated
	// when fillActionBars is called with FILL_PROXY.
	private IWorkbenchAction exitAction;

	private IWorkbenchAction aboutAction;

	private IWorkbenchAction newWindowAction;

	private OpenViewAction openBSIViewAction;

	private IWorkbenchAction saveAction;

	private IWorkbenchAction closeAction;

	private IWorkbenchAction closeAllAction;

	private IWorkbenchAction closeOthersAction;

	private OpenViewAction openDSViewAction;

	private OpenViewAction openBSIModelViewAction;

	private OpenViewAction openTodoViewAction;

	private OpenViewAction openAuditViewAction;

	private ShowExportWizardAction showWizardAction;

	private ShowPreferencesAction showPreferencesAction;

	private OpenViewAction openBSIBrowserAction;

	private IWorkbenchAction copyAction;

	private IWorkbenchAction pasteAction;

	private BSIModelViewOpenDBAction openDBAction;

	private BSIModelViewCloseDBAction closeDBAction;

	private ShowBulkEditAction bulkEditAction;

	private ShowCheatSheetAction showCheatSheetAction;

	private IWorkbenchAction introAction;

	private ShowKonsolidatorAction konsolidatorAction;

	private CheatSheetCategoryBasedSelectionAction showCheatSheetListAction;

	public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
		removeExtraneousActions();
	}

	protected void makeActions(final IWorkbenchWindow window) {
		// Creates the actions and registers them.
		// Registering is needed to ensure that key bindings work.
		// The corresponding commands keybindings are defined in the plugin.xml
		// file.
		// Registering also provides automatic disposal of the actions when
		// the window is closed.

		exitAction = ActionFactory.QUIT.create(window);
		register(exitAction);

		copyAction = ActionFactory.COPY.create(window);
		register(copyAction);

		pasteAction = ActionFactory.PASTE.create(window);
		register(pasteAction);

		aboutAction = ActionFactory.ABOUT.create(window);
		register(aboutAction);

		newWindowAction = ActionFactory.OPEN_NEW_WINDOW.create(window);
		register(newWindowAction);

		saveAction = ActionFactory.SAVE.create(window);
		register(saveAction);

		closeAction = ActionFactory.CLOSE.create(window);
		register(closeAction);

		closeAllAction = ActionFactory.CLOSE_ALL.create(window);
		register(closeAllAction);

		closeOthersAction = ActionFactory.CLOSE_OTHERS.create(window);
		register(closeOthersAction);

		openBSIBrowserAction = new OpenViewAction(window, "GS Browser",
				BrowserView.ID, ImageCache.VIEW_BROWSER);
		register(openBSIBrowserAction);

		openBSIViewAction = new OpenViewAction(window, "GS Kataloge",
				BSIMassnahmenView.ID, ImageCache.VIEW_MASSNAHMEN);
		register(openBSIViewAction);

		openBSIModelViewAction = new OpenViewAction(window, "GS Modell",
				BsiModelView.ID, ImageCache.VIEW_BSIMODEL);
		register(openBSIModelViewAction);

		openDSViewAction = new OpenViewAction(window, "Datenschutz",
				DSModelView.ID, ImageCache.VIEW_DSMODEL);
		register(openDSViewAction);

		openTodoViewAction = new OpenViewAction(window, "Realisierungsplan",
				TodoView.ID, ImageCache.VIEW_TODO);
		register(openTodoViewAction);

		openAuditViewAction = new OpenViewAction(window, "Prüfplan",
				AuditView.ID, ImageCache.VIEW_AUDIT);
		register(openAuditViewAction);

		showWizardAction = new ShowExportWizardAction(window,
				"Report erstellen...");
		register(showWizardAction);

		showPreferencesAction = new ShowPreferencesAction();
//		showPreferencesAction = ActionFactory.PREFERENCES.create(window);
		register(showPreferencesAction);
		
		bulkEditAction = new ShowBulkEditAction(window, "Bulk Edit...");
		register(bulkEditAction);
		
		konsolidatorAction = new ShowKonsolidatorAction(window, "Konsolidator");
		register(konsolidatorAction);
		
		showCheatSheetAction = new ShowCheatSheetAction(true, "Erste Schritte");
		
		showCheatSheetListAction = 
			new CheatSheetCategoryBasedSelectionAction("Spickzettel / Tutorials...");
		
		introAction = ActionFactory.INTRO.create(window);
		register(introAction);
	}

	protected void fillMenuBar(IMenuManager menuBar) {
		IActionBarConfigurer configurer = getActionBarConfigurer();
		IWorkbenchWindow window = configurer.getWindowConfigurer().getWindow();

		
		menuBar.add(createFileMenu(window));
		menuBar.add(createEditMenu(window));
		menuBar.add(createWindowMenu(window));
		menuBar.add(createHelpMenu());
	}

	private IContributionItem createHelpMenu() {
		MenuManager helpMenu = new MenuManager("&Hilfe");
		helpMenu.add(introAction);
		helpMenu.add(showCheatSheetAction);
		helpMenu.add(showCheatSheetListAction);
		helpMenu.add(aboutAction);
		return helpMenu;
	}

	private IContributionItem createEditMenu(IWorkbenchWindow window) {
		MenuManager editMenu = new MenuManager("&Bearbeiten",
				IWorkbenchActionConstants.M_EDIT);

		editMenu.add(bulkEditAction);
		editMenu.add(konsolidatorAction);
		editMenu.add(showWizardAction);
		editMenu.add(new Separator());
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		editMenu.add(new Separator());
		editMenu.add(showPreferencesAction);
		return editMenu;
	}

	private IContributionItem createFileMenu(IWorkbenchWindow window) {
		MenuManager fileMenu = new MenuManager("&Datei",
				IWorkbenchActionConstants.M_FILE);

		// MenuManager neuMenu = new MenuManager("Neu...");
		// IContributionItem wizardList =
		// ContributionItemFactory.NEW_WIZARD_SHORTLIST.
		// create(window);
		// neuMenu.add(wizardList);

		// fileMenu.add(neuMenu);
		fileMenu.add(saveAction);
		fileMenu.add(closeAction);
		fileMenu.add(closeAllAction);
		fileMenu.add(closeOthersAction);
		
		fileMenu.add(new Separator());
		fileMenu.add(exitAction);
		return fileMenu;
	}

	private IContributionItem createWindowMenu(IWorkbenchWindow window) {
		// View:
		MenuManager windowMenu = new MenuManager("&Ansicht",
				IWorkbenchActionConstants.M_WINDOW);

		MenuManager viewsMenu = new MenuManager("Zeige View...");
		// IContributionItem viewList = ContributionItemFactory.VIEWS_SHORTLIST
		// .create(window);

		viewsMenu.add(openBSIModelViewAction);
		viewsMenu.add(openBSIBrowserAction);
		viewsMenu.add(openBSIViewAction);
		viewsMenu.add(openTodoViewAction);
		viewsMenu.add(openAuditViewAction);
		viewsMenu.add(openDSViewAction);
		// viewsMenu.add(viewList);

//		MenuManager perspectivesMenu = new MenuManager("Öffne Perspektive...");
//		IContributionItem perspectiveList = ContributionItemFactory.PERSPECTIVES_SHORTLIST
//				.create(window);
//		perspectivesMenu.add(perspectiveList);

		windowMenu.add(newWindowAction);
		windowMenu.add(new Separator());
//		windowMenu.add(perspectivesMenu);
		windowMenu.add(viewsMenu);
		return windowMenu;
	}

	protected void fillCoolBar(ICoolBarManager coolBar) {
		IToolBarManager myToolbar = new ToolBarManager(coolBar.getStyle());
		coolBar.add(new ToolBarContributionItem(myToolbar));
		myToolbar.add(saveAction);
		myToolbar.add(showWizardAction);
		myToolbar.add(bulkEditAction);
		myToolbar.add(konsolidatorAction);
		
		myToolbar.add(new Separator());
		myToolbar.add(openBSIViewAction);
		myToolbar.add(openBSIModelViewAction);
		myToolbar.add(openBSIBrowserAction);
		myToolbar.add(openTodoViewAction);
		myToolbar.add(openAuditViewAction);
		//myToolbar.add(openDSViewAction);
	}
	
	

	/**
	 * This removes some actions that we inherit from org.eclipse.ui.ide
	 * which we don't want.
	 *
	 */
	private void removeExtraneousActions() {
		ActionSetRegistry reg = WorkbenchPlugin.getDefault()
				.getActionSetRegistry();

		// removing gotoLastPosition message
		removeStandardAction(reg,
				"org.eclipse.ui.edit.text.actionSet.navigation");
		
		removeStandardAction(reg,
				"org.eclipse.ui.NavigateActionSet");

		// "Open File..." in 3.2.1:
		removeStandardAction(reg,
				"org.eclipse.ui.edit.text.actionSet.openExternalFile");

		// "Open File" in 3.4M4:
		removeStandardAction(reg,
			"org.eclipse.ui.actionSet.openFiles");

		removeStandardAction(reg,
				"org.eclipse.ui.preferencePages.Workbench");

		removeStandardAction(reg,
				"org.eclipse.ui.edit.text.actionSet.annotationNavigation");

		// Removing “Convert Line Delimiters To” menu
		removeStandardAction(reg,
				"org.eclipse.ui.edit.text.actionSet.convertLineDelimitersTo");
		
		// remove working sets
		removeStandardAction(reg, 
				"org.eclipse.ui.WorkingSetActionSet");
	}

	private void removeStandardAction(ActionSetRegistry reg, String actionSetId) {
		IActionSetDescriptor[] actionSets = reg.getActionSets();
		for (int i = 0; i < actionSets.length; i++) {
			if (!actionSets[i].getId().equals(actionSetId))
				continue;
			IExtension ext = actionSets[i].getConfigurationElement()
					.getDeclaringExtension();
			reg.removeExtension(ext, new Object[] { actionSets[i] });
		}
	}

}
