@ECHO OFF

REM Set the project root directory
SET PROJECT_DIR=..\src\main\java

REM Create bin directory if it doesn't exist
if not exist ..\bin mkdir ..\bin

REM Delete output from previous run
if exist ACTUAL.TXT del ACTUAL.TXT

REM Compile the code into the bin folder
javac -cp "%PROJECT_DIR%" -Xlint:none -d ..\bin "%PROJECT_DIR%\feedme\*.java" "%PROJECT_DIR%\feedme\Task\*.java"
IF ERRORLEVEL 1 (
    echo ********** BUILD FAILURE **********
    exit /b 1
)

REM No error here, errorlevel == 0

REM Run the program, feed commands from input.txt and redirect the output to ACTUAL.TXT
java -classpath ..\bin feedme.FeedMe < input.txt > ACTUAL.TXT

REM Compare the output to the expected output
FC ACTUAL.TXT EXPECTED.TXT

