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