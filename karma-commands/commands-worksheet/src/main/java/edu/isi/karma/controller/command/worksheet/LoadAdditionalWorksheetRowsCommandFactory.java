/*******************************************************************************
 * Copyright 2012 University of Southern California
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * 	http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 * This code was developed by the Information Integration Group as part 
 * of the Karma project at the Information Sciences Institute of the 
 * University of Southern California.  For more information, publications, 
 * and related projects, please see: http://www.isi.edu/integration
 ******************************************************************************/

package edu.isi.karma.controller.command.worksheet;

import javax.servlet.http.HttpServletRequest;

import edu.isi.karma.controller.command.Command;
import edu.isi.karma.controller.command.CommandFactory;
import edu.isi.karma.rep.Workspace;

public class LoadAdditionalWorksheetRowsCommandFactory extends CommandFactory {
	private enum Arguments {
		worksheetId, tableId, selectionName
	}
	
	@Override
	public Command createCommand(HttpServletRequest request, Workspace workspace) {
		String tableId = request.getParameter(Arguments.tableId.name());
		String vWorksheetId = request.getParameter(Arguments.worksheetId.name());
		String selectionName = request.getParameter(Arguments.selectionName.name());
		return new LoadAdditionalWorksheetRowsCommand(getNewId(workspace), 
				Command.NEW_MODEL,
				tableId, vWorksheetId, selectionName);
	}

	@Override
	public Class<? extends Command> getCorrespondingCommand()
	{
		return LoadAdditionalWorksheetRowsCommand.class;
	}
}
