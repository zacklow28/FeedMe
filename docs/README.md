# FeedMe User Guide

![GUI screenshot](https://zacklow28.github.io/ip/Ui.png)

This is a Bot that helps you keep track of your tasks. It functions as if these tasks are yummy food being fed to it. 
It **first asks you for a file** that contains your tasks. It then allows you to add, delete, mark, unmark, find and edit tasks.

## On starting the application:

The application will ask you for the path of the file that contains your tasks. 
If the file exists, it will set the tasks in the file as the tasks in the tummy. Otherwise, it will create a new tummy at
the specified path and this will be the file to set the tasks.

If input `Documents\feedme.txt` and file exists:
```
Tummy set!

```
If input `Documents\feedme.txt` and file does not exist:
```
Tummy location not found.
Created a new tummy at: Documents\feedme.txt
```

## Listing all tasks: `list`

Shows a list of all tasks in the tummy. No extra parameters required.

Example: `list`

```
Here are the Food in my tummy: 
1: [T][ ] borrow book
2: [D][X] return book by: Jan 01 2001
3: [E][ ] sell book from: Jan 01 2001 to: Jan 02 2001
```

## Marking a task: `mark`

Put a "X" on the task you want to mark. Requires the index of the task, starting from 1.

Example: `mark 1`

```
Yay! I've marked this Food as eaten!
[T][X] borrow book
```

## Unmarking a task: `unmark`

Remove the "X" on the task, if any, you want to unmark. Requires the index of the task, starting from 1.

Example: `unmark 1`

```
Okay! I've unmarked this Food as not eaten!
[T][ ] borrow book
```

## Deleting a task: `delete`

Delete the task you want to delete. Requires the index of the task, starting from 1.

Example: `delete 1`

```
Okay, I've digested this Food:
[T][ ] borrow book
Now you have 1 Food in my tummy.
```

## Adding todos: `todo`

Create a todo task. Requires the description of the task. It adds to the list.

Example: `todo buy snacks`

```
Got it. I've added this Food:
[T][ ] buy snacks
```

## Adding deadlines: `deadline`

Create a deadline task. Requires the description of the task, followed by the word "/by" and the 
date in the format of "YYYY-MM-DD". It adds to the list with the date in the format of "MMM dd yyyy".

Example: `deadline eat snacks /by 2001-01-01`


```
Got it. I've added this Food:
[D][ ] eat snacks by: Jan 01 2001
```

## Adding events: `event`

Create an event task. Requires the description of the task, followed by the word "/from" and the 
start date in the format of "YYYY-MM-DD", followed by the word "/to" and the end date in the format of "YYYY-MM-DD".
It adds to the list with the dates in the format of "MMM dd yyyy".

Example: `event find snacks /from 2001-01-01 /to 2001-01-02`

```
Got it. I've added this Food:
[E][ ] find snacks from: Jan 01 2001 to: Jan 02 2001
```

## Finding tasks: `find`

Find tasks with the same description. Requires the description of the task. It can take in any number of parameters and allow partial matches.

Example: `find snac`

```
Here are the Food in my tummy: 
1: [T][ ] buy snacks
2: [D][ ] eat snacks by: Jan 01 2001
3: [E][ ] find snacks from: Jan 01 2001 to: Jan 02 2001  
```
Example 2: `find money`

```
No matches found in my tummy!
```

Example 3: `find buy in`

```
Finding...
Here are the Food in my tummy: 
1: [T][ ] buy snacks
2. [E][ ] find snacks from: Jan 01 2001 to: Jan 02 2001
```
## Editing tasks: `edit`

Edit a task. Requires the index of the task, starting from 1, the field you want to edit, and the new value. 
Possible fields are "name", "by", "from", "to". Certain tasks can only have certain fields edited.

Example: `edit 1 name open snacks`

```
Yay! I've edited this Food!
[T][ ] buy snacks -> [T][ ] open snacks
```

Example 2: `edit 2 by 2020-02-28`

```
Yay! I've edited this Food!
[D][ ] eat snacks by: Jan 01 2001 -> [D][ ] eat snacks by: Feb 28 2020
```
## Exit: `exit`

Exit the program. No extra parameters required. Introduced a small delay of 0.5 seconds before the application closes.

Example: `exit`

```
Munch. Hope to see you again soon!
```