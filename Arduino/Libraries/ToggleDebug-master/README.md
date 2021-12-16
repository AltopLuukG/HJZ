# ToggleDebug WIP

An Arduino debugging library.

Toggleable debug messages and timed debugging functions.

## Enabling the library

Before including the library, #define the debugging mode:


```cpp
#define DEBUG 0 //Debugging is disabled. Debugging functions won't be compiled
#define DEBUG 1 //Debugging is enabled.
#define DEBUG 2 //Only memory functions are enabled
```

Optional:
```cpp
#define FILE_SHOW_FULL_PATH //Shows full file path in debug messages instead of file name.
#define HIDE_EXTRA_INFO     //Hides info in debug messages like current line and method, millis and filename.
```
Finally: 
```cpp
#include <ToggleDebug.h>
```

## Initializing timers

Timed debugging messages need a timer instance. These can be initialized after including the library.
Timers are used for the TDEBUG_PRINT and TDEBUG_PRINTMEM functions.

```cpp
TDEBUG(timer1, 2000); //Initialize timer1 at 2000 milliseconds.
TDEBUG(timer2, 4000); //Initialize timer2 at 4000 milliseconds.
TDEBUG(timer3, 2000);
```

## Timed functions

Currently, the library has two timed, non blocking functions

```cpp
TDEBUG_PRINT(timer1, "Hello!"); 	//This will print "Hello!" every 2 seconds
TDEBUG_PRINTMEM(timer2); 		//This will print the ammount of memory left between stack and heap every 4 seconds.
TDEBUG_PRINTMEM(timer3, errorMethod()); //You can add an optional method as second parameter. This method will be called if a change in memory has been detected.

void errorMethod()
{
	//This code will run if a change in memory has been detected
}
```

If extra info is enabled, the message output will look like this:
`"DebugDemo.ino void loop() line:45 Hello!"`

If extra info is disabled just `"Hello!"` will be printed.

## Standard debugging

By using this library, you can use the standard arduino print functions and make them toggleable. The following functions will not compile if DEBUG is set to 0:

```cpp
DEBUG_BEGIN(115200); 	  //Serial.begin(115200);
DEBUG_PRINT("Message");	  //Serial.print("Message");
DEBUG_PRINTLN("Message"); //Serial.println("Message");
DEBUG_FLUSH();		  //Serial.flush();

DEBUG_PRINTMEM(); 	  //This wil print and return the ammount of memory left between stack and heap.
```
