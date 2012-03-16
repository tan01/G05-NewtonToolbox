Project Name	:	Newton's Toolbox
Project ID	:	G05
Contributors	:	Clayven Anderson
			May Camp
			Michelle Len
			Jonathan Tan

Description	:	Application that can create/read/search physics formulas.
			Loads/saves to serialized .ntb file in /data directory.
			Will generate default .ntb if none is found.

Installation/	:	For Windows
Usage			

For GUI		:
			1. Run ntbgui.bat
			2. Various buttons are hopefully self-explanatory.
			3. Bottom panel accesses the functionality of the program.

				Search: 	Searches through formulas, variables, and/or units.
						The right side checkboxes determine what databases they will query.

				Print All: 	Prints all formulas, variables, and units.
						The formatted formulas can be clicked on to bring up an info panel.
						Formulas, variables, and units can be deleted from this interface.

				Formula Sheet:	Formula sheets can be created and loaded to consult.

				Add:		Accesses the editor interface,
						where formulas, variables, and units can be added into the existing database

For command	:
line interface			
			1. Run ntb.bat
			2. Type in keywords and press [enter] to access specific functionality.
				Search: Search through formulas by tags. 
					Type "s" or "search" and press [enter]. Then type in the tag and press [enter].
				Add:	Add a formula to the database.
					Type "add" and press [enter].
					Follow onscreen prompts.
				Print:	Type "p" or "print" to access print functionality
					*** NOTE ***
					THIS FUNCTION IS NOT COMPLETE.
					CURRENTLY TERMINATES PROGRAM.
					*** NOTE ***

				Print All: Prints all formulas in database.
					   Type "p a" or "p all" or "print all" and press [enter].

				Quit:	Terminates the program.
					Type "q" or "quit".
				
			3. Access available commands by typing "help."

			For Linux

GUI:			1. In shell, type "java -jar ntbgui.jar" in the directory containing the jar file.
Command Line:		1. In shell, enter "java -jar ntb.jar" in the directory containing the jar file.

Troubleshooting	:	The jar file was generated in the Java SE 6 runtime environment.
			Different versions of java may encounter problems.

TO RESTORE THE DEFAULT DATABASES:	Delete the data directory in the project folder.
					Upon starting the program, the default formulas, 
					variables, and units will be regenerated.
					Your custom entries will NOT be saved.