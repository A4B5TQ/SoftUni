					>>>>>>>>>>>Ivan<<<<<<<<<<<
					
=========Controllers and Scenes:
LogIn Screen:
----> LogInButton ---> need PLayerLOG()
	---> get Player name; get Player Password; get Player Scores
----> SignUpButton ----> CreatePlayer()
	---> set Player name; set Player Password;
Select Quiz:
---> get Quiz type; change scene; 
	--->	Select Single or Chalenge(Bonus level only max Scores in CHALENGE MODE):
		---> set Scenes;
Questions screen:
---> get Question; get Answers; set Question Field text; set Answers Buttons text;
Scoreboard scene:
---> get Player Name and Scores;
Write new question screen:
---> Bonus LEVEL ... Write Question and Answer in Questions.txt file 

		format: [Question]|[Answer1]|[Answer2]|[Answer3]|[Answer4]|[Corret answer]
		
	
		============CLASSES==============
>>>>>>>>>>>>>>>>>>>>>>Gero<<<<<<<<<<<<<<<<<<<<<<<<<	
Player Class:
----> set/get Name;
----> validation for exist Player	
----> set/get Password;
PlayerCatalog Class:
----> HashMap<String,Integer> //Player,Player Scores //Get scores()(only best scores)//

>>>>>>>>>>>>>>>>>>>>BETITY<<<<<<<<<<<<<<<<<<<<<
Question Class:---> Iskam String VYPROS, LIST OTGOVORI, boolean CheckCorrectAnswer(String)
----> get Question;return List with answers(shufle);return String Correct Answer;
----> If clicked button.getText().equals(CorrectAnswer)
QuestionCatalog Class:
----> retun get/set Questions;

>>>>>>>>>>>>>>>>>>>>Diman<<<<<<<<<<<<<<<<<
=========Input/Output Classes =======
PlayerCatalogIO Class
QuestionCatalogIO Class

>>>>>>>>>>>>>>>>>>>>>>>Ivan<<<<<<<<<<<<<<<<<<<<
=========GAME ENGINE========
----> TimeSpan
----> get nextQuestion
----> add PlayerCatalog scores
----> On game END --- get high scores




	