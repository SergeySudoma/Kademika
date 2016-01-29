package Logic;

import java.io.IOException;

public interface PanelManager {
	
	public void addMainMenuPanel();
	public void addActionFieldAndRunGame(String selectedTank) throws Exception;
	public void addGameOverMenu(String gameResult) throws IOException;
}
