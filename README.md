# GoogleCalendar Using MVC

This project was developing during my CS 151 course at San Jose Stae University. The three components that it contains are Modal, 

# Model
- Represents the data that is held 
- works mainly with the counter. The counter pushes on what type of view is accessible for the user
- Keeps sending messages to the view depending on type of outputs by the user 
- CalendarModel is the Model in this example 
  - It has a variety of difrent functions to set & update teh incerement to adjust to the view that is required.
  - For example, to view the Calendar in months instead of days you press the button on the GUI.
  - Model sends a note (msg) to the view to update it to month instead of days 
  
# View 
- The view is the interface the user chooses to view
- Displays the model data depending on the button interaction
- CalendarFrame is the view in this example

# Controller
- You can add/edit/delete data in the view/model
- Interprets user actions
- CalendarEvent is the model in this example
  - Takes care of saving, adding, loading different events.
  - For example if someone would like to view the events for a month
    - Simple press the Load button.
    - Controller updates the model along with the view to load the events for the user

