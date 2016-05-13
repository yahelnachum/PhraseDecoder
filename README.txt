Author:		Yahel Nachum
Language:	Java
Date:		5/13/2016

Purpose:	
	To create a birthday gift for my girlfriend.
	
Description:
	This programs starts off with a loading screen 
	of a heart filling up as a sound clip accompanies 
	it. Then the user is brought to an instruction 
	panel where they may review what they can do in 
	the application. Once the user is in the main 
	panel of the application they will see two designated 
	areas: one a drag and drop panel, and two a phrase 
	panel. In the drag and drop panel the user can 
	drag and drop any set of files from their computer 
	into that panel. Once a set of files is dropped in 
	that panel the phrase panel will start showing a 
	decoded phrase. As the user puts in more and more 
	files into the application more and more of the 
	phrase will be decoded. Once the phrase is fully 
	decoded the phrase panel will turn green and will 
	notify the user that they can reset the 
	application by pressing 'r' for a new random 
	phrase.
	
How decoding a phrase works:
	The program takes in files and outputs decoded 
	phrases. It does this by reading each byte of 
	the file and figuring out the most recurring 
	character version of those bytes in the phrase 
	being decoded. If that character hasn't been 
	decoded in the phrase then it is decoded. If the 
	character has already been decoded then the 
	program will take the second most recurring 
	character. If the second is already decoded it 
	will use the third and so on until the whole 
	phrase has been decoded.	