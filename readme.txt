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
Usage			1. Run ntb.bat
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
			1. In shell, enter "java -jar ntb.jar" in the directory containing the jar file.

Troubleshooting	:	The jar file was generated in the Java SE 6 runtime environment.
			Different versions of java may encounter problems.