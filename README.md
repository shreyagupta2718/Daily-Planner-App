# My Personal Project: Daily Time-Blocking Planner

This project will be useful to anyone who wants a
simple application to quickly **plan and visualize**
their day. It allows users to **brain dump** 
activities for the day, called **blocks**, on the left column. These blocks can then be added
to the day's calendar (titled **schedule**) on the right column. 
This project is of interest to me
because I used a similar planning system with a physical notebook
during high school
and have not found a free application that does this exact thing. 

## User Stories
- As a user, I want to be able to add a block (representing an activity) 
to my brain dump, which is the list of activities for the day
- As a user, I want to be able to view the list of unscheduled blocks on my brain-dump and scheduled blocks on my 
schedule
- As a user, I want to be able to assign a length (in time) to each block and visualize it as a rectangle of
 corresponding height
- As a user, I want to be able to move a block from the brain-dump to the schedule and vice-versa
- As a user, I want to be able to delete a block from the brain-dump
- As a user, I want to be able to save my brain-dump and schedule to file (if I so choose)
- As a user, I want to be able to be able to load my brain-dump and schedule from file (if I so choose)

## Instructions for Grader
- You can generate the first required action related to adding blocks to a brain dump/schedule by
using the "Add a block" section on the left. Fill in the field for the title and length (duration in 
number of hours) of the block, and then click "Add Block". This will add a block to the brain dump.
- You can generate the second required action related to adding blocks to a brain dump/schedule by 
using the "Schedule a block" section on the left. Enter the block number of the block you want to schedule,
as it appears on the brain dump inside square brackets. Also enter the start time for the block. Finally, 
press "Schedule a block". This will remove the block from the brain dump and add it to the schedule.
- You can locate my visual component by simply adding blocks to the brain dump or schedule according
to the first two instructions. Alternatively, you can load a saved plan. Every block will have a height that corresponds to its duration in hours
and the scheduled blocks (i.e. blocks on the schedule) will be placed on a background grid that looks similar to 
the 'daily' view on google calender, positioned according to their start time.
- You can save the state of my application by pressing the 'Save' button on the left
- You can reload the state of my application by pressing the 'Load' button on the left

## Phase 4: Task 2
WindowListener method called: windowClosing.\
Logged Events:\
Fri Aug 11 13:55:26 PDT 2023\
jogging of length 0.50 added to brain dump.\
Fri Aug 11 13:55:31 PDT 2023\
lab of length 2.00 added to brain dump.\
Fri Aug 11 13:55:45 PDT 2023\
lab of length 2.00 was assigned the start time 15.0\
Fri Aug 11 13:55:45 PDT 2023\
lab from 15.00 to 17.00 added to the schedule.\
Fri Aug 11 13:55:45 PDT 2023\
lab from 15.00 to 17.00 deleted from brain dump.

Process finished with exit code 0

## Phase 4: Task 3
If I had more time, I would refactor the code in DailyPlannerApp corresponding to adding and scheduling blocks into 
separate classes to improve the cohesion of the DailyPlannerApp and adhere to the single responsibility principle. 
If I were to add more tools in addition to add and schedule, the DailyPlannerApp would become long and would be handling
more responsibilities than a main frame should. The main frame's responsibility should be to bring all the components 
of the UI together, it should not be creating any major components but rather delegate the task to another class. Thus 
refactoring the code for AddPanel and SchedulePanel out of the DailyPlannerApp would improve the design and readability.

There are two ways to do this, I could either make a 
new abstract class for tools with field (ToolWithFields) and have AddPanel and SchedulePanel extend those fields, or I 
could use the functionality of the existing the abstract class Tool. The latter is a better option since ToolWithFields
would have a very wide range of responsibilities so by the single responsibility principle it's preferable to have
AddPanel and SchedulePanel re-use some of Tool's functionality rather than have an separate abstract class the two extend.

