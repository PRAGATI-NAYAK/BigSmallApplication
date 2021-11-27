Feature: Finding Birthday gifts 

Scenario Outline: checking out a really cute gift for a childs birthday 

	Given browser would start 
	And would navigate to "<url>" 
	And hovers on birthday gifts and clicks on option birthday gift for kids navigates to that page 
	When selects the sort by feature as best selling and should select harry potter 
	Then it should add to cart with a gift note with "<from>" "<to>" and "<note>" 
	
	Examples: 
		|url	|from	|to	|note	|
		|https://www.bigsmall.in/	|abcdefg	|kid	|Wish you a very Happy Birthday!!!	|