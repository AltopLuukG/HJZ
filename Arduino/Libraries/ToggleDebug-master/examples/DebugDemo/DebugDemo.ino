/*
#define DEBUG 0  *Debug mode off, none of the debug functions will be compiled.
#define DEBUG 1  *Debug mode. All debug functions are included and useful information like current method, line and millis are printed along with the debug message.
#define DEBUG 2  *Ram only mode. Only the PRINTMEM functions are compiled.

#define FILE_SHOW_FULL_PATH * This will show the full file path in stead of the file name.
#define HIDE_EXTRA_INFO * This will hide extra info like filename, line and method from debug messages

*Define these options before including the library
*DEBUG will be defined as 0 if not defined in the sketch

DEBUG_BEGIN()   = Serial.begin()
DEBUG_PRINT()   = Serial.print()
DEBUG_PRINTLN() = Serial.println()
DEBUG_FLUSH()   = Serial.flush()

TDEBUG(instance, delay)  *Create debug timer instance. This timer is used for non-blocking, timed printlns
TDEBUG_PRINT(timer instance, "Message")  *Print timed message every x milliseconds. Will show extra information like current millis, line and method if enabled
TDEBUG_PRINTMEM(timer instance, error method (optional))  *Print timed message which shows ammount of RAM left between stack and heap. Calls optional method if change in memory is detected
*/

#define DEBUG 1 //Toggle debug messages by commenting or de-commenting this define
//#define FILE_SHOW_FULL_PATH
//#define HIDE_EXTRA_INFO

#include <ToggleDebug.h>

TDEBUG(timedMessage, 3000); //Create TDEBUG instance for use with TDEBUG_PRINT() method
TDEBUG(timedMessage2, 200);

TDEBUG(PRINTMEMTimer, 6000); //Create TDEBUG instance for TDEBUG_PRINTMEM() method

void setup()
{
    DEBUG_BEGIN(115200);

    DEBUG_PRINTLN("Println"); //These won't compile if DEBUG is set to 0
    DEBUG_PRINT("Print");

    DEBUG_PRINTMEM(); //Prints and returns ammount of free memory between stack and heap.
}

void loop()
{
    TDEBUG_PRINT(timedMessage, "This is a non blocking, timed and toggleable debug message");
    TDEBUG_PRINT(timedMessage2, ":)");

    TDEBUG_PRINTMEM(PRINTMEMTimer, errorMethod()); //Timed PRINTMEM method. Calls optional method when change in memory has been detected.
  //TDEBUG_PRINTMEM(availableMemTimer); //Also works
}

void errorMethod()
{
    DEBUG_PRINTLN("Prints if memory change is detected by TPRINTMEM method");
}
